package by.artempvn.les04.task01.main;

import by.artempvn.les04.task01.entity.CustomArray;
import by.artempvn.les04.task01.service.ArrayService;

public class Main {

	public static void main(String[] args) {
		CustomArray array=new CustomArray(5,4,1,8,7);
		System.out.println(array);
		ArrayService arrayService=new ArrayService();
		arrayService.selectionSort(array);
		System.out.println(array);

	}

}
