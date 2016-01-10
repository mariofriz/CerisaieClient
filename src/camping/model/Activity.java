package camping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {

	@JsonProperty("id")
	ActivityDetails details;
	@JsonProperty("nbloc")
	int amount;
	@JsonProperty("sport")
	Sport sport;
	public ActivityDetails getDetails() {
		return details;
	}
	public void setDetails(ActivityDetails details) {
		this.details = details;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
}
