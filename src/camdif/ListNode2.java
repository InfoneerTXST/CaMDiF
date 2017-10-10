package camdif;

import org.apache.jena.ontology.OntModel;

public class ListNode2 implements Comparable {

	private OntModel factory;
	private String save_name;
	
	public ListNode2(OntModel factory, String save_name) {
		this.factory = factory;
		this.save_name = save_name;
	}
	
	public OntModel getFactory() {
		return factory;
	}
	
	public String toString() {
		return save_name;
	}
	
	public int compareTo(Object a) {
		return(this.toString().compareTo(a.toString()));
	}
	
}
