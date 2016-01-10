package camping.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stay {
	
	@JsonProperty("numSej")
	int id;
	@JsonProperty("client")
	Client client;
	@JsonProperty("emplacement")
	Location location;
	@JsonProperty("datedebSej")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	Date startDate;
	@JsonProperty("dateFinSej")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	Date endDate;
	@JsonProperty("nbPersonnes")
	int numberPersons;
	
	@JsonProperty("numCli")
	int idClient;
	@JsonProperty("numEmplacement")
	int idLocation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getNumberPersons() {
		return numberPersons;
	}
	public void setNumberPersons(int numberPersons) {
		this.numberPersons = numberPersons;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}
	
}
