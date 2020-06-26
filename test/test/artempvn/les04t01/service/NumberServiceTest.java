package test.artempvn.les04t01.service;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les04t01.service.NumberService;

public class NumberServiceTest {
	NumberService numberService;

	@BeforeClass
	public void setUp() {
		numberService = new NumberService();
	}

	@Test(dataProvider = "isPrimeNumberTest")
	public void isPrimeNumberTest(int number, boolean expected) {
		boolean actual = numberService.isPrimeNumber(number);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isPrimeNumberTest() {
		return new Object[][] { { 1, false }, { 2, true }, { 3, true },
				{ 4, false } };
	}

	@Test(dataProvider = "isFibonacciNumberTest")
	public void isFibonacciNumberTest(int number, boolean expected) {
		boolean actual = numberService.isFibonacciNumber(number);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isFibonacciNumberTest() {
		return new Object[][] { { 4, false }, { 5, true }, { 6, false },
				{ -6, false }, { 0, true } };
	}

	@Test(dataProvider = "hasNumberUniqueDigitsTest")
	public void hasNumberUniqueDigitsTest(int number, boolean expected) {
		boolean actual = numberService.hasNumberUniqueDigits(number);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] hasNumberUniqueDigitsTest() {
		return new Object[][] { { 44, false }, { 5, true }, { 789, true } };
	}

	@Test(dataProvider = "hasNumberRequiredLengthTest")
	public void hasNumberRequiredLengthTest(int number, int length,
			boolean expected) {
		boolean actual = numberService.hasNumberRequiredLength(number, length);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] hasNumberRequiredLengthTest() {
		return new Object[][] { { 44, 3, false }, { 5, 1, true },
				{ 789, 3, true } };
	}

	@Test(dataProvider = "isNumberSomeConditionTest")
	public void isNumberSomeConditionTest(int number, boolean isFibonacci,
			boolean isPrime, boolean isUniqueDigits, int numberOfDigits,
			boolean expected) {
		boolean actual = numberService.isNumberSomeCondition(number,
				isFibonacci, isPrime, isUniqueDigits, numberOfDigits);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isNumberSomeConditionTest() {
		return new Object[][] { { 0, false, false, false, 0, false },
				{ 0, true, false, false, 0, true },
				{ 2, false, true, false, 0, true },
				{ 13, false, false, true, 0, true },
				{ 123, false, false, false, 3, true },
				{ -1, true, false, false, 0, false },
				{ 1, false, true, false, 0, false },
				{ 133, false, false, true, 0, false },
				{ 123, false, false, false, 2, false } };
	}

	@AfterClass
	public void tierDown() {
		numberService = null;
	}
}
