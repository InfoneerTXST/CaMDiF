// Reid Yoder
// Texas State University
// Spring 2017

// DO NOT CHANGE THE ORDER OF COMBOBOX ITEMS
// DO NOT CHANGE THE URI OF ANY CLASS IN THE ONTOLOGY

package camdif;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.ToolTipManager;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.ontology.OntResource;
import org.apache.jena.ontology.OntTools;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.NodeIterator;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.RDFWriter;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.jena.vocabulary.RDFS;
import com.github.jsonldjava.core.RDFDataset.Literal;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;

public class Window extends JFrame {
	
	private static Window frame;
	private static boolean loading;
	private static JFileChooser fc;
	private static int result;
	private static OntModelSpec modelSpec = OntModelSpec.OWL_MEM; // change for reasoner
	private static OntModel ontology;
	private static OntModel demo_factory;
	private static OntClass combo_class;
	private static OntClass class_MachineTool;
	private static OntClass class_3DPrinter;
	private static OntClass class_Industry;
	private static OntClass class_Material;
	private static OntClass class_Software;
	private static OntClass class_Certification;
	private Company company;
	private JComboBox<String> comboBox;
	private ArrayList<ListNode2> saved_factories;
	private JList<ListNode> list;
	private DefaultListModel<ListNode> list_model;
	private JScrollPane scrollPane_1;
	private ArrayList<ListNode> equipment_individuals;
	private ArrayList<ListNode> capability_individuals;
	private boolean any;
	private boolean b_3d;
	private boolean b_machine;
	private boolean b_industry;
	private boolean b_material;
	private boolean b_software;
	private boolean b_certification;
	private static String uri_MachineTool = "http://infoneer.txstate.edu/ontology/MSDL_0000070";
	private static String uri_3DPrinter = "http://infoneer.txstate.edu/ontology/MSDL_0000680";
	private static String uri_Industry = "http://infoneer.txstate.edu/ontology/MSDL_0000686";
	private static String uri_Material = "http://infoneer.txstate.edu/ontology/MSDL_0000003";
	private static String uri_Software = "http://purl.obolibrary.org/obo/IAO_0000594";
	private static String uri_Certification = null; // TODO
	private int screenWidth = 700;
	private int screenHeight = 600;
	private Color highlight_color = new Color(255, 220, 0);
	private Color background_color = new Color(235, 235, 235);
	private Color etched_color1 = Color.LIGHT_GRAY;
	private Color etched_color2 = new Color(242, 242, 242);
	private Color tab_color1 = new Color(220, 220, 220);
	private Color tab_color2 = new Color(205, 205, 205);
	private String s_3d = "<html><b>3D Printers</b></html>";
	private String s_machine = "<html><b>Machine Tools</b></html>";
	private String s_industry = "<html><b>Industries</b></html>";
	private String s_material = "<html><b>Materials</b></html>";
	private String s_software = "<html><b>Software</b></html>";
	private String s_certification = "<html><b>Certifications</b></html>";
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					loading = true;
					frame = new Window();
					frame.addWindowListener(new WindowAdapter() {
			            @Override
			            public void windowClosing(WindowEvent e) {
			            	if(loading)
			            		System.exit(0);
			            }
			            @Override
			            public void windowClosed(WindowEvent e) {
			            	if(loading)
			            		System.exit(0);
			            }
			        });
					frame.setResizable(false);
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Window() {
		super();
		setLocationRelativeTo(null);
		loadPage();
	}
	
	public Window(String frame_title) {
		super(frame_title);
	
		company = new Company();
		saved_factories = new ArrayList<ListNode2>();
		equipment_individuals = new ArrayList<ListNode>();
		capability_individuals = new ArrayList<ListNode>();
		
		class_MachineTool = ontology.getOntClass(uri_MachineTool);
		class_3DPrinter = ontology.getOntClass(uri_3DPrinter);
		class_Industry = ontology.getOntClass(uri_Industry);
		class_Material = ontology.getOntClass(uri_Material);
		class_Software = ontology.getOntClass(uri_Software);
		class_Certification = null; // TODO

		Icon empty_icon = new ImageIcon();
		Icon folder_icon = new ImageIcon(getClass().getResource("/images/folder.png"));
		Icon file_icon = new ImageIcon(getClass().getResource("/images/file.png"));
		Icon folder_up_icon = new ImageIcon(getClass().getResource("/images/folder_up.png"));
		Icon home_icon = new ImageIcon(getClass().getResource("/images/home.png"));
		Icon question_icon = new ImageIcon(getClass().getResource("/images/question.png"));
		Icon collapsed_icon = new ImageIcon(getClass().getResource("/images/collapsed.png"));
		Icon expanded_icon = new ImageIcon(getClass().getResource("/images/expanded.png"));
		
		try {
			List<Image> icons = new ArrayList<Image>();
			//icons.add(new ImageIcon(getClass().getResource("/images/logo20.png")).getImage());
			//icons.add(new ImageIcon(getClass().getResource("/images/logo32.png")).getImage());
			super.setIconImages(icons);
		} catch (NullPointerException e) {}
		
		try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } catch(Exception e) { System.out.println("Error 1 setting Java LAF: " + e); }
		
