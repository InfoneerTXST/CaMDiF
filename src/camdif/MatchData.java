package camdif;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

public class MatchData implements Serializable {

	private String save_name;
	private String upper_capacity;
	private String lower_tolerance;
	private String upper_tolerance;
	private String upper_length;
	private String upper_diameter;
	private String lower_surface;
	private String upper_surface;
	private String lower_thickness;
	private String upper_thickness;
	private String upper_weight;
	private ArrayList<String> concepts;
	private ArrayList<IndividualWrapper> materials;
	private ArrayList<IndividualWrapper> functions;
	
	public MatchData() {
		save_name = "";
		upper_capacity = "";
		lower_tolerance = "";
		upper_tolerance = "";
		upper_length = "";
		upper_diameter = "";
		lower_surface = "";
		upper_surface = "";
		lower_thickness = "";
		upper_thickness = "";
		upper_weight = "";

		concepts = new ArrayList<>();
		materials = new ArrayList<>();
		functions = new ArrayList<>();
	}
	
	public MatchData(String save_name, String upper_capacity, String lower_tolerance, String upper_tolerance, String upper_length,
			String upper_diameter, String lower_surface, String upper_surface, String lower_thickness, String upper_thickness,
			String upper_weight, ArrayList<String> concepts, ArrayList<IndividualWrapper> materials, ArrayList<IndividualWrapper> functions) {
		
		this.save_name = save_name;
		this.upper_capacity = upper_capacity;
		this.lower_tolerance = lower_tolerance;
		this.upper_tolerance = upper_tolerance;
		this.upper_length = upper_length;
		this.upper_diameter = upper_diameter;
		this.lower_surface = lower_surface;
		this.upper_surface = upper_surface;
		this.lower_thickness = lower_thickness;
		this.upper_thickness = upper_thickness;
		this.upper_weight = upper_weight;
		
		this.concepts = new ArrayList<>();
		for(String s : concepts)
			this.concepts.add(s.trim().toLowerCase());
		
		this.materials = new ArrayList<>();
		for(IndividualWrapper iw : materials)
			this.materials.add(iw);
		
		this.functions = new ArrayList<>();
		for(IndividualWrapper iw : functions)
			this.functions.add(iw);
	}
	
	public String getCapacity() {
		return upper_capacity;
	}
	
	public String getLowerTolerance() {
		return lower_tolerance;
	}
	
	public String getUpperTolerance() {
		return upper_tolerance;
	}
	
	public String getLength() {
		return upper_length;
	}
	
	public String getDiameter() {
		return upper_diameter;
	}
	
	public String getLowerSurface() {
		return lower_surface;
	}
	
	public String getUpperSurface() {
		return upper_surface;
	}
	
	public String getLowerThickness() {
		return lower_thickness;
	}
	
	public String getUpperThickness() {
		return upper_thickness;
	}
	
	public String getWeight() {
		return upper_weight;
	}
	
	public ArrayList<String> getConcepts() {
		ArrayList<String> temp = new ArrayList<>();
		for(String s : concepts)
			temp.add(s);
		return temp;
	}
	
	public ArrayList<IndividualWrapper> getMaterials() {
		ArrayList<IndividualWrapper> temp = new ArrayList<>();
		for(IndividualWrapper iw : materials)
			temp.add(iw);
		return temp;
	}
	
	public ArrayList<IndividualWrapper> getFunctions() {
		ArrayList<IndividualWrapper> temp = new ArrayList<>();
		for(IndividualWrapper iw : functions)
			temp.add(iw);
		return temp;
	}
	
	public String toString() {
		return save_name;
	}
	
}
