package camping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
	
	@JsonProperty("numEmpl")
	int id;
	@JsonProperty("nbPersMaxEmpl")
	int maxPersons;
	@JsonProperty("surfaceEmpl")
	double area;
	@JsonProperty("typeEmplacement")
	TypeLocation typeLocation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaxPersons() {
		return maxPersons;
	}
	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public TypeLocation getTypeLocation() {
		return typeLocation;
	}
	public void setTypeLocation(TypeLocation typeLocation) {
		this.typeLocation = typeLocation;
	}
	
}
