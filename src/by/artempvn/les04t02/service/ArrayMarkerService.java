package by.artempvn.les04t02.service;

import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t02.entity.ArrayMarker;

public class ArrayMarkerService {

	private boolean isSorted(ArrayMarker[] array) throws CustomException {
		boolean isSorted = true;
		int i = 0;
		while (isSorted && i < array.length - 1) {
			if (array[i].getValue() > array[i + 1].getValue()) {
				isSorted = false;
			} else {
				i++;
			}
		}
		return isSorted;
	}

	public void bubbleSort(ArrayMarker[] array) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		while (!isSorted(array)) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i].getValue() > array[i + 1].getValue()) {
					ArrayMarker element = array[i];
					array[i] = array[i + 1];
					array[i + 1] = element;
				}
			}
		}
	}

	public ArrayMarker[] reverse(ArrayMarker[] array) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		ArrayMarker[] reversedArray = new ArrayMarker[array.length];
		for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
			reversedArray[j] = array[i];
		}
		return reversedArray;
	}
}
