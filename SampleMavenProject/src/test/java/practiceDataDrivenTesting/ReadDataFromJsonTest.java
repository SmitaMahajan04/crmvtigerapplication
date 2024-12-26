package practiceDataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {
	public static void main(String[] args) throws Throwable  {
		
		
		//step1:parse json physical file in to java object using JSONParse class
		
		JSONParser parser=new JSONParser();
		FileReader fr = new FileReader("C:\\Users\\Shree\\Desktop\\TekPyramid\\TestDataForSampleProject\\appCommonData.json");
		Object obj = parser.parse(fr);
	
	
	//step2: convert java object in to jsonobject using down casting
		
		JSONObject map = (JSONObject)obj;
		
		//step3: get the value from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeOut"));
	}

}