		UIManager.put("Panel.background", background_color);
		UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 12));
		UIManager.put("Label.foreground", Color.DARK_GRAY);
		UIManager.put("Button.foreground", Color.DARK_GRAY);
		UIManager.put("ButtonUI", ButtonUI.class.getName());
		UIManager.put("Tree.closedIcon", empty_icon);
        UIManager.put("Tree.openIcon", empty_icon);
        UIManager.put("Tree.collapsedIcon", collapsed_icon);
        UIManager.put("Tree.expandedIcon", expanded_icon);
        UIManager.put("Tree.leafIcon", empty_icon);
        UIManager.put("Tree.textForeground", Color.DARK_GRAY);
        UIManager.put("Tree.hash", Color.LIGHT_GRAY);
        UIManager.put("Tree.selectionBackground", highlight_color);
        UIManager.put("Tree.selectionForeground", Color.DARK_GRAY);
        UIManager.put("Tree.selectionBorderColor", highlight_color);
        UIManager.put("List.foreground", Color.DARK_GRAY);
        UIManager.put("List.selectionForeground", Color.DARK_GRAY);
        UIManager.put("List.selectionBackground", highlight_color);
        UIManager.put("List.focusCellHighlightBorder", highlight_color);
        UIManager.put("ScrollBar.shadow", new Color(235, 235, 235));
        UIManager.put("ScrollBar.darkShadow", Color.GRAY);
        UIManager.put("TextField.border", BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        UIManager.put("TextField.selectionBackground", tab_color1);
        UIManager.put("TextField.foreground", Color.DARK_GRAY);
        UIManager.put("ComboBox.foreground", Color.DARK_GRAY);
        UIManager.put("ComboBox.background", tab_color1);
        UIManager.put("ComboBox.selectionForeground", Color.DARK_GRAY);
        UIManager.put("ComboBox.selectionBackground", new Color(235, 235, 235));
        UIManager.put("ComboBox.disabledForeground", Color.DARK_GRAY);
        UIManager.put("ComboBox.disabledBackground", tab_color1);
		UIManager.put("FileChooser.readOnly", Boolean.TRUE);
		UIManager.put("FileView.directoryIcon", folder_icon);
		UIManager.put("FileView.computerIcon", folder_icon);
		UIManager.put("FileView.floppyDriveIcon", folder_icon);
		UIManager.put("FileView.hardDriveIcon", folder_icon);
		UIManager.put("FileView.fileIcon", file_icon);
		UIManager.put("FileChooser.upFolderIcon", folder_up_icon);
		UIManager.put("FileChooser.homeFolderIcon", home_icon);
		UIManager.put("OptionPane.questionIcon", question_icon);
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 12));
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 12));
		UIManager.put("PopupMenuUI", PopupUI.class.getName());
		UIManager.put("OptionPane.background", background_color);
		UIManager.put("TabbedPaneUI", TabbedUI.class.getName());
		UIManager.put("TabbedPane.font", new Font("Consolas", Font.PLAIN, 12));
		UIManager.put("TabbedPane.foreground", Color.DARK_GRAY);
		UIManager.put("Table.gridColor", tab_color2);
		UIManager.put("Table.foreground", Color.DARK_GRAY);
		UIManager.put("TableHeader.foreground", Color.DARK_GRAY);
		UIManager.put("TableHeader.cellBorder", BorderFactory.createMatteBorder(0, 0, 1, 1, tab_color2));
		
		try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } catch(Exception e) { System.out.println("Error 2 setting Java LAF: " + e); }
		
		ToolTipManager.sharedInstance().setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		company.setName("Default Factory");
		company.setType("Contract manufacturer");
		company.setBusinessType("Small business manufacturing company");
		equipment_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL#MSDL_0000250"), class_MachineTool, ""));
		equipment_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL#MSDL_0000396"), class_MachineTool, ""));
		equipment_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000747"), class_3DPrinter, ""));
		equipment_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000709"), class_3DPrinter, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000797"), class_Industry, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000794"), class_Industry, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000792"), class_Industry, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000834"), class_Material, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000819"), class_Material, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000829"), class_Material, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000783"), class_Software, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000776"), class_Software, ""));
		demo_factory = generateFinalFactory();
		saved_factories.add(new ListNode2(demo_factory, "Default Factory"));
		company = new Company();
		equipment_individuals = new ArrayList<ListNode>();
		capability_individuals = new ArrayList<ListNode>();
		
		loading = false;
		menuPage();
	}
	
	public void loadPage() {
		SwingWorker<?,?> worker = new SwingWorker<Void,Void>() {
			@Override
			protected Void doInBackground() {
				ontology = ModelFactory.createOntologyModel(modelSpec);
				ontology.read("ontologies/MSDL.owl", "RDF/XML");
	            return null;
			}
			
			@Override
			protected void done() {
				frame.dispose();
				frame = new Window("CaMDiF Tool");
				frame.setResizable(false);
				frame.setUndecorated(false);
				frame.setVisible(true);
	        }
		};
	    worker.execute();

		getContentPane().removeAll();
		int loadWidth = 383, loadHeight = 279;
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JLabel label = new JLabel(new ImageIcon(getClass().getResource("/images/loading.gif")));
		panel.add(label);
		setBounds(this.getX() + (this.getWidth() / 2) - (loadWidth / 2), this.getY() + (this.getHeight() / 2) - (loadHeight / 2), loadWidth, loadHeight);
		validate();
	}
	
	// USE THIS METHOD INSTEAD OF "individual.getOntClass()"
	public OntClass getOntClassOf(Individual i) {
		OntClass c = null;
		for(ExtendedIterator<Resource> it = i.listRDFTypes(true); it.hasNext(); ) {
			Resource r = it.next();
			if(r.getURI().equals("http://www.w3.org/2002/07/owl#NamedIndividual") || r.getURI().equals("http://www.w3.org/2002/07/owl#Class")) {}
			else {
				c = ontology.getOntClass(r.getURI());
				break;
			}
		}
		return c;
	}
	
	public String generateID(OntModel model) {
		String ID_prefix = "http://infoneer.txstate.edu/ontology/MSDL_9999999";
		String ID;
		Resource ID_resource;
		int counter = 0;
		
		do {
			counter++;
			ID = ID_prefix + counter;
			ID_resource = model.getResource(ID);
		} while(model.containsResource(ID_resource) || ontology.containsResource(ID_resource));
		
		return ID;
	}
	
	public void refresh_3d() {
		for(int i = 0; i < equipment_individuals.size(); i++) {
			if(equipment_individuals.get(i).getCategoryClass().equals(class_3DPrinter)) {
				if(!b_3d) {
					if(any)
						list_model.addElement(new ListNode(null, null, "\n"));
					list_model.addElement(new ListNode(null, null, s_3d));
					b_3d = true;
					any = true;
				}
				list_model.addElement(equipment_individuals.get(i));
			}
	    }
	}
	
	public void refresh_machine() {
		for(int i = 0; i < equipment_individuals.size(); i++) {
			if(equipment_individuals.get(i).getCategoryClass().equals(class_MachineTool)) {
				if(!b_machine) {
					if(any)
						list_model.addElement(new ListNode(null, null, "\n"));
					list_model.addElement(new ListNode(null, null, s_machine));
					b_machine = true;
					any = true;
				}
				list_model.addElement(equipment_individuals.get(i));
			}
	    }
	}
	
	public void refresh_industry() {
		for(int i = 0; i < capability_individuals.size(); i++) {
			if(capability_individuals.get(i).getCategoryClass().equals(class_Industry)) {
				if(!b_industry) {
					if(any)
						list_model.addElement(new ListNode(null, null, "\n"));
					list_model.addElement(new ListNode(null, null, s_industry));
					b_industry = true;
					any = true;
				}
				list_model.addElement(capability_individuals.get(i));
			}
	    }
	}
	
	public void refresh_material() {
		for(int i = 0; i < capability_individuals.size(); i++) {
			if(capability_individuals.get(i).getCategoryClass().equals(class_Material)) {
				if(!b_material) {
					if(any)
						list_model.addElement(new ListNode(null, null, "\n"));
					list_model.addElement(new ListNode(null, null, s_material));
					b_material = true;
					any = true;
				}
				list_model.addElement(capability_individuals.get(i));
			}
	    }
	}
	
	public void refresh_software() {
		for(int i = 0; i < capability_individuals.size(); i++) {
			if(capability_individuals.get(i).getCategoryClass().equals(class_Software)) {
				if(!b_software) {
					if(any)
						list_model.addElement(new ListNode(null, null, "\n"));
					list_model.addElement(new ListNode(null, null, s_software));
					b_software = true;
					any = true;
				}
				list_model.addElement(capability_individuals.get(i));
			}
	    }
	}
	
	public void refresh_certification() {
		for(int i = 0; i < capability_individuals.size(); i++) {
			if(capability_individuals.get(i).getCategoryClass().equals(class_Certification)) {
				if(!b_certification) {
					if(any)
						list_model.addElement(new ListNode(null, null, "\n"));
					list_model.addElement(new ListNode(null, null, s_certification));
					b_certification = true;
					any = true;
				}
				list_model.addElement(capability_individuals.get(i));
			}
	    }
	}
	
	public boolean refreshList(boolean first_page, OntClass added) {
		list_model.removeAllElements();
		any = false;
		b_3d = false;
		b_machine = false;
		b_industry = false;
		b_material = false;
		b_software = false;
		b_certification = false;
		boolean r = false;
		
		if(first_page) {
			boolean first_3d = false;
			for(int i = 0; i < equipment_individuals.size(); i++) {
				if(equipment_individuals.get(0).getCategoryClass().equals(class_3DPrinter)) {
					first_3d = true;
					i = equipment_individuals.size();
				}
			}
			if(first_3d) {
				refresh_3d();
				refresh_machine();
				if(added != null && added.equals(class_MachineTool))
					r = true;
			}
			else {
				refresh_machine();
				refresh_3d();
				if(added != null && added.equals(class_3DPrinter))
					r = true;
			}
		}
		else {
			boolean ref_industry = false, ref_material = false, ref_software = false, ref_certification = false;
			for(int i = 0; i < capability_individuals.size(); i++) {
				if(capability_individuals.get(i).getCategoryClass().equals(class_Industry) && !ref_industry) {
					r = false;
					refresh_industry();
					ref_industry = true;
					if(added != null && added.equals(class_Industry))
						r = true;
				}
				if(capability_individuals.get(i).getCategoryClass().equals(class_Material) && !ref_material) {
					r = false;
					refresh_material();
					ref_material = true;
					if(added != null && added.equals(class_Material))
						r = true;
				}
				if(capability_individuals.get(i).getCategoryClass().equals(class_Software) && !ref_software) {
					r = false;
					refresh_software();
					ref_software = true;
					if(added != null && added.equals(class_Software))
						r = true;
				}
				if(capability_individuals.get(i).getCategoryClass().equals(class_Certification) && !ref_certification) {
					r = false;
					refresh_certification();
					ref_certification = true;
					if(added != null && added.equals(class_Certification))
						r = true;
				}
				if(ref_industry && ref_material && ref_software && ref_certification)
					i = capability_individuals.size();
			}
		}
		
		scrollPane_1.validate();
		return r;
	}
	
	public boolean isCategoryOf(OntClass child, OntClass category) {
		return (OntTools.findShortestPath(child.getOntModel(), child, category, new OntTools.PredicatesFilter(RDFS.subClassOf)) != null);
	}
	
	private void configureFileChooserUI(Component[] components, boolean save) {
		for(int i = 0; i < components.length; i++)
		{
			if(components[i] instanceof Container)
				configureFileChooserUI(((Container)components[i]).getComponents(), save);
			if(components[i] instanceof JButton)
			{
				JButton jbutton = (JButton)components[i];
				jbutton.setFont(new Font("Arial", Font.PLAIN, 12));
			}
			if(components[i] instanceof JTextField && save)
				((JTextField)components[i]).setText(company.getName().replaceAll(" ","") + "Factory" + ".owl");
			if(components[i] instanceof JScrollPane)
			{
				JScrollPane jscroll = (JScrollPane)components[i];
				jscroll.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jscroll.getVerticalScrollBar().setUnitIncrement(10);
				jscroll.getHorizontalScrollBar().setUnitIncrement(10);
				jscroll.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
				jscroll.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
				jscroll.setOpaque(false);
			}
			if(components[i] instanceof JComboBox)
			{
				JComboBox jcombo = (JComboBox)components[i];
				jcombo.setFont(new Font("Arial", Font.PLAIN, 12));
				jcombo.setUI(new ComboUI(jcombo, false));
				jcombo.setBorder(new LineBorder(Color.LIGHT_GRAY));
				jcombo.setBackground(tab_color1);
				jcombo.setFocusable(false);
				jcombo.setEnabled(false);
			}
			if(components[i] instanceof JLabel)
				((JLabel)components[i]).setFont(new Font("Arial", Font.PLAIN, 12));
			if(components[i] instanceof JToggleButton)
				((JToggleButton)components[i]).setVisible(false);
			if(components[i] instanceof JList)
			{
				JList jlist = (JList)components[i];
				jlist.setFocusable(false);
				jlist.setFont(new Font("Arial", Font.PLAIN, 12));
			}
		}
	}
	
	public OntModel generateFinalFactory() {
		OntModel factory = ModelFactory.createOntologyModel(modelSpec);
		factory.setStrictMode(false);
		Individual company_indiv;
		String company_comment = company.getName() + " information:";
		
		boolean other = false;
		if(company.getBusinessType().trim().equals("Small business manufacturing company"))
			company_indiv = factory.createIndividual(generateID(factory), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000873"));
		else if(company.getBusinessType().trim().equals("Veteran-owned manufacturing company"))
			company_indiv = factory.createIndividual(generateID(factory), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000872"));
		else if(company.getBusinessType().trim().equals("Woman-owned manufacturing company"))
			company_indiv = factory.createIndividual(generateID(factory), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000871"));
		else if(company.getBusinessType().trim().equals("Minority-owned manufacturing company"))
			company_indiv = factory.createIndividual(generateID(factory), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000870"));
		else {
			company_indiv = factory.createIndividual(generateID(factory), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000017"));
			//company_indiv.addComment("Company has business type: Manufacturing company", "en");
			company_comment += "\nBusiness type: Manufacturing company";
			other = true;
		}
		if(!other) {
			//company_indiv.addComment("Company has business type: " + company.getBusinessType().trim(), "en");
			company_comment += "\nBusiness type: " + company.getBusinessType().trim();
		}
		
		Property prop_hasCompanyType = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000877");
		if(company.getType().trim().equals("Original design manufacturer")) {
			company_indiv.addProperty(prop_hasCompanyType, ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000868"));
			//company_indiv.addComment("Company has company type: Original design manufacturer", "en");
			company_comment += "\nCompany type: Original design manufacturer";
		}
		else if(company.getType().trim().equals("Original equipment manufacturer")) {
			company_indiv.addProperty(prop_hasCompanyType, ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000867"));
			//company_indiv.addComment("Company has company type: Original equipment manufacturer", "en");
			company_comment += "\nCompany type: Original equipment manufacturer";
		}
		else if(company.getType().trim().equals("Contract manufacturer")) {
			company_indiv.addProperty(prop_hasCompanyType, ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000866"));
			//company_indiv.addComment("Company has company type: Contract manufacturer", "en");
			company_comment += "\nCompany type: Contract manufacturer";
		}
		else {
			company_indiv.addProperty(prop_hasCompanyType, ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000865"));
			//company_indiv.addComment("Company has company type: Other", "en");
			company_comment += "\nCompany type: Other";
		}
		
		Property prop_hasName = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000149");
		Individual company_name = factory.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000878"));
		company_name.setLabel(company.getName().trim(), "en");
		company_indiv.addProperty(prop_hasName, company_name);
		//company_indiv.addComment("Company has name: " + company.getName().trim(), "en");
		company_comment += "\nName: " + company.getName().trim();

		if(!(company.getEmployees().equals(""))) {
			Individual employees_cmd = null;
			Individual employees_count = null;
			try {
				Property prop_hasNumEmployees = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000874");
				Property prop_isQualMeasAs = ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417");
				Property prop_hasMeasVal = ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004");
				employees_cmd = factory.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000150"));
				employees_cmd.addProperty(prop_hasMeasVal, factory.createTypedLiteral(Double.parseDouble(company.getEmployees().replaceAll(",", "").trim())));
				employees_count = factory.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000194"));
				employees_count.addProperty(prop_isQualMeasAs, employees_cmd);
				company_indiv.addProperty(prop_hasNumEmployees, employees_count);
				//company_indiv.addComment("Company has number of employees: " + company.getEmployees().replaceAll(",", "").trim(), "en");
				company_comment += "\nEmployee count: " + company.getEmployees().replaceAll(",", "").trim();
			} catch(Exception e) {
				if(employees_cmd != null)
					employees_cmd.remove();
				if(employees_count != null)
					employees_count.remove();
			}
		}
		
		if(!(company.getYearFounded().equals(""))) {
			// Property prop_hasYearFounded = ; TODO
		}
		
		if(!(company.getURL().equals(""))) {
			Property prop_hasWebAddress = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000876");
			Individual web_address = factory.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000864"));
			web_address.setLabel(company.getURL().trim(), "en");
			company_indiv.addProperty(prop_hasWebAddress, web_address);
			//company_indiv.addComment("Company has web address: " + company.getURL().trim(), "en");
			company_comment += "\nWeb address: " + company.getURL().trim();
		}
		
		Property prop_hasPhysicalAddress = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000875");
		if(!(company.getAddress().equals(""))) {
			Individual street_address = factory.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000840"));
			street_address.setLabel(company.getAddress().trim(), "en");
			company_indiv.addProperty(prop_hasPhysicalAddress, street_address);
			//company_indiv.addComment("Company has street address: " + company.getAddress().trim(), "en");
			company_comment += "\nStreet address: " + company.getAddress().trim();
		}
		if(!(company.getCity().equals(""))) {
			Individual city = factory.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000838"));
			city.setLabel(company.getCity().trim(), "en");
			company_indiv.addProperty(prop_hasPhysicalAddress, city);
			//company_indiv.addComment("Company has city address: " + company.getCity().trim(), "en");
			company_comment += "\nCity address: " + company.getCity().trim();
		}
		if(!(company.getState().equals(""))) {
			Individual state = factory.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000841"));
			state.setLabel(company.getState().trim(), "en");
			company_indiv.addProperty(prop_hasPhysicalAddress, state);
			//company_indiv.addComment("Company has state address: " + company.getState().trim(), "en");
			company_comment += "\nState address: " + company.getState().trim();
		}
		if(!(company.getZip().equals(""))) {
			Individual zip = factory.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000839"));
			zip.setLabel(company.getZip().trim(), "en");
			company_indiv.addProperty(prop_hasPhysicalAddress, zip);
			//company_indiv.addComment("Company has zip address: " + company.getZip().trim(), "en");
			company_comment += "\nZip address: " + company.getZip().trim();
		}

		Individual factory_indiv = factory.createIndividual(generateID(factory), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000090"));
		String factory_comment = company.getName() + " factory information:";
		Property prop_operates = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000679");
		Property prop_hasFactoryEquipment = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000129");
		Property prop_hasMaterialCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000770");
		Property prop_hasIndustryCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000769");
		Property prop_hasSoftwareCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000771");
		// Property prop_hasCertificateCapability = ; TODO
		for(int x = 0; x < equipment_individuals.size(); x++) {
			ListNode l = equipment_individuals.get(x);
			Individual i = l.getIndividual();
			OntClass c = l.getCategoryClass();
			String s = c.getURI();
			if(s.equals(uri_3DPrinter)) {
				factory_indiv.addProperty(prop_hasFactoryEquipment, i);
				//factory_indiv.addComment("Factory has equipement: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(), "en");
				factory_comment += "\nEquipment: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
			}
			else if(s.equals(uri_MachineTool)) {
				factory_indiv.addProperty(prop_hasFactoryEquipment, i);
				//factory_indiv.addComment("Factory has equipement: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(), "en");
				factory_comment += "\nEquipment: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
			}
		}
		for(int x = 0; x < capability_individuals.size(); x++) {
			ListNode l = capability_individuals.get(x);
			Individual i = l.getIndividual();
			OntClass c = l.getCategoryClass();
			String s = c.getURI();
			if(s.equals(uri_Material)) {
				company_indiv.addProperty(prop_hasMaterialCapability, i);
				//company_indiv.addComment("Company has material capability: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(), "en");
				company_comment += "\nMaterial capability: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
			}
			else if(s.equals(uri_Industry)) {
				company_indiv.addProperty(prop_hasIndustryCapability, i);
				//company_indiv.addComment("Company has industry capability: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(), "en");
				company_comment += "\nIndustry capability: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
			}
			else if(s.equals(uri_Software)) {
				company_indiv.addProperty(prop_hasSoftwareCapability, i);
				//company_indiv.addComment("Company has software capability: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(), "en");
				company_comment += "\nSoftware capability: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
			}
			else if(s.equals(uri_Certification)) {
				// TODO
			}
		}
		factory_indiv.setLabel(company.getName() + " factory", "en");
		if(!(factory_comment.equals(company.getName() + " factory information:")))
			factory_indiv.addComment(factory_comment, "en");
		company_indiv.addProperty(prop_operates, factory_indiv);
		company_indiv.setLabel(company.getName(), "en");
		company_indiv.addComment(company_comment, "en");
		return factory;
	}
	
	public void menuPage() {
		getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnBuild = new JButton("Build");
		btnBuild.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBuild = new GridBagConstraints();
		gbc_btnBuild.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuild.weightx = 1.0;
		gbc_btnBuild.insets = new Insets(125, 225, 10, 225);
		gbc_btnBuild.gridx = 0;
		gbc_btnBuild.gridy = 0;
		panel.add(btnBuild, gbc_btnBuild);
		btnBuild.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factoryPage();
                return;
            }
        });
		
		JButton btnAnalyze = new JButton("Analyze");
		btnAnalyze.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnAnalyze = new GridBagConstraints();
		gbc_btnAnalyze.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnalyze.insets = new Insets(0, 225, 10, 225);
		gbc_btnAnalyze.gridx = 0;
		gbc_btnAnalyze.gridy = 1;
		panel.add(btnAnalyze, gbc_btnAnalyze);
		btnAnalyze.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                analyzePage();
                return;
            }
        });
		
		JButton btnMatch = new JButton("Match");
		btnMatch.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnMatch = new GridBagConstraints();
		gbc_btnMatch.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMatch.insets = new Insets(0, 225, 5, 225);
		gbc_btnMatch.gridx = 0;
		gbc_btnMatch.gridy = 2;
		panel.add(btnMatch, gbc_btnMatch);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.insets = new Insets(40, 290, 0, 290);
		gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExit.gridx = 0;
		gbc_btnExit.gridy = 3;
		panel.add(btnExit, gbc_btnExit);
		btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	public void factoryPage() {
		getContentPane().removeAll();
		
		company = new Company();
		equipment_individuals = new ArrayList<ListNode>();
		capability_individuals = new ArrayList<ListNode>();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnBuildNewFactory = new JButton("Create New Factory");
		btnBuildNewFactory.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBuildNewFactory = new GridBagConstraints();
		gbc_btnBuildNewFactory.weightx = 1.0;
		gbc_btnBuildNewFactory.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuildNewFactory.insets = new Insets(125, 225, 10, 225);
		gbc_btnBuildNewFactory.gridx = 0;
		gbc_btnBuildNewFactory.gridy = 0;
		panel.add(btnBuildNewFactory, gbc_btnBuildNewFactory);
		btnBuildNewFactory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                companyPage();
                return;
            }
        });
		
		JButton btnImportFactory = new JButton("Import Factory");
		btnImportFactory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
						fc = new JFileChooser("Desktop") {
							@Override
						    public void approveSelection() {
						        File f = getSelectedFile();
						        if(f.exists()) {
						        	super.approveSelection();
						        }
						    }
						};
						
						FileNameExtensionFilter OWL_filter = new FileNameExtensionFilter("RDF/XML (*.owl)", "owl");
						fc.setFileFilter(OWL_filter);
						fc.setFocusable(false);
						fc.setDialogTitle("Import Factory");
						fc.setMultiSelectionEnabled(false);
						fc.setCurrentDirectory(new File("\\"));
						fc.changeToParentDirectory();
						JComboBox open_combo = (JComboBox)(fc.getComponent(0).getAccessibleContext().getAccessibleChild(2));
						open_combo.setFont(new Font("Arial", Font.PLAIN, 12));
						open_combo.setUI(new ComboUI(open_combo, true));
						open_combo.setBorder(new LineBorder(Color.GRAY));
						open_combo.setBackground(Color.WHITE);
						configureFileChooserUI(fc.getComponents(), false);
						
						result = fc.showOpenDialog(frame);
						if(result == 0)
						{
							File selected_file = fc.getSelectedFile();
							if(selected_file.exists())
							{
								OntModel imported_factory = ModelFactory.createOntologyModel(modelSpec);
								OntDocumentManager factory_dm = imported_factory.getDocumentManager();
								factory_dm.addAltEntry("http://infoneer.txstate.edu/ontology/MSDL.owl", "file:ontologies/MSDL.owl");
								imported_factory.read(selected_file.getAbsolutePath(), "RDF/XML");
								builderPage(true, imported_factory, true, false);
							}
						}
				    }
				});	
			
			}
		});
		
		JButton btnEditExistingFactory = new JButton("Edit Saved Factory");
		btnEditExistingFactory.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnEditExistingFactory = new GridBagConstraints();
		gbc_btnEditExistingFactory.weightx = 1.0;
		gbc_btnEditExistingFactory.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditExistingFactory.insets = new Insets(0, 225, 10, 225);
		gbc_btnEditExistingFactory.gridx = 0;
		gbc_btnEditExistingFactory.gridy = 1;
		panel.add(btnEditExistingFactory, gbc_btnEditExistingFactory);
		btnImportFactory.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnImportFactory = new GridBagConstraints();
		gbc_btnImportFactory.insets = new Insets(0, 225, 5, 225);
		gbc_btnImportFactory.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImportFactory.gridx = 0;
		gbc_btnImportFactory.gridy = 2;
		panel.add(btnImportFactory, gbc_btnImportFactory);
		btnEditExistingFactory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
				EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	JPanel save_panel = new JPanel();
						GridBagLayout gbl_save_panel = new GridBagLayout();
						gbl_save_panel.columnWidths = new int[]{345, 0};
						gbl_save_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
						gbl_save_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
						save_panel.setLayout(gbl_save_panel); 
						
						JPanel message_panel = new JPanel(new FlowLayout(FlowLayout.LEADING,0, 0));
						GridBagConstraints gbc_message_save = new GridBagConstraints();
						gbc_message_save.insets = new Insets(1, 0, 5, 0);
						gbc_message_save.fill = GridBagConstraints.BOTH;
						gbc_message_save.gridx = 0;
						gbc_message_save.gridy = 0;
						JLabel message_save = new JLabel("Select a factory to edit:", SwingConstants.LEFT);
						message_save.setFont(new Font("Arial", Font.PLAIN, 12));
						message_panel.add(message_save);
						save_panel.add(message_panel, gbc_message_save);
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<ListNode2> list_model_save = new DefaultListModel<ListNode2>();
						for(ListNode2 ln : saved_factories) {
							list_model_save.addElement(ln);
						}
						
						JList<ListNode2> list_save = new JList<ListNode2>(list_model_save);
						list_save.setFont(new Font("Arial", Font.PLAIN, 12));
						list_save.setVisibleRowCount(6);
						list_save.setFocusable(false);
						list_save.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						list_panel.add(list_save, BorderLayout.CENTER);
				    	
						JScrollPane scrollPane_save = new JScrollPane(list_save);
				    	scrollPane_save.setBorder(BorderFactory.createEmptyBorder());
				    	scrollPane_save.getVerticalScrollBar().setUnitIncrement(10);
				    	scrollPane_save.getHorizontalScrollBar().setUnitIncrement(10);
				    	scrollPane_save.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
				    	scrollPane_save.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
				    	scrollPane_save.setOpaque(false);
						list_panel.add(scrollPane_save);
						
						GridBagConstraints gbc_list_panel = new GridBagConstraints();
						gbc_list_panel.insets = new Insets(0, 0, 8, 0);
						gbc_list_panel.fill = GridBagConstraints.BOTH;
						gbc_list_panel.gridx = 0;
						gbc_list_panel.gridy = 1;
						save_panel.add(list_panel, gbc_list_panel);
				    	
				    	result = JOptionPane.showOptionDialog(frame, save_panel, "Open Factory", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Open", "Cancel"}, null);
			            switch(result) {
			                case JOptionPane.OK_OPTION:
			                	if(list_save.getSelectedValue() != null) {
			                		OntModel factory = list_save.getSelectedValue().getFactory();
			                		builderPage(true, factory, true, false);
			                	}
			                    return;
			                case JOptionPane.CANCEL_OPTION:
			                    return;
			                case JOptionPane.CLOSED_OPTION:
			                    return;
				    	}
				    }
				});
				
            }
        });
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBack.insets = new Insets(40, 290, 0, 290);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 3;
		panel.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuPage();
                return;
            }
        });
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	public void companyPage() {
		getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(20, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCompanyInformation = new JLabel("Company Information");
		lblCompanyInformation.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCompanyInformation.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblCompanyInformation, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.weightx = 1.0;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblCompanyName = new JLabel("* Company Name:");
		lblCompanyName.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCompanyName = new GridBagConstraints();
		gbc_lblCompanyName.insets = new Insets(15, 35, 5, 15);
		gbc_lblCompanyName.anchor = GridBagConstraints.EAST;
		gbc_lblCompanyName.gridx = 0;
		gbc_lblCompanyName.gridy = 0;
		panel_2.add(lblCompanyName, gbc_lblCompanyName);
		
		JTextField name = new JTextField();
		name.setText(company.getName());
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.insets = new Insets(15, 0, 5, 80);
		gbc_name.fill = GridBagConstraints.BOTH;
		gbc_name.gridx = 1;
		gbc_name.gridy = 0;
		panel_2.add(name, gbc_name);
		name.setColumns(10);
		
		JLabel lblEmployees = new JLabel("Employee count:");
		lblEmployees.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblEmployees = new GridBagConstraints();
		gbc_lblEmployees.anchor = GridBagConstraints.EAST;
		gbc_lblEmployees.insets = new Insets(5, 0, 5, 15);
		gbc_lblEmployees.gridx = 0;
		gbc_lblEmployees.gridy = 1;
		panel_2.add(lblEmployees, gbc_lblEmployees);
		
		JTextField employees = new JTextField();
		employees.setText(company.getEmployees());
		GridBagConstraints gbc_employees = new GridBagConstraints();
		gbc_employees.insets = new Insets(5, 0, 5, 80);
		gbc_employees.fill = GridBagConstraints.BOTH;
		gbc_employees.gridx = 1;
		gbc_employees.gridy = 1;
		panel_2.add(employees, gbc_employees);
		employees.setColumns(10);
		
		JLabel lblYearFounded = new JLabel("Year Founded:");
		lblYearFounded.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblYearFounded = new GridBagConstraints();
		gbc_lblYearFounded.anchor = GridBagConstraints.EAST;
		gbc_lblYearFounded.insets = new Insets(5, 0, 5, 15);
		gbc_lblYearFounded.gridx = 0;
		gbc_lblYearFounded.gridy = 2;
		panel_2.add(lblYearFounded, gbc_lblYearFounded);
		
		JTextField year_founded = new JTextField();
		year_founded.setText(company.getYearFounded());
		GridBagConstraints gbc_year_founded = new GridBagConstraints();
		gbc_year_founded.insets = new Insets(5, 0, 5, 80);
		gbc_year_founded.fill = GridBagConstraints.BOTH;
		gbc_year_founded.gridx = 1;
		gbc_year_founded.gridy = 2;
		panel_2.add(year_founded, gbc_year_founded);
		year_founded.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblUrl = new GridBagConstraints();
		gbc_lblUrl.anchor = GridBagConstraints.EAST;
		gbc_lblUrl.insets = new Insets(5, 0, 5, 15);
		gbc_lblUrl.gridx = 0;
		gbc_lblUrl.gridy = 3;
		panel_2.add(lblUrl, gbc_lblUrl);
		
		JTextField URL = new JTextField();
		URL.setText(company.getURL());
		GridBagConstraints gbc_URL = new GridBagConstraints();
		gbc_URL.insets = new Insets(5, 0, 5, 80);
		gbc_URL.fill = GridBagConstraints.BOTH;
		gbc_URL.gridx = 1;
		gbc_URL.gridy = 3;
		panel_2.add(URL, gbc_URL);
		URL.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(5, 0, 5, 15);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 4;
		panel_2.add(lblAddress, gbc_lblAddress);
		
		JTextField address = new JTextField();
		address.setText(company.getAddress());
		GridBagConstraints gbc_address = new GridBagConstraints();
		gbc_address.insets = new Insets(5, 0, 5, 80);
		gbc_address.fill = GridBagConstraints.BOTH;
		gbc_address.gridx = 1;
		gbc_address.gridy = 4;
		panel_2.add(address, gbc_address);
		address.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(5, 0, 5, 15);
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 5;
		panel_2.add(lblCity, gbc_lblCity);
		
		JTextField city = new JTextField();
		city.setText(company.getCity());
		GridBagConstraints gbc_city = new GridBagConstraints();
		gbc_city.insets = new Insets(5, 0, 5, 80);
		gbc_city.fill = GridBagConstraints.BOTH;
		gbc_city.gridx = 1;
		gbc_city.gridy = 5;
		panel_2.add(city, gbc_city);
		city.setColumns(10);
		
		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.anchor = GridBagConstraints.EAST;
		gbc_lblState.insets = new Insets(5, 0, 5, 15);
		gbc_lblState.gridx = 0;
		gbc_lblState.gridy = 6;
		panel_2.add(lblState, gbc_lblState);
		
		JTextField state = new JTextField();
		state.setText(company.getState());
		GridBagConstraints gbc_state = new GridBagConstraints();
		gbc_state.insets = new Insets(5, 0, 5, 80);
		gbc_state.fill = GridBagConstraints.BOTH;
		gbc_state.gridx = 1;
		gbc_state.gridy = 6;
		panel_2.add(state, gbc_state);
		state.setColumns(10);
		
		JLabel lblZipCode = new JLabel("ZIP Code:");
		lblZipCode.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblZipCode = new GridBagConstraints();
		gbc_lblZipCode.anchor = GridBagConstraints.EAST;
		gbc_lblZipCode.insets = new Insets(5, 0, 5, 15);
		gbc_lblZipCode.gridx = 0;
		gbc_lblZipCode.gridy = 7;
		panel_2.add(lblZipCode, gbc_lblZipCode);
		
		JTextField zip = new JTextField();
		zip.setText(company.getZip());
		GridBagConstraints gbc_zip = new GridBagConstraints();
		gbc_zip.insets = new Insets(5, 0, 5, 80);
		gbc_zip.fill = GridBagConstraints.BOTH;
		gbc_zip.gridx = 1;
		gbc_zip.gridy = 7;
		panel_2.add(zip, gbc_zip);
		zip.setColumns(10);
		
		JLabel lblCompanyType = new JLabel("* Company Type:");
		lblCompanyType.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCompanyType = new GridBagConstraints();
		gbc_lblCompanyType.insets = new Insets(5, 0, 5, 15);
		gbc_lblCompanyType.anchor = GridBagConstraints.EAST;
		gbc_lblCompanyType.gridx = 0;
		gbc_lblCompanyType.gridy = 8;
		panel_2.add(lblCompanyType, gbc_lblCompanyType);
		
		JComboBox<String> type = new JComboBox<String>();
		type.setFont(new Font("Arial", Font.PLAIN, 12));
		type.setForeground(Color.DARK_GRAY);
		type.setBackground(Color.WHITE);
		type.setUI(new ComboUI(type, true));
		type.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		type.setFocusable(false);
		type.setRenderer(new PromptComboBoxRenderer(" Select company type"));
		type.insertItemAt(" Original design manufacturer", 0);
		type.insertItemAt(" Original equipment manufacturer", 1);
		type.insertItemAt(" Contract manufacturer", 2);
		type.insertItemAt(" Other", 3);
		type.setSelectedIndex(-1);
		type.setSelectedItem(" " + company.getType().trim());
		GridBagConstraints gbc_type = new GridBagConstraints();
		gbc_type.insets = new Insets(5, 0, 5, 80);
		gbc_type.fill = GridBagConstraints.BOTH;
		gbc_type.gridx = 1;
		gbc_type.gridy = 8;
		panel_2.add(type, gbc_type);
		
		JLabel lblBusinessType = new JLabel("* Business Type:");
		lblBusinessType.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblBusinessType = new GridBagConstraints();
		gbc_lblBusinessType.anchor = GridBagConstraints.EAST;
		gbc_lblBusinessType.insets = new Insets(5, 0, 5, 15);
		gbc_lblBusinessType.gridx = 0;
		gbc_lblBusinessType.gridy = 9;
		panel_2.add(lblBusinessType, gbc_lblBusinessType);
		
		JComboBox<String> business_type = new JComboBox<String>();
		business_type.setSelectedItem(company.getBusinessType());
		business_type.setFont(new Font("Arial", Font.PLAIN, 12));
		business_type.setForeground(Color.DARK_GRAY);
		business_type.setBackground(Color.WHITE);
		business_type.setUI(new ComboUI(business_type, true));
		business_type.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		business_type.setFocusable(false);
		business_type.setRenderer(new PromptComboBoxRenderer(" Select business type"));
		business_type.insertItemAt(" Small business manufacturing company", 0);
		business_type.insertItemAt(" Veteran-owned manufacturing company", 1);
		business_type.insertItemAt(" Woman-owned manufacturing company", 2);
		business_type.insertItemAt(" Minority-owned manufacturing company", 3);
		business_type.insertItemAt(" Other", 4);
		business_type.setSelectedIndex(-1);
		business_type.setSelectedItem(" " + company.getBusinessType().trim());
		GridBagConstraints gbc_business_type = new GridBagConstraints();
		gbc_business_type.insets = new Insets(5, 0, 5, 80);
		gbc_business_type.fill = GridBagConstraints.BOTH;
		gbc_business_type.gridx = 1;
		gbc_business_type.gridy = 9;
		panel_2.add(business_type, gbc_business_type);
		
		/*JLabel req = new JLabel("* - required field");
		req.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_req = new GridBagConstraints();
		gbc_req.anchor = GridBagConstraints.WEST;
		gbc_req.insets = new Insets(5, 0, 5, 15);
		gbc_req.gridx = 1;
		gbc_req.gridy = 10;
		panel_2.add(req, gbc_req);*/
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(40, 0, 0, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBack.weightx = 0.5;
		gbc_btnBack.insets = new Insets(0, 220, 0, 10);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		panel_3.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                factoryPage();
                return;
            }
        });
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 10, 0, 220);
		gbc_btnNext.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNext.weightx = 0.5;
		gbc_btnNext.gridx = 1;
		gbc_btnNext.gridy = 0;
		panel_3.add(btnNext, gbc_btnNext);
		btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String ct = "";
        		String bt = "";
        		try { ct = type.getSelectedItem().toString(); } catch(Exception e1) {}
        		try { bt = business_type.getSelectedItem().toString(); } catch(Exception e1) {}
            	
        		if(name.getText().equals("") || ct.equals("") || bt.equals(""))
        			JOptionPane.showMessageDialog(frame, "Please enter all required fields before continuing.", "Notice", JOptionPane.PLAIN_MESSAGE, null);
            	else {
            		company = new Company(name.getText(), ct, bt, employees.getText(), year_founded.getText(), URL.getText(), address.getText(), city.getText(), state.getText(), zip.getText());
            		
            		builderPage(false, null, true, false);
                    return;
            	}
            }
        });
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	public void builderPage(boolean imported, OntModel imported_factory, boolean first_page, boolean from_second_page) {
		getContentPane().removeAll();
		
		list_model = new DefaultListModel<ListNode>();
		list = new JList<ListNode>(list_model);
		list.setFont(new Font("Arial", Font.PLAIN, 12));
		list.setFocusable(false);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent ev) {
				ListNode selection = list.getSelectedValue();
				if(selection == null)
					return;
				String s = selection.toString();
				if(s.equals("\n") || s.equals(s_3d) || s.equals(s_machine) || s.equals(s_material) || s.equals(s_certification) || s.equals(s_industry) || s.equals(s_software))
					list.clearSelection();
			}
		});
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel_6.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{300, 21, 300, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 228, 0, 228, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.weightx = 0.5;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 0;
		panel_1.add(panel_7, gbc_panel_7);
		
		JPanel panel_13 = new JPanel();
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 5, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 2;
		gbc_panel_9.gridy = 0;
		panel_1.add(panel_9, gbc_panel_9);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_12.setBackground(tab_color1);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_9.createSequentialGroup()
					.addComponent(panel_12, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_12, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_9.setLayout(gl_panel_9);
		
		JPanel panel_25 = new JPanel();
		GridBagConstraints gbc_panel_25 = new GridBagConstraints();
		gbc_panel_25.insets = new Insets(0, 0, 5, 5);
		gbc_panel_25.fill = GridBagConstraints.BOTH;
		gbc_panel_25.gridx = 0;
		gbc_panel_25.gridy = 1;
		panel_1.add(panel_25, gbc_panel_25);
		
		JLabel lblNewLabel;
		if(first_page)
			lblNewLabel = new JLabel("Equipment Classes:");
		else
			lblNewLabel = new JLabel("Capability Classes:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel_25 = new GroupLayout(panel_25);
		gl_panel_25.setHorizontalGroup(
			gl_panel_25.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_25.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
		);
		gl_panel_25.setVerticalGroup(
			gl_panel_25.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		panel_25.setLayout(gl_panel_25);
		
		JPanel panel_28 = new JPanel();
		GridBagConstraints gbc_panel_28 = new GridBagConstraints();
		gbc_panel_28.insets = new Insets(0, 5, 5, 0);
		gbc_panel_28.fill = GridBagConstraints.BOTH;
		gbc_panel_28.gridx = 2;
		gbc_panel_28.gridy = 1;
		panel_1.add(panel_28, gbc_panel_28);
		
		JLabel lblAddedIndividuals;
		if(first_page)
			lblAddedIndividuals = new JLabel("Added Equipment Individuals:");
		else
			lblAddedIndividuals = new JLabel("Added Capability Individuals:");
		lblAddedIndividuals.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel_28 = new GroupLayout(panel_28);
		gl_panel_28.setHorizontalGroup(
			gl_panel_28.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_28.createSequentialGroup()
					.addComponent(lblAddedIndividuals, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_28.setVerticalGroup(
			gl_panel_28.createParallelGroup(Alignment.LEADING)
				.addComponent(lblAddedIndividuals, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
		);
		panel_28.setLayout(gl_panel_28);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.weightx = 0.5;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		panel_1.add(panel_4, gbc_panel_4);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_10.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane.setOpaque(false);
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_15 = new JPanel();
		scrollPane.setViewportView(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JTree tree = new JTree();
		panel_15.add(tree);
		tree.setFont(new Font("Arial", Font.PLAIN, 12));
		tree.setToggleClickCount(2);
		DefaultMutableTreeNode tree_root = new DefaultMutableTreeNode("");
		DefaultTreeModel tree_model = new DefaultTreeModel(tree_root);
		tree.setSelectionModel(new RootTreeSelectionModel(tree));
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setModel(tree_model);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		panel_10.add(scrollPane);
		panel_4.setLayout(gl_panel_4);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setUI(new ComboUI(comboBox, true));
		comboBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		comboBox.setFocusable(false);
		panel_7.setLayout(gl_panel_7);
		if(first_page) {
			comboBox.setRenderer(new PromptComboBoxRenderer(" Select Equipment"));
			comboBox.insertItemAt(" 3D Printer", 0);
			comboBox.insertItemAt(" Machine Tool", 1);
			comboBox.setSelectedIndex(-1);
			comboBox.addItemListener(new ItemListener() {
		        public void itemStateChanged(ItemEvent event) {
		        	if(event.getStateChange() == ItemEvent.SELECTED) {
		        		int selection_index = comboBox.getSelectedIndex();
				    	OntClass c = null;
				    	switch(selection_index)
				    	{
				    		case 0:
				    			c = class_3DPrinter;
				    			break;
				    		case 1:
				    			c = class_MachineTool;
				    			break;
				    	}
				    	combo_class = c;
		        	}
		        }
		    });
		}
		else {
			comboBox.setRenderer(new PromptComboBoxRenderer(" Select Capabilities"));
			comboBox.insertItemAt(" Industry", 0);
			comboBox.insertItemAt(" Material", 1);
			comboBox.insertItemAt(" Software", 2);
			comboBox.insertItemAt(" Certification", 3);
			comboBox.setSelectedIndex(-1);
			comboBox.addItemListener(new ItemListener() {
		        public void itemStateChanged(ItemEvent event) {
		        	if(event.getStateChange() == ItemEvent.SELECTED) {
		        		int selection_index = comboBox.getSelectedIndex();
				    	OntClass c = null;
				    	switch(selection_index)
				    	{
				    		case 0:
				    			c = class_Industry;
				    			break;
				    		case 1:
				    			c = class_Material;
				    			break;
				    		case 2:
				    			c = class_Software;
				    			break;
				    		case 3:
				    			c = class_Certification;
				    			break;
				    	}
				    	combo_class = c;
		        	}
		        }
		    });
		}
		panel_13.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 3;
		gbc_panel_3.insets = new Insets(0, 5, 5, 0);
		gbc_panel_3.weightx = 0.5;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 2;
		panel_1.add(panel_3, gbc_panel_3);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
		panel_11.setBackground(Color.WHITE);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane_1.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane_1.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane_1.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane_1.setOpaque(false);
		
		JPanel panel_14 = new JPanel();
		scrollPane_1.setViewportView(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		panel_14.add(list);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
		panel_11.add(scrollPane_1);
		panel_3.setLayout(gl_panel_3);
		
		if(imported && first_page && (!from_second_page)) {
			try { company.setName(imported_factory.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_99999991").getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000149")).getObject().asResource().getProperty(RDFS.label).getObject().asLiteral().getLexicalForm()); } catch(Exception e) {}
			try { company.setEmployess(((int)Double.parseDouble(imported_factory.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_99999991").getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000874")).getObject().asResource().getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().asLiteral().getLexicalForm())) + ""); } catch(Exception e) {}
			try { company.setYearFounded(""); } catch(Exception e) {} // TODO
			try { company.setURL(imported_factory.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_99999991").getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000876")).getObject().asResource().getProperty(RDFS.label).getObject().asLiteral().getLexicalForm()); } catch(Exception e) {}
				
			String bt = getOntClassOf(imported_factory.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_99999991")).toString();
			if(bt.equals("http://infoneer.txstate.edu/ontology/MSDL_0000873"))
				try { company.setBusinessType("Small business manufacturing company"); } catch(Exception e) {}
			else if(bt.equals("http://infoneer.txstate.edu/ontology/MSDL_0000872"))
				try { company.setBusinessType("Veteran-owned manufacturing company"); } catch(Exception e) {}
			else if(bt.equals("http://infoneer.txstate.edu/ontology/MSDL_0000871"))
				try { company.setBusinessType("Woman-owned manufacturing company"); } catch(Exception e) {}
			else if(bt.equals("http://infoneer.txstate.edu/ontology/MSDL_0000870"))
				try { company.setBusinessType("Minority-owned manufacturing company"); } catch(Exception e) {}
			else if(bt.equals("http://infoneer.txstate.edu/ontology/MSDL_0000017"))
				try { company.setBusinessType("Other"); } catch(Exception e) {}
				
			String ct = imported_factory.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_99999991").getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000877")).getObject().toString();
			if(ct.equals("http://infoneer.txstate.edu/ontology/MSDL_0000868"))
				try { company.setType("Original design manufacturer"); } catch(Exception e) {}
			else if(ct.equals("http://infoneer.txstate.edu/ontology/MSDL_0000867"))
				try { company.setType("Original equipment manufacturer"); } catch(Exception e) {}
			else if(ct.equals("http://infoneer.txstate.edu/ontology/MSDL_0000866"))
				try { company.setType("Contract manufacturer"); } catch(Exception e) {}
			else if(ct.equals("http://infoneer.txstate.edu/ontology/MSDL_0000865"))
				try { company.setType("Other"); } catch(Exception e) {}
				
			RDFNode street_thing = null, city_thing = null, state_thing = null, zip_thing = null;
			for(NodeIterator n = imported_factory.listObjectsOfProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000875")); n.hasNext(); ) {
				try {
					RDFNode address_thing = n.next();
					for(ExtendedIterator<Statement> s = imported_factory.listStatements(); s.hasNext(); ) {
						Statement statement_thing = s.next();
						Resource subject = statement_thing.getSubject();
						String predicate = statement_thing.getPredicate().toString();
						String object = statement_thing.getObject().toString();
						if(subject.equals(address_thing) && predicate.equals("http://www.w3.org/1999/02/22-rdf-syntax-ns#type") && object.equals("http://infoneer.txstate.edu/ontology/MSDL_0000840"))
							street_thing = address_thing;
						if(subject.equals(address_thing) && predicate.equals("http://www.w3.org/1999/02/22-rdf-syntax-ns#type") && object.equals("http://infoneer.txstate.edu/ontology/MSDL_0000838"))
							city_thing = address_thing;
						if(subject.equals(address_thing) && predicate.equals("http://www.w3.org/1999/02/22-rdf-syntax-ns#type") && object.equals("http://infoneer.txstate.edu/ontology/MSDL_0000841"))
							state_thing = address_thing;
						if(subject.equals(address_thing) && predicate.equals("http://www.w3.org/1999/02/22-rdf-syntax-ns#type") && object.equals("http://infoneer.txstate.edu/ontology/MSDL_0000839"))
							zip_thing = address_thing;
					}
				} catch(Exception e) {}
			}
			for(ExtendedIterator<Statement> s = imported_factory.listStatements(); s.hasNext(); ) {
				Statement statement_thing = s.next();
				Resource subject = statement_thing.getSubject();
				String predicate = statement_thing.getPredicate().toString();
				if(subject.equals(street_thing) && predicate.equals("http://www.w3.org/2000/01/rdf-schema#label"))
					try { company.setAddress(statement_thing.getObject().asLiteral().getLexicalForm()); } catch(Exception e) {}
				else if(subject.equals(city_thing) && predicate.equals("http://www.w3.org/2000/01/rdf-schema#label"))
					try { company.setCity(statement_thing.getObject().asLiteral().getLexicalForm()); } catch(Exception e) {}
				else if(subject.equals(state_thing) && predicate.equals("http://www.w3.org/2000/01/rdf-schema#label"))
					try { company.setState(statement_thing.getObject().asLiteral().getLexicalForm()); } catch(Exception e) {}
				else if(subject.equals(zip_thing) && predicate.equals("http://www.w3.org/2000/01/rdf-schema#label"))
					try { company.setZip(statement_thing.getObject().asLiteral().getLexicalForm()); } catch(Exception e) {}
			}

			for(NodeIterator n = imported_factory.listObjects(); n.hasNext(); ) {
				RDFNode obj = n.next();
				Individual indiv = null;
				OntClass category_class = null;
				
				try {
					indiv = ontology.getIndividual(obj.toString());
					if(isCategoryOf(getOntClassOf(indiv), class_3DPrinter))
						category_class = class_3DPrinter;
					else if(isCategoryOf(getOntClassOf(indiv), class_MachineTool))
						category_class = class_MachineTool;

					if(category_class != null) {
						boolean exists = false;
						for(int x = 0; x < equipment_individuals.size(); x++) {
							if(equipment_individuals.get(x).getIndividual().getURI().equals(indiv.getURI())) {
								exists = true;
								x = equipment_individuals.size();
							}
						}
						if(!exists)
							equipment_individuals.add(new ListNode(indiv, category_class, ""));
					}
				} catch(Exception aaa) {}
			}
			for(NodeIterator n = imported_factory.listObjects(); n.hasNext(); ) {
				RDFNode obj = n.next();
				Individual indiv = null;
				OntClass category_class = null;
				
				try {
					indiv = ontology.getIndividual(obj.toString());
					if(isCategoryOf(getOntClassOf(indiv), class_Industry))
						category_class = class_Industry;
					else if(isCategoryOf(getOntClassOf(indiv), class_Material))
						category_class = class_Material;
					else if(isCategoryOf(getOntClassOf(indiv), class_Software))
						category_class = class_Software;
					else if(isCategoryOf(getOntClassOf(indiv), class_Certification))
						category_class = class_Certification;
						
					if(category_class != null) {
						boolean exists = false;
						for(int x = 0; x < capability_individuals.size(); x++) {
							if(capability_individuals.get(x).getIndividual().getURI().equals(indiv.getURI())) {
								exists = true;
								x = capability_individuals.size();
							}
						}
						if(!exists)
							capability_individuals.add(new ListNode(indiv, category_class, ""));
					}
				} catch(Exception aaa) {}
			}
		}
		
		JLabel lblCompanyName_1;
		int company_name_max = 38;
		if(company.getName().length() > company_name_max)
			lblCompanyName_1 = new JLabel(company.getName().substring(0, company_name_max - 2) + "...");
		else if(company.getName().equals(""))
			lblCompanyName_1 = new JLabel("[ Untitled Company ]");
		else
			lblCompanyName_1 = new JLabel(company.getName());
		lblCompanyName_1.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblCompanyName_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCompanyName_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		panel_12.add(lblCompanyName_1);
		
		JPanel panel_30 = new JPanel();
		GridBagConstraints gbc_panel_30 = new GridBagConstraints();
		gbc_panel_30.insets = new Insets(0, 0, 5, 5);
		gbc_panel_30.fill = GridBagConstraints.BOTH;
		gbc_panel_30.gridx = 0;
		gbc_panel_30.gridy = 3;
		panel_1.add(panel_30, gbc_panel_30);
		
		JLabel lblNewLabel_1;
		if(first_page)
			lblNewLabel_1 = new JLabel("Equipment Individuals:");
		else
			lblNewLabel_1 = new JLabel("Capability Individuals:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel_30 = new GroupLayout(panel_30);
		gl_panel_30.setHorizontalGroup(
			gl_panel_30.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_30.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
		);
		gl_panel_30.setVerticalGroup(
			gl_panel_30.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
		);
		panel_30.setLayout(gl_panel_30);
		
		JPanel panel_21 = new JPanel();
		GridBagConstraints gbc_panel_21 = new GridBagConstraints();
		gbc_panel_21.weightx = 0.5;
		gbc_panel_21.insets = new Insets(0, 0, 5, 5);
		gbc_panel_21.fill = GridBagConstraints.BOTH;
		gbc_panel_21.gridx = 0;
		gbc_panel_21.gridy = 4;
		panel_1.add(panel_21, gbc_panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
		panel_22.setBackground(Color.WHITE);
		GroupLayout gl_panel_21 = new GroupLayout(panel_21);
		gl_panel_21.setHorizontalGroup(
			gl_panel_21.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_21.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_22, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
		);
		gl_panel_21.setVerticalGroup(
			gl_panel_21.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_21.createSequentialGroup()
					.addComponent(panel_22, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_22.setLayout(new BoxLayout(panel_22, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_2.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane_2.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane_2.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane_2.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane_2.setOpaque(false);
		panel_22.add(scrollPane_2);
		
		JPanel panel_23 = new JPanel();
		scrollPane_2.setViewportView(panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));
		
		DefaultListModel<ListNode> list_model_1 = new DefaultListModel<ListNode>();
		JList<ListNode> list_1 = new JList<ListNode>(list_model_1);
		list_1.setFont(new Font("Arial", Font.PLAIN, 12));
		list_1.setFocusable(false);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_23.add(list_1, BorderLayout.CENTER);
		panel_21.setLayout(gl_panel_21);
		
		refreshList(first_page, null);
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
		    public void valueChanged(TreeSelectionEvent e) {
		    	list_model_1.removeAllElements();
		    	list_1.setListData(new ListNode[0]);
		    	DefaultMutableTreeNode selected_node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		        if(selected_node == null)
		        	return;
		        OntClass selected_class = ontology.getOntClass(((TreeNode)selected_node.getUserObject()).getID());
		        for(ExtendedIterator<? extends OntResource> i = selected_class.listInstances(true); i.hasNext(); ) {
					Individual indiv = i.next().asIndividual();
					try {
						list_model_1.addElement(new ListNode(indiv, combo_class, ""));
					} catch(Exception aaa) {
						System.out.println(indiv + " " + aaa);
					}
				}
				ListNode[] elements = new ListNode[list_model_1.getSize()];
				for(int i = 0; i < elements.length; i++){
					elements[i] = list_model_1.getElementAt(i);
			    }
			    Arrays.sort(elements);
			    list_1.setListData(elements);
		    }
		});
		
		comboBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	list_model_1.removeAllElements();
		    	list_1.setListData(new ListNode[0]);
		    	OntClass root_class = combo_class;
		    	DefaultMutableTreeNode tree_root = new DefaultMutableTreeNode("NULL");
		    	DefaultTreeModel tree_model = new DefaultTreeModel(tree_root);
		    	
		    	if(root_class != null)
		    	{
		    		tree_root = new DefaultMutableTreeNode();
			    	tree_root.setUserObject(new TreeNode(root_class.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(), root_class.toString()));
					tree_model = new DefaultTreeModel(tree_root);
					ArrayList<DefaultMutableTreeNode> current_nodes = new ArrayList<DefaultMutableTreeNode>();
					ArrayList<DefaultMutableTreeNode> next_nodes = new ArrayList<DefaultMutableTreeNode>();
					current_nodes.add(tree_root);
					
					while(current_nodes.size() > 0)
					{
						for(DefaultMutableTreeNode node : current_nodes) {
							if(node.getUserObject() == null)
								System.out.println("NULL!");
							else {
								for(Iterator<OntClass> i = ontology.getOntClass(((TreeNode)node.getUserObject()).getID()).listSubClasses(); i.hasNext(); ) {
									DefaultMutableTreeNode add_node = new DefaultMutableTreeNode();
									OntClass c = i.next();
									add_node.setUserObject(new TreeNode(c.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(), c.toString()));
									node.add(add_node);
									next_nodes.add(add_node);
								}
							}
				    	}
						current_nodes = next_nodes;
						next_nodes = new ArrayList<DefaultMutableTreeNode>();
					}
		    	}

				tree.setModel(tree_model);
		    	tree_model.reload(tree_root);
		    }
		});
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 5, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 4;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.ipadx = -30;
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 0;
		panel_2.add(panel_8, gbc_panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton arrow_right = new JButton(">>");
		arrow_right.setFont(new Font("Consolas", Font.PLAIN, 15));
		arrow_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListNode selected_node = list_1.getSelectedValue();
				if(selected_node == null)
					return;
				Individual selected_individual = selected_node.getIndividual();
				boolean exists = false;
				if(first_page) {
					for(int x = 0; x < equipment_individuals.size(); x++) {
						if(equipment_individuals.get(x).getIndividual().getURI().equals(selected_individual.getURI())) {
							exists = true;
							x = equipment_individuals.size();
						}
					}
					if(!exists) {
						boolean found_category = false;
						for(int x = equipment_individuals.size() - 1; x >= 0; x--) {
							if(equipment_individuals.get(x).getCategoryClass().equals(combo_class)) {
								equipment_individuals.add(x + 1, new ListNode(selected_individual, combo_class, ""));
								found_category = true;
								x = -1;
							}
						}
						if(!found_category)
							equipment_individuals.add(new ListNode(selected_individual, combo_class, ""));
					}
				}
				else {
					for(int x = 0; x < capability_individuals.size(); x++) {
						if(capability_individuals.get(x).getIndividual().getURI().equals(selected_individual.getURI())) {
							exists = true;
							x = capability_individuals.size();
						}
					}
					if(!exists) {
						boolean found_category = false;
						for(int x = capability_individuals.size() - 1; x >= 0; x--) {
							if(capability_individuals.get(x).getCategoryClass().equals(combo_class)) {
								capability_individuals.add(x + 1, new ListNode(selected_individual, combo_class, ""));
								found_category = true;
								x = -1;
							}
						}
						if(!found_category)
							capability_individuals.add(new ListNode(selected_individual, combo_class, ""));
					}
				}
				
				if(refreshList(first_page, combo_class))
					scrollPane_1.getVerticalScrollBar().setValue(scrollPane_1.getVerticalScrollBar().getMaximum());
			}
		});
		panel_8.add(arrow_right);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(5, 0, 5, 0);
		gbc_panel_5.ipadx = -30;
		gbc_panel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_2.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton arrow_left = new JButton("<<");
		arrow_left.setFont(new Font("Consolas", Font.PLAIN, 15));
		arrow_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected_index = list.getSelectedIndex();
				if(selected_index != -1) {
					ListNode a = list_model.getElementAt(selected_index);
					if(first_page)
						equipment_individuals.remove(a);
					else
						capability_individuals.remove(a);
				}
			    refreshList(first_page, null);
			}
		});
		panel_5.add(arrow_left);
		
		JPanel panel_24 = new JPanel();
		GridBagConstraints gbc_panel_24 = new GridBagConstraints();
		gbc_panel_24.insets = new Insets(5, 0, 5, 0);
		gbc_panel_24.ipadx = -30;
		gbc_panel_24.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_24.gridx = 0;
		gbc_panel_24.gridy = 2;
		panel_2.add(panel_24, gbc_panel_24);
		panel_24.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnInfo = new JButton("Info");
		btnInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	ListNode ln = list_1.getSelectedValue();
				    	if(ln != null && (combo_class.getURI().equals(uri_MachineTool) || combo_class.getURI().equals(uri_3DPrinter))) {
					    	JPanel info_panel = new JPanel();
							GridBagLayout gbl_info_panel = new GridBagLayout();
							gbl_info_panel.columnWidths = new int[]{160, 0};
							gbl_info_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
							gbl_info_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
							info_panel.setLayout(gbl_info_panel); 
							
							JPanel message_panel = new JPanel(new FlowLayout(FlowLayout.LEADING,0, 0));
							GridBagConstraints gbc_message_info = new GridBagConstraints();
							gbc_message_info.insets = new Insets(1, 0, 5, 0);
							gbc_message_info.fill = GridBagConstraints.BOTH;
							gbc_message_info.gridx = 0;
							gbc_message_info.gridy = 0;
							
							JPanel message_panel2 = new JPanel(new FlowLayout(FlowLayout.LEADING,0, 0));
							GridBagConstraints gbc_message_info2 = new GridBagConstraints();
							gbc_message_info2.insets = new Insets(1, 0, 5, 0);
							gbc_message_info2.fill = GridBagConstraints.BOTH;
							gbc_message_info2.gridx = 1;
							gbc_message_info2.gridy = 0;
							
							JLabel message_info = new JLabel();
							JLabel message_info2 = new JLabel();
							String s = combo_class.getURI();
							
							// CAREFUL NOT TO REORDER ELEMENTS IN COLUMNS
							
							String val1 = "-", val2 = "-", val3 = "-", val4 = "-", val5 = "-", val6 = "-", val7 = "-",
									val8 = "-", val9 = "-", val10 = "-", val11 = "-", val12 = "-", val13 = "-", val14 = "-",
									val15 = "-", val16 = "-", val17 = "-", val18 = "-", val19 = "-", val20 = "-", val21 = "-";
							
							Individual selected_indiv = ln.getIndividual();
							Property has_part_prop = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000130");
							Property has_manufacturer_prop = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000179");
							Property has_build_prop = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000714");
							
							if(s.equals(uri_MachineTool)) { // Machine Tool
								try { // manufacturer
									for(StmtIterator si = selected_indiv.listProperties(has_manufacturer_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										val1 = i1.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
										break;
									}
								} catch(Exception e) { val1 = "-"; }
								
								try { // table length
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000084"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000184")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val2 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val2.indexOf("^") != -1)
												val2 = val2.substring(0, val2.indexOf("^"));
											try { val2 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val2 = "-"; }
									
								try { // table width
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000084"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000185")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val3 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val3.indexOf("^") != -1)
												val3 = val3.substring(0, val3.indexOf("^"));
											try { val3 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val3 = "-"; }
								
								try { // max load capacity
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000084"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000186")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val4 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val4.indexOf("^") != -1)
												val4 = val4.substring(0, val4.indexOf("^"));
											try { val4 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val4 = "-"; }
								
								try { // max spindle speed
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000120"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000183")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val5 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val5.indexOf("^") != -1)
												val5 = val5.substring(0, val5.indexOf("^"));
											try { val5 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val5 = "-"; }
								
								try { // spindle power
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000120"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000182")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val6 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val6.indexOf("^") != -1)
												val6 = val6.substring(0, val6.indexOf("^"));
											try { val6 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val6 = "-"; }
								
								try { // spindle torque
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000120"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000181")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val7 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val7.indexOf("^") != -1)
												val7 = val7.substring(0, val7.indexOf("^"));
											try { val7 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val7 = "-"; }

								try { // rapid traverse X
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000156"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000205")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val8 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val8.indexOf("^") != -1)
												val8 = val8.substring(0, val8.indexOf("^"));
											try { val8 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val8 = "-"; }
									
								try { // rapid traverse Y
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000157"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000205")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val9 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val9.indexOf("^") != -1)
												val9 = val9.substring(0, val9.indexOf("^"));
											try { val9 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val9 = "-"; }
								
								try { // rapid traverse Z
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000158"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000205")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val10 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val10.indexOf("^") != -1)
												val10 = val10.substring(0, val10.indexOf("^"));
											try { val10 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val10 = "-"; }
								
								try { // cutting feed rate X
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000156"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000200")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val11 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val11.indexOf("^") != -1)
												val11 = val11.substring(0, val11.indexOf("^"));
											try { val11 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val11 = "-"; }
								
								try { // cutting feed rate Y
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000157"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000200")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val12 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val12.indexOf("^") != -1)
												val12 = val12.substring(0, val12.indexOf("^"));
											try { val12 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val12 = "-"; }
								
								try { // cutting feed rate Z
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000158"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000200")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val13 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val13.indexOf("^") != -1)
												val13 = val13.substring(0, val13.indexOf("^"));
											try { val13 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val13 = "-"; }
								
								try { // travel X
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000156"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000199")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val14 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val14.indexOf("^") != -1)
												val14 = val14.substring(0, val14.indexOf("^"));
											try { val14 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val14 = "-"; }
								
								try { // travel Y
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000157"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000199")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val15 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val15.indexOf("^") != -1)
												val15 = val15.substring(0, val15.indexOf("^"));
											try { val15 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val15 = "-"; }
								
								try { // travel Z
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000158"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000199")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val16 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val16.indexOf("^") != -1)
												val16 = val16.substring(0, val16.indexOf("^"));
											try { val16 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val16 = "-"; }
								
								try { // max num of tools
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000195"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000193")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val17 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val17.indexOf("^") != -1)
												val17 = val17.substring(0, val17.indexOf("^"));
											try { val17 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val17 = "-"; }
								
								try { // tool to tool time
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000195"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000192")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val18 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val18.indexOf("^") != -1)
												val18 = val18.substring(0, val18.indexOf("^"));
											try { val18 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val18 = "-"; }
								
								try { // chip to chip time
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000195"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000191")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val19 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val19.indexOf("^") != -1)
												val19 = val19.substring(0, val19.indexOf("^"));
											try { val19 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val19 = "-"; }
								
								try { // max tool length
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000195"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000189")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val20 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val20.indexOf("^") != -1)
												val20 = val20.substring(0, val20.indexOf("^"));
											try { val20 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val20 = "-"; }

								try { // max tool weight
									for(StmtIterator si = selected_indiv.listProperties(has_part_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000195"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000190")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val21 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val21.indexOf("^") != -1)
												val21 = val21.substring(0, val21.indexOf("^"));
											try { val21 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val21 = "-"; }
								
								message_info = new JLabel("<html><body>"
										+ "<p style=\"margin-bottom:-12\"><b>Machine Property</b></p>"
										+ "<br><p style=\"margin-bottom:-12\">manufacturer</p>"
										+ "<br><p style=\"margin-bottom:-12\">table length</p>"
										+ "<br><p style=\"margin-bottom:-12\">table width</p>"
										+ "<br><p style=\"margin-bottom:-12\">max load capacity</p>"
										+ "<br><p style=\"margin-bottom:-12\">max spindle speed</p>"
										+ "<br><p style=\"margin-bottom:-12\">spindle power</p>"
										+ "<br><p style=\"margin-bottom:-12\">spindle torque</p>"
										+ "<br><p style=\"margin-bottom:-12\">rapid traverse X</p>"
										+ "<br><p style=\"margin-bottom:-12\">rapid traverse Y</p>"
										+ "<br><p style=\"margin-bottom:-12\">rapid traverse Z</p>"
										+ "<br><p style=\"margin-bottom:-12\">cutting feed rate X</p>"
										+ "<br><p style=\"margin-bottom:-12\">cutting feed rate Y</p>"
										+ "<br><p style=\"margin-bottom:-12\">cutting feed rate Z</p>"
										+ "<br><p style=\"margin-bottom:-12\">travel X</p>"
										+ "<br><p style=\"margin-bottom:-12\">travel Y</p>"
										+ "<br><p style=\"margin-bottom:-12\">travel Z</p>"
										+ "<br><p style=\"margin-bottom:-12\">max num of tools</p>"
										+ "<br><p style=\"margin-bottom:-12\">tool to tool time</p>"
										+ "<br><p style=\"margin-bottom:-12\">chip to chip time</p>"
										+ "<br><p style=\"margin-bottom:-12\">max tool length</p>"
										+ "<br>max tool weight"
										+ "</body></html>", SwingConstants.LEFT);
								
								message_info2 = new JLabel("<html><body>"
										+ "<p style=\"margin-bottom:-12\"><b>Value</b></p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val1 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val2 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val3 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val4 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val5 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val6 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val7 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val8 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val9 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val10 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val11 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val12 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val13 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val14 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val15 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val16 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val17 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val18 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val19 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val20 + "</p>"
										+ "<br>" + val21
										+ "</body></html>", SwingConstants.LEFT);
							}
							else if(s.equals(uri_3DPrinter)) {
								try { // manufacturer
									for(StmtIterator si = selected_indiv.listProperties(has_manufacturer_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										val1 = i1.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
										break;
									}
								} catch(Exception e) { val1 = "-"; }
								
								try { // build volume length
									for(StmtIterator si = selected_indiv.listProperties(has_build_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000708"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000728")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val2 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val2.indexOf("^") != -1)
												val2 = val2.substring(0, val2.indexOf("^"));
											try { val2 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val2 = "-"; }
									
								try { // build volume width
									for(StmtIterator si = selected_indiv.listProperties(has_build_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000708"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000729")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val3 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val3.indexOf("^") != -1)
												val3 = val3.substring(0, val3.indexOf("^"));
											try { val3 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val3 = "-"; }
								
								try { // build volume height
									for(StmtIterator si = selected_indiv.listProperties(has_build_prop); si.hasNext(); ) {
										Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
										if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000708"))) {
											Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000730")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
											val4 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
											if(val4.indexOf("^") != -1)
												val4 = val4.substring(0, val4.indexOf("^"));
											try { val4 += " " + getOntClassOf(ontology.getIndividual(MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000039")).getObject().asResource().getURI())).listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm(); } catch(Exception e1) {}
											break;
										}
									}
								} catch(Exception e) { val4 = "-"; }
								
								message_info = new JLabel("<html><body>"
										+ "<p style=\"margin-bottom:-12\"><b>Machine Property</b></p>"
										+ "<br><p style=\"margin-bottom:-12\">manufacturer</p>"
										+ "<br><p style=\"margin-bottom:-12\">build volume length</p>"
										+ "<br><p style=\"margin-bottom:-12\">build volume width</p>"
										+ "<br>build volume height"
										+ "</body></html>", SwingConstants.LEFT);
								
								message_info2 = new JLabel("<html><body>"
										+ "<p style=\"margin-bottom:-12\"><b>Value</b></p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val1 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val2 + "</p>"
										+ "<br><p style=\"margin-bottom:-12\">" + val3 + "</p>"
										+ "<br>" + val4
										+ "</body></html>", SwingConstants.LEFT);
							}
							
							message_info2.setText(message_info2.getText().replaceAll(Matcher.quoteReplacement("unit"), Matcher.quoteReplacement("")));
							message_info2.setText(message_info2.getText().replaceAll(Matcher.quoteReplacement(".0 "), Matcher.quoteReplacement(" ")));
							message_info2.setText(message_info2.getText().replaceAll(Matcher.quoteReplacement("Second"), Matcher.quoteReplacement("sec")));
							message_info2.setText(message_info2.getText().replaceAll(Matcher.quoteReplacement(" per "), Matcher.quoteReplacement("/")));
							message_info2.setText(message_info2.getText().replaceAll(Matcher.quoteReplacement("horsepower"), Matcher.quoteReplacement("hp")));
							message_info2.setText(message_info2.getText().replaceAll(Matcher.quoteReplacement("minute"), Matcher.quoteReplacement("min")));

							message_info.setFont(new Font("Arial", Font.PLAIN, 12));
							message_panel.add(message_info);
							info_panel.add(message_panel, gbc_message_info);
							message_info2.setFont(new Font("Arial", Font.PLAIN, 12));
							message_panel2.add(message_info2);
							info_panel.add(message_panel2, gbc_message_info2);
					    	
					    	JOptionPane.showOptionDialog(frame, info_panel, ln.toString(), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Close"}, null);
				    	}
				    }
				});
				
			}
		});
		panel_24.add(btnInfo);
		
		JPanel panel_17 = new JPanel();
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.insets = new Insets(0, 0, 0, 5);
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 0;
		gbc_panel_17.gridy = 5;
		panel_1.add(panel_17, gbc_panel_17);
		
		JPanel panel_18 = new JPanel();
		GroupLayout gl_panel_17 = new GroupLayout(panel_17);
		gl_panel_17.setHorizontalGroup(
			gl_panel_17.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_17.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_18, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
		);
		gl_panel_17.setVerticalGroup(
			gl_panel_17.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_17.createSequentialGroup()
					.addComponent(panel_18, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
					.addContainerGap())
		);
		GridBagLayout gbl_panel_18 = new GridBagLayout();
		gbl_panel_18.columnWidths = new int[]{100, 100, 0};
		gbl_panel_18.rowHeights = new int[]{0, 0};
		gbl_panel_18.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_18.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_18.setLayout(gbl_panel_18);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPage();
				return;
			}
		});
		btnMenu.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMenu.weightx = 0.5;
		gbc_btnMenu.insets = new Insets(0, 20, 5, 10);
		gbc_btnMenu.gridx = 0;
		gbc_btnMenu.gridy = 0;
		panel_18.add(btnMenu, gbc_btnMenu);
		
		JPanel panel_19 = new JPanel();
		GridBagConstraints gbc_panel_19 = new GridBagConstraints();
		gbc_panel_19.insets = new Insets(0, 5, 0, 0);
		gbc_panel_19.fill = GridBagConstraints.BOTH;
		gbc_panel_19.gridx = 2;
		gbc_panel_19.gridy = 5;
		panel_1.add(panel_19, gbc_panel_19);
		
		JPanel panel_20 = new JPanel();
		GroupLayout gl_panel_19 = new GroupLayout(panel_19);
		gl_panel_19.setHorizontalGroup(
			gl_panel_19.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addComponent(panel_20, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_19.setVerticalGroup(
			gl_panel_19.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addComponent(panel_20, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
					.addContainerGap())
		);
		GridBagLayout gbl_panel_20 = new GridBagLayout();
		gbl_panel_20.columnWidths = new int[]{100, 100, 0};
		gbl_panel_20.rowHeights = new int[]{0, 0};
		gbl_panel_20.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_20.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_20.setLayout(gbl_panel_20);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(first_page)
					companyPage();
				else
					builderPage(false, null, true, true);
				return;
			}
		});
		btnBack_1.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBack_1 = new GridBagConstraints();
		gbc_btnBack_1.insets = new Insets(0, 20, 5, 10);
		gbc_btnBack_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBack_1.weightx = 0.5;
		gbc_btnBack_1.gridx = 0;
		gbc_btnBack_1.gridy = 0;
		panel_20.add(btnBack_1, gbc_btnBack_1);
		panel_17.setLayout(gl_panel_17);
		
		if(first_page) {
			JButton btnNextt_1 = new JButton("Next");
			btnNextt_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					builderPage(false, null, false, false);
				}
			});
			
			btnNextt_1.setFont(new Font("Arial", Font.PLAIN, 15));
			GridBagConstraints gbc_btnNextt_1 = new GridBagConstraints();
			gbc_btnNextt_1.insets = new Insets(0, 10, 5, 20);
			gbc_btnNextt_1.weightx = 0.5;
			gbc_btnNextt_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnNextt_1.gridx = 1;
			gbc_btnNextt_1.gridy = 0;
			panel_20.add(btnNextt_1, gbc_btnNextt_1);
			panel_19.setLayout(gl_panel_19);
		}
		else {
			JButton btnExportFactory_1 = new JButton("Export");
			btnExportFactory_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	
						EventQueue.invokeLater(new Runnable() {
						    @Override
						    public void run() {
						    	fc = new JFileChooser("Desktop") {
									@Override
								    public void approveSelection() {
								        File f = getSelectedFile();
								        if(f.exists() && getDialogType() == SAVE_DIALOG) {
								            result = JOptionPane.showConfirmDialog(this, "File already exists. Overwrite?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
								            switch(result) {
								                case JOptionPane.YES_OPTION:
								                    super.approveSelection();
								                    return;
								                case JOptionPane.NO_OPTION:
								                    return;
								                case JOptionPane.CLOSED_OPTION:
								                    return;
								                case JOptionPane.CANCEL_OPTION:
								                    cancelSelection();
								                    return;
								            }
								        }
								        super.approveSelection();
								    }
								};
								
								FileNameExtensionFilter OWL_filter = new FileNameExtensionFilter("RDF/XML (*.owl)", "owl");
								fc.setFileFilter(OWL_filter);
								fc.setFocusable(false);
								fc.setDialogTitle("Export Factory");
								fc.setMultiSelectionEnabled(false);
								fc.setCurrentDirectory(new File("\\"));
								fc.changeToParentDirectory();
								JComboBox save_combo = (JComboBox)(fc.getComponent(0).getAccessibleContext().getAccessibleChild(2));
								save_combo.setFont(new Font("Arial", Font.PLAIN, 12));
								save_combo.setUI(new ComboUI(save_combo, true));
								save_combo.setBorder(new LineBorder(Color.GRAY));
								save_combo.setBackground(Color.WHITE);
								configureFileChooserUI(fc.getComponents(), true);
								
								result = fc.showSaveDialog(frame);	
								if(result == 0)
								{
									try {
										OntModel factory = generateFinalFactory();
										File selected_file = fc.getSelectedFile();
										String selected_file_path = selected_file.getAbsolutePath();
										if(selected_file_path.length() < 4 || !(selected_file_path.substring(selected_file_path.length() - 4, selected_file_path.length()).equals(".owl")))
											selected_file = new File(selected_file_path + ".owl");
										selected_file.createNewFile();
										FileOutputStream fos = new FileOutputStream(selected_file, false);
										OutputStreamWriter osw = new OutputStreamWriter(fos);
										RDFWriter writer = factory.getWriter("RDF/XML-ABBREV");
										writer.setProperty("showXmlDeclaration", false);
										writer.write(factory, osw, null);
										osw.close();
										fos.close();
									} catch (IOException e1) {
										System.out.println("ERROR SAVING: " + e1);
									}
								}
						    }
						});
	
				}
			});
			
			btnExportFactory_1.setFont(new Font("Arial", Font.PLAIN, 15));
			GridBagConstraints gbc_btnExportFactory_1 = new GridBagConstraints();
			gbc_btnExportFactory_1.insets = new Insets(0, 10, 5, 20);
			gbc_btnExportFactory_1.weightx = 0.5;
			gbc_btnExportFactory_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnExportFactory_1.gridx = 1;
			gbc_btnExportFactory_1.gridy = 0;
			panel_20.add(btnExportFactory_1, gbc_btnExportFactory_1);
			panel_19.setLayout(gl_panel_19);
		}
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	JPanel save_panel = new JPanel();
						GridBagLayout gbl_save_panel = new GridBagLayout();
						gbl_save_panel.columnWidths = new int[]{345, 0};
						gbl_save_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
						gbl_save_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
						save_panel.setLayout(gbl_save_panel); 
						
						JPanel message_panel = new JPanel(new FlowLayout(FlowLayout.LEADING,0, 0));
						GridBagConstraints gbc_message_save = new GridBagConstraints();
						gbc_message_save.insets = new Insets(1, 0, 5, 0);
						gbc_message_save.fill = GridBagConstraints.BOTH;
						gbc_message_save.gridx = 0;
						gbc_message_save.gridy = 0;
						JLabel message_save = new JLabel("<html>Saved factories are remembered until the program is closed.<br><br>Currently saved factories:</html>", SwingConstants.LEFT);
						message_save.setFont(new Font("Arial", Font.PLAIN, 12));
						message_panel.add(message_save);
						save_panel.add(message_panel, gbc_message_save);
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<ListNode2> list_model_save = new DefaultListModel<ListNode2>();
						for(ListNode2 ln : saved_factories) {
							list_model_save.addElement(ln);
						}
						
						JList<ListNode2> list_save = new JList<ListNode2>(list_model_save);
						list_save.setFont(new Font("Arial", Font.PLAIN, 12));
						list_save.setFocusable(false);
						list_save.setSelectionBackground(list_save.getBackground());
						list_save.setVisibleRowCount(6);
						list_save.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						list_panel.add(list_save, BorderLayout.CENTER);
				    	
						JScrollPane scrollPane_save = new JScrollPane(list_save);
				    	scrollPane_save.setBorder(BorderFactory.createEmptyBorder());
				    	scrollPane_save.getVerticalScrollBar().setUnitIncrement(10);
				    	scrollPane_save.getHorizontalScrollBar().setUnitIncrement(10);
				    	scrollPane_save.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
				    	scrollPane_save.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
				    	scrollPane_save.setOpaque(false);
						list_panel.add(scrollPane_save);
						
						GridBagConstraints gbc_list_panel = new GridBagConstraints();
						gbc_list_panel.insets = new Insets(0, 0, 10, 0);
						gbc_list_panel.fill = GridBagConstraints.BOTH;
						gbc_list_panel.gridx = 0;
						gbc_list_panel.gridy = 1;
						save_panel.add(list_panel, gbc_list_panel);
						
						JPanel enter_panel = new JPanel(new FlowLayout(FlowLayout.LEADING,0, 0));
						JLabel enter_save = new JLabel("Enter save name:", SwingConstants.LEFT);
						enter_save.setFont(new Font("Arial", Font.PLAIN, 12));
						GridBagConstraints gbc_enter_save = new GridBagConstraints();
						gbc_enter_save.insets = new Insets(0, 0, 5, 0);
						gbc_enter_save.fill = GridBagConstraints.BOTH;
						gbc_enter_save.gridx = 0;
						gbc_enter_save.gridy = 2;
						enter_panel.add(enter_save);
						save_panel.add(enter_panel, gbc_enter_save);
						
						JTextField name_save = new JTextField();
						name_save.setText(company.getName() + " Factory");
						GridBagConstraints gbc_name_save = new GridBagConstraints();
						gbc_name_save.insets = new Insets(0, 0, 10, 0);
						gbc_name_save.fill = GridBagConstraints.BOTH;
						gbc_name_save.gridx = 0;
						gbc_name_save.gridy = 3;
						save_panel.add(name_save, gbc_name_save);
				    	
				    	result = JOptionPane.showOptionDialog(frame, save_panel, "Save Factory", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Save", "Cancel"}, null);
			            switch(result) {
			                case JOptionPane.OK_OPTION:
								OntModel factory = generateFinalFactory();
			                	saved_factories.add(new ListNode2(factory, name_save.getText()));
			                    return;
			                case JOptionPane.CANCEL_OPTION:
			                    return;
			                case JOptionPane.CLOSED_OPTION:
			                    return;
				    	}
				    }
				});
				
			}
		});
		btnSave.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.weightx = 0.5;
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.insets = new Insets(0, 10, 5, 20);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 0;
		panel_18.add(btnSave, gbc_btnSave);

		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	public void analyzePage() {
		getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAnalyzeFactory = new JButton("Analyze Factory");
		btnAnalyzeFactory.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnAnalyzeFactory = new GridBagConstraints();
		gbc_btnAnalyzeFactory.weightx = 1.0;
		gbc_btnAnalyzeFactory.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnalyzeFactory.insets = new Insets(125, 225, 10, 225);
		gbc_btnAnalyzeFactory.gridx = 0;
		gbc_btnAnalyzeFactory.gridy = 0;
		panel.add(btnAnalyzeFactory, gbc_btnAnalyzeFactory);
		btnAnalyzeFactory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
				EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	JPanel analyze_panel = new JPanel();
						GridBagLayout gbl_analyze_panel = new GridBagLayout();
						gbl_analyze_panel.columnWidths = new int[]{345, 0};
						gbl_analyze_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
						gbl_analyze_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
						analyze_panel.setLayout(gbl_analyze_panel);
						
						JPanel message_panel = new JPanel(new FlowLayout(FlowLayout.LEADING,0, 0));
						GridBagConstraints gbc_message_analyze = new GridBagConstraints();
						gbc_message_analyze.insets = new Insets(1, 0, 5, 0);
						gbc_message_analyze.fill = GridBagConstraints.BOTH;
						gbc_message_analyze.gridx = 0;
						gbc_message_analyze.gridy = 0;
						JLabel message_analyze = new JLabel("Select a factory to analyze:", SwingConstants.LEFT);
						message_analyze.setFont(new Font("Arial", Font.PLAIN, 12));
						message_panel.add(message_analyze);
						analyze_panel.add(message_panel, gbc_message_analyze);
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<ListNode2> list_model_analyze = new DefaultListModel<ListNode2>();
						for(ListNode2 ln : saved_factories) {
							list_model_analyze.addElement(ln);
						}
						
						JList<ListNode2> list_analyze = new JList<ListNode2>(list_model_analyze);
						list_analyze.setFont(new Font("Arial", Font.PLAIN, 12));
						list_analyze.setVisibleRowCount(6);
						list_analyze.setFocusable(false);
						list_analyze.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						list_panel.add(list_analyze, BorderLayout.CENTER);
				    	
						JScrollPane scrollPane_analyze = new JScrollPane(list_analyze);
				    	scrollPane_analyze.setBorder(BorderFactory.createEmptyBorder());
				    	scrollPane_analyze.getVerticalScrollBar().setUnitIncrement(10);
				    	scrollPane_analyze.getHorizontalScrollBar().setUnitIncrement(10);
				    	scrollPane_analyze.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
				    	scrollPane_analyze.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
				    	scrollPane_analyze.setOpaque(false);
						list_panel.add(scrollPane_analyze);
						
						GridBagConstraints gbc_list_panel = new GridBagConstraints();
						gbc_list_panel.insets = new Insets(0, 0, 8, 0);
						gbc_list_panel.fill = GridBagConstraints.BOTH;
						gbc_list_panel.gridx = 0;
						gbc_list_panel.gridy = 1;
						analyze_panel.add(list_panel, gbc_list_panel);
				    	
				    	result = JOptionPane.showOptionDialog(frame, analyze_panel, "Open Factory", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Open", "Cancel"}, null);
			            switch(result) {
			                case JOptionPane.OK_OPTION:
			                	if(list_analyze.getSelectedValue() != null) {
			                		OntModel factory = list_analyze.getSelectedValue().getFactory();
			                		resultsPage(factory);
			                	}
			                    return;
			                case JOptionPane.CANCEL_OPTION:
			                    return;
			                case JOptionPane.CLOSED_OPTION:
			                    return;
				    	}
				    }
				});
				
            }
        });
		
		JButton btnCompareFactories = new JButton("Compare Factories");
		btnCompareFactories.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnCompareFactories = new GridBagConstraints();
		gbc_btnCompareFactories.weightx = 1.0;
		gbc_btnCompareFactories.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCompareFactories.insets = new Insets(0, 225, 10, 225);
		gbc_btnCompareFactories.gridx = 0;
		gbc_btnCompareFactories.gridy = 1;
		panel.add(btnCompareFactories, gbc_btnCompareFactories);
		btnAnalyzeFactory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO
                return;
            }
        });
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBack.insets = new Insets(69, 290, 0, 290);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 3;
		panel.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuPage();
                return;
            }
        });
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	public void resultsPage(OntModel factory) {
		getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{684, 0};
		gbl_panel.rowHeights = new int[]{50, 0, 40, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblFactoryAnalysisResults = new JLabel("Factory Analysis");
		lblFactoryAnalysisResults.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblFactoryAnalysisResults = new GridBagConstraints();
		gbc_lblFactoryAnalysisResults.insets = new Insets(14, 0, 5, 0);
		gbc_lblFactoryAnalysisResults.fill = GridBagConstraints.VERTICAL;
		gbc_lblFactoryAnalysisResults.gridx = 0;
		gbc_lblFactoryAnalysisResults.gridy = 0;
		panel.add(lblFactoryAnalysisResults, gbc_lblFactoryAnalysisResults);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFocusable(false);
		tabbedPane.setBorder(null);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(5, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		panel.add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, tab_color2));
		tabbedPane.addTab("Capability Range", null, panel_1, null);
		panel_1.setBackground(tab_color1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(tab_color1);
		GridBagConstraints gbc_panel_20 = new GridBagConstraints();
		gbc_panel_20.insets = new Insets(0, 0, 5, 0);
		gbc_panel_20.fill = GridBagConstraints.BOTH;
		gbc_panel_20.gridx = 0;
		gbc_panel_20.gridy = 0;
		panel_1.add(panel_20, gbc_panel_20);
		GridBagLayout gbl_panel_20 = new GridBagLayout();
		gbl_panel_20.columnWidths = new int[]{0, 0};
		gbl_panel_20.rowHeights = new int[]{0, 0};
		gbl_panel_20.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_20.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_20.setLayout(gbl_panel_20);
		
		JLabel lblQuantitativeIndicators = new JLabel("Quantitative Indicators:");
		GridBagConstraints gbc_lblQuantitativeIndicators = new GridBagConstraints();
		gbc_lblQuantitativeIndicators.insets = new Insets(15, 50, 0, 0);
		gbc_lblQuantitativeIndicators.fill = GridBagConstraints.BOTH;
		gbc_lblQuantitativeIndicators.gridx = 0;
		gbc_lblQuantitativeIndicators.gridy = 0;
		panel_20.add(lblQuantitativeIndicators, gbc_lblQuantitativeIndicators);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(tab_color1);
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.insets = new Insets(0, 0, 5, 0);
		gbc_panel_18.fill = GridBagConstraints.BOTH;
		gbc_panel_18.gridx = 0;
		gbc_panel_18.gridy = 1;
		panel_1.add(panel_18, gbc_panel_18);
		GridBagLayout gbl_panel_18 = new GridBagLayout();
		gbl_panel_18.columnWidths = new int[]{0, 0};
		gbl_panel_18.rowHeights = new int[]{0, 0};
		gbl_panel_18.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_18.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_18.setLayout(gbl_panel_18);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBackground(Color.WHITE);
		scrollPane_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane_4.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane_4.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane_4.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane_4.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.insets = new Insets(0, 50, 0, 50);
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridx = 0;
		gbc_scrollPane_4.gridy = 0;
		panel_18.add(scrollPane_4, gbc_scrollPane_4);
		
		JTable table_6 = new JTable();
		table_6.setBorder(new EmptyBorder(0, 0, 0, 0));
		table_6.setFillsViewportHeight(true);
		table_6.setRowHeight(20);
		table_6.getTableHeader().setPreferredSize(new Dimension(0, 30));
		table_6.setModel(new DefaultTableModel(
			new Object[][] {
				{"Precision (inch)", ".00001 - .001", ""},
				{"Part length (inch)", "5 - 45", ""},
				{"Part diameter (inch)", "4 - 18", ""},
				{"Surface roughness", "1.6 - 50", ""},
				{"Smallest wall thickness", ".2", ""},
			},
			new String[] {
				"Capability", "Explicit", "Inferred"
			}
		));
		table_6.getColumnModel().getColumn(0).setPreferredWidth(300);
		table_6.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_6.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_6.setAutoCreateColumnsFromModel(false);
		table_6.setDragEnabled(false);
		table_6.setEnabled(false);
		table_6.setOpaque(true);
		table_6.getTableHeader().setReorderingAllowed(false);
		scrollPane_4.setViewportView(table_6);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(tab_color1);
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.insets = new Insets(10, 0, 10, 0);
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 0;
		gbc_panel_17.gridy = 2;
		panel_1.add(panel_17, gbc_panel_17);
		GridBagLayout gbl_panel_17 = new GridBagLayout();
		gbl_panel_17.columnWidths = new int[]{0, 0, 0};
		gbl_panel_17.rowHeights = new int[]{0, 0};
		gbl_panel_17.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_17.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_17.setLayout(gbl_panel_17);
		
		JButton btnInferCapability_2 = new JButton("Infer Capability");
		btnInferCapability_2.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInferCapability_2.setUI(new ButtonUI2());
		GridBagConstraints gbc_btnInferCapability_2 = new GridBagConstraints();
		gbc_btnInferCapability_2.fill = GridBagConstraints.BOTH;
		gbc_btnInferCapability_2.insets = new Insets(0, 50, 0, 5);
		gbc_btnInferCapability_2.gridx = 0;
		gbc_btnInferCapability_2.gridy = 0;
		panel_17.add(btnInferCapability_2, gbc_btnInferCapability_2);
		
		JButton btnReset_3 = new JButton("Reset");
		btnReset_3.setFont(new Font("Arial", Font.PLAIN, 15));
		btnReset_3.setUI(new ButtonUI2());
		GridBagConstraints gbc_btnReset_3 = new GridBagConstraints();
		gbc_btnReset_3.insets = new Insets(0, 5, 0, 250);
		gbc_btnReset_3.fill = GridBagConstraints.BOTH;
		gbc_btnReset_3.gridx = 1;
		gbc_btnReset_3.gridy = 0;
		panel_17.add(btnReset_3, gbc_btnReset_3);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(tab_color1);
		GridBagConstraints gbc_panel_19 = new GridBagConstraints();
		gbc_panel_19.insets = new Insets(0, 0, 5, 0);
		gbc_panel_19.fill = GridBagConstraints.BOTH;
		gbc_panel_19.gridx = 0;
		gbc_panel_19.gridy = 3;
		panel_1.add(panel_19, gbc_panel_19);
		GridBagLayout gbl_panel_19 = new GridBagLayout();
		gbl_panel_19.columnWidths = new int[]{0, 0};
		gbl_panel_19.rowHeights = new int[]{0, 0};
		gbl_panel_19.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_19.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_19.setLayout(gbl_panel_19);
		
		JLabel lblQualitativeIndicators = new JLabel("Qualitative Indicators:");
		GridBagConstraints gbc_lblQualitativeIndicators = new GridBagConstraints();
		gbc_lblQualitativeIndicators.insets = new Insets(0, 50, 0, 0);
		gbc_lblQualitativeIndicators.fill = GridBagConstraints.BOTH;
		gbc_lblQualitativeIndicators.gridx = 0;
		gbc_lblQualitativeIndicators.gridy = 0;
		panel_19.add(lblQualitativeIndicators, gbc_lblQualitativeIndicators);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(tab_color1);
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 0;
		gbc_panel_16.gridy = 4;
		panel_1.add(panel_16, gbc_panel_16);
		GridBagLayout gbl_panel_16 = new GridBagLayout();
		gbl_panel_16.columnWidths = new int[]{0, 0};
		gbl_panel_16.rowHeights = new int[]{0, 0};
		gbl_panel_16.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_16.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_16.setLayout(gbl_panel_16);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBackground(Color.WHITE);
		scrollPane_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane_5.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane_5.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane_5.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane_5.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
		gbc_scrollPane_5.insets = new Insets(0, 50, 20, 50);
		gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_5.gridx = 0;
		gbc_scrollPane_5.gridy = 0;
		panel_16.add(scrollPane_5, gbc_scrollPane_5);
		
		JTable table_7 = new JTable();
		table_7.setBorder(new EmptyBorder(0, 0, 0, 0));
		table_7.setFillsViewportHeight(true);
		table_7.setRowHeight(20);
		table_7.getTableHeader().setPreferredSize(new Dimension(0, 30));
		table_7.setModel(new DefaultTableModel(
			new Object[][] {
				{"Complexity", "Medium", ""},
				{"Variety", "Low", ""},
				{"Production range", "Low - medium", ""},
			},
			new String[] {
				"Capability", "Explicit", "Inferred"
			}
		));
		table_7.getColumnModel().getColumn(0).setPreferredWidth(300);
		table_7.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_7.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_7.setAutoCreateColumnsFromModel(false);
		table_7.setDragEnabled(false);
		table_7.setEnabled(false);
		table_7.setOpaque(true);
		table_7.getTableHeader().setReorderingAllowed(false);
		scrollPane_5.setViewportView(table_7);
		
		btnInferCapability_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_7.setModel(new DefaultTableModel(
					new Object[][] {
						{"Complexity", "Medium", "Medium"},
						{"Variety", "Low", "Low - medium"},
						{"Production range", "Low - medium", "Low - medium"},
					},
					new String[] {
						"Capability", "Explicit", "Inferred"
					}
				));
				table_6.setModel(new DefaultTableModel(
					new Object[][] {
						{"Precision (inch)", ".00001 - .001", ".00001 - .001"},
						{"Part length (inch)", "5 - 45", "3 - 48"},
						{"Part diameter (inch)", "4 - 18", "3.5 - 20"},
						{"Surface roughness", "1.6 - 50", "8 - 50"},
						{"Smallest wall thickness", ".2", ".1"},
					},
					new String[] {
						"Capability", "Explicit", "Inferred"
					}
				));
			}
		});
		
		btnReset_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_7.setModel(new DefaultTableModel(
					new Object[][] {
						{"Complexity", "Medium", ""},
						{"Variety", "Low", ""},
						{"Production range", "Low - medium", ""},
					},
					new String[] {
						"Capability", "Explicit", "Inferred"
					}
				));
				table_6.setModel(new DefaultTableModel(
					new Object[][] {
						{"Precision (inch)", ".00001 - .001", ""},
						{"Part length (inch)", "5 - 45", ""},
						{"Part diameter (inch)", "4 - 18", ""},
						{"Surface roughness", "1.6 - 50", ""},
						{"Smallest wall thickness", ".2", ""},
					},
					new String[] {
						"Capability", "Explicit", "Inferred"
					}
				));
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 1, 0, tab_color2));
		panel_2.setBackground(tab_color1);
		tabbedPane.addTab("Process Capability", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(tab_color1);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 0;
		panel_2.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JScrollPane scrollPaneExp = new JScrollPane();
		scrollPaneExp.setBackground(Color.WHITE);
		scrollPaneExp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPaneExp.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneExp.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPaneExp.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPaneExp.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		GridBagConstraints gbc_scrollPaneExp = new GridBagConstraints();
		gbc_scrollPaneExp.insets = new Insets(20, 50, 0, 50);
		gbc_scrollPaneExp.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneExp.gridx = 0;
		gbc_scrollPaneExp.gridy = 0;
		panel_8.add(scrollPaneExp, gbc_scrollPaneExp);
		
		JTable table_1 = new JTable();
		table_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		table_1.setFillsViewportHeight(true);
		table_1.setRowHeight(20);
		table_1.getTableHeader().setPreferredSize(new Dimension(0, 30));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Milling"},
				{"Turning"}
			},
			new String[] {
				"Explicit Processes"
			}
		));
		table_1.setDragEnabled(false);
		table_1.setEnabled(false);
		table_1.setOpaque(true);
		((DefaultTableCellRenderer)table_1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
		table_1.getTableHeader().setReorderingAllowed(false);
		scrollPaneExp.setViewportView(table_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(tab_color1);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 1;
		panel_2.add(panel_9, gbc_panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0};
		gbl_panel_9.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JButton btnInfer = new JButton("Infer Capability");
		btnInfer.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInfer.setUI(new ButtonUI2());
		GridBagConstraints gbc_btnInfer = new GridBagConstraints();
		gbc_btnInfer.fill = GridBagConstraints.BOTH;
		gbc_btnInfer.insets = new Insets(0, 50, 0, 5);
		gbc_btnInfer.gridx = 0;
		gbc_btnInfer.gridy = 0;
		panel_9.add(btnInfer, gbc_btnInfer);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Arial", Font.PLAIN, 15));
		btnReset.setUI(new ButtonUI2());
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 5, 0, 250);
		gbc_btnReset.fill = GridBagConstraints.BOTH;
		gbc_btnReset.gridx = 1;
		gbc_btnReset.gridy = 0;
		panel_9.add(btnReset, gbc_btnReset);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(tab_color1);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 2;
		panel_2.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JScrollPane scrollPaneInf = new JScrollPane();
		scrollPaneInf.setBackground(Color.WHITE);
		scrollPaneInf.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPaneInf.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneInf.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPaneInf.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPaneInf.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		GridBagConstraints gbc_scrollPaneInf = new GridBagConstraints();
		gbc_scrollPaneInf.insets = new Insets(0, 50, 20, 50);
		gbc_scrollPaneInf.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneInf.gridx = 0;
		gbc_scrollPaneInf.gridy = 0;
		panel_7.add(scrollPaneInf, gbc_scrollPaneInf);
		
		JTable table_2 = new JTable();
		table_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		table_2.setFillsViewportHeight(true);
		table_2.setRowHeight(20);
		table_2.getTableHeader().setPreferredSize(new Dimension(0, 30));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
				"Inferred Processes"
			}
		));
		table_2.setDragEnabled(false);
		table_2.setEnabled(false);
		table_2.setOpaque(true);
		((DefaultTableCellRenderer)table_2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
		table_2.getTableHeader().setReorderingAllowed(false);
		scrollPaneInf.setViewportView(table_2);
		
		btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	table_2.setModel(new DefaultTableModel(
            		new Object[][] {

            		},
            		new String[] {
            			"Inferred Processes"
            		}
            	));
            }
        });
		
		btnInfer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	table_2.setModel(new DefaultTableModel(
            		new Object[][] {
            			{"Treading"},
            			{"Knurling"},
            			{"Boring"},
            			{"Grooving"}
            		},
            		new String[] {
            			"Inferred Processes"
            		}
            	));
            }
        });
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(0, 0, 1, 0, tab_color2));
		tabbedPane.addTab("Material Capability", null, panel_3, null);
		panel_3.setBackground(tab_color1);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(tab_color1);
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.insets = new Insets(0, 0, 5, 0);
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.gridx = 0;
		gbc_panel_15.gridy = 0;
		panel_3.add(panel_15, gbc_panel_15);
		GridBagLayout gbl_panel_15 = new GridBagLayout();
		gbl_panel_15.columnWidths = new int[]{0, 0};
		gbl_panel_15.rowHeights = new int[]{0, 0};
		gbl_panel_15.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_15.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_15.setLayout(gbl_panel_15);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(20, 50, 0, 50);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_15.add(scrollPane, gbc_scrollPane);
		
		JTable table = new JTable();
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setFillsViewportHeight(true);
		table.setRowHeight(20);
		table.getTableHeader().setPreferredSize(new Dimension(0, 30));
		table.setModel(new DefaultTableModel(
			new Object[][] {
        		{"Alloy Steel"},
        		{"Cast Steel"},
        		{"Brass"},
        		{"Bronze"}
        	},
        	new String[] {
        		"Explicit Material"
        	}
		));
		table.setDragEnabled(false);
		table.setEnabled(false);
		table.setOpaque(true);
		((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(tab_color1);
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.insets = new Insets(0, 0, 5, 0);
		gbc_panel_14.fill = GridBagConstraints.BOTH;
		gbc_panel_14.gridx = 0;
		gbc_panel_14.gridy = 1;
		panel_3.add(panel_14, gbc_panel_14);
		GridBagLayout gbl_panel_14 = new GridBagLayout();
		gbl_panel_14.columnWidths = new int[]{0, 0, 0};
		gbl_panel_14.rowHeights = new int[]{0, 0};
		gbl_panel_14.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_14.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_14.setLayout(gbl_panel_14);
		
		JButton btnInferCapability = new JButton("Infer Capability");
		btnInferCapability.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInferCapability.setUI(new ButtonUI2());
		GridBagConstraints gbc_btnInferCapability = new GridBagConstraints();
		gbc_btnInferCapability.fill = GridBagConstraints.BOTH;
		gbc_btnInferCapability.insets = new Insets(0, 50, 0, 5);
		gbc_btnInferCapability.gridx = 0;
		gbc_btnInferCapability.gridy = 0;
		panel_14.add(btnInferCapability, gbc_btnInferCapability);
		
		JButton btnReset_1 = new JButton("Reset");
		btnReset_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnReset_1.setUI(new ButtonUI2());
		GridBagConstraints gbc_btnReset_1 = new GridBagConstraints();
		gbc_btnReset_1.insets = new Insets(0, 5, 0, 250);
		gbc_btnReset_1.fill = GridBagConstraints.BOTH;
		gbc_btnReset_1.gridx = 1;
		gbc_btnReset_1.gridy = 0;
		panel_14.add(btnReset_1, gbc_btnReset_1);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(tab_color1);
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 0;
		gbc_panel_13.gridy = 2;
		panel_3.add(panel_13, gbc_panel_13);
		GridBagLayout gbl_panel_13 = new GridBagLayout();
		gbl_panel_13.columnWidths = new int[]{0, 0};
		gbl_panel_13.rowHeights = new int[]{0, 0};
		gbl_panel_13.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_13.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_13.setLayout(gbl_panel_13);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane_1.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane_1.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane_1.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 50, 20, 50);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_13.add(scrollPane_1, gbc_scrollPane_1);
		
		JTable table_3 = new JTable();
		table_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		table_3.setFillsViewportHeight(true);
		table_3.setRowHeight(20);
		table_3.getTableHeader().setPreferredSize(new Dimension(0, 30));
		table_3.setModel(new DefaultTableModel(
			new Object[][] {

        	},
        	new String[] {
        		"Inferred Material"
        	}
		));
		table_3.setDragEnabled(false);
		table_3.setEnabled(false);
		table_3.setOpaque(true);
		((DefaultTableCellRenderer)table_3.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
		table_3.getTableHeader().setReorderingAllowed(false);
		scrollPane_1.setViewportView(table_3);
		
		btnInferCapability.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	table_3.setModel(new DefaultTableModel(
            		new Object[][] {
                    	{"Stainless Steel"},
                    	{"Tool Steel"},
                    	{"Die Steel"},
                    	{"Copper"}
                    },
                    new String[] {
                    	"Inferred Material"
                    }
            	));
            }
        });
		
		btnReset_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	table_3.setModel(new DefaultTableModel(
            		new Object[][] {

                    },
                    new String[] {
                    	"Inferred Material"
                    }
            	));
            }
        });
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(0, 0, 1, 0, tab_color2));
		tabbedPane.addTab("Capability Class", null, panel_4, null);
		panel_4.setBackground(tab_color1);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(tab_color1);
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(0, 0, 5, 0);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 0;
		panel_4.add(panel_12, gbc_panel_12);
		GridBagLayout gbl_panel_12 = new GridBagLayout();
		gbl_panel_12.columnWidths = new int[]{0, 0};
		gbl_panel_12.rowHeights = new int[]{0, 0};
		gbl_panel_12.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_12.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_12.setLayout(gbl_panel_12);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBackground(Color.WHITE);
		scrollPane_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane_2.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane_2.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane_2.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane_2.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(20, 50, 0, 50);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 0;
		panel_12.add(scrollPane_2, gbc_scrollPane_2);
		
		JTable table_4 = new JTable();
		table_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		table_4.setFillsViewportHeight(true);
		table_4.setRowHeight(20);
		table_4.getTableHeader().setPreferredSize(new Dimension(0, 30));
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
                {"Heavy and bulky part machining capability"},
                {"Difficult and complex machining capability"},
                {"Engineering design capability"},
                {"Smallest wall thickness capability"}
			},
        	new String[] {
        		"Explicit Capability Class"
        	}
		));
		table_4.setDragEnabled(false);
		table_4.setEnabled(false);
		table_4.setOpaque(true);
		((DefaultTableCellRenderer)table_4.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
		table_4.getTableHeader().setReorderingAllowed(false);
		scrollPane_2.setViewportView(table_4);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(tab_color1);
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 0);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 1;
		panel_4.add(panel_11, gbc_panel_11);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{0, 0, 0};
		gbl_panel_11.rowHeights = new int[]{0, 0};
		gbl_panel_11.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_11.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_11.setLayout(gbl_panel_11);
		
		JButton btnInferCapability_1 = new JButton("Infer Capability");
		btnInferCapability_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInferCapability_1.setUI(new ButtonUI2());
		GridBagConstraints gbc_btnInferCapability_1 = new GridBagConstraints();
		gbc_btnInferCapability_1.fill = GridBagConstraints.BOTH;
		gbc_btnInferCapability_1.insets = new Insets(0, 50, 0, 5);
		gbc_btnInferCapability_1.gridx = 0;
		gbc_btnInferCapability_1.gridy = 0;
		panel_11.add(btnInferCapability_1, gbc_btnInferCapability_1);
		
		JButton btnReset_2 = new JButton("Reset");
		btnReset_2.setUI(new ButtonUI2());
		btnReset_2.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnReset_2 = new GridBagConstraints();
		gbc_btnReset_2.fill = GridBagConstraints.BOTH;
		gbc_btnReset_2.insets = new Insets(0, 5, 0, 250);
		gbc_btnReset_2.gridx = 1;
		gbc_btnReset_2.gridy = 0;
		panel_11.add(btnReset_2, gbc_btnReset_2);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(tab_color1);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 2;
		panel_4.add(panel_10, gbc_panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{0, 0};
		gbl_panel_10.rowHeights = new int[]{0, 0};
		gbl_panel_10.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_10.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_10.setLayout(gbl_panel_10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(Color.WHITE);
		scrollPane_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane_3.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane_3.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane_3.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane_3.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.insets = new Insets(0, 50, 20, 50);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 0;
		panel_10.add(scrollPane_3, gbc_scrollPane_3);
		
		JTable table_5 = new JTable();
		table_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		table_5.setFillsViewportHeight(true);
		table_5.setRowHeight(20);
		table_5.getTableHeader().setPreferredSize(new Dimension(0, 30));
		table_5.setModel(new DefaultTableModel(
			new Object[][] {

        	},
        	new String[] {
        		"Inferred Capability Class"
        	}
		));
		table_5.setDragEnabled(false);
		table_5.setEnabled(false);
		table_5.setOpaque(true);
		((DefaultTableCellRenderer)table_5.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
		table_5.getTableHeader().setReorderingAllowed(false);
		scrollPane_3.setViewportView(table_5);
		
		btnInferCapability_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	table_5.setModel(new DefaultTableModel(
            		new Object[][] {
                    	{"Low tooling cost capability"},
                    	{"Mechanism fabrication capability"},
                    	{"Short lead time capability"}
                    },
                    new String[] {
                    	"Inferred Capability Class"
                    }
            	));
            }
        });
		
		btnReset_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	table_5.setModel(new DefaultTableModel(
            		new Object[][] {

                    },
                    new String[] {
                    	"Inferred Capability Class"
                    }
            	));
            }
        });
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, tab_color2));
		tabbedPane.addTab("Export", null, panel_5, null);
		panel_5.setBackground(tab_color1);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JButton btnExport = new JButton("Export Capability Model");
		btnExport.setUI(new ButtonUI2());
		btnExport.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.fill = GridBagConstraints.BOTH;
		gbc_btnExport.insets = new Insets(120, 228, 10, 228);
		gbc_btnExport.gridx = 0;
		gbc_btnExport.gridy = 0;
		panel_5.add(btnExport, gbc_btnExport);
		
		JButton btnExportServiceModel = new JButton("Export Service Model");
		btnExportServiceModel.setUI(new ButtonUI2());
		btnExportServiceModel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnExportServiceModel = new GridBagConstraints();
		gbc_btnExportServiceModel.insets = new Insets(0, 228, 0, 228);
		gbc_btnExportServiceModel.fill = GridBagConstraints.BOTH;
		gbc_btnExportServiceModel.gridx = 0;
		gbc_btnExportServiceModel.gridy = 1;
		panel_5.add(btnExportServiceModel, gbc_btnExportServiceModel);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(12, 0, 12, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 2;
		panel.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{308, 0};
		gbl_panel_6.rowHeights = new int[]{27, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuPage();
				return;
			}
		});
		btnMenu.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.insets = new Insets(0, 290, 5, 290);
		gbc_btnMenu.fill = GridBagConstraints.BOTH;
		gbc_btnMenu.gridx = 0;
		gbc_btnMenu.gridy = 0;
		panel_6.add(btnMenu, gbc_btnMenu);
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
}
