package camdif;

import java.util.ArrayList;

public class MatchData {

	private String save_name;
	private String upper_capacity;
	private String upper_tolerance;
	private String upper_length;
	private String upper_diameter;
	private String upper_surface;
	private String upper_min_thickness;
	private String upper_weight;
	private ArrayList<String> concepts;
	private ArrayList<String> materials;
	private ArrayList<String> functions;
	
	public MatchData(String save_name, String upper_capacity, String upper_tolerance, String upper_length,
			String upper_diameter, String upper_surface, String upper_min_thickness, String upper_weight,
			ArrayList<String> concepts, ArrayList<String> materials, ArrayList<String> functions) {
		
		this.save_name = save_name;
		this.upper_capacity = upper_capacity;
		this.upper_tolerance = upper_tolerance;
		this.upper_length = upper_length;
		this.upper_diameter = upper_diameter;
		this.upper_surface = upper_surface;
		this.upper_min_thickness = upper_min_thickness;
		this.upper_weight = upper_weight;
		
		this.concepts = new ArrayList<>();
		for(String s : concepts)
			this.concepts.add(s.trim().toLowerCase());
		
		this.materials = new ArrayList<>();
		for(String s : materials)
			this.materials.add(s.trim().toLowerCase());
		
		this.functions = new ArrayList<>();
		for(String s : functions)
			this.functions.add(s.trim().toLowerCase());
	}
	
	public String getCapacity() {
		return upper_capacity;
	}
	
	public String getTolerance() {
		return upper_tolerance;
	}
	
	public String getLength() {
		return upper_length;
	}
	
	public String getDiameter() {
		return upper_diameter;
	}
	
	public String getSurface() {
		return upper_surface;
	}
	
	public String getThickness() {
		return upper_min_thickness;
	}
	
	public String getWeight() {
		return upper_weight;
	}
	
	public ArrayList<String> getConcepts() {
		return concepts;
	}
	
	public ArrayList<String> getMaterials() {
		return materials;
	}
	
	public ArrayList<String> getFunctions() {
		return functions;
	}
	
	public String toString() {
		return save_name;
	}
	
}
