package com.ssbb.kanban.utils;

public class StringHelper {
	
	public static boolean isNullOrEmpty(String stringToCheck){
		if(null == stringToCheck || stringToCheck.isEmpty()){
			return true;
		}
		return false;			
	}

}
