package by.artempvn.les04t01.service;

import by.artempvn.les04t01.entity.CustomArray;
import by.artempvn.les04t01.exception.CustomException;

public class ArraySortService {
	// TODO check nullPointerEx

	private void bubbleSortUtil(CustomArray array, int leftBorder,
			int rightBorder, boolean isRefersed) {
		try {
			if (isRefersed == false) {
				for (int i = leftBorder; i < rightBorder; i++) {
					if (array.getElement(i) > array.getElement(i + 1)) {
						int element = array.getElement(i);
						array.setElement(i, array.getElement(i + 1));
						array.setElement(i + 1, element);
					}
				}
			} else {
				for (int i = rightBorder; i > leftBorder; i--) {
					if (array.getElement(i) < array.getElement(i - 1)) {
						int element = array.getElement(i);
						array.setElement(i, array.getElement(i - 1));
						array.setElement(i - 1, element);
					}
				}
			}
		} catch (CustomException e) {
			// exception is impossible in this method
		}
	}

	public void bubbleSort(CustomArray array) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		ArrayUtilService arrayUtilService = new ArrayUtilService();
		while (!arrayUtilService.isSorted(array)) {
			bubbleSortUtil(array, 0, array.getLength() - 1, false);
		}
	}

	public void selectionSort(CustomArray array) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		ArrayUtilService arrayUtilService = new ArrayUtilService();
		try {
			for (int j = 0; j < array.getLength() - 1; j++) {
				int indexMin = arrayUtilService.findIndexOfMin(array, j);
				int element = array.getElement(j);
				array.setElement(j, array.getElement(indexMin));
				array.setElement(indexMin, element);
			}
		} catch (CustomException ex) {
			// exception is impossible in this method
		}
	}

	public void shakerSort(CustomArray array) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		int leftBorder = 0;
		int rightBorder = array.getLength() - 1;
		while (leftBorder < rightBorder) {
			bubbleSortUtil(array, leftBorder, rightBorder, false);
			rightBorder--;
			bubbleSortUtil(array, leftBorder, rightBorder, true);
			leftBorder++;
		}
	}

}
