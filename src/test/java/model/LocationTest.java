package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidLocationException;

public class LocationTest {
	
	@Test
	public void rowLocationTest() {
		assertEquals(0, Location.indexMatchColumnLocation("A2"));
		assertEquals(1, Location.indexMatchColumnLocation("B2"));
		assertEquals(2, Location.indexMatchColumnLocation("C3"));
		assertEquals(3, Location.indexMatchColumnLocation("D3"));
		assertEquals(4, Location.indexMatchColumnLocation("E4"));
		assertEquals(5, Location.indexMatchColumnLocation("F4"));
		assertEquals(6, Location.indexMatchColumnLocation("G5"));
		assertEquals(7, Location.indexMatchColumnLocation("H5"));
	}
	
	@Test
	public void columnLocationTest() {
		assertEquals(0, Location.indexMatchRowLocation("B1"));
		assertEquals(1, Location.indexMatchRowLocation("B2"));
		assertEquals(2, Location.indexMatchRowLocation("D3"));
		assertEquals(3, Location.indexMatchRowLocation("D4"));
		assertEquals(4, Location.indexMatchRowLocation("F5"));
		assertEquals(5, Location.indexMatchRowLocation("F6"));
		assertEquals(6, Location.indexMatchRowLocation("H7"));
		assertEquals(7, Location.indexMatchRowLocation("H8"));
	}
	
	@Test(expected=InvalidLocationException.class)
	public void rowLocationExceptionTest1() {
		Location.indexMatchRowLocation("B0");
	}
	
	@Test(expected=InvalidLocationException.class)
	public void rowLocationExceptionTest2() {
		Location.indexMatchRowLocation("B9");
	}
	
	@Test(expected=InvalidLocationException.class)
	public void columnLocationExceptionTest1() {
		Location.indexMatchColumnLocation("Z5");
	}
	
	@Test(expected=InvalidLocationException.class)
	public void columnLocationExceptionTest2() {
		Location.indexMatchColumnLocation("I5");
	}
}
