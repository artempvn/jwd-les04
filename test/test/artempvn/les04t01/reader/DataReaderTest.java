package test.artempvn.les04t01.reader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t01.reader.DataReader;

public class DataReaderTest {
	DataReader dataReader;

	@BeforeClass
	public void setUp() {
		dataReader = new DataReader();
	}

	@Test(dataProvider = "readFileTest")
	public void readFileTestPositive(String path) {
		String actual = null;
		try {
			actual = dataReader.readFile("path");
		} catch (CustomException e) {
			fail("exception occurred");
		}
		String expected = "5 6 7 4 9 11 13 1 2 3";
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] readFileTest() {
		return new Object[][] { { "input/data.txt" }, { "input/wrongData.txt" },
				{ null } };
	}

	@Test(expectedExceptions = CustomException.class)
	public void readFileTestNegative() throws CustomException {
		dataReader.readFile("input/dataTest.txt");
	}

	@AfterClass
	public void tierDown() {
		dataReader = null;
	}
}
