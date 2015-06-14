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
		statement.append(INSERT);
		statement.append(table + "(");
		
		if( columns.length == values.length ) {
			for(int i = 0; i < columns.length; i++) {
				statement.append(columns[i]);
				if( i == columns.length - 1) {
					statement.append(") ");
					break;
				}
				statement.append(", ");
			}
			
			statement.append("VALUES(");
			for(int i = 0; i < values.length; i++) {
				statement.append(values[i]);
				if( i == values.length - 1) {
					statement.append(")");
					break;
				}
				statement.append(", ");
			}
			
			return statement.toString();
		}
		throw new IllegalArgumentException("Number of columns is different from number of values.\n" 
				+ "Column array size: " + columns.length + "\nValues list size: " + values.length);
	}
	
	public static void checkForSecurityKeywords(String value) {
	
		
	}
	
}
