package by.artempvn.les04t02.service;

import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t02.entity.ArrayMarker;
import by.artempvn.les04t02.entity.SortingMethod;

public class JaggedArrayService {

	private ArrayMarker[] calculateRowsValue(int[][] jaggedArray,
			SortingMethod method) throws CustomException {
		if (jaggedArray == null || method == null) {
			throw new CustomException("Incorrect input (null)");
		}
		ArrayMarker[] rowValue = new ArrayMarker[jaggedArray.length];
		ArrayService arrayService = new ArrayService();
		for (int i = 0; i < jaggedArray.length; i++) {
			switch (method) {
			case BY_SUM:
				rowValue[i] = new ArrayMarker(
						arrayService.calculateSum(jaggedArray[i]), i);
				break;
			case BY_MAX_VALUE:
				rowValue[i] = new ArrayMarker(
						arrayService.findMax(jaggedArray[i]), i);
				break;
			case BY_MIN_VALUE:
				rowValue[i] = new ArrayMarker(
						arrayService.findMin(jaggedArray[i]), i);
				break;
			}
		}
		return rowValue;
	}

	public int[][] sortRows(int[][] jaggedArray, SortingMethod method,
			boolean isReversed) throws CustomException {
		if (jaggedArray == null || method == null) {
			throw new CustomException("Incorrect input (null)");
		}
		int[][] sortedRows = new int[jaggedArray.length][];
		ArrayMarker[] rowValue = calculateRowsValue(jaggedArray, method);
		ArrayMarkerService arrayMarkerService = new ArrayMarkerService();
		arrayMarkerService.bubbleSort(rowValue);
		if (isReversed) {
			rowValue = arrayMarkerService.reverse(rowValue);
		}
		for (int i = 0; i < sortedRows.length; i++) {
			sortedRows[i] = jaggedArray[rowValue[i].getStartPosition()];
		}
		return sortedRows;
	}
}
