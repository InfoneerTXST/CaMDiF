package camdif;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.vocabulary.RDFS;

public class ListNode implements Comparable {

	private Individual indiv;
	private OntClass category_class;
	private String null_label;
	
	public ListNode(Individual indiv, OntClass category_class, String null_label) {
		this.indiv = indiv;
		this.category_class = category_class;
		this.null_label = null_label;
	}
	
	public Individual getIndividual() {
		return indiv;
	}
	
	public OntClass getCategoryClass() {
		return category_class;
	}
	
	public String toString() {
		try {
			return indiv.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
		} catch(Exception e) {}
		return null_label;
	}
	
	public int compareTo(Object a) {
		return(this.toString().compareTo(a.toString()));
	}
	
}
