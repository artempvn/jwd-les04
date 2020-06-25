package by.artempvn.les04t01.service;

import by.artempvn.les04t01.entity.CustomArray;
import by.artempvn.les04t01.exception.CustomException;

public class ArrayUtilService {

	public int findIndexOfMin(CustomArray array) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		int min = Integer.MAX_VALUE;
		int index = 0;
		try {
			for (int i = 0; i < array.getLength(); i++) {
				if (min > array.getElement(i)) {
					min = array.getElement(i);
					index = i;
				}
			}
		} catch (CustomException ex) {
			// exception is impossible in this method
		}
		return index;
	}

	public int findIndexOfMin(CustomArray array, int leftBorder)
			throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		int min = Integer.MAX_VALUE;
		int index = 0;
		try {
			for (int i = leftBorder; i < array.getLength(); i++) {
				if (min > array.getElement(i)) {
					min = array.getElement(i);
					index = i;
				}
			}
		} catch (CustomException ex) {
			// exception is impossible in this method
		}
		return index;
	}

	public int findIndexOfMax(CustomArray array) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		int max = Integer.MIN_VALUE;
		int index = 0;
		try {
			for (int i = 0; i < array.getLength(); i++) {
				if (max < array.getElement(i)) {
					max = array.getElement(i);
					index = i;
				}
			}
		} catch (CustomException ex) {
			// exception is impossible in this method
		}
		return index;
	}

	public int findIndexOfMax(CustomArray array, int leftBorder)
			throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		int max = Integer.MIN_VALUE;
		int index = 0;
		try {
			for (int i = leftBorder; i < array.getLength(); i++) {
				if (max < array.getElement(i)) {
					max = array.getElement(i);
					index = i;
				}
			}
		} catch (CustomException ex) {
			// exception is impossible in this method
		}
		return index;
	}

	public boolean isSorted(CustomArray array) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
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
				// exception is impossible in this method
			}
		}
		return isSorted;
	}

	private CustomArray copyValue(CustomArray array, int length)
			throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		CustomArray outputArray = new CustomArray(length);
		try {
			for (int i = 0; i < length; i++) {
				outputArray.setElement(i, array.getElement(i));
			}
		} catch (CustomException e) {
			// exception is impossible in this method
		}
		return outputArray;
	}

	/*
	 * large number of arguments can be useful to customize search; solution
	 * with switch/case/enum could be seen in
	 * by.artempvn.les04t02.service.JaggedArrayService
	 */
	public CustomArray getSpecificNumber(CustomArray array,
			boolean getFibonacci, boolean getPrime, boolean getUniqueDigits,
			int numberOfDigits) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		CustomArray rawArray = new CustomArray(array.getLength());
		int count = 0;
		NumberService numberService = new NumberService();
		try {
			for (int i = 0, j = 0; i < array.getLength(); i++) {
				boolean condition = numberService.isNumberSomeCondition(
						array.getElement(i), getFibonacci, getPrime,
						getUniqueDigits, numberOfDigits);
				if (condition) {
					rawArray.setElement(j, array.getElement(i));
					j++;
					count++;
				}
			}
		} catch (CustomException e) {
			// exception is impossible in this method
		}
		CustomArray outputArray = copyValue(rawArray, count);
		return outputArray;
	}

	public int binarySearch(CustomArray array, int searchedNumber)
			throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		if (!isSorted(array)) {
			throw new CustomException(
					"Array isn't sorted yet. Result could be uncorrect");
		}
		int indexOfSearchedNumber = -1;
		boolean isFound = false;
		int leftBorder = 0;
		int rightBorder = array.getLength() - 1;
		int centralElement = (rightBorder - leftBorder) / 2;
		try {
			while ((rightBorder - leftBorder) / 2 > 0 && !isFound) {
				if (searchedNumber != array.getElement(centralElement)) {
					if (searchedNumber < array.getElement(centralElement)) {
						rightBorder = centralElement;
						centralElement = (rightBorder - leftBorder) / 2
								+ leftBorder;
					} else {
						leftBorder = centralElement;
						centralElement = (rightBorder - leftBorder) / 2
								+ leftBorder;
					}
				} else {
					indexOfSearchedNumber = centralElement;
					isFound = true;
				}
				if ((rightBorder - leftBorder) / 2 == 0) {
					if (searchedNumber == array.getElement(leftBorder)) {
						indexOfSearchedNumber = leftBorder;
					} else {
						if (searchedNumber == array.getElement(rightBorder)) {
							indexOfSearchedNumber = rightBorder;
						}
					}
				}
			}
		} catch (CustomException e) {
			// exception is impossible in this method
		}
		return indexOfSearchedNumber;
	}
}
