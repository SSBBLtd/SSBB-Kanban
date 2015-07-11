package com.ssbb.kanban.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class SQLHelperTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void testInsertStatementReturnsExpectedString() {
		String table = "TEST_TABLE";
		String[] columns = {"ID", "NAME", "AGE"};
		String[] values = {"1", "JOHN", "35"};
		

		
		String actualString = SQLHelper.formInsertStatement(table, columns, values);
		String expectedString = "INSERT INTO TEST_TABLE(ID, NAME, AGE) VALUES(1, JOHN, 35) ";
		assertEquals(expectedString, actualString);
		
	}
	
	@Test
	public void testInsertStatementThrowsExceptionWithDifferentValueAndColumnSize() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Column array size: 2\nValues list size: 1");
		String table = "test";
		String[] columns = {"1", "2"};
		String[] values = {"1"};
		
		SQLHelper.formInsertStatement(table, columns, values);
		
		
	}

}
