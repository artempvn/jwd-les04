package test.artempvn.les04t01.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import by.artempvn.les04t01.entity.CustomArray;
import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t01.service.ArraySortService;

public class ArraySortServiceTest {
	ArraySortService arraySortService;
	CustomArray array;
	CustomArray expectedArray;

	@BeforeClass
	public void setUp() {
		arraySortService = new ArraySortService();
		expectedArray = new CustomArray();
		expectedArray.setElement(0, 1);
		expectedArray.setElement(1, 2);
		expectedArray.setElement(2, 3);
		expectedArray.setElement(3, 4);
		expectedArray.setElement(4, 5);
	}

	@BeforeMethod
	public void beforeMethod() {
		array = new CustomArray();
		array.setElement(0, 5);
		array.setElement(1, 4);
		array.setElement(2, 3);
		array.setElement(3, 2);
		array.setElement(4, 1);
	}

	@Test
	public void bubbleSortTestPositive() {
		try {
			arraySortService.bubbleSort(array);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		CustomArray actual = array;
		CustomArray expected = expectedArray;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void bubbleSortTestNegative() throws CustomException {
		arraySortService.bubbleSort(null);
	}

	@Test
	public void selectionSortTestPositive() {
		try {
			arraySortService.selectionSort(array);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		CustomArray actual = array;
		CustomArray expected = expectedArray;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void selectionSortTestNegative() throws CustomException {
		arraySortService.selectionSort(null);
	}

	@Test
	public void shakerSortTestPositive() {
		try {
			arraySortService.shakerSort(array);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		CustomArray actual = array;
		CustomArray expected = expectedArray;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void shakerSortTestNegative() throws CustomException {
		arraySortService.shakerSort(null);
	}

	@AfterMethod
	public void afterMethod() {
		array = null;
	}

	@AfterClass
	public void tierDown() {
		arraySortService = null;
		expectedArray = null;
	}
}
