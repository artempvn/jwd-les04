package test.artempvn.les04t02.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t02.entity.SortingMethod;
import by.artempvn.les04t02.service.JaggedArrayService;

public class JaggedArrayServiceTest {
	JaggedArrayService jaggedArrayService;
	int[][] array;
	int[][] arrayBySum;
	int[][] arrayByMin;
	int[][] arrayByMax;
	int[][] arrayByMaxReversed;

	@BeforeClass
	public void setUp() {
		jaggedArrayService = new JaggedArrayService();
		array = new int[][] { { 4, 5, 6 }, { 10 }, { 7, 8, 9, 0 } };
		arrayBySum = new int[][] { { 10 }, { 4, 5, 6 }, { 7, 8, 9, 0 } };
		arrayByMin = new int[][] { { 7, 8, 9, 0 }, { 4, 5, 6 }, { 10 } };
		arrayByMax = new int[][] { { 4, 5, 6 }, { 7, 8, 9, 0 }, { 10 } };
		arrayByMaxReversed = new int[][] { { 10 }, { 7, 8, 9, 0 },
				{ 4, 5, 6 } };
	}

	@Test(dataProvider = "sortRowsTestPositive")
	public void sortRowsTestPositive(SortingMethod method, boolean isReversed,
			int[][] expected) {
		int[][] actual = null;
		try {
			actual = jaggedArrayService.sortRows(array, method, isReversed);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] sortRowsTestPositive() {
		return new Object[][] { { SortingMethod.BY_SUM, false, arrayBySum },
				{ SortingMethod.BY_MIN_VALUE, false, arrayByMin },
				{ SortingMethod.BY_MAX_VALUE, false, arrayByMax },
				{ SortingMethod.BY_MAX_VALUE, true, arrayByMaxReversed } };
	}

	@Test(dataProvider = "sortRowsTestNegative",
			expectedExceptions = CustomException.class)
	public void sortRowsTestNegative(int[][] inputArray, SortingMethod method)
			throws CustomException {
		jaggedArrayService.sortRows(inputArray, method, false);
	}

	@DataProvider
	public Object[][] sortRowsTestNegative() {
		return new Object[][] { { array, null },
				{ null, SortingMethod.BY_MIN_VALUE }, { null, null } };
	}

	@AfterClass
	public void tierDown() {
		jaggedArrayService = null;
		array = null;
		arrayBySum = null;
		arrayByMin = null;
		arrayByMax = null;
		arrayByMaxReversed = null;
	}
}
