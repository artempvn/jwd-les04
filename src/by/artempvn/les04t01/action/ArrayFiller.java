package by.artempvn.les04t01.action;

import by.artempvn.les04t01.entity.CustomArray;
import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t01.parser.DataParser;

public class ArrayFiller {
	private static final String DELIMITER = "\\s+";

	public void fillRandom(CustomArray array, int maxRandomValue)
			throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		for (int i = 0; i < array.getLength(); i++) {
			array.setElement(i, (int) (Math.random() * maxRandomValue));
		}
	}

	// data string can be got by DataReader.class from console or file
	public int fillFromString(CustomArray array, String data)
			throws CustomException {
		if (array == null || data == null) {
			throw new CustomException("Incorrect input (null)");
		}
		int numberOfAddedNumbers = 0;
		String[] splittedData = data.split(DELIMITER);
		DataParser dataParser = new DataParser();
		int length = (array.getLength() <= splittedData.length)
				? array.getLength()
				: splittedData.length;
		for (int i = 0; i < length; i++) {
			int value;
			try {
				value = dataParser.findInt(splittedData[i]);
				array.setElement(i, value);
				numberOfAddedNumbers++;
			} catch (CustomException e) {
				// place for log in future (it wasn't learnt yet)
			}
		}
		return numberOfAddedNumbers;
	}
}
