package gongjv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//import org.json.JSONArray;
//import org.json.JSONObject;

public class Json {
	public static void main(String []args)throws FileNotFoundException, IOException{
		ArrayList<String> a=new ArrayList<String>();
		BufferedReader reader =new BufferedReader(new FileReader(""));
		String s=null;
		/* while((s=reader.readLine())!=null){
			JSONObject dataJson=new JSONObject(s);
			JSONArray features=dataJson.getJSONArray("features");
			System.out.println(features);
		}*/
		
	}

}
