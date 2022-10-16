package com.steampowered.jsonreader;

import org.json.simple.JSONObject;

public class DataStore {
	
	private static JSONObject jsonObject;
	

	public static Object getJsonObject() {
		return jsonObject;
		
	}

	public static void setJsonObject(JSONObject jsonObject) {
		DataStore.jsonObject = jsonObject; 
	} 
	
	public static Object getJsonObject(String key) {
		return (Object) jsonObject.get(key);
	}
	
}
