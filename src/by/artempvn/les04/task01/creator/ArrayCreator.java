package by.artempvn.les04.task01.creator;

import java.io.File;
import java.io.InputStream;

import by.artempvn.les04.task01.entity.CustomArray;

public class ArrayCreator {
	public void fillRandom(CustomArray array, int maxRandomValue) {
		for (int i=0;i<array.getLength();i++) {
			array.setElement(i,(int)(Math.random()*maxRandomValue));
		}
	}
	
	public void fillFromFile(CustomArray array, File f) {
		
	}
	
	public void fillFromStream(CustomArray array, InputStream input) {
		
	}
	

}
