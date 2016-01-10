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

import camping.model.Client;

public class ClientService {
	
	private static ClientService instance = null;
	
	public static ClientService getInstance() {
		if (instance == null) {
			instance = new ClientService();
		}
		
		return instance;
	}
	
	public List<Client> getAllClients() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/ProjetRestTomcat/client/getclients";
		String value = restTemplate.getForObject(url, String.class);
		
		ArrayList<Client> clients = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode rootNode = mapper.readValue(value, JsonNode.class);
			for (JsonNode node : rootNode.path("client")) {
			    //System.out.println("Client: " + node.toString());
				Client c = mapper.readValue(node.toString(), Client.class);
			    clients.add(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clients;
	}
	
	public Client getClient(int id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/ProjetRestTomcat/client/getclient";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("numcli", id);
		Client client = restTemplate.getForObject(builder.build().encode().toUri().toString(), Client.class);	
		
		return client;
	}
	
	public void storeClient(Client client) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/ProjetRestTomcat/client/createclient";
		
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(client);
			System.out.println(json);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> entity = new HttpEntity<String>(json, headers);
			String answer = restTemplate.postForObject(url, entity, String.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Client updateClient(Client client) {
		return null;
	}
	
	public void deleteClient(int id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/ProjetRestTomcat/client/deleteclient";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("numCli", id);
		String value = restTemplate.getForObject(builder.build().encode().toUri().toString(), String.class, id);
	}

}
