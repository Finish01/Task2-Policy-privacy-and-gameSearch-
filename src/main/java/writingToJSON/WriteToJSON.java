package writingToJSON;

import java.io.File;
import java.io.FileOutputStream;
import java.util.jar.JarException;

import org.json.simple.JSONObject;

public class WriteToJSON {
	
	private static String path = "./data.json";
	
	String name; 
	int platforms; 
	String releaseDate; 
	String summary; 
	String price;
	
	public WriteToJSON(String name, int platforms, String releaseDate, String summary, String price ) {
		this.name = name;
		this.platforms = platforms;
		this.releaseDate = releaseDate;
		this.summary = summary; 
		this.price = price;
	}
	
	
	@SuppressWarnings("unchecked")
	public void Write() throws JarException {
		
		String jsonStr = "";
		
		JSONObject json = new JSONObject();
		
		json.put("name", name);
		json.put("platforms", platforms);
		json.put("releaseDate", releaseDate);
		json.put("summary", summary);
		json.put("price", price);
		
		
		JSONObject records = new JSONObject();
		records.put("Games", json);
		
		jsonStr = records.toString();
		
        FileOutputStream fileOutputStream = null;
        try {

            fileOutputStream = new FileOutputStream(new File(path),true);
            fileOutputStream.write(jsonStr.getBytes());
            fileOutputStream.close();
        	
        } catch (Exception e) {
            e.printStackTrace();
   
        }
		
	}
	
	
}
