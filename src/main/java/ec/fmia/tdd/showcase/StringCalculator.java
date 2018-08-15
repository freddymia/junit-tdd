package ec.fmia.tdd.showcase;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public static int add(String numbersParam) {

		String delimiter = getDelimiter(numbersParam);

		String numbers = getNumbers(numbersParam);

		int result = 0;

		String[] numbersArray = numbers.split(delimiter);
		List<String> negativeNumbers = new ArrayList<>();

		for (String number : numbersArray) {
			if (!number.trim().isEmpty()) {
				int numberInteger = Integer.parseInt(number);
				if (numberInteger < 0) {
					negativeNumbers.add(number);
				} else if (numberInteger <= 1000) {
					result += Integer.parseInt(number);
				}
			}
		}

		if (!negativeNumbers.isEmpty()) {
			throw new RuntimeException("Negatives not allowed: " + negativeNumbers);
		}

		return result;
	}

	private static String getDelimiter(String numbers) {
		
		String delimiter = ",|n";
		
		if (numbers.startsWith("//")) {
			
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, numbers.indexOf("n"));
		
			if(delimiter.length() > 1) {
				StringBuilder delimiterSB = new StringBuilder();
				for (int i = 0; i < delimiter.length(); i++) {
					if(delimiterSB.length() > 0) {
						delimiterSB.append("|");
					}
					delimiterSB.append(delimiter.charAt(i));
				}
				return delimiterSB.toString();
			}
		}
		return delimiter;
	}

	private static String getNumbers(String numbers) {
		String numbersWithoutDelimiter = numbers;
		if (!numbers.isEmpty() && numbers.startsWith("//") && numbers.contains("n")) {
			numbersWithoutDelimiter = numbers.substring(numbers.indexOf("n") + 1);
		}
		return numbersWithoutDelimiter;
	}
}