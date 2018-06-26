package camdif;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringWriter;

import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFWriter;

public class OntModelWrapper implements Serializable {

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
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		StringWriter out = new StringWriter();
		out.write(name + "<camdif_model_flag>");
		model.write(out, "RDF/XML-ABBREV");
		String rdfxml = out.toString();
		oos.writeObject(rdfxml);
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		String str = (String)ois.readObject();
		int flag_index = str.indexOf("<camdif_model_flag>");
		name = str.substring(0, flag_index);
		model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		OntDocumentManager model_dm = model.getDocumentManager();
		model_dm.addAltEntry("http://infoneer.txstate.edu/ontology/MSDL.owl", "file:information/MSDL.owl");
		model.read(new ByteArrayInputStream(str.substring(flag_index + 19).getBytes()), "RDF/XML");
	}
	
}
