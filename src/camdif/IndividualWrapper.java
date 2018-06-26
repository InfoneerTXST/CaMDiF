package camdif;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringWriter;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.RDFS;

public class IndividualWrapper implements Serializable {

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
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeObject(indiv.getURI());
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		String URI = (String)ois.readObject();
		indiv = Window.ontology.getIndividual(URI);
		try {
			label = indiv.getProperty(RDFS.label).getObject().asLiteral().getLexicalForm().trim();
		} catch(Exception a) {}
	}
	
}
