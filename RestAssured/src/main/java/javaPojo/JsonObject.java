package javaPojo;

import org.json.simple.JSONObject;

public class JsonObject {

	public Object jsonObject() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Sukesh");
		jobj.put("projectName", "Pract358");
		jobj.put("status", "onGoing");
		jobj.put("teamSize", 5);
		
		return jobj;
		
	}
	
}
