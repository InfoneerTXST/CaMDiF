package camdif;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonNodeWrapper implements Comparable {

	private JsonNode j;
	private String name;
	private String matching_name;
	private String matching_name_alt;
	
	public JsonNodeWrapper(JsonNode j) {
		this.j = j;
		name = "";
		try {
			name = j.get("http://www.w3.org/2004/02/skos/core#prefLabel").get(0).get("value").asText();
		} catch(Exception a) {}
		matching_name = name.toLowerCase().replaceAll("&", " and ").trim().replaceAll("\\s+", " ");
		if(matching_name.equals(" "))
			matching_name = "";
		matching_name_alt = "";
		try {
			matching_name_alt = j.get("http://www.w3.org/2004/02/skos/core#altLabel").get(0).get("value").asText().toLowerCase().replaceAll("&", " and ").trim().replaceAll("\\s+", " ");;
		} catch(Exception a) {}
		if(matching_name_alt.equals(" "))
			matching_name_alt = "";
	}
	
	public JsonNode getJsonNode() {
		return j;
	}
	
	public String getMatchingName() {
		return matching_name;
	}
	
	public String getMatchingNameAlt() {
		return matching_name_alt;
	}
	
	public String toString() {
		return name;
	}
	
	public int compareTo(Object a) {
		return(this.toString().toLowerCase().compareTo(a.toString().toLowerCase()));
	}

}
