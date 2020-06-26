package test.artempvn.les04t01.validator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les04t01.entity.CustomArray;
import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t01.validator.ArrayCheck;

public class ArrayCheckTest {
	ArrayCheck arrayCheck;
	CustomArray array;

	@BeforeClass
	public void setUp() {
		arrayCheck = new ArrayCheck();
		array = new CustomArray(3);
	}

	@Test(dataProvider = "isCorrectPositionTestPositive")
	public void isCorrectPositionTestPositive(int position, boolean expected) {
		boolean actual = false;
		try {
			actual = arrayCheck.isCorrectPosition(array, position);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isCorrectPositionTestPositive() {
		return new Object[][] { { 0, true }, { 3, false }, { -1, false } };
	}

	@Test(expectedExceptions = CustomException.class)
	public void isCorrectPositionTestNegative() throws CustomException {
		int position = 0;
		arrayCheck.isCorrectPosition(null, position);
	}

	@AfterClass
	public void tierDown() {
		arrayCheck = null;
		array = null;
	}
}
