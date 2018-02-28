package camdif;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.vocabulary.RDFS;

public class OntClassWrapper implements Comparable {

	private OntClass ont_class;
	
	public OntClassWrapper(OntClass ont_class) {
		this.ont_class = ont_class;
	}
	
	public OntClass getOntClass() {
		return ont_class;
	}
	
	public String toString() {
		try {
			return ont_class.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
		} catch(Exception e) {}
		return "";
	}
	
	public int compareTo(Object a) {
		return(this.toString().compareTo(a.toString()));
	}
	
}
