package test.artempvn.les04t02.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t02.service.ArrayService;

public class ArrayServiceTest {
	ArrayService arrayService;
	int[] array;

	@BeforeClass
	public void setUp() {
		arrayService = new ArrayService();
		array = new int[] { 5, 4, 7, 3 };
	}

	@Test
	public void calculateSumTestPositive() {
		int actual = 0;
		try {
			actual = arrayService.calculateSum(array);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		int expected = 19;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void fillRandomTestNegative() throws CustomException {
		arrayService.calculateSum(null);
	}

	@Test
	public void findMinTestPositive() {
		int actual = 0;
		try {
			actual = arrayService.findMin(array);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		int expected = 3;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void findMinTestNegative() throws CustomException {
		arrayService.findMin(null);
	}

	@Test
	public void findMaxTestPositive() {
		int actual = 0;
		try {
			actual = arrayService.findMax(array);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		int expected = 7;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void findMaxTestNegative() throws CustomException {
		arrayService.findMax(null);
	}

	@AfterClass
	public void tierDown() {
		arrayService = null;
		array = null;
	}
}
