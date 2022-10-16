package com.steampowered.jsonreader;

import java.io.FileWriter;
import java.io.PrintWriter;
import org.json.simple.JSONObject;

public class JSONWriter {
	
	private static String path = "./games.json";
	
	String name; 
	int platforms; 
	String releaseDate; 
	String summary; 
	String price;
	
	public JSONWriter(String name, int platforms, String releaseDate, String summary, String price ) {
		this.name = name;
		this.platforms = platforms;
		this.releaseDate = releaseDate;
		this.summary = summary; 
		this.price = price;
	}
	
	
	@SuppressWarnings("unchecked")
	public void Write() {
		
		JSONObject json = new JSONObject();
		
        try {
    		json.put("name", name);
    		json.put("platforms", platforms);
    		json.put("releaseDate", releaseDate);
    		json.put("summary", summary);
    		json.put("price", price);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        try (PrintWriter out = new PrintWriter(new FileWriter(path, true))) {
            out.append(json.toString());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
}
