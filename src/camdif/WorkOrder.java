package camdif;

import java.util.ArrayList;

public class WorkOrder {

	private String part_name;
	private String production_volume;
	private String lower_tolerance;
	private String upper_tolerance;
	private String max_diameter;
	private String max_length;
	private String surface_roughness;
	private String min_wall_thickness;
	private String part_weight;
	private IndividualWrapper material_capability;
	private ArrayList<IndividualWrapper> process_capabilities;
	private ArrayList<String> concepts;
	
	public WorkOrder() {
		part_name = "";
		production_volume = "";
		lower_tolerance = "";
		upper_tolerance = "";
		max_diameter = "";
		max_length = "";
		surface_roughness = "";
		min_wall_thickness = "";
		part_weight = "";
		material_capability = new IndividualWrapper(null);
		process_capabilities = new ArrayList<>();
		concepts = new ArrayList<>();
	}
	
	public WorkOrder(String part_name, String production_volume, String lower_tolerance, String upper_tolerance,
			String max_diameter, String max_length, String surface_roughness, String min_wall_thickness,
			String part_weight, IndividualWrapper material_capability, ArrayList<IndividualWrapper> process_capabilities) {
		this.part_name = part_name;
		this.production_volume = production_volume;
		this.lower_tolerance = lower_tolerance;
		this.upper_tolerance = upper_tolerance;
		this.max_diameter = max_diameter;
		this.max_length = max_length;
		this.surface_roughness = surface_roughness;
		this.min_wall_thickness = min_wall_thickness;
		this.part_weight = part_weight;
		
		if(material_capability == null)
			this.material_capability = new IndividualWrapper(null);
		else
			this.material_capability = material_capability;
		
		this.process_capabilities = new ArrayList<>();
		for(IndividualWrapper iw : process_capabilities)
			this.process_capabilities.add(iw);
	}
	
	public String getPartName() {
		return part_name;
	}
	
	public String getProductionVolume() {
		return production_volume;
	}
	
	public String getLowerTolerance() {
		return lower_tolerance;
	}
	
	public String getUpperTolerance() {
		return upper_tolerance;
	}
	
	public String getMaxDiameter() {
		return max_diameter;
	}
	
	public String getMaxLength() {
		return max_length;
	}
	
	public String getSurfaceRoughness() {
		return surface_roughness;
	}
	
	public String getMinWallThickness() {
		return min_wall_thickness;
	}
	
	public String getPartWeight() {
		return part_weight;
	}
	
	public IndividualWrapper getMaterialCapability() {
		return material_capability;
	}
	
	public ArrayList<IndividualWrapper> getProcessCapabilities() {
		return process_capabilities;
	}
	
	public ArrayList<String> getConcepts() {
		return concepts;
	}
	
	public void setPartName(String part_name) {
		this.part_name = part_name;
	}
	
	public void setProductionVolume(String production_volume) {
		this.production_volume = production_volume;
	}
	
	public void setLowerTolerance(String lower_tolerance) {
		this.lower_tolerance = lower_tolerance;
	}
	
	public void setUpperTolerance(String upper_tolerance) {
		this.upper_tolerance = upper_tolerance;
	}
	
	public void setMaxDiameter(String max_diameter) {
		this.max_diameter = max_diameter;
	}
	
	public void setMaxLength(String max_length) {
		this.max_length = max_length;
	}
	
	public void setSurfaceRoughness(String surface_roughness) {
		this.surface_roughness = surface_roughness;
	}
	
	public void setMinWallThickness(String min_wall_thickness) {
		this.min_wall_thickness = min_wall_thickness;
	}
	
	public void setPartWeight(String part_weight) {
		this.part_weight = part_weight;
	}
	
	public void setMaterialCapability(IndividualWrapper material_capability) {
		if(material_capability == null)
			this.material_capability = new IndividualWrapper(null);
		this.material_capability = material_capability;
	}
	
	public void setProcessCapabilities(ArrayList<IndividualWrapper> process_capabilities) {
		this.process_capabilities = new ArrayList<>();
		for(IndividualWrapper iw : process_capabilities)
			this.process_capabilities.add(iw);
	}
	
	public void addProcessCapability(IndividualWrapper process_capability) {
		process_capabilities.add(process_capability);
	}
	
	public void addConcept(String concept) {
		concepts.add(concept);
	}
	
	public void removeConcept(String concept) {
		for(int x = 0; x < concepts.size(); ++x) {
			if(concepts.get(x).equals(concept)) {
				concepts.remove(x);
				return;
			}
		}
	}
	
}
