package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import camping.model.Stay;

public class StayService {

	private static StayService instance = null;

	public static StayService getInstance() {
		if (instance == null) {
			instance = new StayService();
		}

		return instance;
	}

	public List<Stay> getAllStays() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/ProjetRestTomcat/sejour/getsejours";
		String value = restTemplate.getForObject(url, String.class);

		ArrayList<Stay> stays = new ArrayList<>();

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode rootNode = mapper.readValue(value, JsonNode.class);
			for (JsonNode node : rootNode.path("sejour")) {
				// System.out.println("Client: " + node.toString());
				Stay s = mapper.readValue(node.toString(), Stay.class);
				stays.add(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stays;
	}

	public Stay getStay(int id) {
		return null;
	}

	public Stay updateStay(Stay client) {
		return null;
	}

	public void deleteStay(int id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/ProjetRestTomcat/sejour/deletesejour";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("numsej", id);
		String value = restTemplate.getForObject(builder.build().encode().toUri().toString(), String.class, id);

	}

	public void storeStay(Stay stay) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/ProjetRestTomcat/sejour/createsejour";
		
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(stay);
			
			System.out.println(json);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> entity = new HttpEntity<String>(json, headers);
			//String answer = restTemplate.postForObject(url, entity, String.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
