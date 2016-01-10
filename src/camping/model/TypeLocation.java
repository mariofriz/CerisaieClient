package camping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TypeLocation {
	
	@JsonProperty("codeTypeE")
	String type;
	@JsonProperty("libtypepl")
	String label;
	@JsonProperty("tariftypepl")
	double price;

}
