package test.artempvn.les04t01.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les04t01.entity.CustomArray;
import by.artempvn.les04t01.exception.CustomException;

public class CustomArrayTest {
	CustomArray array;

	@BeforeMethod
	public void beforeMethod() {
		array = new CustomArray();
	}

	@Test(dataProvider = "constructorCustomArrayTest")
	public void constructorCustomArrayTest(int inputLength, int expected) {
		int actual = new CustomArray(inputLength).getLength();
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] constructorCustomArrayTest() {
		return new Object[][] { { -1, 0 }, { 10, 10 } };
	}

	@Test
	public void getElementTestPositive() {
		int actual = 0;
		try {
			actual = array.getElement(4);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		int expected = 0;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void getElementTestNegative() throws CustomException {
		array.getElement(-1);
	}

	@Test(dataProvider = "setElementTest")
	public void setElementTest(int position, boolean expected) {
		final int value = 99;
		boolean actual = array.setElement(position, value);
		if (actual) {
			try {
				actual = (array.getElement(position) == value);
			} catch (CustomException e) {
				// exception is impossible in this method
			}
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] setElementTest() {
		return new Object[][] { { -1, false }, { 3, true } };
	}

	@AfterMethod
	public void afterMethod() {
		array = null;
	}
}
