package com.ssbb.kanban.utils;

/** Helper class to assist in forming SQL statements
 * 
 * @author RTONG_WJ
 *
 */
public class SQLHelper {

	private static final String INSERT = "INSERT INTO ";
	
	/** Method to form an insert statement by specifying table, columns and values to be added
	 * 
	 * "INSERT INTO..."
	 * 
	 * @param table - name of the table
	 * @param columns - String array of columns to be updated
	 * @param values - String array of values to be added
	 * @return
	 */
	public static String formInsertStatement(String table, String[] columns, String[] values) {
		StringBuffer statement = new StringBuffer();
		statement.append(INSERT).append(table).append("(");
		
		if( columns.length == values.length ) {
			appendArray(statement, columns).append("VALUES(");
			appendArray(statement, values);
			return statement.toString();
		}
		throw new IllegalArgumentException("Number of columns is different from number of values.\n" 
				+ "Column array size: " + columns.length + "\nValues list size: " + values.length);
	}
	
	public static void checkForSecurityKeywords(String value) {
			
	}
	
	private static StringBuffer appendArray(StringBuffer statement, String[] array) {
		int i = 0;
		while(true) {			
			statement.append(array[i]);
			if( i == array.length - 1) {
				statement.append(") ");
				break;
			}
			statement.append(", ");
			i++;
		}
		return statement;
	}
	
}
