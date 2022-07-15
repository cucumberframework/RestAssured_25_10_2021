package payloads;

public class payload {

	
	
	public static String Addplace() { 
		
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.394,\r\n" + 
				"    \"lng\": 33.262\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frotne house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, sidut, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoeark\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://gogle.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String putApi(String placeid) { 
		return "{\r\n" + 
				"\"place_id\":\""+placeid+"\",\r\n" + 
				"\"address\":\"70 winter walk, USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				""; 
		
	}
}
