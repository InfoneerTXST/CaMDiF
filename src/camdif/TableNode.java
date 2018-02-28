package camdif;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.vocabulary.RDFS;

public class TableNode implements Comparable {

	private Individual individual;
	private String null_label;
	
	public TableNode(Individual individual, String null_label) {
		this.individual = individual;
		this.null_label = null_label;
	}
	
	public Individual getIndividual() {
		return individual;
	}
	
	public String toString() {
		if(individual != null)
			return individual.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm().trim();
		else
			return null_label;
	}
	
	public int compareTo(Object a) {
		return(this.toString().compareTo(a.toString()));
	}
	
}
