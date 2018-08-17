package ec.fmia.tdd.showcase;

import java.util.regex.Pattern;

public class Greeting {

	public static String greet(String[] namesParam) {
		String names = "";
		if (namesParam != null) {
			for (String name : namesParam) {
				if (!names.isEmpty()) {
					names += ", ";
				}
				names += name;
			}
		}
		return greet(names);
	}

	public static String greet(String namesParam) {

		String greeting = "Hello, ";
		String name = "my friend";

		if (namesParam != null) {

			if (validateUpperCaseName(namesParam)) {

				if (namesParam.contains(",")) {

					int lastIndex = namesParam.lastIndexOf(",");

					StringBuilder sb = new StringBuilder();
					sb.append(namesParam.substring(0, lastIndex));
					sb.append(" AND ");
					sb.append(namesParam.substring(lastIndex + 2, namesParam.length()));
					name = sb.toString();

				} else {
					name = namesParam;
				}

				name = name.toUpperCase();
				greeting = greeting.toUpperCase();

			} else {

				if (namesParam.contains(",")) {

					int lastIndex = namesParam.lastIndexOf(",");

					StringBuilder sb = new StringBuilder();
					sb.append(namesParam.substring(0, lastIndex));
					sb.append(" and ");
					sb.append(namesParam.substring(lastIndex + 2, namesParam.length()));
					name = sb.toString();

				} else {
					name = namesParam;
				}

			}
		}

		return greeting + name + ".";
	}

	private static boolean validateUpperCaseName(String name) {
		Pattern upperCasePattern = Pattern.compile("[A-Z]");
		for (int i = 0; i < name.length(); i++) {
			CharSequence c = String.valueOf(name.charAt(i));
			if (!c.equals(",") && !c.equals(" ") && !upperCasePattern.matcher(c).find()) {
				return false;
			}
		}
		return true;
	}

}
