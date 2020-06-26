package test.artempvn.les04t02.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import by.artempvn.les04t01.exception.CustomException;
import by.artempvn.les04t02.entity.ArrayMarker;
import by.artempvn.les04t02.service.ArrayMarkerService;

public class ArrayMarkerServiceTest {
	ArrayMarkerService arrayMarkerService;
	ArrayMarker arrayMarker1;
	ArrayMarker arrayMarker2;
	ArrayMarker arrayMarker3;
	ArrayMarker arrayMarker4;
	ArrayMarker[] arrayMarkers;
	ArrayMarker[] arrayMarkersSorted;
	ArrayMarker[] arrayMarkersReversed;

	@BeforeClass
	public void setUp() {
		arrayMarkerService = new ArrayMarkerService();
		arrayMarker1 = new ArrayMarker(6, 0);
		arrayMarker2 = new ArrayMarker(1, 1);
		arrayMarker3 = new ArrayMarker(5, 2);
		arrayMarker4 = new ArrayMarker(7, 3);
		arrayMarkersSorted = new ArrayMarker[] { arrayMarker2, arrayMarker3,
				arrayMarker1, arrayMarker4 };
		arrayMarkersReversed = new ArrayMarker[] { arrayMarker4, arrayMarker3,
				arrayMarker2, arrayMarker1 };
	}

	@BeforeMethod
	public void beforeMethod() {
		arrayMarkers = new ArrayMarker[] { arrayMarker1, arrayMarker2,
				arrayMarker3, arrayMarker4 };
	}

	@Test
	public void bubbleSortTestPositive() {
		try {
			arrayMarkerService.bubbleSort(arrayMarkers);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		ArrayMarker[] actual = arrayMarkers;
		ArrayMarker[] expected = arrayMarkersSorted;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void bubbleSortTestNegative() throws CustomException {
		arrayMarkerService.bubbleSort(null);
	}

	@Test
	public void reverseTestPositive() {
		ArrayMarker[] actual = null;
		try {
			actual = arrayMarkerService.reverse(arrayMarkers);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		ArrayMarker[] expected = arrayMarkersReversed;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void reverseTestNegative() throws CustomException {
		arrayMarkerService.reverse(null);
	}

	@AfterMethod
	public void afterMethod() {
		arrayMarkers = null;
	}

	@AfterClass
	public void tierDown() {
		arrayMarkerService = null;
		arrayMarker1 = null;
		arrayMarker2 = null;
		arrayMarker3 = null;
		arrayMarker4 = null;
	}
}
