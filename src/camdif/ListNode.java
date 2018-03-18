package camdif;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.vocabulary.RDFS;

public class ListNode implements Comparable {

	private Individual indiv;
	private OntClass category_class;
	private String null_label;
	private String skill_level;
	
	public ListNode(Individual indiv, OntClass category_class, String null_label) {
		this.indiv = indiv;
		this.category_class = category_class;
		this.null_label = null_label;
		this.skill_level = "";
	}
	
	public Individual getIndividual() {
		return indiv;
	}
	
	public OntClass getCategoryClass() {
		return category_class;
	}
	
	public String getSkillLevel() {
		return skill_level;
	}
	
	public void setSkillLevel(String skill_level) {
		this.skill_level = skill_level;
	}
	
	public String toString() {
		try {
			if(!skill_level.isEmpty() && category_class.getURI().equals("http://infoneer.txstate.edu/ontology/MSDL_0001034"))
				return indiv.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm() + " (" + skill_level + ")";
			return indiv.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
		} catch(Exception e) {}
		return null_label;
	}
	
	public int compareTo(Object a) {
		return(this.toString().compareTo(a.toString()));
	}
	
}
