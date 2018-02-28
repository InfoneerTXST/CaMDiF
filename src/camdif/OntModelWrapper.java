package camdif;

import org.apache.jena.ontology.OntModel;

public class OntModelWrapper {

	private OntModel model;
	private String name;
	
	public OntModelWrapper(OntModel model, String name) {
		this.model = model;
		this.name = name;
	}
	
	public OntModel getModel() {
		return model;
	}
	
	public String toString() {
		return name;
	}
	
}
