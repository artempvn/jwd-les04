package by.artempvn.les04t01.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.artempvn.les04t01.exception.CustomException;

public class DataParser {
	private static final String PATTERN_INT = "(?<=\\b)\\d+(?=\\b)";

	public int findInt(String input) throws CustomException {
		int number = 0;
		if (input != null) {
			String parsedString = "";
			Pattern patternInt = Pattern.compile(PATTERN_INT);
			Matcher matcherInt = patternInt.matcher(input);
			if (matcherInt.find()) {
				parsedString = input.substring(matcherInt.start(),
						matcherInt.end());
				number = Integer.parseInt(parsedString);
			} else {
				throw new CustomException("Can't find correct int value");
			}
		} else {
			throw new CustomException("Incorrect input (null)");
		}
		return number;
	}
}
