package DDT_Practice_AS;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDTByJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		FileReader file = new FileReader("C:\\Users\\kavit\\eclipse-workspace\\Advance_selenium\\src\\test\\resources\\JData.json");
		Object javaObj = parser.parse(file);
		
		JSONObject obj = (JSONObject)javaObj;
		String name = obj.get("name").toString();
		String id= obj.get("id").toString();
		Object id1 = obj.get("id");
		String branch = obj.get("Branch").toString();
		String Age = obj.get("Age").toString();
		String isStudent= obj.get("isStudent").toString();
		 Object isStudent1 = obj.get("isStudent");
		 Object bcklg = obj.get("backlogs");
		// String bcklg1 = obj.get("backlogs").toString();
		 
		System.out.println(name);
		System.out.println(id);
		System.out.println(id1);
		System.out.println(branch);
		System.out.println(Age);
		System.out.println(isStudent);
		System.out.println(isStudent);
		System.out.println(bcklg);
		//System.out.println(bcklg1);

	}

}
