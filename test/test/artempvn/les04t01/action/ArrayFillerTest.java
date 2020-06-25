package test.artempvn.les04t01.action;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les04t01.action.ArrayFiller;
import by.artempvn.les04t01.entity.CustomArray;
import by.artempvn.les04t01.exception.CustomException;

public class ArrayFillerTest {
	ArrayFiller arrayFiller;
	CustomArray array;

	@BeforeClass
	public void setUp() {
		arrayFiller = new ArrayFiller();
	}

	@BeforeMethod
	public void beforeMethod() {
		array = new CustomArray();
	}

	@Test
	public void fillRandomTestPositive() {
		boolean actual = true;
		final int maxRandonNumber = 10;
		try {
			arrayFiller.fillRandom(array, maxRandonNumber);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		for (int i = 0; i < array.getLength(); i++) {
			try {
				if (array.getElement(i) >= maxRandonNumber
						|| array.getElement(i) < 0) {
					actual = false;
				}
			} catch (CustomException e) {
				// exception is impossible in this method
			}
		}
		assertTrue(actual, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void fillRandomTestNegative() throws CustomException {
		final int maxRandonNumber = 10;
		arrayFiller.fillRandom(null, maxRandonNumber);
	}

	@Test(dataProvider = "fillFromStringTestPositive")
	public void fillFromStringTestPositive(String input, int expected) {
		int actual = 0;
		try {
			actual = arrayFiller.fillFromString(array, input);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] fillFromStringTestPositive() {
		return new Object[][] { { "0 1 2 3 4", 5 }, { "6", 1 },
				{ "0 1 2 3 4 5", 5 } };
	}

	@Test(dataProvider = "fillFromStringTestNegative",
			expectedExceptions = CustomException.class)
	public void fillFromStringTestNegative(String input, CustomArray someArray)
			throws CustomException {
		arrayFiller.fillFromString(someArray, input);
	}

	@DataProvider
	public Object[][] fillFromStringTestNegative() {
		return new Object[][] { { "0 1 2 3 4", null }, { null, array } };
	}

	@AfterMethod
	public void afterMethod() {
		array = null;
	}

	@AfterClass
	public void tierDown() {
		arrayFiller = null;
	}
}
