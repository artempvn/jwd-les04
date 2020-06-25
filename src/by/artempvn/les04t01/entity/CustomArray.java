package by.artempvn.les04t01.entity;

import java.util.Arrays;
import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t01.validator.ArrayCheck;

public class CustomArray {

	private static final String ARRAY_STRING_DELIMITER = ", ";
	private static final int DEFAULT_ARRAY_LENGTH = 5;
	private static final int MIN_ARRAY_LENGTH = 0;

	private int[] array;

	public CustomArray() {
		array = new int[DEFAULT_ARRAY_LENGTH];
	}

	public CustomArray(int length) {
		if (length < MIN_ARRAY_LENGTH) {
			length = MIN_ARRAY_LENGTH;
		}
		array = new int[length];
	}

	public int getLength() {
		return array.length;
	}

	public int getElement(int position) throws CustomException {
		ArrayCheck arrayCheck = new ArrayCheck();
		if (!arrayCheck.isCorrectPosition(this, position)) {
			throw new CustomException("Position is out of bounds");
		}
		return array[position];
	}

	public boolean setElement(int position, int value) {
		ArrayCheck arrayCheck = new ArrayCheck();
		boolean isSet = false;
		try {
			if (arrayCheck.isCorrectPosition(this, position)) {
				array[position] = value;
				isSet = true;
			}
		} catch (CustomException e) {
			// exception is impossible in this method
		}
		return isSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CustomArray other = (CustomArray) obj;
		if (!Arrays.equals(array, other.array)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		StringBuilder builderArray = new StringBuilder();
		for (int i = 0; i < array.length - 1; i++) {
			builderArray.append(array[i]).append(ARRAY_STRING_DELIMITER);
		}
		builderArray.append(array[array.length - 1]);
		builder.append("CustomArray [array=");
		builder.append(builderArray);
		builder.append("]");
		return builder.toString();
	}
}
