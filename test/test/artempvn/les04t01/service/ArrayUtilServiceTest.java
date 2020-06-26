package test.artempvn.les04t01.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les04t01.entity.CustomArray;
import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t01.service.ArrayUtilService;

public class ArrayUtilServiceTest {
	ArrayUtilService arrayUtilService;
	CustomArray arrayTest1;
	CustomArray arrayTest2;
	CustomArray arrayNullLength;
	CustomArray arrayPrimeTest1;

	@BeforeClass
	public void setUp() {
		arrayUtilService = new ArrayUtilService();
		arrayNullLength = new CustomArray(0);
		arrayTest1 = new CustomArray();
		arrayTest2 = new CustomArray();
		arrayPrimeTest1 = new CustomArray(2);
		arrayTest1.setElement(0, 1);
		arrayTest1.setElement(1, 2);
		arrayTest1.setElement(2, 3);
		arrayTest1.setElement(3, 4);
		arrayTest1.setElement(4, 6);
		arrayTest2.setElement(0, 4);
		arrayTest2.setElement(1, 8);
		arrayTest2.setElement(2, 1);
		arrayTest2.setElement(3, 0);
		arrayTest2.setElement(4, 6);
		arrayPrimeTest1.setElement(0, 2);
		arrayPrimeTest1.setElement(1, 3);
	}

	@Test(dataProvider = "findIndexOfMinTestPositive")
	public void findIndexOfMinTestPositive(CustomArray array, int expected) {
		int actual = 0;
		try {
			actual = arrayUtilService.findIndexOfMin(array);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] findIndexOfMinTestPositive() {
		return new Object[][] { { arrayTest1, 0 }, { arrayNullLength, -1 } };
	}

	@Test(expectedExceptions = CustomException.class)
	public void findIndexOfMinTestNegative() throws CustomException {
		arrayUtilService.findIndexOfMin(null);
	}

	@Test
	public void findIndexOfMinTest2Positive() {
		int actual = 0;
		try {
			actual = arrayUtilService.findIndexOfMin(arrayTest1, 3);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		int expected = 3;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "findIndexOfMaxTestPositive")
	public void findIndexOfMaxTestPositive(CustomArray array, int expected) {
		int actual = 0;
		try {
			actual = arrayUtilService.findIndexOfMax(array);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] findIndexOfMaxTestPositive() {
		return new Object[][] { { arrayTest2, 1 }, { arrayNullLength, -1 } };
	}

	@Test(expectedExceptions = CustomException.class)
	public void findIndexOfMaxTestNegative() throws CustomException {
		arrayUtilService.findIndexOfMax(null);
	}

	@Test(dataProvider = "isSortedTestPositive")
	public void isSortedTestPositive(CustomArray array, boolean expected) {
		boolean actual = false;
		try {
			actual = arrayUtilService.isSorted(array);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isSortedTestPositive() {
		return new Object[][] { { arrayTest1, true }, { arrayTest2, false } };
	}

	@Test(expectedExceptions = CustomException.class)
	public void isSortedTestNegative() throws CustomException {
		arrayUtilService.isSorted(null);
	}

	@Test
	public void findSpecificNumberTestPositive() {
		CustomArray actual = null;
		try {
			actual = arrayUtilService.findSpecificNumber(arrayTest1, false,
					true, false, 0);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		CustomArray expected = arrayPrimeTest1;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void findSpecificNumberTestNegative() throws CustomException {
		arrayUtilService.findSpecificNumber(null, false, false, false, 0);
	}

	@Test(dataProvider = "binarySearchTestPositive")
	public void binarySearchTestPositive(CustomArray array, int element,
			int expected) {
		int actual = 0;
		try {
			actual = arrayUtilService.binarySearch(array, element);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] binarySearchTestPositive() {
		return new Object[][] { { arrayTest1, 5, -1 }, { arrayTest1, 6, 4 },
				{ arrayTest1, 1, 0 }, { arrayTest1, 3, 2 } };
	}

	@Test(dataProvider = "binarySearchTestNegative",
			expectedExceptions = CustomException.class)
	public void binarySearchTestNegative(CustomArray array)
			throws CustomException {
		int element = 0;
		arrayUtilService.binarySearch(array, element);
	}

	@DataProvider
	public Object[][] binarySearchTestNegative() {
		return new Object[][] { { arrayTest2 }, { null } };
	}

	@AfterClass
	public void tierDown() {
		arrayUtilService = null;
		arrayTest1 = null;
		arrayTest2 = null;
		arrayNullLength = null;
	}
}
