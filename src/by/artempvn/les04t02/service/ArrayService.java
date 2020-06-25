package by.artempvn.les04t02.service;

import by.artempvn.les04t01.exception.CustomException;

public class ArrayService {

	public int calculateSum(int[] array) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		int sum = 0;
		for (int element : array) {
			sum += element;
		}
		return sum;
	}

	public int findMin(int[] array) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}

	public int findMax(int[] array) throws CustomException {
		if (array == null) {
			throw new CustomException("Incorrect input (null)");
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}
}
