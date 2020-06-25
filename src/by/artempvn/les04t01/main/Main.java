package by.artempvn.les04t01.main;

import java.util.Arrays;

import by.artempvn.les04t01.action.ArrayFiller;
import by.artempvn.les04t01.entity.CustomArray;
import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t01.reader.DataReader;
import by.artempvn.les04t01.service.ArraySortService;
import by.artempvn.les04t01.service.ArrayUtilService;
import by.artempvn.les04t01.service.NumberService;
import by.artempvn.les04t02.entity.ArrayMarker;
import by.artempvn.les04t02.entity.SortingMethod;
import by.artempvn.les04t02.service.ArrayMarkerService;
import by.artempvn.les04t02.service.JaggedArrayService;

public class Main {
	
	static void print(int[][] a) {
		for (int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws CustomException {
		

		DataReader dr=new DataReader();
		String s=dr.readConsole();
		System.out.println(s);
		s=dr.readFile("fd");
		System.out.println(s);
		
		

		
		

	}

}
