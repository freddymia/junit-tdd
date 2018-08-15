package ec.fmia.tdd.showcase;

import java.util.regex.Pattern;

public class PasswordVerifier {

	public static boolean verify(String passwordParam) {
		return isValid(passwordParam);
	}

	private static boolean isValid(String passwordParam) {

		int feature = 0;
		boolean valid = true;


		if (passwordParam == null) {
			// throw new RuntimeException("Password should not be null.");
			System.out.println("Password should not be null.");
		} else {
			feature++;
		}

		if (passwordParam.trim().length() <= 8) {
			// throw new RuntimeException("Password should be larger than 8 chars.");
			System.out.println("Password should be larger than 8 chars.");
		} else {
			feature++;
		}

		Pattern upperCasePatten = Pattern.compile("[A-Z]");
		if (!upperCasePatten.matcher(passwordParam).find()) {
			// throw new RuntimeException("Password must have at least one uppercase
			// character.");
			System.out.println("Password must have at least one uppercase character.");
		} else {
			feature++;
		}

		Pattern lowerCasePatten = Pattern.compile("[a-z]");
		if (!lowerCasePatten.matcher(passwordParam).find()) {
			valid = false;
			// throw new RuntimeException("Password must have at least one lowercase
			// character.");//
			System.out.println("Password must have at least one lowercase character.");
		} else {
			feature++;
		}

		Pattern numberCasePatten = Pattern.compile("[0-9]");
		if (!numberCasePatten.matcher(passwordParam).find()) {
			// throw new RuntimeException("Password must have at least one number
			// character.");
			System.out.println("Password must have at least one number character.");
		} else {
			feature++;
		}

		if (feature < 3 || !valid) {
			return false;
		}

		return true;
	}

}