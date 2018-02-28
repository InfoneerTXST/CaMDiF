package camdif;

import org.apache.jena.ontology.Individual;
import org.apache.jena.vocabulary.RDFS;

public class IndividualWrapper {

	private Individual indiv;
	private String label;
	
	public IndividualWrapper(Individual indiv) {
		this.indiv = indiv;
		label = "";
		try {
			label = indiv.getProperty(RDFS.label).getObject().asLiteral().getLexicalForm().trim();
		} catch(Exception a) {}
	}
	
	public Individual getIndividual() {
		return indiv;
	}
	
	public String toString() {
		return label;
	}
	
}
