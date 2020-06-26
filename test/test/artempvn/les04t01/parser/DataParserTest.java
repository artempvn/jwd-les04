package test.artempvn.les04t01.parser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t01.parser.DataParser;

public class DataParserTest {
	DataParser dataParser;

	@BeforeClass
	public void setUp() {
		dataParser = new DataParser();
	}

	@Test
	public void findIntTestPositive() {
		int actual = 0;
		try {
			actual = dataParser.findInt(" 31 ");
		} catch (CustomException e) {
			fail("exception occurred");
		}
		int expected = 31;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "findIntTestNegative",
			expectedExceptions = CustomException.class)
	public void findIntTestNegative(String input) throws CustomException {
		dataParser.findInt(input);
	}

	@DataProvider
	public Object[][] findIntTestNegative() {
		return new Object[][] { { null }, { "notNumber" } };
	}

	@AfterClass
	public void tierDown() {
		dataParser = null;
	}
}
