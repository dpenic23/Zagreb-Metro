package hr.fer.zgmetro.controller;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jackson.map.util.JSONWrappedObject;
import org.codehaus.jackson.type.TypeReference;

import hr.fer.zgmetro.algorithms.TripDistance;
import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.loader.FileLoader;

public class JSONTest_JSON_To_JavaObject {

	
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// JSON to Object
		User user = mapper.readValue(new File("./inputJSON/user.json"), User.class);
		System.out.println(user);
		
		// JSON string to Object
		String jsonInString = "{\"age\":33,\"messages\":[\"msg 1\",\"msg 2\"],\"name\":\"mkyong\"}";
		User user1 = mapper.readValue(jsonInString, User.class);
		System.out.println(user1);
	}
}
