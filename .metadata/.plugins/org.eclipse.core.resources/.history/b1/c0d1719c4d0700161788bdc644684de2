package hr.fer.zgmetro.controller;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONTest_JSON_To_JavaObject {

	
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		User user = mapper.readValue(new File("./inputJSON/user.json"), User.class);
		System.out.println(user);

		// Convert JSON string to Object
		String jsonInString = "{\"age\":33,\"messages\":[\"msg 1\",\"msg 2\"],\"name\":\"mkyong\"}";
		User user1 = mapper.readValue(jsonInString, User.class);
		System.out.println(user1);
	}
}
