package by.artempvn.les04t01.validator;

import by.artempvn.les04t01.entity.CustomArray;
import by.artempvn.les04t01.exception.CustomException;

public class ArrayCheck {

	public boolean isCorrectPosition(CustomArray array, int position)
			throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		return (position < array.getLength() && position >= 0);
	}
}
