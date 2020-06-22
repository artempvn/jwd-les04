package by.artempvn.les04.task01.service;


import by.artempvn.les04.task01.entity.CustomArray;
import by.artempvn.les04.task01.exception.CustomException;
import by.artempvn.les04.task01.validator.ArrayCheck;

public class ArrayService {
	//TODO check nullPointerEx
	
	public void bubbleSort(CustomArray array) {
		ArrayCheck arrayCheck=new ArrayCheck();
		while (!arrayCheck.isSorted(array)) {
			for (int i=0;i<array.getLength()-1;i++) {
				try {
					if(array.getElement(i)>array.getElement(i+1)){
						int element=array.getElement(i);
						array.setElement(i,array.getElement(i+1));
						array.setElement(i+1,element);
					}
				} catch (CustomException e) {
					// exception  is impossible in this method
				}
			}
		}	
	}
	
	public void selectionSort (CustomArray array) {
		try {
			for (int j=0;j<array.getLength()-1;j++) {
				int min=Integer.MAX_VALUE;
				int indexMin=0;
				for (int i=j;i<array.getLength();i++) {
					if (array.getElement(i)<min) {
						min=array.getElement(i);
						indexMin=i;
					}
				}
				int element=array.getElement(j);
				array.setElement(j, min);
				array.setElement(indexMin, element);
			}
		} catch (CustomException ex) {
			// exception  is impossible in this method
		}
	}
	
	
	
	
	

}
