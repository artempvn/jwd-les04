package by.artempvn.les04.task01.validator;

import by.artempvn.les04.task01.entity.CustomArray;
import by.artempvn.les04.task01.exception.CustomException;

public class ArrayCheck {

	public boolean isCorrectPosition(CustomArray array, int position) {
		return (position < array.getLength() && position >= 0);
	}

	public boolean isSorted(CustomArray array) {
		boolean isSorted = true;
		int i = 0;
		while (isSorted && i < array.getLength() - 1) {
			try {
				if (array.getElement(i) > array.getElement(i + 1)) {
					isSorted = false;
				} else {
					i++;
				}
			} catch (CustomException e) {
				// exception  is impossible in this method
			}
		}
		return isSorted;
	}

}
