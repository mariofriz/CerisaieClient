package camping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {
	
	@JsonProperty("numCli")
	private int id;
	@JsonProperty("nomCli")
	private String name;
	@JsonProperty("adrRueCli")
	private String address;
	@JsonProperty("cpCli")
	private String zipCode;
	@JsonProperty("villeCli")
	private String city;
	@JsonProperty("pieceCli")
	private String typeIdentity;
	@JsonProperty("numPieceCli")
	private String numIdentity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTypeIdentity() {
		return typeIdentity;
	}
	public void setTypeIdentity(String typeIdentity) {
		this.typeIdentity = typeIdentity;
	}
	public String getNumIdentity() {
		return numIdentity;
	}
	public void setNumIdentity(String numIdentity) {
		this.numIdentity = numIdentity;
	}
	
	public String toString() {
		return "Id : " + id
				+ " , Name : " + name
				+ " , City : " + city;
	}

}
