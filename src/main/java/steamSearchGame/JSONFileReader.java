package steamSearchGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReader{
	
	private final static String FILEPATH = "./testData.json";
	
	public static JSONObject getJSONConfigData(){
		
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader(FILEPATH));
			JSONObject jsonObject = (JSONObject) obj; 
			DataStore.setJsonObject(jsonObject);
			
			return jsonObject; 

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	public static Object getValue(String key) {
		
		JSONObject json = getJSONConfigData();
		return json.get(key);
	}
}

