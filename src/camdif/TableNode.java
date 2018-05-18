package camdif;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.vocabulary.RDFS;

public class TableNode implements Comparable {

	private Individual individual;
	private String null_label;
	private String name;
	
	public TableNode(Individual individual, String null_label) {
		this.individual = individual;
		this.null_label = null_label;
		this.name = this.null_label;
		try { this.name = individual.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm().trim(); } catch(Exception e) {}
	}
	
	public Individual getIndividual() {
		return individual;
	}
	
	public String toString() {
		return name;
	}
	
	public int compareTo(Object a) {
		return(this.toString().compareTo(a.toString()));
	}
	
}
