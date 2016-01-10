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

}
