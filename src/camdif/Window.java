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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.ToolTipManager;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
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
import org.apache.jena.util.FileManager;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.jena.vocabulary.RDFS;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
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
	
	// ---------- CURRENT SECTIONS ----------
	// FLAG 0: BUILD
	// FLAG 1: ANALYZE
	// FLAG 2: MATCH
	
	// ---------- CURRENT PAGES ----------
	// loadPage()
	// menuPage()
	// companyPage()
	// listPage()
	// buildPage1()
	// buildPage2()
	// analyzePage1()
	// analyzePage2()
	// analyzePage3()
	// analyzePage4()
	// matchPage1()
	// matchPage2()
	// matchPage3()
	// matchPage4()
	
	// properties
	private static Property prop_hasCompanyType;
	private static Property prop_hasCompanyName;
	private static Property prop_hasNumEmployees;
	private static Property prop_hasYearFounded;
	private static Property prop_hasWebAddress;
	private static Property prop_hasPhysicalAddress;
	private static Property prop_isQualMeasAs;
	private static Property prop_hasMeasVal;
	private static Property prop_operates;
	private static Property prop_hasFactoryEquipment;
	private static Property prop_hasMaterialCapability;
	private static Property prop_hasIndustryCapability;
	private static Property prop_hasSoftwareCapability;
	private static Property prop_hasSkillCapability;
	private static Property prop_hasMinTolerance;
	private static Property prop_hasMaxTolerance;
	private static Property prop_hasMinLength;
	private static Property prop_hasMaxLength;
	private static Property prop_hasMinDiameter;
	private static Property prop_hasMaxDiameter;
	private static Property prop_hasMinRoughness;
	private static Property prop_hasMaxRoughness;
	private static Property prop_hasMinThickness;
	private static Property prop_hasMaxThickness;
	private static Property prop_hasMaxWeight;
	private static Property prop_hasProcessCapability;
	private static Property prop_hasCapacityCapability;
	private static Property prop_hasComplexityCapability;
	private static Property prop_hasVarietyCapability;
	private static Property prop_hasManufacturingCapability;
	private static Property prop_issuedBy;
	private static Property prop_isAbout;
	private static Property prop_hasSpecifiedOutput;
	private static Property prop_requiresCapability;
	private static Property prop_requiresLowerTolerance;
	private static Property prop_requiresUpperTolerance;
	private static Property prop_hasPart;
	private static Property prop_hasMachinePart;
	private static Property prop_hasManufacturer;
	private static Property prop_hasBuildVolume;
	private static Property prop_hasMeasurement;
	private static Property prop_hasMeasurementValue;
	private static Property prop_hasFunction;
	private static Property prop_hasMember;
	
	// window
	private static Window frame;
	private static int screenWidth = 700;
	private static int screenHeight = 600;
	
	// flags
	private static boolean loading;
	private static boolean crawl_go;
	private static int opt_flag = 0;
	
	// general
	private static String version = "1.26.0";
	private static OntModelSpec modelSpec = OntModelSpec.OWL_MEM;
	public static OntModel ontology;
	private static OntModel demo_factory;
	private static OntModel demo_work_order;
	
	// categories
	private static final String uri_MachineTool = "http://infoneer.txstate.edu/ontology/MSDL_0000070";
	private static final String uri_3DPrinter = "http://infoneer.txstate.edu/ontology/MSDL_0000680";
	private static final String uri_Industry = "http://infoneer.txstate.edu/ontology/MSDL_0000686";
	private static final String uri_Material = "http://infoneer.txstate.edu/ontology/MSDL_0000676";
	private static final String uri_Software = "http://purl.obolibrary.org/obo/IAO_0000594";
	private static final String uri_Skill = "http://infoneer.txstate.edu/ontology/MSDL_0001034";
	private static OntClass class_MachineTool;
	private static OntClass class_3DPrinter;
	private static OntClass class_Industry;
	private static OntClass class_Material;
	private static OntClass class_Software;
	private static OntClass class_Skill;
	
	// build headers
	private static String s_3d = "<html><b>3D Printers</b></html>";
	private static String s_machine = "<html><b>Machine Tools</b></html>";
	private static String s_industry = "<html><b>Industries</b></html>";
	private static String s_material = "<html><b>Materials</b></html>";
	private static String s_software = "<html><b>Software</b></html>";
	private static String s_skill = "<html><b>Skills</b></html>";
	private static boolean any;
	private static boolean b_3d;
	private static boolean b_machine;
	private static boolean b_industry;
	private static boolean b_material;
	private static boolean b_software;
	private static boolean b_skill;
	
	// build
	private static Company company;
	private static ArrayList<CompanyWrapper> saved_companies;
	private static ArrayList<ListNode> equipment_individuals;
	private static ArrayList<ListNode> capability_individuals;
	private static ArrayList<OntModelWrapper> saved_factories;
	private static OntClass combo_class;
	private static JComboBox<String> comboBox;
	private static JList<ListNode> list;
	private static DefaultListModel<ListNode> list_model;
	private static JScrollPane scrollPane_1;
	
	// file chooser
	private static JFileChooser fc;
	private static int result;
	private static String import_path;
	private static String export_path;
	
	// analysis
	private static ArrayList<TableNode> exp_functions;
	private static ArrayList<TableNode> inf_functions;
	private static ArrayList<TableNode> exp_materials;
	private static ArrayList<TableNode> inf_materials;
	
	// parsing
	private static JsonNode rn;
	private static ArrayList<JsonNodeWrapper> thesaurus_concepts;
	private static JTable parsing_table;
	private static Map<String, Integer> link_depths;
	
	// work order
	private static WorkOrder work_order;
	private static ArrayList<OntModelWrapper> saved_work_orders;
	private static ArrayList<JsonNodeWrapper> thesaurus_concepts_with_top;
	private static DefaultMutableTreeNode thesaurus_tree_root;
	private static JTree thesaurus_tree;
	private static ArrayList<IndividualWrapper> mat_list;
	private static ArrayList<IndividualWrapper> proc_list;
	
	// matching
	private static ArrayList<MatchData> saved_match_data;
	private static ArrayList<CustomRadioButton> chains;
	
	// colors
	private static Color highlight_color = new Color(255, 220, 0);
	private static Color background_color = new Color(235, 235, 235);
	private static Color etched_color1 = Color.LIGHT_GRAY;
	private static Color etched_color2 = new Color(242, 242, 242);
	private static Color tab_color1 = new Color(220, 220, 220);
	private static Color tab_color2 = new Color(205, 205, 205);
	
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
	
	private Window() {
		super();
		setLocationRelativeTo(null);
		loadPage();
	}
	
	private Window(String frame_title) {
		super(frame_title);
		
		prop_hasCompanyType = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000877");
		prop_hasCompanyName = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000149");
		prop_hasNumEmployees = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000874");
		prop_hasYearFounded = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001081");
		prop_hasWebAddress = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000876");
		prop_hasPhysicalAddress = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000875");
		prop_isQualMeasAs = ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417");
		prop_hasMeasVal = ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004");
		prop_operates = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000679");
		prop_hasFactoryEquipment = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000129");
		prop_hasMaterialCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000770");
		prop_hasIndustryCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000769");
		prop_hasSoftwareCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000771");
		prop_hasSkillCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001059");
		prop_hasMinTolerance = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000928");
		prop_hasMaxTolerance = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000970");
		prop_hasMinLength = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000935");
		prop_hasMaxLength = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000936");
		prop_hasMinDiameter = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000933");
		prop_hasMaxDiameter = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000934");
		prop_hasMinRoughness = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000932");
		prop_hasMaxRoughness = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000931");
		prop_hasMinThickness = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000930");
		prop_hasMaxThickness = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000929");
		prop_hasMaxWeight = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000954");
		prop_hasProcessCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000995");
		prop_hasCapacityCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000967");
		prop_hasComplexityCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001083");
		prop_hasVarietyCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000966");
		prop_hasManufacturingCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000964");
		prop_issuedBy = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001077");
		prop_isAbout = ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000136");
		prop_hasSpecifiedOutput = ontology.getProperty("http://purl.obolibrary.org/obo/OBI_0000299");
		prop_requiresCapability = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001016");
		prop_requiresLowerTolerance = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001075");
		prop_requiresUpperTolerance = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001074");
		prop_hasPart = ontology.getProperty("http://purl.obolibrary.org/obo/BFO_0000051");
		prop_hasMachinePart = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000130");
		prop_hasManufacturer = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000179");
		prop_hasBuildVolume = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000714");
		prop_hasMeasurement = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000924");
		prop_hasMeasurementValue = ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004");
		prop_hasFunction = ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000984");
		prop_hasMember = ontology.getProperty("http://purl.obolibrary.org/obo/RO_0002351");
		
		crawl_go = false;
		company = new Company();
		saved_companies = new ArrayList<CompanyWrapper>();
		work_order = new WorkOrder();
		saved_factories = new ArrayList<>();
		saved_work_orders = new ArrayList<>();
		equipment_individuals = new ArrayList<>();
		capability_individuals = new ArrayList<>();
		exp_functions = new ArrayList<>();
		inf_functions = new ArrayList<>();
		exp_materials = new ArrayList<>();
		inf_materials = new ArrayList<>();
		link_depths = new LinkedHashMap<>();
		saved_match_data = new ArrayList<>();
		chains = new ArrayList<>();
		import_path = "\\";
		export_path = "\\";

		mat_list = new ArrayList<>();
		proc_list = new ArrayList<>();
		OntClass mat_cap = ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000676");
		OntClass proc_cap = ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000959");
		for(ExtendedIterator<OntClass> ei = ontology.listClasses(); ei.hasNext(); ) {
			OntClass oc = ei.next();
			if(isCategoryOf(oc, mat_cap, false)) {
				for(ExtendedIterator<Individual> ei2 = ontology.listIndividuals(oc); ei2.hasNext(); ) {
					IndividualWrapper iw = new IndividualWrapper(ei2.next());
					if(!iw.toString().isEmpty())
						mat_list.add(iw);
				}
			}
			else if(isCategoryOf(oc, proc_cap, false)) {
				for(ExtendedIterator<Individual> ei2 = ontology.listIndividuals(oc); ei2.hasNext(); ) {
					IndividualWrapper iw = new IndividualWrapper(ei2.next());
					if(!iw.toString().isEmpty())
						proc_list.add(iw);
				}
			}
		}

		Collections.sort(mat_list, new Comparator() {
			public int compare(Object o1, Object o2) {
	            return (o1.toString().toLowerCase().compareTo(o2.toString().toLowerCase()));
            }
        });
		Collections.sort(proc_list, new Comparator() {
			public int compare(Object o1, Object o2) {
	            return (o1.toString().toLowerCase().compareTo(o2.toString().toLowerCase()));
            }
        });
		
		class_MachineTool = ontology.getOntClass(uri_MachineTool);
		class_3DPrinter = ontology.getOntClass(uri_3DPrinter);
		class_Industry = ontology.getOntClass(uri_Industry);
		class_Material = ontology.getOntClass(uri_Material);
		class_Software = ontology.getOntClass(uri_Software);
		class_Skill = ontology.getOntClass(uri_Skill);
		
		ToolTipManager.sharedInstance().setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		company.setName("Default");
		company.setURL("https://en.wikipedia.org/wiki/Factory");
		company.setType("Contract manufacturer");
		company.setBusinessType("Small business manufacturing company");
		saved_companies.add(new CompanyWrapper(company, "Default"));
		equipment_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL#MSDL_0000250"), class_MachineTool, ""));
		equipment_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL#MSDL_0000396"), class_MachineTool, ""));
		equipment_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000747"), class_3DPrinter, ""));
		equipment_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000709"), class_3DPrinter, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000797"), class_Industry, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000794"), class_Industry, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000792"), class_Industry, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/steel_capability"), class_Material, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/Al_1000_series_capability"), class_Material, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000783"), class_Software, ""));
		capability_individuals.add(new ListNode(ontology.getIndividual("http://infoneer.txstate.edu/ontology/MSDL_0000776"), class_Software, ""));
		demo_factory = generateFinalExport(0, true, "", "", "", "", "", "", "", "", "", "", "", "", "", "", null);
		saved_factories.add(new OntModelWrapper(demo_factory, "Default Factory"));
		work_order.setPartName("Aluminum Housing");
		work_order.setProductionVolume("Medium");
		work_order.setLowerTolerance(".001");
		work_order.setUpperTolerance(".001");
		work_order.setMaxDiameter("0");
		work_order.setMaxLength("15");
		work_order.setSurfaceRoughness("56");
		work_order.setMinWallThickness(".5");
		work_order.setPartWeight("6");
		work_order.setMaterialCapability(new IndividualWrapper(ontology.getIndividual("http://infoneer.txstate.edu/ontology/aluminum_capability")));
		work_order.addProcessCapability(new IndividualWrapper(ontology.getIndividual("http://infoneer.txstate.edu/ontology/grooving_function")));
		work_order.addProcessCapability(new IndividualWrapper(ontology.getIndividual("http://infoneer.txstate.edu/ontology/end_milling_function")));
		work_order.addProcessCapability(new IndividualWrapper(ontology.getIndividual("http://infoneer.txstate.edu/ontology/face_milling_function")));
		demo_work_order = generateFinalExport(2, false, "", "", "", "", "", "", "", "", "", "", "", "", "", "", null);
		saved_work_orders.add(new OntModelWrapper(demo_work_order, "Default Work Order"));
		
		company = new Company();
		work_order = new WorkOrder();
		equipment_individuals = new ArrayList<ListNode>();
		capability_individuals = new ArrayList<ListNode>();
		
		loading = false;
		menuPage();
	}
	
	private void loadPage() {
		SwingWorker<?,?> worker = new SwingWorker<Void,Void>() {
			@Override
			protected Void doInBackground() {
				try {
					// ---------- LOAD UI ----------
					Icon empty_icon = new ImageIcon();
					Icon folder_icon = new ImageIcon(getClass().getResource("/images/folder.png"));
					Icon file_icon = new ImageIcon(getClass().getResource("/images/file.png"));
					Icon folder_up_icon = new ImageIcon(getClass().getResource("/images/folder_up.png"));
					Icon home_icon = new ImageIcon(getClass().getResource("/images/home.png"));
					Icon question_icon = new ImageIcon(getClass().getResource("/images/question.png"));
					Icon collapsed_icon = new ImageIcon(getClass().getResource("/images/collapsed.png"));
					Icon expanded_icon = new ImageIcon(getClass().getResource("/images/expanded.png"));
					
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
					UIManager.put("CheckBox.foreground", Color.DARK_GRAY);
					UIManager.put("CheckBox.background", tab_color1);
					
					try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } catch(Exception e) { System.out.println("Error 2 setting Java LAF: " + e); }
					
					// ---------- LOAD ONTOLOGY ----------
					ontology = ModelFactory.createOntologyModel(modelSpec);
					//ontology = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC);
					//InfModel inf_model = ModelFactory.createInfModel(PelletReasonerFactory.theInstance().create(), ontology);
					//ontology = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC, infModel);
					ontology.read("information/MSDL.owl", "RDF/XML");
					//ontology.prepare();
					
					// ---------- LOAD THESAURUS ----------
					ObjectMapper mapper = new ObjectMapper();         
		            rn = mapper.readTree(getClass().getResource("/information/thesaurus.rj"));
		            thesaurus_concepts = new ArrayList<JsonNodeWrapper>();
		            thesaurus_concepts_with_top = new ArrayList<JsonNodeWrapper>();
					thesaurus_tree_root = new DefaultMutableTreeNode("Capability Thesaurus");
					ArrayList<DefaultMutableTreeNode> current_nodes = new ArrayList<DefaultMutableTreeNode>();
					for(JsonNode n : rn) {
						if(n.get("http://www.w3.org/2004/02/skos/core#hasTopConcept") != null) {
							DefaultMutableTreeNode category_node = new DefaultMutableTreeNode(new JsonNodeWrapper(n));
							thesaurus_tree_root.add(category_node);
							for(int x = 0; x < n.get("http://www.w3.org/2004/02/skos/core#hasTopConcept").size(); ++x) {
								DefaultMutableTreeNode top_node = new DefaultMutableTreeNode(new JsonNodeWrapper(rn.get(n.get("http://www.w3.org/2004/02/skos/core#hasTopConcept").get(x).get("value").asText())));
								category_node.add(top_node);
								current_nodes.add(top_node);
							}
						}
						else {
							if(n.get("http://www.w3.org/2004/02/skos/core#topConceptOf") == null)
								thesaurus_concepts.add(new JsonNodeWrapper(n));
							thesaurus_concepts_with_top.add(new JsonNodeWrapper(n));
						}
					}
					ArrayList<DefaultMutableTreeNode> next_nodes = new ArrayList<DefaultMutableTreeNode>();
					while(current_nodes.size() > 0)
					{
						for(DefaultMutableTreeNode node : current_nodes) {
							if(node.getUserObject() != null && ((JsonNodeWrapper)node.getUserObject()).getJsonNode().get("http://www.w3.org/2004/02/skos/core#narrower") != null) {
								JsonNode json_node = ((JsonNodeWrapper)node.getUserObject()).getJsonNode();
								for(int x = 0; x < json_node.get("http://www.w3.org/2004/02/skos/core#narrower").size(); ++x) {
									DefaultMutableTreeNode add_node = new DefaultMutableTreeNode(new JsonNodeWrapper(rn.get(json_node.get("http://www.w3.org/2004/02/skos/core#narrower").get(x).get("value").asText())));
									node.add(add_node);
									next_nodes.add(add_node);
								}
							}
					    }
						current_nodes = next_nodes;
						next_nodes = new ArrayList<DefaultMutableTreeNode>();
					}
					thesaurus_tree = new JTree();
					thesaurus_tree.setModel(new DefaultTreeModel(thesaurus_tree_root));
				} catch(Exception e1) {
					e1.printStackTrace(System.out);
					System.exit(0);
				}
				return null;
			}
			
			@Override
			protected void done() {
				try {
					frame.dispose();
					frame = new Window("CaMDiF Tool");
					frame.setResizable(false);
					frame.setUndecorated(false);
					frame.setVisible(true);
				} catch(Exception ee) { ee.printStackTrace(System.out); }
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
	private OntClass getOntClassOf(Individual i) {
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
	
	ArrayList<MatchData> getChainFromIndexes(int[] index_list) {
	    ArrayList<MatchData> chain = new ArrayList<>(); 
	    for(int i = 0; i < index_list.length; ++i)
	    	chain.add(saved_match_data.get(index_list[i]));
	    return chain;
	}
	
	private String generateID(OntModel model) {
		String ID_prefix = "http://infoneer.txstate.edu/ontology/MSDL_";
		String ID;
		Resource ID_resource;
		int counter = 10000000;
		
		do {
			--counter;
			ID = ID_prefix + counter;
			ID_resource = model.getResource(ID);
		} while(model.containsResource(ID_resource) || ontology.containsResource(ID_resource));
		
		return ID;
	}
	
	private void refresh_3d() {
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
	
	private void refresh_machine() {
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
	
	private void refresh_industry() {
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
	
	private void refresh_material() {
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
	
	private void refresh_software() {
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
	
	private void refresh_skill() {
		for(int i = 0; i < capability_individuals.size(); i++) {
			if(capability_individuals.get(i).getCategoryClass().equals(class_Skill)) {
				if(!b_skill) {
					if(any)
						list_model.addElement(new ListNode(null, null, "\n"));
					list_model.addElement(new ListNode(null, null, s_skill));
					b_skill = true;
					any = true;
				}
				list_model.addElement(capability_individuals.get(i));
			}
	    }
	}
	
	private boolean refreshList(boolean first_page, OntClass added) {
		any = false;
		b_3d = false;
		b_machine = false;
		b_industry = false;
		b_material = false;
		b_software = false;
		b_skill = false;
		boolean r = false;
		
		if(first_page) {
			boolean first_3d = false;
			for(int x = 0; x < list_model.size(); ++x) {
				try {
					if(list_model.size() > 0) {
						if(list_model.get(x).getCategoryClass().equals(class_3DPrinter))
							first_3d = true;
						else if(list_model.get(x).getCategoryClass().equals(class_MachineTool))
							first_3d = false;
					}
					break;
				} catch(Exception e) {}
			}
			list_model.removeAllElements();
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
			list_model.removeAllElements();
			boolean ref_industry = false, ref_material = false, ref_software = false, ref_skill = false;
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
				if(capability_individuals.get(i).getCategoryClass().equals(class_Skill) && !ref_skill) {
					r = false;
					refresh_skill();
					ref_skill = true;
					if(added != null && added.equals(class_Skill))
						r = true;
				}
				if(ref_industry && ref_material && ref_software && ref_skill)
					break;
			}
		}
		
		scrollPane_1.validate();
		return r;
	}
	
	private OntClass accountRestrictions(OntClass c) {
		if(c.isIntersectionClass()) {
			for(ExtendedIterator<?> i = c.asIntersectionClass().listOperands(); i.hasNext(); ) {
			      OntClass op = (OntClass)i.next();
			      if(!op.isRestriction()) {
			    	  c = op;
			    	  break;
			      }
			}
		}
		if(c.isUnionClass()) {
			for(ExtendedIterator<?> i = c.asUnionClass().listOperands(); i.hasNext(); ) {
			      OntClass op = (OntClass)i.next();
			      if(!op.isRestriction()) {
			    	  c = op;
			    	  break;
			      }
			}
		}
		return c;
	}
	
	private boolean isCategoryOf(OntClass child, OntClass category, boolean check_equal) {
		if(OntTools.findShortestPath(child.getOntModel(), child, category, new OntTools.PredicatesFilter(RDFS.subClassOf)) != null || (check_equal && child.equals(category)))
			return true;
		if(child.hasSuperClass()) {
			OntClass sc = child.getSuperClass();
			if(sc.isIntersectionClass() || sc.isUnionClass())
				return isCategoryOf(accountRestrictions(sc), category, check_equal);
		}
		return false;
	}
	
	private void configureFileChooserUI(Component[] components, boolean export, int from_flag) {
		for(int i = 0; i < components.length; i++)
		{
			if(components[i] instanceof Container)
				configureFileChooserUI(((Container)components[i]).getComponents(), export, from_flag);
			if(components[i] instanceof JButton)
			{
				JButton jbutton = (JButton)components[i];
				jbutton.setFont(new Font("Arial", Font.PLAIN, 12));
			}
			if(components[i] instanceof JTextField && export && from_flag == 0)
				((JTextField)components[i]).setText(company.getName().replaceAll(" ","") + "Factory.owl");
			if(components[i] instanceof JTextField && export && from_flag == 1)
				((JTextField)components[i]).setText(company.getName().replaceAll(" ","") + "Factory-Cap.owl");
			if(components[i] instanceof JTextField && export && from_flag == 2)
				((JTextField)components[i]).setText(work_order.getPartName().replaceAll(" ","") + "-WO.owl");
			if(components[i] instanceof JTextField && export && from_flag == 3)
				((JTextField)components[i]).setText("SupplyChain.owl");
			if(components[i] instanceof JTextField && export && from_flag == 4)
				((JTextField)components[i]).setText("Session.cmdf");
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
				jcombo.setUI(new ComboUI(jcombo, false, tab_color1));
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
	
	private void setImportedInfo(OntModel model, int from_flag) {
		equipment_individuals = new ArrayList<ListNode>();
		capability_individuals = new ArrayList<ListNode>();
		company = new Company();
		work_order = new WorkOrder();
		
		// MUST FOLLOW ID ORDER GUIDELINES IN "generateFinalExport()"
		OntModel dummy_model = ModelFactory.createOntologyModel(modelSpec);
		Individual indiv_1 = model.getIndividual(generateID(dummy_model));
		dummy_model.createIndividual(generateID(dummy_model), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000010"));
		Individual indiv_2 = model.getIndividual(generateID(dummy_model));
		dummy_model.createIndividual(generateID(dummy_model), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000010"));
		
		try { company.setName(indiv_1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000149")).getObject().asResource().getProperty(RDFS.label).getObject().asLiteral().getLexicalForm().trim()); } catch(Exception e) {}
		try { company.setEmployees(indiv_1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000874")).getObject().asResource().getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().asLiteral().getLexicalForm().trim()); } catch(Exception e) {}
		try { company.setYearFounded(indiv_1.getPropertyResourceValue(prop_hasYearFounded).getProperty(RDFS.label).getObject().asLiteral().getLexicalForm().trim()); } catch(Exception e) {}
		try { company.setURL(indiv_1.getPropertyResourceValue(prop_hasWebAddress).getProperty(RDFS.label).getObject().asLiteral().getLexicalForm().trim()); } catch(Exception e) {}
		
		String bt = getOntClassOf(indiv_1).toString();
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
			
		String ct = indiv_1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000877")).getObject().toString();
		if(ct.equals("http://infoneer.txstate.edu/ontology/MSDL_0000868"))
			try { company.setType("Original design manufacturer"); } catch(Exception e) {}
		else if(ct.equals("http://infoneer.txstate.edu/ontology/MSDL_0000867"))
			try { company.setType("Original equipment manufacturer"); } catch(Exception e) {}
		else if(ct.equals("http://infoneer.txstate.edu/ontology/MSDL_0000866"))
			try { company.setType("Contract manufacturer"); } catch(Exception e) {}
		else if(ct.equals("http://infoneer.txstate.edu/ontology/MSDL_0000865"))
			try { company.setType("Other"); } catch(Exception e) {}
			
		RDFNode street_thing = null, city_thing = null, state_thing = null, zip_thing = null;
		for(NodeIterator n = model.listObjectsOfProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000875")); n.hasNext(); ) {
			try {
				RDFNode address_thing = n.next();
				for(ExtendedIterator<Statement> s = model.listStatements(); s.hasNext(); ) {
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
		for(ExtendedIterator<Statement> s = model.listStatements(); s.hasNext(); ) {
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

		if(from_flag == 0 || from_flag == 1) {
			for(NodeIterator n = indiv_2.listPropertyValues(prop_hasFactoryEquipment); n.hasNext(); ) {
				RDFNode obj = n.next();
				Individual indiv = null;
				OntClass category_class = null;
				
				try {
					indiv = ontology.getIndividual(obj.toString());
					if(isCategoryOf(getOntClassOf(indiv), class_3DPrinter, true))
						category_class = class_3DPrinter;
					else if(isCategoryOf(getOntClassOf(indiv), class_MachineTool, true))
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
			for(NodeIterator n = indiv_2.listPropertyValues(prop_hasIndustryCapability); n.hasNext(); ) {
				RDFNode obj = n.next();
				Individual indiv = null;
				try {
					indiv = ontology.getIndividual(obj.toString());
					boolean exists = false;
					for(int x = 0; x < capability_individuals.size(); x++) {
						if(capability_individuals.get(x).getIndividual().getURI().equals(indiv.getURI())) {
							exists = true;
							x = capability_individuals.size();
						}
					}
					if(!exists)
						capability_individuals.add(new ListNode(indiv, class_Industry, ""));
				} catch(Exception aaa) {}
			}
			for(NodeIterator n = indiv_2.listPropertyValues(prop_hasMaterialCapability); n.hasNext(); ) {
				RDFNode obj = n.next();
				Individual indiv = null;
				try {
					indiv = ontology.getIndividual(obj.toString());
					boolean exists = false;
					for(int x = 0; x < capability_individuals.size(); x++) {
						if(capability_individuals.get(x).getIndividual().getURI().equals(indiv.getURI())) {
							exists = true;
							x = capability_individuals.size();
						}
					}
					if(!exists)
						capability_individuals.add(new ListNode(indiv, class_Material, ""));
				} catch(Exception aaa) {}
			}
			for(NodeIterator n = indiv_2.listPropertyValues(prop_hasSoftwareCapability); n.hasNext(); ) {
				RDFNode obj = n.next();
				Individual indiv = null;
				try {
					indiv = ontology.getIndividual(obj.toString());
					boolean exists = false;
					for(int x = 0; x < capability_individuals.size(); x++) {
						if(capability_individuals.get(x).getIndividual().getURI().equals(indiv.getURI())) {
							exists = true;
							x = capability_individuals.size();
						}
					}
					if(!exists)
						capability_individuals.add(new ListNode(indiv, class_Software, ""));
				} catch(Exception aaa) {}
			}
			for(NodeIterator n = indiv_2.listPropertyValues(prop_hasPart); n.hasNext(); ) {
				Resource r = n.next().asResource();
				for(StmtIterator si = r.listProperties(prop_hasSkillCapability); si.hasNext(); ) {
					try {
						Resource obj = si.next().getObject().asResource();
						String compare_name = obj.getProperty(RDFS.label).getObject().asLiteral().getLexicalForm();
						Individual indiv = null;
						boolean found = false;
						for(ExtendedIterator<Individual> ind = ontology.listIndividuals(); ind.hasNext() && !found; ) {
							try {
								Individual i = ind.next();
								if(i.getProperty(RDFS.label).getObject().asLiteral().getLexicalForm().equals(compare_name)) {
									indiv = i;
									found = true;
								}
							} catch(Exception eee) {}
						}
						if(indiv != null) {
							boolean exists = false;
							for(int x = 0; x < capability_individuals.size(); x++) {
								if(capability_individuals.get(x).getIndividual().getURI().equals(indiv.getURI())) {
									exists = true;
									x = capability_individuals.size();
								}
							}
							if(!exists) {
								ListNode ln = new ListNode(indiv, class_Skill, "");
								ln.setSkillLevel("Very low");
								try {
									Resource obj2 = obj.getPropertyResourceValue(prop_hasMeasurement);
									ln.setSkillLevel(obj2.getProperty(prop_hasMeasurementValue).getObject().toString());
								} catch(Exception e) {}
								capability_individuals.add(ln);
							}
						}
					} catch(Exception aaa) {}
				}
			}
		}
		else if(from_flag == 2) {
			Resource component_res = indiv_2.getPropertyResourceValue(prop_isAbout);
			try { work_order.setPartName(component_res.getProperty(RDFS.label).getObject().asLiteral().getLexicalForm()); } catch(Exception e) {}
			try { work_order.setLowerTolerance(component_res.listProperties(prop_requiresLowerTolerance).next().getObject().asResource().getProperty(RDFS.label).getObject().asLiteral().getLexicalForm()); } catch(Exception e) {}
			try { work_order.setUpperTolerance(component_res.listProperties(prop_requiresUpperTolerance).next().getObject().asResource().getProperty(RDFS.label).getObject().asLiteral().getLexicalForm()); } catch(Exception e) {}
			
			OntClass mat_cap = ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000676");
			OntClass proc_cap = ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000959");
			for(StmtIterator si = component_res.listProperties(prop_requiresCapability); si.hasNext(); ) {
				Resource obj = si.next().getObject().asResource();
				String obj_label = "";
				try {
					obj_label = obj.getProperty(RDFS.label).getObject().asLiteral().getLexicalForm().trim();
				} catch(Exception e) {
					try {
						obj_label = ontology.getIndividual(obj.getURI()).getProperty(RDFS.label).getObject().asLiteral().getLexicalForm().trim();
					}
					catch(Exception e1) { continue; }
				}
				
				for(ExtendedIterator<Individual> ei = model.listIndividuals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000925")); ei.hasNext(); ) {
					if(ei.next().equals(obj)) {
						work_order.setProductionVolume(obj_label);
						break;
					}
				}
				for(ExtendedIterator<Individual> ei = model.listIndividuals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000919")); ei.hasNext(); ) {
					if(ei.next().equals(obj)) {
						work_order.setMaxDiameter(obj_label);
						break;
					}
				}
				for(ExtendedIterator<Individual> ei = model.listIndividuals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000674")); ei.hasNext(); ) {
					if(ei.next().equals(obj)) {
						work_order.setMaxLength(obj_label);
						break;
					}
				}
				for(ExtendedIterator<Individual> ei = model.listIndividuals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000920")); ei.hasNext(); ) {
					if(ei.next().equals(obj)) {
						work_order.setSurfaceRoughness(obj_label);
						break;
					}
				}
				for(ExtendedIterator<Individual> ei = model.listIndividuals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000921")); ei.hasNext(); ) {
					if(ei.next().equals(obj)) {
						work_order.setMinWallThickness(obj_label);
						break;
					}
				}
				for(ExtendedIterator<Individual> ei = model.listIndividuals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000955")); ei.hasNext(); ) {
					if(ei.next().equals(obj)) {
						work_order.setPartWeight(obj_label);
						break;
					}
				}
				
				for(ExtendedIterator<OntClass> ei = ontology.listClasses(); ei.hasNext(); ) {
					OntClass oc = ei.next();
					if(isCategoryOf(oc, mat_cap, false)) {
						for(ExtendedIterator<Individual> ei2 = ontology.listIndividuals(oc); ei2.hasNext(); ) {
							if(ei2.next().equals(obj)) {
								for(IndividualWrapper iw : mat_list) {
									if(iw.toString().equals(obj_label)) {
										work_order.setMaterialCapability(iw);
										break;
									}
								}
								break;
							}
						}
					}
					else if(isCategoryOf(oc, proc_cap, false)) {
						for(ExtendedIterator<Individual> ei2 = ontology.listIndividuals(oc); ei2.hasNext(); ) {
							if(ei2.next().equals(obj)) {
								for(IndividualWrapper iw : proc_list) {
									if(iw.toString().equals(obj_label)) {
										work_order.addProcessCapability(iw);
										break;
									}
								}
								break;
							}
						}
					}
				}

				for(ExtendedIterator<Individual> ei = model.listIndividuals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000010")); ei.hasNext(); ) {
					if(ei.next().equals(obj)) {
						for(JsonNodeWrapper jnw : thesaurus_concepts_with_top) {
							if(jnw.toString().equals(obj_label)) {
								work_order.addConcept(jnw.toString());
								break;
							}
						}
						break;
					}
				}
			}
		}
	}
	
	private Image getScaledImage(Image srcImg, int w, int h) {
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}
	
	private String getTopConceptName(JsonNode rootNode, JsonNode j) {
		if(j.get("http://www.w3.org/2004/02/skos/core#broader") != null)
			return getTopConceptName(rootNode, rootNode.get(j.get("http://www.w3.org/2004/02/skos/core#broader").get(0).get("value").asText()));
		else if(j.get("http://www.w3.org/2004/02/skos/core#topConceptOf") != null) {
			try {
				return j.get("http://www.w3.org/2004/02/skos/core#prefLabel").get(0).get("value").asText().trim();
			} catch(Exception e) { return ""; }
		}
		return "";
	}
	
	private static String getHostName(String url) {
		if(url == null || url.length() == 0)
			return "";

		int doubleslash = url.indexOf("//");
		if(doubleslash == -1)
			doubleslash = 0;
		else
			doubleslash += 2;

		int end = url.indexOf('/', doubleslash);
		end = end >= 0 ? end : url.length();

		int port = url.indexOf(':', doubleslash);
		end = (port > 0 && port < end) ? port : end;

		String host = url.substring(doubleslash, end);
		return host.startsWith("www.") ? host.substring(4) : host;
	}
	
	private String getLinkText(String url, int depth, boolean footer_gotten) {
		ArrayList<String> visited = new ArrayList<>();
		visited.add(url.replaceAll("www.", "").replaceAll("https://", "").replaceAll("http://", "").replaceAll("Http://", "").replaceAll("HTTP://", ""));
		String text = " ";
		String host_domain = getHostName(url);
		int current_depth = 0, cap = 100000;
		while(current_depth <= depth && text.replaceAll("\\s+", " ").length() < cap) {
			Map<String, Integer> to_add = new LinkedHashMap<>();
			for(Map.Entry<String, Integer> ld : link_depths.entrySet()) {
				if(!crawl_go)
					return "";
				if(ld.getValue() == current_depth) {
					Document doc = null;
					String current_link = ld.getKey();
					boolean connected = false;
					try {
						doc = Jsoup.connect(current_link).get();
						connected = true;
					} catch(Exception e1) {
						if(url.length() >= 5 && url.substring(0, 5).equals("https")) {
							try {
								doc = Jsoup.connect("http" + current_link.substring(5)).get();
								connected = true;
							} catch(Exception e2) {}
						}
						else {
							try {
								doc = Jsoup.connect("http://" + current_link).get();
								connected = true;
							} catch(Exception e2) {}
						}
					}

					if(connected) {
						if(current_depth < depth) {
							Elements new_links = doc.select("a[href]");
							for(Element new_link : new_links) {
								String test_key = new_link.attr("abs:href").replaceAll("www.", "").replaceAll("https://", "").replaceAll("http://", "").replaceAll("Http://", "").replaceAll("HTTP://", "");
								if(test_key.lastIndexOf('#') != -1)
									test_key = test_key.substring(0, test_key.lastIndexOf('#'));
								if(!visited.contains(test_key)) {
									try {
										String link_domain = getHostName(new_link.attr("abs:href"));
										if(link_domain.equals(host_domain))
											to_add.put(new_link.attr("abs:href"), current_depth + 1);
									} catch(Exception e) {}
								}
							}
						}
						
						String body_text = doc.body().text(), footer_text = "";
						
						if(doc.select("footer").isEmpty()) {
							if(footer_gotten) {
								for(Element e : doc.select("#footer"))
									body_text.replaceFirst(e.text(), "");
							}
						}
						else {
							if(footer_gotten) {
								for(Element e : doc.select("footer"))
									body_text.replaceFirst(e.text(), "");
							}
						}
						
						footer_gotten = true;
						text += body_text + " " + footer_text + " ";
						if(text.replaceAll("\\s+", " ").length() >= cap)
							return text;
					}
				}
			}
			for(Map.Entry<String, Integer> e : to_add.entrySet()) {
				String key = e.getKey().replaceAll("www.", "").replaceAll("https://", "").replaceAll("http://", "").replaceAll("Http://", "").replaceAll("HTTP://", "");
				if(key.lastIndexOf('#') != -1)
					key = key.substring(0, key.lastIndexOf('#'));
				link_depths.put(e.getKey(), e.getValue());
				visited.add(key);
			}
			current_depth++;
		}

		return text;
	}
	
	private Map<JsonNodeWrapper, Integer> crawl(String url, int depth) {
		link_depths = new LinkedHashMap<>();
		link_depths.put(url, 0);
		String master_text = "  " + getLinkText(url, depth, false).toLowerCase().replaceAll("&", " and ").trim().replaceAll("\\s+", " ") + "  ";
		Map<JsonNodeWrapper, Integer> matched_concepts = new LinkedHashMap<>();
		Pattern p;
		Matcher m;
		
		for(JsonNodeWrapper n : thesaurus_concepts) {
			if(!crawl_go)
				return new LinkedHashMap<>();
			String matching_name = n.getMatchingName();
			String matching_name_alt = n.getMatchingNameAlt();
			int total_occurrences = 0;
			if(!matching_name.isEmpty()) {
				int occurrences1 = 0, occurrences2 = 0, occurrences3 = 0;
				p = Pattern.compile("[()\\s.?,\'\"!]" + matching_name + "(?=\\(|\\)|\\s|\\.|\\?|\\!|\\,|\\-|\'|\"|s\\(|s\\)|s\\s|s\\.|s\\?|s\\!|s\\,|s\\-|s\'|s\"|es\\(|es\\)|es\\s|es\\.|es\\?|es\\!|es\\,|es\\-|es\'|es\")", Pattern.CASE_INSENSITIVE);
				m = p.matcher(master_text);
				while(m.find())
					occurrences1++;
				if(matching_name.substring(matching_name.length() - 1, matching_name.length()).equals("s")) {
					p = Pattern.compile("[()\\s.?,\'\"!]" + matching_name.substring(0, matching_name.length() - 1) + "(?=\\(|\\)|\\s|\\.|\\?|\\!|\\,|\\-|\'|\"|s\\(|s\\)|s\\s|s\\.|s\\?|s\\!|s\\,|s\\-|s\'|s\"|es\\(|es\\)|es\\s|es\\.|es\\?|es\\!|es\\,|es\\-|es\'|es\")", Pattern.CASE_INSENSITIVE);
					m = p.matcher(master_text);
					while(m.find())
						occurrences2++;
				}
				if(matching_name.substring(matching_name.length() - 2, matching_name.length()).equals("es")) {
					p = Pattern.compile("[()\\s.?,\'\"!]" + matching_name.substring(0, matching_name.length() - 2) + "(?=\\(|\\)|\\s|\\.|\\?|\\!|\\,|\\-|\'|\"|s\\(|s\\)|s\\s|s\\.|s\\?|s\\!|s\\,|s\\-|s\'|s\"|es\\(|es\\)|es\\s|es\\.|es\\?|es\\!|es\\,|es\\-|es\'|es\")", Pattern.CASE_INSENSITIVE);
					m = p.matcher(master_text);
					while(m.find())
						occurrences3++;
				}
				else if(occurrences2 > occurrences1 && occurrences2 > occurrences3)
					total_occurrences += occurrences2;
				else if(occurrences3 > occurrences1 && occurrences3 > occurrences2)
					total_occurrences += occurrences3;
				else
					total_occurrences += occurrences1;
			}
			if(!matching_name_alt.isEmpty()) {
				int alt_occurrences1 = 0, alt_occurrences2 = 0, alt_occurrences3 = 0;
				p = Pattern.compile("[()\\s.?,\'\"!]" + matching_name_alt + "(?=\\(|\\)|\\s|\\.|\\?|\\!|\\,|\\-|\'|\"|s\\(|s\\)|s\\s|s\\.|s\\?|s\\!|s\\,|s\\-|s\'|s\"|es\\(|es\\)|es\\s|es\\.|es\\?|es\\!|es\\,|es\\-|es\'|es\")", Pattern.CASE_INSENSITIVE);
				m = p.matcher(master_text);
				while(m.find())
					alt_occurrences1++;
				if(matching_name_alt.substring(matching_name_alt.length() - 1, matching_name_alt.length()).equals("s")) {
					p = Pattern.compile("[()\\s.?,\'\"!]" + matching_name_alt.substring(0, matching_name_alt.length() - 1) + "(?=\\(|\\)|\\s|\\.|\\?|\\!|\\,|\\-|\'|\"|s\\(|s\\)|s\\s|s\\.|s\\?|s\\!|s\\,|s\\-|s\'|s\"|es\\(|es\\)|es\\s|es\\.|es\\?|es\\!|es\\,|es\\-|es\'|es\")", Pattern.CASE_INSENSITIVE);
					m = p.matcher(master_text);
					while(m.find())
						alt_occurrences2++;
				}
				if(matching_name_alt.substring(matching_name_alt.length() - 2, matching_name_alt.length()).equals("es")) {
					p = Pattern.compile("[()\\s.?,\'\"!]" + matching_name_alt.substring(0, matching_name_alt.length() - 2) + "(?=\\(|\\)|\\s|\\.|\\?|\\!|\\,|\\-|\'|\"|s\\(|s\\)|s\\s|s\\.|s\\?|s\\!|s\\,|s\\-|s\'|s\"|es\\(|es\\)|es\\s|es\\.|es\\?|es\\!|es\\,|es\\-|es\'|es\")", Pattern.CASE_INSENSITIVE);
					m = p.matcher(master_text);
					while(m.find())
						alt_occurrences3++;
				}
				else if(alt_occurrences2 > alt_occurrences1 && alt_occurrences2 > alt_occurrences3)
					total_occurrences += alt_occurrences2;
				else if(alt_occurrences3 > alt_occurrences1 && alt_occurrences3 > alt_occurrences2)
					total_occurrences += alt_occurrences3;
				else
					total_occurrences += alt_occurrences1;
			}
			if(total_occurrences != 0)
				matched_concepts.put(n, total_occurrences);
		}

		Map<JsonNodeWrapper, Integer> matched_concepts_desc = new LinkedHashMap<>();
		matched_concepts.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(entry -> matched_concepts_desc.put(entry.getKey(), entry.getValue()));
		return matched_concepts_desc;
	}
	
	private OntModel generateFinalExport(int from_flag, boolean include_factory_file, String inf_complexity, String inf_variety, String inf_range,
			String inf_min_tolerance, String inf_max_tolerance, String inf_min_length, String inf_max_length,
			String inf_min_diameter, String inf_max_diameter, String inf_min_roughness, String inf_max_roughness,
			String inf_min_thickness, String inf_max_thickness, String inf_max_weight, ArrayList<String> final_concepts) {
		
		// ---------- ID ORDER GUIDELINES ----------
		// 1. COMPANY
		// 2. FACTORY or WORK ORDER
		
		OntModel exp = ModelFactory.createOntologyModel(modelSpec);
		exp.setStrictMode(false);
		
		Individual company_indiv;
		String company_comment = "\n----- " + company.getName().trim() + " company information -----";
		
		boolean other = false;
		if(company.getBusinessType().equals("Small business manufacturing company"))
			company_indiv = exp.createIndividual(generateID(exp), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000873"));
		else if(company.getBusinessType().equals("Veteran-owned manufacturing company"))
			company_indiv = exp.createIndividual(generateID(exp), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000872"));
		else if(company.getBusinessType().equals("Woman-owned manufacturing company"))
			company_indiv = exp.createIndividual(generateID(exp), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000871"));
		else if(company.getBusinessType().equals("Minority-owned manufacturing company"))
			company_indiv = exp.createIndividual(generateID(exp), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000870"));
		else {
			company_indiv = exp.createIndividual(generateID(exp), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000017"));
			company_comment += "\nBusiness type: Manufacturing company";
			other = true;
		}
		if(!other)
			company_comment += "\nBusiness type: " + company.getBusinessType().trim();
		
		if(company.getType().equals("Original design manufacturer")) {
			company_indiv.addProperty(prop_hasCompanyType, ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000868"));
			company_comment += "\nCompany type: Original design manufacturer";
		}
		else if(company.getType().equals("Original equipment manufacturer")) {
			company_indiv.addProperty(prop_hasCompanyType, ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000867"));
			company_comment += "\nCompany type: Original equipment manufacturer";
		}
		else if(company.getType().equals("Contract manufacturer")) {
			company_indiv.addProperty(prop_hasCompanyType, ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000866"));
			company_comment += "\nCompany type: Contract manufacturer";
		}
		else {
			company_indiv.addProperty(prop_hasCompanyType, ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000865"));
			company_comment += "\nCompany type: Other";
		}
		
		Individual company_name = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000878"));
		company_name.setLabel(company.getName(), "en");
		company_indiv.addProperty(prop_hasCompanyName, company_name);
		company_comment += "\nName: " + company.getName().trim();

		if(!(company.getEmployees().equals(""))) {
			Individual employees_cmd = null;
			Individual employees_count = null;
			try {
				employees_cmd = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000150"));
				employees_cmd.addProperty(prop_hasMeasVal, exp.createTypedLiteral(company.getEmployees().replaceAll(",", "").trim()));
				employees_count = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000194"));
				employees_count.addProperty(prop_isQualMeasAs, employees_cmd);
				company_indiv.addProperty(prop_hasNumEmployees, employees_count);
				company_comment += "\nEmployee count: " + company.getEmployees().replaceAll(",", "").trim();
			} catch(Exception e) {
				if(employees_cmd != null)
					employees_cmd.remove();
				if(employees_count != null)
					employees_count.remove();
			}
		}
		
		if(!(company.getYearFounded().equals(""))) {
			Individual year_founded = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0001082"));
			year_founded.setLabel(company.getYearFounded().trim(), "en");
			company_indiv.addProperty(prop_hasYearFounded, year_founded);
			company_comment += "\nYear founded: " + company.getYearFounded().trim();
		}
		
		if(!(company.getURL().equals(""))) {
			Individual web_address = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000864"));
			web_address.setLabel(company.getURL().trim(), "en");
			company_indiv.addProperty(prop_hasWebAddress, web_address);
			company_comment += "\nWeb address: " + company.getURL().trim();
		}
		
		if(!(company.getAddress().equals(""))) {
			Individual street_address = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000840"));
			street_address.setLabel(company.getAddress().trim(), "en");
			company_indiv.addProperty(prop_hasPhysicalAddress, street_address);
			company_comment += "\nStreet address: " + company.getAddress().trim();
		}
		if(!(company.getCity().equals(""))) {
			Individual city = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000838"));
			city.setLabel(company.getCity().trim(), "en");
			company_indiv.addProperty(prop_hasPhysicalAddress, city);
			company_comment += "\nCity address: " + company.getCity().trim();
		}
		if(!(company.getState().equals(""))) {
			Individual state = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000841"));
			state.setLabel(company.getState().trim(), "en");
			company_indiv.addProperty(prop_hasPhysicalAddress, state);
			company_comment += "\nState address: " + company.getState().trim();
		}
		if(!(company.getZip().equals(""))) {
			Individual zip = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000839"));
			zip.setLabel(company.getZip().trim(), "en");
			company_indiv.addProperty(prop_hasPhysicalAddress, zip);
			company_comment += "\nZip address: " + company.getZip().trim();
		}
		
		if(from_flag == 2) {
			Individual work_order_indiv = exp.createIndividual(generateID(exp), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0001012"));
			String work_order_comment = "\n----- " + work_order.getPartName().trim() + " work order information -----";
			Individual component_indiv = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0001014"));
			String component_comment = "\n----- " + work_order.getPartName().trim() + " work order component information -----";
			work_order_indiv.addProperty(prop_isAbout, component_indiv);
			Individual part_indiv = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000027"));
			part_indiv.setLabel(work_order.getPartName().trim(), "en");
			component_indiv.addProperty(prop_hasSpecifiedOutput, part_indiv);
			component_comment += "\nSpecified output (part): " + work_order.getPartName().trim();
			component_indiv.setLabel(work_order.getPartName().trim(), "en");
			
			if(!(work_order.getProductionVolume().equals(""))) {
				Individual production_volume = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000925"));
				production_volume.setLabel(work_order.getProductionVolume().trim(), "en");
				component_indiv.addProperty(prop_requiresCapability, production_volume);
				component_comment += "\nRequires capability (production volume): " + work_order.getProductionVolume().trim();
			}
			
			if(!(work_order.getLowerTolerance().equals(""))) {
				Individual lower_tolerance = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000675"));
				lower_tolerance.setLabel(work_order.getLowerTolerance().trim(), "en");
				component_indiv.addProperty(prop_requiresLowerTolerance, lower_tolerance);
				component_comment += "\nRequires capability (lower tolerance): " + work_order.getLowerTolerance().trim();
			}
			
			if(!(work_order.getUpperTolerance().equals(""))) {
				Individual upper_tolerance = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000675"));
				upper_tolerance.setLabel(work_order.getUpperTolerance().trim(), "en");
				component_indiv.addProperty(prop_requiresUpperTolerance, upper_tolerance);
				component_comment += "\nRequires capability (upper tolerance): " + work_order.getUpperTolerance().trim();
			}
			
			if(!(work_order.getMaxDiameter().equals(""))) {
				Individual max_diameter = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000919"));
				max_diameter.setLabel(work_order.getMaxDiameter().trim(), "en");
				component_indiv.addProperty(prop_requiresCapability, max_diameter);
				component_comment += "\nRequires capability (max diameter): " + work_order.getMaxDiameter().trim();
			}
			
			if(!(work_order.getMaxLength().equals(""))) {
				Individual max_length = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000674"));
				max_length.setLabel(work_order.getMaxLength().trim(), "en");
				component_indiv.addProperty(prop_requiresCapability, max_length);
				component_comment += "\nRequires capability (max length): " + work_order.getMaxLength().trim();
			}
			
			if(!(work_order.getSurfaceRoughness().equals(""))) {
				Individual surface_roughness = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000920"));
				surface_roughness.setLabel(work_order.getSurfaceRoughness().trim(), "en");
				component_indiv.addProperty(prop_requiresCapability, surface_roughness);
				component_comment += "\nRequires capability (surface roughness): " + work_order.getSurfaceRoughness().trim();
			}
			
			if(!(work_order.getMinWallThickness().equals(""))) {
				Individual wall_thickness = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000921"));
				wall_thickness.setLabel(work_order.getMinWallThickness().trim(), "en");
				component_indiv.addProperty(prop_requiresCapability, wall_thickness);
				component_comment += "\nRequires capability (min wall thickness): " + work_order.getMinWallThickness().trim();
			}
			
			if(!(work_order.getPartWeight().equals(""))) {
				Individual part_weight = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000955"));
				part_weight.setLabel(work_order.getPartWeight().trim(), "en");
				component_indiv.addProperty(prop_requiresCapability, part_weight);
				component_comment += "\nRequires capability (part weight): " + work_order.getPartWeight().trim();
			}
			
			if(work_order.getMaterialCapability().getIndividual() != null) {
				component_indiv.addProperty(prop_requiresCapability, work_order.getMaterialCapability().getIndividual());
				component_comment += "\nRequires capability (material capability): " + work_order.getMaterialCapability().toString().trim();
			}
			
			if(work_order.getProcessCapabilities().size() != 0) {
				ArrayList<IndividualWrapper> temp = work_order.getProcessCapabilities();
				for(int x = 0; x < temp.size(); ++x) {
					component_indiv.addProperty(prop_requiresCapability, temp.get(x).getIndividual());
					component_comment += "\nRequires capability (process capability): " + temp.get(x).toString().trim();
				}
			}
			
			if(final_concepts != null) {
				for(int x = 0; x < final_concepts.size(); ++x) {
					Individual concept = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000010"));
					concept.setLabel(final_concepts.get(x), "en");
					component_indiv.addProperty(prop_requiresCapability, concept);
					component_comment += "\nRequires capability (manufacturing capability concept): " + final_concepts.get(x);
				}
			}
			
			work_order_indiv.addProperty(prop_issuedBy, company_indiv);
			work_order_comment += "\nIssued by: " + company.getName().trim();
			if(!work_order_comment.equals(""))
				work_order_indiv.addComment(work_order_comment + "\n", "en");
			if(!component_comment.equals(""))
				component_indiv.addComment(component_comment + "\n", "en");
		}
		
		if(from_flag == 0 || from_flag == 1) {
			Individual factory_indiv = exp.createIndividual(generateID(exp), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000090"));
			factory_indiv.setLabel(company.getName().trim() + " factory", "en");
			String factory_comment = "\n----- " + company.getName().trim() + " factory information -----";
			
			if(from_flag == 0 || (from_flag == 1 && include_factory_file)) {
				for(int x = 0; x < equipment_individuals.size(); x++) {
					ListNode l = equipment_individuals.get(x);
					Individual i = l.getIndividual();
					OntClass c = l.getCategoryClass();
					String s = c.getURI();
					if(s.equals(uri_3DPrinter)) {
						factory_indiv.addProperty(prop_hasFactoryEquipment, i);
						factory_comment += "\nEquipment: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
					}
					else if(s.equals(uri_MachineTool)) {
						factory_indiv.addProperty(prop_hasFactoryEquipment, i);
						factory_comment += "\nEquipment: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
					}
				}
				
				for(int x = 0; x < capability_individuals.size(); x++) {
					ListNode l = capability_individuals.get(x);
					Individual i = l.getIndividual();
					OntClass c = l.getCategoryClass();
					String s = c.getURI();
					if(s.equals(uri_Material)) {
						factory_indiv.addProperty(prop_hasMaterialCapability, i);
						factory_comment += "\nMaterial: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
					}
					else if(s.equals(uri_Industry)) {
						factory_indiv.addProperty(prop_hasIndustryCapability, i);
						factory_comment += "\nIndustry: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
					}
					else if(s.equals(uri_Software)) {
						factory_indiv.addProperty(prop_hasSoftwareCapability, i);
						factory_comment += "\nSoftware: " + i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
					}
					else if(s.equals(uri_Skill)) {
						String skill_name = i.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
						Individual skill = exp.createIndividual(getOntClassOf(i));
						skill.setLabel(skill_name, "en");
						Individual worker_indiv = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0001062"));
						Individual measurement_indiv = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000926"));
						measurement_indiv.addProperty(prop_hasMeasurementValue, l.getSkillLevel());
						skill.addProperty(prop_hasMeasurement, measurement_indiv);
						worker_indiv.addProperty(prop_hasSkillCapability, skill);
						factory_indiv.addProperty(prop_hasPart, worker_indiv);
						factory_comment += "\nSkill (" + l.getSkillLevel().toLowerCase() + ")" + ": " + skill_name;
					}
				}
			}
			
			if(from_flag == 1) {
				// part quality capability
				if(!inf_min_tolerance.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000675"));
					i.setLabel(inf_min_tolerance, "en");
					factory_indiv.addProperty(prop_hasMinTolerance, i);
					factory_comment += "\nPart lower tolerance capability (inch): " + inf_min_tolerance;
				}
				if(!inf_max_tolerance.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000675"));
					i.setLabel(inf_max_tolerance, "en");
					factory_indiv.addProperty(prop_hasMaxTolerance, i);
					factory_comment += "\nPart upper tolerance capability (inch): " + inf_max_tolerance;
				}
				if(!inf_min_length.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000674"));
					i.setLabel(inf_min_length, "en");
					factory_indiv.addProperty(prop_hasMinLength, i);
					factory_comment += "\nPart minimum length capability (inch): " + inf_min_length;
				}
				if(!inf_max_length.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000674"));
					i.setLabel(inf_max_length, "en");
					factory_indiv.addProperty(prop_hasMaxLength, i);
					factory_comment += "\nPart maximum length capability (inch): " + inf_max_length;
				}
				if(!inf_min_diameter.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000919"));
					i.setLabel(inf_min_diameter, "en");
					factory_indiv.addProperty(prop_hasMinDiameter, i);
					factory_comment += "\nPart minimum diameter capability (inch): " + inf_min_diameter;
				}
				if(!inf_max_diameter.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000919"));
					i.setLabel(inf_max_diameter, "en");
					factory_indiv.addProperty(prop_hasMaxDiameter, i);
					factory_comment += "\nPart maximum diameter capability (inch): " + inf_max_diameter;
				}
				if(!inf_min_roughness.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000920"));
					i.setLabel(inf_min_roughness, "en");
					factory_indiv.addProperty(prop_hasMinRoughness, i);
					factory_comment += "\nPart surface finish lower capability (microinch): " + inf_min_roughness;
				}
				if(!inf_max_roughness.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000920"));
					i.setLabel(inf_max_roughness, "en");
					factory_indiv.addProperty(prop_hasMaxRoughness, i);
					factory_comment += "\nPart surface finish upper capability (microinch): " + inf_max_roughness;
				}
				if(!inf_min_thickness.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000921"));
					i.setLabel(inf_min_thickness, "en");
					factory_indiv.addProperty(prop_hasMinThickness, i);
					factory_comment += "\nMinimum wall thickness lower capability (inch): " + inf_min_thickness;
				}
				if(!inf_max_thickness.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000921"));
					i.setLabel(inf_max_thickness, "en");
					factory_indiv.addProperty(prop_hasMaxThickness, i);
					factory_comment += "\nMinimum wall thickness upper capability (inch): " + inf_max_thickness;
				}
				if(!inf_max_weight.equals("") && !inf_max_weight.equals(" - ")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000955"));
					i.setLabel(inf_max_weight, "en");
					factory_indiv.addProperty(prop_hasMaxWeight, i);
					factory_comment += "\nPart max weight capability (lb): " + inf_max_weight;
				}
				
				// process capability
				for(int x = 0; x < exp_functions.size(); x++) {
					TableNode tn = exp_functions.get(x);
					factory_indiv.addProperty(prop_hasProcessCapability, tn.getIndividual());
					factory_comment += "\nProcess capability: " + tn.toString();
				}
				for(int x = 0; x < inf_functions.size(); x++) {
					TableNode tn = inf_functions.get(x);
					factory_indiv.addProperty(prop_hasProcessCapability, tn.getIndividual());
					factory_comment += "\nProcess capability: " + tn.toString();
				}
				
				// material capability
				for(int x = 0; x < exp_materials.size(); x++) {
					TableNode tn = exp_materials.get(x);
					factory_indiv.addProperty(prop_hasMaterialCapability, tn.getIndividual());
					factory_comment += "\nMaterial capability: " + tn.toString();
				}
				for(int x = 0; x < inf_materials.size(); x++) {
					TableNode tn = inf_materials.get(x);
					factory_indiv.addProperty(prop_hasMaterialCapability, tn.getIndividual());
					factory_comment += "\nMaterial capability: " + tn.toString();
				}
				
				// production range
				if(!inf_range.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000925"));
					i.setLabel(inf_range, "en");
					factory_indiv.addProperty(prop_hasCapacityCapability, i);
					factory_comment += "\nProduction capacity capability: " + inf_range;
				}
				
				// production complexity
				if(!inf_complexity.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000672"));
					i.setLabel(inf_complexity, "en");
					factory_indiv.addProperty(prop_hasComplexityCapability, i);
					factory_comment += "\nProduction complexity capability: " + inf_complexity;
				}
				
				// production variety
				if(!inf_variety.equals("")) {
					Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000956"));
					i.setLabel(inf_variety, "en");
					factory_indiv.addProperty(prop_hasVarietyCapability, i);
					factory_comment += "\nProduction variety capability: " + inf_variety;
				}
				
				// extracted capability
				if(final_concepts != null) {
					for(int x = 0; x < final_concepts.size(); ++x) {
						Individual i = exp.createIndividual(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000010"));
						i.setLabel(final_concepts.get(x), "en");
						factory_indiv.addProperty(prop_hasManufacturingCapability, i);
						factory_comment += "\nManufacturing capability concept: " + final_concepts.get(x);
					}
				}
			}
			
			if(!factory_comment.equals(""))
				factory_indiv.addComment(factory_comment + "\n", "en");
			company_indiv.addProperty(prop_operates, factory_indiv);
			company_comment += "\nOperates: " + company.getName().trim() + " factory";
		}
		
		company_indiv.setLabel(company.getName().trim(), "en");
		if(!company_comment.equals(""))
			company_indiv.addComment(company_comment + "\n", "en");
		
		return exp;
	}
	
	private void menuPage() {
		getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnBuild = new JButton("Build");
		btnBuild.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBuild = new GridBagConstraints();
		gbc_btnBuild.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuild.weightx = 1.0;
		gbc_btnBuild.insets = new Insets(105, 225, 10, 225);
		gbc_btnBuild.gridx = 0;
		gbc_btnBuild.gridy = 0;
		panel.add(btnBuild, gbc_btnBuild);
		btnBuild.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buildPage1();
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
                analyzePage1();
                return;
            }
        });
		
		JButton btnMatch = new JButton("Match");
		btnMatch.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnMatch = new GridBagConstraints();
		gbc_btnMatch.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMatch.insets = new Insets(0, 225, 10, 225);
		gbc_btnMatch.gridx = 0;
		gbc_btnMatch.gridy = 2;
		panel.add(btnMatch, gbc_btnMatch);
		btnMatch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matchPage1();
                return;
            }
        });
		
		JButton btnList = new JButton("Models");
		btnList.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnList = new GridBagConstraints();
		gbc_btnList.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnList.weightx = 1.0;
		gbc_btnList.insets = new Insets(15, 225, 5, 225);
		gbc_btnList.gridx = 0;
		gbc_btnList.gridy = 3;
		panel.add(btnList, gbc_btnList);
		btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listPage();
                return;
            }
        });
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.insets = new Insets(40, 290, 10, 290);
		gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExit.gridx = 0;
		gbc_btnExit.gridy = 4;
		panel.add(btnExit, gbc_btnExit);
		btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
		
		JButton btnAbout = new JButton("About");
		btnAbout.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnAbout = new GridBagConstraints();
		gbc_btnAbout.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAbout.insets = new Insets(0, 290, 0, 290);
		gbc_btnAbout.gridx = 0;
		gbc_btnAbout.gridy = 5;
		panel.add(btnAbout, gbc_btnAbout);
		btnAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String about_info = "<html>CaMDiF<br>Version " + version + "<br><br>About - CaMDiF is developed by the Engineering Informatics Research group (Infoneer) at<br>Texas State University."
            			+ " Funding for development of CaMDiF is provided by the Digital Design<br>and Manufacturing Innovation Institute (DMDII) under contract #0220160024."
            			+ "<br><br>Copyright - This software is licensed under a Creative Commons Attribution 4.0 International<br>License CC BY-NC-Nd-4.0 (https://creativecommons.org/licenses/by-nc-nd/4.0/), with the<br>exception of DMDII members.<br><br></html>";
            	JOptionPane.showMessageDialog(frame, new JLabel(about_info, SwingConstants.CENTER), "About", JOptionPane.PLAIN_MESSAGE, null);
            }
        });
		
		JLabel camdif_pic = new JLabel(new ImageIcon(getClass().getResource("/images/camdif.png")));
		GridBagConstraints gbc_camdifPic = new GridBagConstraints();
		gbc_camdifPic.fill = GridBagConstraints.HORIZONTAL;
		gbc_camdifPic.insets = new Insets(-123, 18, 0, 0);
		gbc_camdifPic.gridx = 0;
		gbc_camdifPic.gridy = 6;
		panel.add(camdif_pic, gbc_camdifPic);
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	private void buildPage1() {
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
		gbc_btnBuildNewFactory.insets = new Insets(105, 225, 10, 225);
		gbc_btnBuildNewFactory.gridx = 0;
		gbc_btnBuildNewFactory.gridy = 0;
		panel.add(btnBuildNewFactory, gbc_btnBuildNewFactory);
		btnBuildNewFactory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                companyPage(true);
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
						if(import_path.equals("\\"))
							import_path = export_path;
						fc.setCurrentDirectory(new File(import_path));
						JComboBox open_combo = (JComboBox)(fc.getComponent(0).getAccessibleContext().getAccessibleChild(2));
						open_combo.setFont(new Font("Arial", Font.PLAIN, 12));
						open_combo.setUI(new ComboUI(open_combo, true, tab_color1));
						open_combo.setBorder(new LineBorder(Color.GRAY));
						open_combo.setBackground(Color.WHITE);
						configureFileChooserUI(fc.getComponents(), false, 0);
						
						result = fc.showOpenDialog(frame);
						if(result == 0)
						{
							File selected_file = fc.getSelectedFile();
							if(selected_file.exists())
							{
								int f = 0;
								try {
									import_path = selected_file.getCanonicalPath();
									InputStream in = FileManager.get().open("file:///" + import_path.replace("\\", "/"));
									if(in == null)
							            throw new IllegalArgumentException();
									OntModel model = ModelFactory.createOntologyModel(modelSpec);
									OntDocumentManager model_dm = model.getDocumentManager();
									model_dm.addAltEntry("http://infoneer.txstate.edu/ontology/MSDL.owl", "file:information/MSDL.owl");
									model.read(in, "RDF/XML");
									setImportedInfo(model, 0);
									String name_save = company.getName() + " Factory";
									OntModel exp = generateFinalExport(0, true, "", "", "", "", "", "", "", "", "", "", "", "", "", "", null);
									for(int x = 0; x < saved_factories.size(); x++) {
										if(saved_factories.get(x).toString().equals(name_save)) {
											saved_factories.remove(x);
											break;
										}
									}
				                	saved_factories.add(new OntModelWrapper(exp, name_save));
				                	in.close();
								} catch(Exception e1) {
									f = 1;
									System.out.println(e1);
									JOptionPane.showMessageDialog(frame, new JLabel("Unable to import.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
								}
								if(f == 0)
									buildPage2(true);
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

						DefaultListModel<OntModelWrapper> list_model_save = new DefaultListModel<>();
						for(OntModelWrapper omw : saved_factories) {
							list_model_save.addElement(omw);
						}
						
						JList<OntModelWrapper> list_save = new JList<>(list_model_save);
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
			                		OntModel model = list_save.getSelectedValue().getModel();
			                		setImportedInfo(model, 0);
			                		buildPage2(true);
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
		
		JLabel build_pic = new JLabel(new ImageIcon(getClass().getResource("/images/build.png")));
		GridBagConstraints gbc_buildPic = new GridBagConstraints();
		gbc_buildPic.fill = GridBagConstraints.HORIZONTAL;
		gbc_buildPic.insets = new Insets(-60, 0, 0, 0);
		gbc_buildPic.gridx = 0;
		gbc_buildPic.gridy = 4;
		panel.add(build_pic, gbc_buildPic);
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	private void companyPage(boolean from_build) {
		getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblCompanyName = new JLabel("* Company name:");
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
		name.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	company.setName(name.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
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
		employees.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	company.setEmployees(employees.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblYearFounded = new JLabel("Year founded:");
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
		year_founded.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	company.setYearFounded(year_founded.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblUrl = new JLabel("* URL:");
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
		URL.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	company.setURL(URL.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
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
		address.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	company.setAddress(address.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
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
		city.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	company.setCity(city.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
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
		state.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	company.setState(state.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblZipCode = new JLabel("ZIP code:");
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
		zip.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	company.setZip(zip.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblCompanyType = new JLabel("* Company type:");
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
		type.setUI(new ComboUI(type, true, Color.WHITE));
		type.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		type.setFocusable(false);
		type.setRenderer(new PromptComboBoxRenderer("Select company type"));
		type.insertItemAt("Original design manufacturer", 0);
		type.insertItemAt("Original equipment manufacturer", 1);
		type.insertItemAt("Contract manufacturer", 2);
		type.insertItemAt("Other", 3);
		type.setSelectedIndex(-1);
		type.setSelectedItem(company.getType());
		GridBagConstraints gbc_type = new GridBagConstraints();
		gbc_type.insets = new Insets(5, 0, 5, 80);
		gbc_type.fill = GridBagConstraints.BOTH;
		gbc_type.gridx = 1;
		gbc_type.gridy = 8;
		panel_2.add(type, gbc_type);
		type.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	company.setType((String)type.getSelectedItem());
            }
        });
		
		JLabel lblBusinessType = new JLabel("* Business type:");
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
		business_type.setUI(new ComboUI(business_type, true, Color.WHITE));
		business_type.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		business_type.setFocusable(false);
		business_type.setRenderer(new PromptComboBoxRenderer("Select business type"));
		business_type.insertItemAt("Small business manufacturing company", 0);
		business_type.insertItemAt("Veteran-owned manufacturing company", 1);
		business_type.insertItemAt("Woman-owned manufacturing company", 2);
		business_type.insertItemAt("Minority-owned manufacturing company", 3);
		business_type.insertItemAt("Other", 4);
		business_type.setSelectedIndex(-1);
		business_type.setSelectedItem(company.getBusinessType());
		GridBagConstraints gbc_business_type = new GridBagConstraints();
		gbc_business_type.insets = new Insets(5, 0, 5, 80);
		gbc_business_type.fill = GridBagConstraints.BOTH;
		gbc_business_type.gridx = 1;
		gbc_business_type.gridy = 9;
		panel_2.add(business_type, gbc_business_type);
		business_type.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	company.setBusinessType((String)business_type.getSelectedItem());
            }
        });
		
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
		gbc_panel_3.insets = new Insets(15, 0, 0, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 29, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnSave = new JButton("Save Company");
		btnSave.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridwidth = 2;
		gbc_btnSave.fill = GridBagConstraints.BOTH;
		gbc_btnSave.weightx = 0.5;
		gbc_btnSave.insets = new Insets(0, 250, 5, 250);
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 0;
		panel_3.add(btnSave, gbc_btnSave);
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
						JLabel message_save = new JLabel("<html>Saved companies are remembered until the program is closed.<br><br>Currently saved companies:</html>", SwingConstants.LEFT);
						message_save.setFont(new Font("Arial", Font.PLAIN, 12));
						message_panel.add(message_save);
						save_panel.add(message_panel, gbc_message_save);
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<CompanyWrapper> list_model_save = new DefaultListModel<>();
						for(CompanyWrapper cw : saved_companies) {
							list_model_save.addElement(cw);
						}
						
						JList<CompanyWrapper> list_save = new JList<>(list_model_save);
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
						JLabel enter_save = new JLabel("Enter save name (if same name exists, it will be overwritten):", SwingConstants.LEFT);
						enter_save.setFont(new Font("Arial", Font.PLAIN, 12));
						GridBagConstraints gbc_enter_save = new GridBagConstraints();
						gbc_enter_save.insets = new Insets(0, 0, 5, 0);
						gbc_enter_save.fill = GridBagConstraints.BOTH;
						gbc_enter_save.gridx = 0;
						gbc_enter_save.gridy = 2;
						enter_panel.add(enter_save);
						save_panel.add(enter_panel, gbc_enter_save);
						
						JTextField name_save = new JTextField();
						name_save.setText(company.getName());
						GridBagConstraints gbc_name_save = new GridBagConstraints();
						gbc_name_save.insets = new Insets(0, 0, 10, 0);
						gbc_name_save.fill = GridBagConstraints.BOTH;
						gbc_name_save.gridx = 0;
						gbc_name_save.gridy = 3;
						save_panel.add(name_save, gbc_name_save);
				    	
				    	result = JOptionPane.showOptionDialog(frame, save_panel, "Save Company", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Save", "Cancel"}, null);
			            switch(result) {
			                case JOptionPane.OK_OPTION:
			                	for(int x = 0; x < saved_companies.size(); x++) {
									if(saved_companies.get(x).toString().equals(name_save.getText())) {
										saved_companies.remove(x);
										break;
									}
								}
			                	saved_companies.add(new CompanyWrapper(company, name_save.getText()));
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
		
		JButton btnOpen = new JButton("Open Company");
		btnOpen.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnOpen = new GridBagConstraints();
		gbc_btnOpen.gridwidth = 2;
		gbc_btnOpen.fill = GridBagConstraints.BOTH;
		gbc_btnOpen.weightx = 0.5;
		gbc_btnOpen.insets = new Insets(5, 250, 10, 250);
		gbc_btnOpen.gridx = 0;
		gbc_btnOpen.gridy = 1;
		panel_3.add(btnOpen, gbc_btnOpen);
		btnOpen.addActionListener(new ActionListener() {
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
						JLabel message_save = new JLabel("Select a company to open:", SwingConstants.LEFT);
						message_save.setFont(new Font("Arial", Font.PLAIN, 12));
						message_panel.add(message_save);
						save_panel.add(message_panel, gbc_message_save);
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<CompanyWrapper> list_model_save = new DefaultListModel<>();
						for(CompanyWrapper cw : saved_companies) {
							list_model_save.addElement(cw);
						}
						
						JList<CompanyWrapper> list_save = new JList<>(list_model_save);
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
			                		company = new Company(list_save.getSelectedValue().getCompany());
			                		companyPage(from_build);
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
		
		JSeparator separator = new JSeparator();
		separator.setForeground(tab_color2);
		separator.setBackground(background_color);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(10, 215, 10, 215);
		gbc_separator.gridwidth = 2;
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		panel_3.add(separator, gbc_separator);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.weightx = 0.5;
		gbc_btnBack.insets = new Insets(10, 220, 0, 10);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 3;
		panel_3.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(from_build)
            		buildPage1();
            	else
            		matchPage1();
                return;
            }
        });
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(10, 10, 0, 220);
		gbc_btnNext.fill = GridBagConstraints.BOTH;
		gbc_btnNext.weightx = 0.5;
		gbc_btnNext.gridx = 1;
		gbc_btnNext.gridy = 3;
		panel_3.add(btnNext, gbc_btnNext);
		btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String ct = "";
        		String bt = "";
        		try { ct = type.getSelectedItem().toString(); } catch(Exception e1) {}
        		try { bt = business_type.getSelectedItem().toString(); } catch(Exception e1) {}
            	
        		if(name.getText().equals("") || ct.equals("") || bt.equals("") || URL.getText().equals(""))
        			JOptionPane.showMessageDialog(frame, new JLabel("Please enter all required fields before continuing.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
            	else {
            		company = new Company(name.getText(), ct, bt, employees.getText(), year_founded.getText(), URL.getText(), address.getText(), city.getText(), state.getText(), zip.getText());
            		if(from_build)
            			buildPage2(true);
            		else
            			matchPage2();
                    return;
            	}
            }
        });
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	private void buildPage2(boolean first_page) {
		getContentPane().removeAll();
		
		DefaultListModel<ListNode> list_model_1 = new DefaultListModel<ListNode>();
		JList<ListNode> list_1 = new JList<ListNode>(list_model_1);
		
		list_model = new DefaultListModel<ListNode>();
		list = new JList<ListNode>(list_model);
		list.setFont(new Font("Arial", Font.PLAIN, 12));
		list.setFocusable(false);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent ev) {
				ListNode selection = list.getSelectedValue();
				int selection_index = list.getSelectedIndex();
				if(selection == null)
					return;
				String s = selection.toString();
				if(s.equals("\n") || s.equals(s_3d) || s.equals(s_machine) || s.equals(s_material) || s.equals(s_skill) || s.equals(s_industry) || s.equals(s_software))
					list.clearSelection();
				else {
			    	list_1.clearSelection();
			    	list.setSelectedIndex(selection_index);
				}
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
		comboBox.setUI(new ComboUI(comboBox, true, tab_color1));
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
			comboBox.insertItemAt(" Skill", 3);
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
				    			c = class_Skill;
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
		
		list_1.setFont(new Font("Arial", Font.PLAIN, 12));
		list_1.setFocusable(false);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_23.add(list_1, BorderLayout.CENTER);
		panel_21.setLayout(gl_panel_21);
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent ev) {
				list.clearSelection();
			}
		});
		
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
					try {
						Individual indiv = i.next().asIndividual();
						indiv.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
						list_model_1.addElement(new ListNode(indiv, combo_class, ""));
					} catch(Exception aaa) {
						System.out.println("Error: No rdfs:label for an individual");
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
								break;
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
							break;
						}
					}
					if(!exists) {
						if(combo_class.getURI().equals(uri_Skill)) {
							
							EventQueue.invokeLater(new Runnable() {
							    @Override
							    public void run() {
							    	JPanel save_panel = new JPanel();
									GridBagLayout gbl_save_panel = new GridBagLayout();
									gbl_save_panel.columnWidths = new int[]{300, 0};
									gbl_save_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
									gbl_save_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
									save_panel.setLayout(gbl_save_panel); 
									
									JPanel message_panel = new JPanel(new FlowLayout(FlowLayout.LEADING,0, 0));
									GridBagConstraints gbc_message_save = new GridBagConstraints();
									gbc_message_save.insets = new Insets(1, 0, 5, 0);
									gbc_message_save.fill = GridBagConstraints.BOTH;
									gbc_message_save.gridx = 0;
									gbc_message_save.gridy = 0;
									JLabel message_save = new JLabel("<html>Set skill level for '" + selected_node.toString() + "':</html>", SwingConstants.LEFT);
									message_save.setFont(new Font("Arial", Font.PLAIN, 12));
									message_panel.add(message_save);
									save_panel.add(message_panel, gbc_message_save);
							    	
							    	JPanel list_panel = new JPanel();
									list_panel.setLayout(new BorderLayout(0, 0));
									list_panel.setBackground(Color.WHITE);
									
									JComboBox<String> skill = new JComboBox<>();
									skill.setFont(new Font("Arial", Font.PLAIN, 12));
									skill.setForeground(Color.DARK_GRAY);
									skill.setBackground(Color.WHITE);
									skill.setUI(new ComboUI(skill, true, Color.WHITE));
									skill.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
									skill.setFocusable(false);
									skill.insertItemAt("Very low", 0);
									skill.insertItemAt("Low", 1);
									skill.insertItemAt("Medium", 2);
									skill.insertItemAt("High", 3);
									skill.insertItemAt("Very high", 4);
									skill.setSelectedIndex(0);
									list_panel.add(skill);
									
									GridBagConstraints gbc_list_panel = new GridBagConstraints();
									gbc_list_panel.insets = new Insets(0, 0, 10, 0);
									gbc_list_panel.fill = GridBagConstraints.BOTH;
									gbc_list_panel.gridx = 0;
									gbc_list_panel.gridy = 1;
									save_panel.add(list_panel, gbc_list_panel);
							    	
							    	result = JOptionPane.showOptionDialog(frame, save_panel, "Skill Level", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"OK", "Cancel"}, null);
						            switch(result) {
						                case JOptionPane.OK_OPTION:
						                	String current_skill = skill.getSelectedItem().toString();
						                	ListNode ln = new ListNode(selected_individual, combo_class, "");
											ln.setSkillLevel(current_skill);
											boolean found_category = false;
											for(int x = capability_individuals.size() - 1; x >= 0; x--) {
												if(capability_individuals.get(x).getCategoryClass().equals(combo_class)) {
													capability_individuals.add(x + 1, ln);
													found_category = true;
													break;
												}
											}
											if(!found_category)
												capability_individuals.add(ln);
						                	if(refreshList(first_page, combo_class))
						    					scrollPane_1.getVerticalScrollBar().setValue(scrollPane_1.getVerticalScrollBar().getMaximum());
						                    return;
						                case JOptionPane.CANCEL_OPTION:
						                    return;
						                case JOptionPane.CLOSED_OPTION:
						                    return;
							    	}
							    }
							});
							
						}
						else {
							boolean found_category = false;
							for(int x = capability_individuals.size() - 1; x >= 0; x--) {
								if(capability_individuals.get(x).getCategoryClass().equals(combo_class)) {
									capability_individuals.add(x + 1, new ListNode(selected_individual, combo_class, ""));
									found_category = true;
									break;
								}
							}
							if(!found_category)
								capability_individuals.add(new ListNode(selected_individual, combo_class, ""));
						}
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
		
		if(first_page) {
			JButton btnInfo = new JButton("Info");
			btnInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			btnInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					EventQueue.invokeLater(new Runnable() {
					    @Override
					    public void run() {
					    	ListNode ln = list_1.getSelectedValue();
					    	if(ln == null)
					    		ln = list.getSelectedValue();
					    	if(ln != null && (ln.getCategoryClass().getURI().equals(uri_MachineTool) || ln.getCategoryClass().getURI().equals(uri_3DPrinter))) {
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
								String s = ln.getCategoryClass().getURI();
								
								// CAREFUL NOT TO REORDER ELEMENTS IN COLUMNS
								
								String val1 = "-", val2 = "-", val3 = "-", val4 = "-", val5 = "-", val6 = "-", val7 = "-",
										val8 = "-", val9 = "-", val10 = "-", val11 = "-", val12 = "-", val13 = "-", val14 = "-",
										val15 = "-", val16 = "-", val17 = "-", val18 = "-", val19 = "-", val20 = "-", val21 = "-",
										val22 = "-", val23 = "-", val24 = "-", val25 = "-", val26 = "-", val27 = "-", val28 = "-",
										val29 = "-", val30 = "-";
								
								Individual selected_indiv = ln.getIndividual();
								
								if(s.equals(uri_MachineTool)) { // Machine Tool
									try { // manufacturer
										for(StmtIterator si = selected_indiv.listProperties(prop_hasManufacturer); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											val1 = i1.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
											break;
										}
									} catch(Exception e) { val1 = "-"; }
									
									try { // table length
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000084"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000184")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val2 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val2.indexOf("^") != -1)
													val2 = val2.substring(0, val2.indexOf("^"));
												val2 += " in";
												break;
											}
										}
									} catch(Exception e) { val2 = "-"; }
										
									try { // table width
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000084"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000185")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val3 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val3.indexOf("^") != -1)
													val3 = val3.substring(0, val3.indexOf("^"));
												val3 += " in";
												break;
											}
										}
									} catch(Exception e) { val3 = "-"; }
									
									try { // max load capacity
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000084"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000186")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val4 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val4.indexOf("^") != -1)
													val4 = val4.substring(0, val4.indexOf("^"));
												val4 += " lb";
												break;
											}
										}
									} catch(Exception e) { val4 = "-"; }
									
									try { // max spindle speed
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000120"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000183")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val5 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val5.indexOf("^") != -1)
													val5 = val5.substring(0, val5.indexOf("^"));
												val5 += " rpm";
												break;
											}
										}
									} catch(Exception e) { val5 = "-"; }
									
									try { // spindle power
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000120"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000182")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val6 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val6.indexOf("^") != -1)
													val6 = val6.substring(0, val6.indexOf("^"));
												val6 += " hp";
												break;
											}
										}
									} catch(Exception e) { val6 = "-"; }
									
									try { // spindle torque
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000120"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000181")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val7 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val7.indexOf("^") != -1)
													val7 = val7.substring(0, val7.indexOf("^"));
												val7 += " ft-lb";
												break;
											}
										}
									} catch(Exception e) { val7 = "-"; }
	
									try { // rapid traverse X
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000156"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000205")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val8 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val8.indexOf("^") != -1)
													val8 = val8.substring(0, val8.indexOf("^"));
												val8 += " in/min";
												break;
											}
										}
									} catch(Exception e) { val8 = "-"; }
										
									try { // rapid traverse Y
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000157"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000205")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val9 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val9.indexOf("^") != -1)
													val9 = val9.substring(0, val9.indexOf("^"));
												val9 += " in/min";
												break;
											}
										}
									} catch(Exception e) { val9 = "-"; }
									
									try { // rapid traverse Z
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000158"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000205")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val10 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val10.indexOf("^") != -1)
													val10 = val10.substring(0, val10.indexOf("^"));
												val10 += " in/min";
												break;
											}
										}
									} catch(Exception e) { val10 = "-"; }
									
									try { // cutting feed rate X
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000156"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000200")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val11 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val11.indexOf("^") != -1)
													val11 = val11.substring(0, val11.indexOf("^"));
												val11 += " in/min";
												break;
											}
										}
									} catch(Exception e) { val11 = "-"; }
									
									try { // cutting feed rate Y
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000157"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000200")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val12 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val12.indexOf("^") != -1)
													val12 = val12.substring(0, val12.indexOf("^"));
												val12 += " in/min";
												break;
											}
										}
									} catch(Exception e) { val12 = "-"; }
									
									try { // cutting feed rate Z
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000158"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000200")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val13 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val13.indexOf("^") != -1)
													val13 = val13.substring(0, val13.indexOf("^"));
												val13 += " in/min";
												break;
											}
										}
									} catch(Exception e) { val13 = "-"; }
									
									try { // travel X
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000156"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000199")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val14 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val14.indexOf("^") != -1)
													val14 = val14.substring(0, val14.indexOf("^"));
												val14 += " in";
												break;
											}
										}
									} catch(Exception e) { val14 = "-"; }
									
									try { // travel Y
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000157"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000199")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val15 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val15.indexOf("^") != -1)
													val15 = val15.substring(0, val15.indexOf("^"));
												val15 += " in";
												break;
											}
										}
									} catch(Exception e) { val15 = "-"; }
									
									try { // travel Z
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000158"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000199")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val16 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val16.indexOf("^") != -1)
													val16 = val16.substring(0, val16.indexOf("^"));
												val16 += " in";
												break;
											}
										}
									} catch(Exception e) { val16 = "-"; }
									
									try { // max num of tools
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000195"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000193")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val17 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val17.indexOf("^") != -1)
													val17 = val17.substring(0, val17.indexOf("^"));
												break;
											}
										}
									} catch(Exception e) { val17 = "-"; }
									
									try { // tool to tool time
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000195"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000192")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val18 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val18.indexOf("^") != -1)
													val18 = val18.substring(0, val18.indexOf("^"));
												val18 += " sec";
												break;
											}
										}
									} catch(Exception e) { val18 = "-"; }
									
									try { // chip to chip time
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000195"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000191")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val19 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val19.indexOf("^") != -1)
													val19 = val19.substring(0, val19.indexOf("^"));
												val19 += " sec";
												break;
											}
										}
									} catch(Exception e) { val19 = "-"; }
									
									try { // max tool length
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000195"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000189")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val20 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val20.indexOf("^") != -1)
													val20 = val20.substring(0, val20.indexOf("^"));
												val20 += " in";
												break;
											}
										}
									} catch(Exception e) { val20 = "-"; }
	
									try { // max tool weight
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000195"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000190")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val21 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val21.indexOf("^") != -1)
													val21 = val21.substring(0, val21.indexOf("^"));
												val21 += " lb";
												break;
											}
										}
									} catch(Exception e) { val21 = "-"; }
									
									try { // travel angle A
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000159"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001021")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val22 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val22.indexOf("^") != -1)
													val22 = val22.substring(0, val22.indexOf("^"));
												val22 += " deg";
												break;
											}
										}
									} catch(Exception e) { val22 = "-"; }
									
									try { // travel angle B
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000160"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001021")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val23 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val23.indexOf("^") != -1)
													val23 = val23.substring(0, val23.indexOf("^"));
												val23 += " deg";
												break;
											}
										}
									} catch(Exception e) { val23 = "-"; }
									
									try { // travel angle C
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0001024"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001021")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val24 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val24.indexOf("^") != -1)
													val24 = val24.substring(0, val24.indexOf("^"));
												val24 += " deg";
												break;
											}
										}
									} catch(Exception e) { val24 = "-"; }
									
									try { // cutting feed rate A
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000159"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001030")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val25 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val25.indexOf("^") != -1)
													val25 = val25.substring(0, val25.indexOf("^"));
												val25 += " deg/sec";
												break;
											}
										}
									} catch(Exception e) { val25 = "-"; }
									
									try { // cutting feed rate B
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000160"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001030")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val26 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val26.indexOf("^") != -1)
													val26 = val26.substring(0, val26.indexOf("^"));
												val26 += " deg/sec";
												break;
											}
										}
									} catch(Exception e) { val26 = "-"; }
									
									try { // cutting feed rate C
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0001024"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001030")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val27 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val27.indexOf("^") != -1)
													val27 = val27.substring(0, val27.indexOf("^"));
												val27 += " deg/sec";
												break;
											}
										}
									} catch(Exception e) { val27 = "-"; }
									
									try { // max torque A
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000159"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001029")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val28 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val28.indexOf("^") != -1)
													val28 = val28.substring(0, val28.indexOf("^"));
												val28 += " ft-lb";
												break;
											}
										}
									} catch(Exception e) { val28 = "-"; }
									
									try { // max torque B
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000160"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001029")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val29 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val29.indexOf("^") != -1)
													val29 = val29.substring(0, val29.indexOf("^"));
												val29 += " ft-lb";
												break;
											}
										}
									} catch(Exception e) { val29 = "-"; }
									
									try { // max torque C
										for(StmtIterator si = selected_indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0001024"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0001029")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val30 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val30.indexOf("^") != -1)
													val30 = val30.substring(0, val30.indexOf("^"));
												val30 += " ft-lb";
												break;
											}
										}
									} catch(Exception e) { val30 = "-"; }
									
									message_info = new JLabel("<html><body>"
											+ "<p style=\"margin-bottom:-12\"><b>Property</b></p>"
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
											+ "<br><p style=\"margin-bottom:-12\">max tool weight</p>"
											+ "<br><p style=\"margin-bottom:-12\">travel angle A</p>"
											+ "<br><p style=\"margin-bottom:-12\">travel angle B</p>"
											+ "<br><p style=\"margin-bottom:-12\">travel angle C</p>"
											+ "<br><p style=\"margin-bottom:-12\">cutting feed rate A</p>"
											+ "<br><p style=\"margin-bottom:-12\">cutting feed rate B</p>"
											+ "<br><p style=\"margin-bottom:-12\">cutting feed rate C</p>"
											+ "<br><p style=\"margin-bottom:-12\">max torque A</p>"
											+ "<br><p style=\"margin-bottom:-12\">max torque B</p>"
											+ "<br>max torque C"
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
											+ "<br><p style=\"margin-bottom:-12\">" + val21 + "</p>"
											+ "<br><p style=\"margin-bottom:-12\">" + val22 + "</p>"
											+ "<br><p style=\"margin-bottom:-12\">" + val23 + "</p>"
											+ "<br><p style=\"margin-bottom:-12\">" + val24 + "</p>"
											+ "<br><p style=\"margin-bottom:-12\">" + val25 + "</p>"
											+ "<br><p style=\"margin-bottom:-12\">" + val26 + "</p>"
											+ "<br><p style=\"margin-bottom:-12\">" + val27 + "</p>"
											+ "<br><p style=\"margin-bottom:-12\">" + val28 + "</p>"
											+ "<br><p style=\"margin-bottom:-12\">" + val29 + "</p>"
											+ "<br>" + val30
											+ "</body></html>", SwingConstants.LEFT);
								}
								else if(s.equals(uri_3DPrinter)) {
									try { // manufacturer
										for(StmtIterator si = selected_indiv.listProperties(prop_hasManufacturer); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											val1 = i1.listPropertyValues(RDFS.label).next().asLiteral().getLexicalForm();
											break;
										}
									} catch(Exception e) { val1 = "-"; }
									
									try { // build volume length
										for(StmtIterator si = selected_indiv.listProperties(prop_hasBuildVolume); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000708"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000728")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val2 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val2.indexOf("^") != -1)
													val2 = val2.substring(0, val2.indexOf("^"));
												val2 += " in";
												break;
											}
										}
									} catch(Exception e) { val2 = "-"; }
										
									try { // build volume width
										for(StmtIterator si = selected_indiv.listProperties(prop_hasBuildVolume); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000708"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000729")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val3 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val3.indexOf("^") != -1)
													val3 = val3.substring(0, val3.indexOf("^"));
												val3 += " in";
												break;
											}
										}
									} catch(Exception e) { val3 = "-"; }
									
									try { // build volume height
										for(StmtIterator si = selected_indiv.listProperties(prop_hasBuildVolume); si.hasNext(); ) {
											Individual i1 = ontology.getIndividual(si.next().getObject().asResource().getURI());
											if(getOntClassOf(i1).equals(ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000708"))) {
												Individual MD = ontology.getIndividual(ontology.getIndividual(i1.getProperty(ontology.getProperty("http://infoneer.txstate.edu/ontology/MSDL_0000730")).getObject().asResource().getURI()).getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000417")).getObject().asResource().getURI());
												val4 = MD.getProperty(ontology.getProperty("http://purl.obolibrary.org/obo/IAO_0000004")).getObject().toString();
												if(val4.indexOf("^") != -1)
													val4 = val4.substring(0, val4.indexOf("^"));
												val4 += " in";
												break;
											}
										}
									} catch(Exception e) { val4 = "-"; }
									
									message_info = new JLabel("<html><body>"
											+ "<p style=\"margin-bottom:-12\"><b>Property</b></p>"
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
								
								message_info2.setText(message_info2.getText().replaceAll(Matcher.quoteReplacement(".0 "), Matcher.quoteReplacement(" ")));
								
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
		}
		
		/*JPanel panel_pic = new JPanel();
		GridBagConstraints gbc_panel_pic = new GridBagConstraints();
		gbc_panel_pic.insets = new Insets(-190, 0, 5, 0);
		gbc_panel_pic.ipadx = -30;
		gbc_panel_pic.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_pic.gridx = 0;
		gbc_panel_pic.gridy = 4;
		panel_2.add(panel_pic, gbc_panel_pic);
		panel_pic.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnPic = new JButton("Pic");
		btnPic.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				    	ListNode ln = list_1.getSelectedValue();
				    	if(ln != null) {
							try {
								JDialog pic_dialog = new JDialog();
								ImageIcon pic = new ImageIcon(new URL("https://mazakfiles.blob.core.windows.net/web-site/image/machine/large/96c238cf-1e88-43ab-8824-dc2d1cd630ce/INTEGREX-e-420H-ST_Large.gif")); // TODO image property
								int pic_width = pic.getIconWidth(), pic_height = pic.getIconHeight();
								if(pic_width > pic_height) {
									float ratio = (float)pic_height / pic_width;
									pic_width = screenWidth - 20;
									pic_height = (int)(pic_width * ratio);
								}
								else {
									float ratio = (float)pic_width / pic_height;
									pic_height = screenHeight - 20;
									pic_width = (int)(pic_height * ratio);
								}
								pic.setImage(getScaledImage(pic.getImage(), pic_width, pic_height));
								JLabel pic_label = new JLabel();
								pic_label.setIcon(pic);
								pic_dialog.add(pic_label);
								pic_dialog.setLocationRelativeTo(null);
								pic_dialog.setBounds(frame.getX() + (frame.getWidth() / 2) - (pic_width / 2), frame.getY() + (frame.getHeight() / 2) - (pic_height / 2), pic_width, pic_height);
								//pic_dialog.setAlwaysOnTop(true);
								pic_dialog.setResizable(false);
								pic_dialog.setVisible(true);
								frame.addWindowListener(new WindowAdapter() {
					                @Override
					                public void windowActivated(WindowEvent e) {pic_dialog.setAlwaysOnTop(true);}
					                @Override
					                public void windowDeactivated(WindowEvent e) {
					                	pic_dialog.toBack();
					                    frame.toBack();
					                }
					            });
							} catch (Exception e) {
								JOptionPane.showMessageDialog(frame, new JLabel("No available picture.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
							}
				    	}
				    }
				});
				
			}
		});
		panel_pic.add(btnPic);*/
		
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
					companyPage(true);
				else
					buildPage2(true);
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
					buildPage2(false);
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
								if(export_path.equals("\\"))
									export_path = import_path;
								fc.setCurrentDirectory(new File(export_path));
								JComboBox save_combo = (JComboBox)(fc.getComponent(0).getAccessibleContext().getAccessibleChild(2));
								save_combo.setFont(new Font("Arial", Font.PLAIN, 12));
								save_combo.setUI(new ComboUI(save_combo, true, tab_color1));
								save_combo.setBorder(new LineBorder(Color.GRAY));
								save_combo.setBackground(Color.WHITE);
								configureFileChooserUI(fc.getComponents(), true, 0);
								
								result = fc.showSaveDialog(frame);	
								if(result == 0)
								{
									try {
										OntModel exp = generateFinalExport(0, true, "", "", "", "", "", "", "", "", "", "", "", "", "", "", null);
										File selected_file = fc.getSelectedFile();
										String selected_file_path = selected_file.getCanonicalPath();
										if(selected_file_path.length() < 4 || !(selected_file_path.substring(selected_file_path.length() - 4, selected_file_path.length()).equals(".owl")))
											selected_file = new File(selected_file_path + ".owl");
										selected_file.createNewFile();
										export_path = selected_file.getCanonicalPath();
										FileOutputStream fos = new FileOutputStream(selected_file, false);
										OutputStreamWriter osw = new OutputStreamWriter(fos);
										RDFWriter writer = exp.getWriter("RDF/XML-ABBREV");
										writer.setProperty("showXmlDeclaration", false);
										writer.write(exp, osw, null);
										osw.close();
										fos.close();
									} catch(Exception e1) {
										JOptionPane.showMessageDialog(frame, new JLabel("Unable to export.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
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

						DefaultListModel<OntModelWrapper> list_model_save = new DefaultListModel<>();
						for(OntModelWrapper omw : saved_factories) {
							list_model_save.addElement(omw);
						}
						
						JList<OntModelWrapper> list_save = new JList<>(list_model_save);
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
						JLabel enter_save = new JLabel("Enter save name (if same name exists, it will be overwritten):", SwingConstants.LEFT);
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
								OntModel exp = generateFinalExport(0, true, "", "", "", "", "", "", "", "", "", "", "", "", "", "", null);
								for(int x = 0; x < saved_factories.size(); x++) {
									if(saved_factories.get(x).toString().equals(name_save.getText())) {
										saved_factories.remove(x);
										break;
									}
								}
			                	saved_factories.add(new OntModelWrapper(exp, name_save.getText()));
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
	
	private void analyzePage1() {
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
		gbc_btnAnalyzeFactory.insets = new Insets(105, 225, 10, 225);
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

						DefaultListModel<OntModelWrapper> list_model_analyze = new DefaultListModel<>();
						for(OntModelWrapper omw : saved_factories) {
							list_model_analyze.addElement(omw);
						}
						
						JList<OntModelWrapper> list_analyze = new JList<>(list_model_analyze);
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
			                		OntModel model = list_analyze.getSelectedValue().getModel();
			                		setImportedInfo(model, 1);
			                		analyzePage2();
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
		btnCompareFactories.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(saved_factories.size() < 2)
            		JOptionPane.showMessageDialog(frame, new JLabel("There must be at least two factories saved.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
            	else {
            		
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
    						JLabel message_save = new JLabel("Select the 1st factory to compare:", SwingConstants.LEFT);
    						message_save.setFont(new Font("Arial", Font.PLAIN, 12));
    						message_panel.add(message_save);
    						save_panel.add(message_panel, gbc_message_save);
    				    	
    				    	JPanel list_panel = new JPanel();
    						list_panel.setLayout(new BorderLayout(0, 0));
    						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
    						list_panel.setBackground(Color.WHITE);

    						DefaultListModel<OntModelWrapper> list_model_save = new DefaultListModel<>();
    						for(OntModelWrapper omw : saved_factories) {
    							list_model_save.addElement(omw);
    						}
    						
    						JList<OntModelWrapper> list_save = new JList<>(list_model_save);
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
    				    	
    				    	result = JOptionPane.showOptionDialog(frame, save_panel, "Select 1st Factory", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"OK", "Cancel"}, null);
    			            switch(result) {
    			                case JOptionPane.OK_OPTION:
    			                	if(list_save.getSelectedIndex() >= 0) {
    			                		OntModelWrapper omw1 = list_save.getSelectedValue();
    			                		
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
    			        						JLabel message_save = new JLabel("Select the 2nd factory to compare:", SwingConstants.LEFT);
    			        						message_save.setFont(new Font("Arial", Font.PLAIN, 12));
    			        						message_panel.add(message_save);
    			        						save_panel.add(message_panel, gbc_message_save);
    			        				    	
    			        				    	JPanel list_panel = new JPanel();
    			        						list_panel.setLayout(new BorderLayout(0, 0));
    			        						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
    			        						list_panel.setBackground(Color.WHITE);

    			        						DefaultListModel<OntModelWrapper> list_model_save = new DefaultListModel<>();
    			        						for(OntModelWrapper omw : saved_factories) {
    			        							if(!omw.toString().equals(omw1.toString()))
    			        								list_model_save.addElement(omw);
    			        						}
    			        						
    			        						JList<OntModelWrapper> list_save = new JList<>(list_model_save);
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
    			        				    	
    			        				    	result = JOptionPane.showOptionDialog(frame, save_panel, "Select 2nd Factory", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"OK", "Cancel"}, null);
    			        			            switch(result) {
    			        			                case JOptionPane.OK_OPTION:
    			        			                	if(list_save.getSelectedIndex() >= 0) {
    			        			                		OntModelWrapper omw2 = list_save.getSelectedValue();
    			        			                		analyzePage3(omw1, omw2);
    			        			                		return;
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
    			                    return;
    			                case JOptionPane.CANCEL_OPTION:
    			                    return;
    			                case JOptionPane.CLOSED_OPTION:
    			                    return;
    				    	}
    				    }
    				});
            		
            	}
            }
        });
		
		JButton btnQuery = new JButton("Query Capability Models");
		btnQuery.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnQuery = new GridBagConstraints();
		gbc_btnQuery.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuery.insets = new Insets(0, 225, 10, 225);
		gbc_btnQuery.gridx = 0;
		gbc_btnQuery.gridy = 2;
		panel.add(btnQuery, gbc_btnQuery);
		btnQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(saved_match_data.size() == 0)
        			JOptionPane.showMessageDialog(frame, new JLabel("<html><center>There are no capability models saved.</html>", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
            	else {
            		analyzePage4();
                	return;
            	}
            }
        });
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBack.insets = new Insets(35, 290, 0, 290);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 3;
		panel.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuPage();
                return;
            }
        });
		
		JLabel build_pic = new JLabel(new ImageIcon(getClass().getResource("/images/analyze.png")));
		GridBagConstraints gbc_buildPic = new GridBagConstraints();
		gbc_buildPic.fill = GridBagConstraints.HORIZONTAL;
		gbc_buildPic.insets = new Insets(-55, 8, 0, 0);
		gbc_buildPic.gridx = 0;
		gbc_buildPic.gridy = 4;
		panel.add(build_pic, gbc_buildPic);
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	private void analyzePage2() {
		getContentPane().removeAll();
		
		parsing_table = new JTable();
		parsing_table.setBorder(new EmptyBorder(0, 0, 0, 0));
		parsing_table.setFillsViewportHeight(true);
		parsing_table.setRowHeight(20);
		DefaultTableModel parsing_model = new DefaultTableModel(new Object[][] {}, new String[] { "Parsing... please wait" });
		parsing_table.setModel(parsing_model);
		parsing_table.setDragEnabled(false);
		parsing_table.setEnabled(false);
		parsing_table.setOpaque(true);
		parsing_table.getTableHeader().setReorderingAllowed(false);
		parsing_table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		ArrayList<String> final_concepts = new ArrayList<>();
		
		crawl_go = true;
		SwingWorker<?,?> worker = new SwingWorker<Void,Void>() {
			@Override
			protected Void doInBackground() {
				String url = company.getURL();
				Map<JsonNodeWrapper, Integer> matched_concepts = crawl(url, 2);
				if(matched_concepts.size() == 0) {
					DefaultTableModel parsing_model = new DefaultTableModel(new Object[][] {}, new String[] { "No matched concepts!" });
					parsing_table.setModel(parsing_model);
				}
				else {
					Map<String, ArrayList<String>> unordered_columns = new LinkedHashMap<>();
					int max_rows = 1;
					for(JsonNodeWrapper concept : matched_concepts.keySet()) {
						String top_concept = getTopConceptName(rn, concept.getJsonNode());
						if(unordered_columns.get(top_concept) != null) {
							unordered_columns.get(top_concept).add(concept.toString() + " (" + matched_concepts.get(concept) + ")");
							if(unordered_columns.get(top_concept).size() > max_rows)
								max_rows = unordered_columns.get(top_concept).size();
						}
						else {
							ArrayList<String> concept_list = new ArrayList<String>();
							concept_list.add(concept.toString() + " (" + matched_concepts.get(concept) + ")");
							unordered_columns.put(top_concept, concept_list);
						}
					}
					Map<String, ArrayList<String>> columns = new LinkedHashMap<>();
					unordered_columns.entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparingInt(e -> e.getValue().size()))).forEach(entry -> columns.put(entry.getKey(), entry.getValue()));
					
					TableColumnModel cm = parsing_table.getColumnModel();
					int rows = max_rows, cols = columns.size();
					parsing_model.setRowCount(rows);
					parsing_model.setColumnCount(cols);
					int c = 0;
					for(Map.Entry<String, ArrayList<String>> e : columns.entrySet()) {
						cm.getColumn(c).setHeaderValue(e.getKey());
						for(int r = 0; r < e.getValue().size(); r++) {
							String val = e.getValue().get(r);
							parsing_model.setValueAt(val, r, c);
							final_concepts.add(val.substring(0, val.lastIndexOf(" (")));
						}
						c++;
					}
					
					int total_width = 0;
					for(c = 0; c < cols; ++c) {
						int min_width = 100, max_width = 700;
						cm.getColumn(c).setMinWidth(min_width);
						cm.getColumn(c).setMaxWidth(max_width);
						int preferred_width = min_width;
						for(int r = 0; r < rows; r++) {
					        int width = ((Component)parsing_table.prepareRenderer(parsing_table.getCellRenderer(r, c), r, c)).getPreferredSize().width + parsing_table.getIntercellSpacing().width;
					        if(width > preferred_width)
					        	preferred_width = width;
					        if (preferred_width >= max_width) {
					            preferred_width = max_width;
					            break;
					        }
						}
						int header_width = (parsing_table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(parsing_table, cm.getColumn(c).getHeaderValue(), false, false, -1, c)).getPreferredSize().width + parsing_table.getIntercellSpacing().width;
						if(header_width > preferred_width)
				        	preferred_width = header_width;
						cm.getColumn(c).setPreferredWidth(preferred_width + 8);
						total_width += preferred_width;
					}
					if(total_width >= 590)
						parsing_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				}
				return null;
			}
			
			@Override
			protected void done() {
				crawl_go = false;
	        }
		};
	    worker.execute();
		
		OntClass class_ProductionMachine = ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000033");
		OntClass class_FeedDrive = ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000119");
		exp_functions = new ArrayList<TableNode>();
		inf_functions = new ArrayList<TableNode>();
		exp_materials = new ArrayList<TableNode>();
		inf_materials = new ArrayList<TableNode>();
		int total_machines = equipment_individuals.size();
		int max_feed_drives = 0;
		
		for(int i = 0; i < capability_individuals.size(); ++i) {
			if(capability_individuals.get(i).getCategoryClass().equals(class_Material)) {
				Individual mater = capability_individuals.get(i).getIndividual();
				boolean exists = false;
				for(int y = 0; y < exp_materials.size(); y++) {
					if(exp_materials.get(y).getIndividual().getURI().equals(mater.getURI())) {
						exists = true;
						break;
					}
				}
				if(!exists) {
					TableNode add_node = new TableNode(mater, "");
					if(!add_node.toString().equals(""))
						exp_materials.add(add_node);
				}
			}
		}
		
		float exp_min_tolerance = -1, exp_max_tolerance = -1, exp_min_length = -1, exp_max_length = -1, exp_min_diameter = -1, exp_max_diameter = -1, exp_min_roughness = -1, exp_max_roughness = -1, exp_min_thickness = -1, exp_max_thickness = -1, exp_max_weight = -1;
		float inf_min_tolerance = -1, inf_max_tolerance = -1, inf_min_length = -1, inf_max_length = -1, inf_min_diameter = -1, inf_max_diameter = -1, inf_min_roughness = -1, inf_max_roughness = -1, inf_min_thickness = -1, inf_max_thickness = -1, inf_max_weight = -1;
		for(int x = 0; x < equipment_individuals.size(); x++) {
			Individual indiv = equipment_individuals.get(x).getIndividual();
			
			int feed_drives = 0;
			for(StmtIterator si = indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
				if(isCategoryOf(getOntClassOf(ontology.getIndividual(si.next().getObject().asResource().getURI())), class_FeedDrive, true))
					feed_drives++;
			}
			if(feed_drives > max_feed_drives)
				max_feed_drives = feed_drives;
			
			for(StmtIterator si = indiv.listProperties(prop_hasFunction); si.hasNext(); ) {
				Individual i = ontology.getIndividual(si.next().getObject().asResource().getURI());
				boolean exists = false;
				for(int y = 0; y < exp_functions.size(); y++) {
					if(exp_functions.get(y).getIndividual().getURI().equals(i.getURI())) {
						exists = true;
						break;
					}
				}
				if(!exists) {
					TableNode add_node = new TableNode(i, "");
					if(!add_node.toString().equals(""))
						exp_functions.add(add_node);
				}
			}
			
			for(StmtIterator si = indiv.listProperties(prop_hasMaterialCapability); si.hasNext(); ) {
				Individual i = ontology.getIndividual(si.next().getObject().asResource().getURI());
				boolean exists = false;
				for(int y = 0; y < exp_materials.size(); y++) {
					if(exp_materials.get(y).getIndividual().getURI().equals(i.getURI())) {
						exists = true;
						break;
					}
				}
				if(!exists) {
					TableNode add_node = new TableNode(i, "");
					if(!add_node.toString().equals(""))
						exp_materials.add(add_node);
				}
			}
					
			try { // min tolerance
				Individual MD_minTolerance = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMinTolerance).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
				String val = MD_minTolerance.getPropertyValue(prop_hasMeasurementValue).toString();
				if(val.indexOf("^") != -1)
					val = val.substring(0, val.indexOf("^"));
				float f_val = Float.parseFloat(val);
				if(f_val < exp_min_tolerance || exp_min_tolerance == -1)
					exp_min_tolerance = f_val;
			} catch(Exception property_not_given) {
				OntClass c = getOntClassOf(indiv);
				boolean go_higher = true;
				while(c.hasSuperClass() && go_higher) {
					c = accountRestrictions(c.getSuperClass());
					if(!isCategoryOf(c, class_ProductionMachine, true)) {
						go_higher = false;
						break;
					}
					for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
						Individual inf_indiv = i.next().asIndividual();
						try {
							Individual inf_MD_minTolerance = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMinTolerance).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
							String inf_val = inf_MD_minTolerance.getPropertyValue(prop_hasMeasurementValue).toString();
							if(inf_val.indexOf("^") != -1)
								inf_val = inf_val.substring(0, inf_val.indexOf("^"));
							float inf_f_val = Float.parseFloat(inf_val);
							if(inf_f_val < inf_min_tolerance || inf_min_tolerance == -1)
								inf_min_tolerance = inf_f_val;
						} catch(Exception property_not_given2) {}
					}
				}
			}
			
			try { // max tolerance
				Individual MD_maxTolerance = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxTolerance).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
				String val = MD_maxTolerance.getPropertyValue(prop_hasMeasurementValue).toString();
				if(val.indexOf("^") != -1)
					val = val.substring(0, val.indexOf("^"));
				float f_val = Float.parseFloat(val);
				if(f_val > exp_max_tolerance)
					exp_max_tolerance = f_val;
			} catch(Exception property_not_given) {
				OntClass c = getOntClassOf(indiv);
				boolean go_higher = true;
				while(c.hasSuperClass() && go_higher) {
					c = accountRestrictions(c.getSuperClass());
					if(!isCategoryOf(c, class_ProductionMachine, true)) {
						go_higher = false;
						break;
					}
					for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
						Individual inf_indiv = i.next().asIndividual();
						try {
							Individual inf_MD_maxTolerance = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxTolerance).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
							String inf_val = inf_MD_maxTolerance.getPropertyValue(prop_hasMeasurementValue).toString();
							if(inf_val.indexOf("^") != -1)
								inf_val = inf_val.substring(0, inf_val.indexOf("^"));
							float inf_f_val = Float.parseFloat(inf_val);
							if(inf_f_val > inf_max_tolerance)
								inf_max_tolerance = inf_f_val;
						} catch(Exception property_not_given2) {}
					}
				}
			}
			
			try { // min length
				Individual MD_minLength = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMinLength).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
				String val = MD_minLength.getPropertyValue(prop_hasMeasurementValue).toString();
				if(val.indexOf("^") != -1)
					val = val.substring(0, val.indexOf("^"));
				float f_val = Float.parseFloat(val);
				if(f_val < exp_min_length || exp_min_length == -1)
					exp_min_length = f_val;
			} catch(Exception property_not_given) {
				OntClass c = getOntClassOf(indiv);
				boolean go_higher = true;
				while(c.hasSuperClass() && go_higher) {
					c = accountRestrictions(c.getSuperClass());
					if(!isCategoryOf(c, class_ProductionMachine, true)) {
						go_higher = false;
						break;
					}
					for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
						Individual inf_indiv = i.next().asIndividual();
						try {
							Individual inf_MD_minLength = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMinLength).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
							String inf_val = inf_MD_minLength.getPropertyValue(prop_hasMeasurementValue).toString();
							if(inf_val.indexOf("^") != -1)
								inf_val = inf_val.substring(0, inf_val.indexOf("^"));
							float inf_f_val = Float.parseFloat(inf_val);
							if(inf_f_val < inf_min_length || inf_min_length == -1)
								inf_min_length = inf_f_val;
						} catch(Exception property_not_given2) {}
					}
				}
			}
			
			try { // max length
				Individual MD_maxLength = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxLength).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
				String val = MD_maxLength.getPropertyValue(prop_hasMeasurementValue).toString();
				if(val.indexOf("^") != -1)
					val = val.substring(0, val.indexOf("^"));
				float f_val = Float.parseFloat(val);
				if(f_val > exp_max_length)
					exp_max_length = f_val;
			} catch(Exception property_not_given) {
				OntClass c = getOntClassOf(indiv);
				boolean go_higher = true;
				while(c.hasSuperClass() && go_higher) {
					c = accountRestrictions(c.getSuperClass());
					if(!isCategoryOf(c, class_ProductionMachine, true)) {
						go_higher = false;
						break;
					}
					for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
						Individual inf_indiv = i.next().asIndividual();
						try {
							Individual inf_MD_maxLength = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxLength).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
							String inf_val = inf_MD_maxLength.getPropertyValue(prop_hasMeasurementValue).toString();
							if(inf_val.indexOf("^") != -1)
								inf_val = inf_val.substring(0, inf_val.indexOf("^"));
							float inf_f_val = Float.parseFloat(inf_val);
							if(inf_f_val > inf_max_length)
								inf_max_length = inf_f_val;
						} catch(Exception property_not_given2) {}
					}
				}
			}
			
			try { // min diameter
				Individual MD_minDiameter = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMinDiameter).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
				String val = MD_minDiameter.getPropertyValue(prop_hasMeasurementValue).toString();
				if(val.indexOf("^") != -1)
					val = val.substring(0, val.indexOf("^"));
				float f_val = Float.parseFloat(val);
				if(f_val < exp_min_diameter || exp_min_diameter == -1)
					exp_min_diameter = f_val;
			} catch(Exception property_not_given) {
				OntClass c = getOntClassOf(indiv);
				boolean go_higher = true;
				while(c.hasSuperClass() && go_higher) {
					c = accountRestrictions(c.getSuperClass());
					if(!isCategoryOf(c, class_ProductionMachine, true)) {
						go_higher = false;
						break;
					}
					for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
						Individual inf_indiv = i.next().asIndividual();
						try {
							Individual inf_MD_minDiameter = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMinDiameter).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
							String inf_val = inf_MD_minDiameter.getPropertyValue(prop_hasMeasurementValue).toString();
							if(inf_val.indexOf("^") != -1)
								inf_val = inf_val.substring(0, inf_val.indexOf("^"));
							float inf_f_val = Float.parseFloat(inf_val);
							if(inf_f_val < inf_min_diameter || inf_min_diameter == -1)
								inf_min_diameter = inf_f_val;
						} catch(Exception property_not_given2) {}
					}
				}
			}
			
			try { // max diameter
				Individual MD_maxDiameter = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxDiameter).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
				String val = MD_maxDiameter.getPropertyValue(prop_hasMeasurementValue).toString();
				if(val.indexOf("^") != -1)
					val = val.substring(0, val.indexOf("^"));
				float f_val = Float.parseFloat(val);
				if(f_val > exp_max_diameter)
					exp_max_diameter = f_val;
			} catch(Exception property_not_given) {
				OntClass c = getOntClassOf(indiv);
				boolean go_higher = true;
				while(c.hasSuperClass() && go_higher) {
					c = accountRestrictions(c.getSuperClass());
					if(!isCategoryOf(c, class_ProductionMachine, true)) {
						go_higher = false;
						break;
					}
					for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
						Individual inf_indiv = i.next().asIndividual();
						try {
							Individual inf_MD_maxDiameter = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxDiameter).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
							String inf_val = inf_MD_maxDiameter.getPropertyValue(prop_hasMeasurementValue).toString();
							if(inf_val.indexOf("^") != -1)
								inf_val = inf_val.substring(0, inf_val.indexOf("^"));
							float inf_f_val = Float.parseFloat(inf_val);
							if(inf_f_val > inf_max_diameter)
								inf_max_diameter = inf_f_val;
						} catch(Exception property_not_given2) {}
					}
				}
			}
			
			try { // min roughness
				Individual MD_minRoughness = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMinRoughness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
				String val = MD_minRoughness.getPropertyValue(prop_hasMeasurementValue).toString();
				if(val.indexOf("^") != -1)
					val = val.substring(0, val.indexOf("^"));
				float f_val = Float.parseFloat(val);
				if(f_val < exp_min_roughness || exp_min_roughness == -1)
					exp_min_roughness = f_val;
			} catch(Exception property_not_given) {
				OntClass c = getOntClassOf(indiv);
				boolean go_higher = true;
				while(c.hasSuperClass() && go_higher) {
					c = accountRestrictions(c.getSuperClass());
					if(!isCategoryOf(c, class_ProductionMachine, true)) {
						go_higher = false;
						break;
					}
					for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
						Individual inf_indiv = i.next().asIndividual();
						try {
							Individual inf_MD_minRoughness = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMinRoughness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
							String inf_val = inf_MD_minRoughness.getPropertyValue(prop_hasMeasurementValue).toString();
							if(inf_val.indexOf("^") != -1)
								inf_val = inf_val.substring(0, inf_val.indexOf("^"));
							float inf_f_val = Float.parseFloat(inf_val);
							if(inf_f_val < inf_min_roughness || inf_min_roughness == -1)
								inf_min_roughness = inf_f_val;
						} catch(Exception property_not_given2) {}
					}
				}
			}
			
			try { // max roughness
				Individual MD_maxRoughness = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxRoughness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
				String val = MD_maxRoughness.getPropertyValue(prop_hasMeasurementValue).toString();
				if(val.indexOf("^") != -1)
					val = val.substring(0, val.indexOf("^"));
				float f_val = Float.parseFloat(val);
				if(f_val > exp_max_roughness)
					exp_max_roughness = f_val;
			} catch(Exception property_not_given) {
				OntClass c = getOntClassOf(indiv);
				boolean go_higher = true;
				while(c.hasSuperClass() && go_higher) {
					c = accountRestrictions(c.getSuperClass());
					if(!isCategoryOf(c, class_ProductionMachine, true)) {
						go_higher = false;
						break;
					}
					for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
						Individual inf_indiv = i.next().asIndividual();
						try {
							Individual inf_MD_maxRoughness = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxRoughness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
							String inf_val = inf_MD_maxRoughness.getPropertyValue(prop_hasMeasurementValue).toString();
							if(inf_val.indexOf("^") != -1)
								inf_val = inf_val.substring(0, inf_val.indexOf("^"));
							float inf_f_val = Float.parseFloat(inf_val);
							if(inf_f_val > inf_max_roughness)
								inf_max_roughness = inf_f_val;
						} catch(Exception property_not_given2) {}
					}
				}
			}
			
			try { // min thickness
				Individual MD_minThickness = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMinThickness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
				String val = MD_minThickness.getPropertyValue(prop_hasMeasurementValue).toString();
				if(val.indexOf("^") != -1)
					val = val.substring(0, val.indexOf("^"));
				float f_val = Float.parseFloat(val);
				if(f_val < exp_min_thickness || exp_min_thickness == -1)
					exp_min_thickness = f_val;
			} catch(Exception property_not_given) {
				OntClass c = getOntClassOf(indiv);
				boolean go_higher = true;
				while(c.hasSuperClass() && go_higher) {
					c = accountRestrictions(c.getSuperClass());
					if(!isCategoryOf(c, class_ProductionMachine, true)) {
						go_higher = false;
						break;
					}
					for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
						Individual inf_indiv = i.next().asIndividual();
						try {
							Individual inf_MD_minThickness = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMinThickness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
							String inf_val = inf_MD_minThickness.getPropertyValue(prop_hasMeasurementValue).toString();
							if(inf_val.indexOf("^") != -1)
								inf_val = inf_val.substring(0, inf_val.indexOf("^"));
							float inf_f_val = Float.parseFloat(inf_val);
							if(inf_f_val < inf_min_thickness || inf_min_thickness == -1)
								inf_min_thickness = inf_f_val;
						} catch(Exception property_not_given2) {}
					}
				}
			}
			
			try { // max thickness
				Individual MD_maxThickness = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxThickness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
				String val = MD_maxThickness.getPropertyValue(prop_hasMeasurementValue).toString();
				if(val.indexOf("^") != -1)
					val = val.substring(0, val.indexOf("^"));
				float f_val = Float.parseFloat(val);
				if(f_val > exp_max_thickness)
					exp_max_thickness = f_val;
			} catch(Exception property_not_given) {
				OntClass c = getOntClassOf(indiv);
				boolean go_higher = true;
				while(c.hasSuperClass() && go_higher) {
					c = accountRestrictions(c.getSuperClass());
					if(!isCategoryOf(c, class_ProductionMachine, true)) {
						go_higher = false;
						break;
					}
					for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
						Individual inf_indiv = i.next().asIndividual();
						try {
							Individual inf_MD_maxThickness = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxThickness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
							String inf_val = inf_MD_maxThickness.getPropertyValue(prop_hasMeasurementValue).toString();
							if(inf_val.indexOf("^") != -1)
								inf_val = inf_val.substring(0, inf_val.indexOf("^"));
							float inf_f_val = Float.parseFloat(inf_val);
							if(inf_f_val > inf_max_thickness)
								inf_max_thickness = inf_f_val;
						} catch(Exception property_not_given2) {}
					}
				}
			}
			
			try { // max weight
				Individual MD_maxWeight = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxWeight).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
				String val = MD_maxWeight.getPropertyValue(prop_hasMeasurementValue).toString();
				if(val.indexOf("^") != -1)
					val = val.substring(0, val.indexOf("^"));
				float f_val = Float.parseFloat(val);
				if(f_val > exp_max_weight)
					exp_max_weight = f_val;
			} catch(Exception property_not_given) {
				OntClass c = getOntClassOf(indiv);
				boolean go_higher = true;
				while(c.hasSuperClass() && go_higher) {
					c = accountRestrictions(c.getSuperClass());
					if(!isCategoryOf(c, class_ProductionMachine, true)) {
						go_higher = false;
						break;
					}
					for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
						Individual inf_indiv = i.next().asIndividual();
						try {
							Individual inf_MD_maxWeight = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxWeight).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
							String inf_val = inf_MD_maxWeight.getPropertyValue(prop_hasMeasurementValue).toString();
							if(inf_val.indexOf("^") != -1)
								inf_val = inf_val.substring(0, inf_val.indexOf("^"));
							float inf_f_val = Float.parseFloat(inf_val);
							if(inf_f_val > inf_max_weight)
								inf_max_weight = inf_f_val;
						} catch(Exception property_not_given2) {}
					}
				}
			}

		}
		
		for(TableNode t : exp_functions) {
        	Individual i = t.getIndividual();
        	for(ExtendedIterator<Individual> n = ontology.listIndividuals(); n.hasNext(); ) {
    			try {
    				Individual i2 = n.next();
    				if(isCategoryOf(getOntClassOf(i2), getOntClassOf(i), true)) {
    					boolean exists = false;
    					for(int x = 0; x < exp_functions.size(); x++) {
    						if(exp_functions.get(x).getIndividual().getURI().equals(i2.getURI())) {
    							exists = true;
    							x = exp_functions.size();
    						}
    					}
    					if(!exists) {
    						for(int x = 0; x < inf_functions.size(); x++) {
        						if(inf_functions.get(x).getIndividual().getURI().equals(i2.getURI())) {
        							exists = true;
        							x = inf_functions.size();
        						}
        					}
    					}
    					if(!exists) {
    						TableNode add_node = new TableNode(i2, "");
    						if(!add_node.toString().equals(""))
    							inf_functions.add(add_node);
    					}
    				}
    			} catch(Exception aaa) {}
    		}
        }
		
		for(TableNode t : exp_materials) {
        	Individual i = t.getIndividual();
        	for(ExtendedIterator<Individual> n = ontology.listIndividuals(); n.hasNext(); ) {
    			try {
    				Individual i2 = n.next();
    				if(isCategoryOf(getOntClassOf(i2), getOntClassOf(i), true)) {
    					boolean exists = false;
    					for(int x = 0; x < exp_materials.size(); x++) {
    						if(exp_materials.get(x).getIndividual().getURI().equals(i2.getURI())) {
    							exists = true;
    							x = exp_materials.size();
    						}
    					}
    					if(!exists) {
    						for(int x = 0; x < inf_materials.size(); x++) {
        						if(inf_materials.get(x).getIndividual().getURI().equals(i2.getURI())) {
        							exists = true;
        							x = inf_materials.size();
        						}
        					}
    					}
    					if(!exists) {
    						TableNode add_node = new TableNode(i2, "");
    						if(!add_node.toString().equals(""))
    							inf_materials.add(add_node);
    					}
    				}
    			} catch(Exception aaa) {}
    		}
        }
		
		String exp_range = "Low";
		if(total_machines >= 3)
			exp_range = "Medium";
		if(total_machines >= 10)
			exp_range = "High";
		String inf_range = exp_range;
		
		String exp_variety = "Low";
		if(exp_functions.size() >= 3)
			exp_variety = "Medium";
		if(exp_functions.size() >= 10)
			exp_variety = "High";
		String inf_variety = "Low";
		if(exp_functions.size() + inf_functions.size() >= 3)
			inf_variety = "Medium";
		if(exp_functions.size() + inf_functions.size() >= 10)
			inf_variety = "High";
		
		String exp_complexity = "Low - Medium";
		if(max_feed_drives > 3)
			exp_complexity = "High";
		String inf_complexity = exp_complexity;
		
		final String fin_exp_complexity = exp_complexity, fin_inf_complexity = inf_complexity;
		final String fin_exp_variety = exp_variety, fin_inf_variety = inf_variety;
		final String fin_exp_range = exp_range, fin_inf_range = inf_range;
		
		if(inf_min_tolerance > exp_min_tolerance && exp_min_tolerance != -1)
			inf_min_tolerance = exp_min_tolerance;
		if(inf_max_tolerance < exp_max_tolerance)
			inf_max_tolerance = exp_max_tolerance;
		if(inf_min_length > exp_min_length && exp_min_length != -1)
			inf_min_length = exp_min_length;
		if(inf_max_length < exp_max_length)
			inf_max_length = exp_max_length;
		if(inf_min_diameter > exp_min_diameter && exp_min_diameter != -1)
			inf_min_diameter = exp_min_diameter;
		if(inf_max_diameter < exp_max_diameter)
			inf_max_diameter = exp_max_diameter;
		if(inf_min_roughness > exp_min_roughness && exp_min_roughness != -1)
			inf_min_roughness = exp_min_roughness;
		if(inf_max_roughness < exp_max_roughness)
			inf_max_roughness = exp_max_roughness;
		if(inf_min_thickness > exp_min_thickness && exp_min_thickness != -1)
			inf_min_thickness = exp_min_thickness;
		if(inf_max_thickness < exp_max_thickness)
			inf_max_thickness = exp_max_thickness;
		if(inf_max_weight < exp_max_weight)
			inf_max_weight = exp_max_weight;
		
		final String fin_exp_min_tolerance = ("" + exp_min_tolerance).replaceFirst("-1.0", ""), fin_exp_max_tolerance = ("" + exp_max_tolerance).replaceFirst("-1.0", "");
		final String fin_exp_min_length = ("" + exp_min_length).replaceFirst("-1.0", ""), fin_exp_max_length = ("" + exp_max_length).replaceFirst("-1.0", "");
		final String fin_exp_min_diameter = ("" + exp_min_diameter).replaceFirst("-1.0", ""), fin_exp_max_diameter = ("" + exp_max_diameter).replaceFirst("-1.0", "");
		final String fin_exp_min_roughness = ("" + exp_min_roughness).replaceFirst("-1.0", ""), fin_exp_max_roughness = ("" + exp_max_roughness).replaceFirst("-1.0", "");
		final String fin_exp_min_thickness = ("" + exp_min_thickness).replaceFirst("-1.0", ""), fin_exp_max_thickness = ("" + exp_max_thickness).replaceFirst("-1.0", "");
		final String fin_exp_max_weight = ("" + exp_max_weight).replaceFirst("-1.0", " - ");
		
		final String fin_inf_min_tolerance = ("" + inf_min_tolerance).replaceFirst("-1.0", fin_exp_min_tolerance), fin_inf_max_tolerance = ("" + inf_max_tolerance).replaceFirst("-1.0", fin_exp_max_tolerance);
		final String fin_inf_min_length = ("" + inf_min_length).replaceFirst("-1.0", fin_exp_min_length), fin_inf_max_length = ("" + inf_max_length).replaceFirst("-1.0", fin_exp_max_length);
		final String fin_inf_min_diameter = ("" + inf_min_diameter).replaceFirst("-1.0", fin_exp_min_diameter), fin_inf_max_diameter = ("" + inf_max_diameter).replaceFirst("-1.0", fin_exp_max_diameter);
		final String fin_inf_min_roughness = ("" + inf_min_roughness).replaceFirst("-1.0", fin_exp_min_roughness), fin_inf_max_roughness = ("" + inf_max_roughness).replaceFirst("-1.0", fin_exp_max_roughness);
		final String fin_inf_min_thickness = ("" + inf_min_thickness).replaceFirst("-1.0", fin_exp_min_thickness), fin_inf_max_thickness = ("" + inf_max_thickness).replaceFirst("-1.0", fin_exp_max_thickness);
		final String fin_inf_max_weight = ("" + inf_max_weight).replaceFirst("-1.0", fin_exp_max_weight);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{684, 0};
		gbl_panel.rowHeights = new int[]{50, 0, 40, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblFactoryAnalysisResults;
		try {
			lblFactoryAnalysisResults = new JLabel("Factory Analysis - " + company.getName());
		} catch(Exception ee) {
			lblFactoryAnalysisResults = new JLabel("Factory Analysis - [ Untitled ]");
		}
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
		tabbedPane.addTab("<html>Part Quality<br/>Capability</html>", null, panel_1, null);
		panel_1.setBackground(tab_color1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{200, 0, 200, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(tab_color1);
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.insets = new Insets(0, 0, 5, 0);
		gbc_panel_18.fill = GridBagConstraints.BOTH;
		gbc_panel_18.gridx = 0;
		gbc_panel_18.gridy = 0;
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
		gbc_scrollPane_4.insets = new Insets(20, 50, 0, 50);
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
				{"Tolerance (inch)", fin_exp_min_tolerance + " - " + fin_exp_max_tolerance, ""},
				{"Length (inch)", fin_exp_min_length + " - " + fin_exp_max_length, ""},
				{"Diameter (inch)", fin_exp_min_diameter + " - " + fin_exp_max_diameter, ""},
				{"Surface roughness (microinch)", fin_exp_min_roughness + " - " + fin_exp_max_roughness, ""},
				{"Wall thickness (inch)", fin_exp_min_thickness + " - " + fin_exp_max_thickness, ""},
				{"Maximum weight (lb)", fin_exp_max_weight, ""},
				{"Complexity", fin_exp_complexity, ""},
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
		gbc_panel_17.insets = new Insets(0, 0, 5, 0);
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 0;
		gbc_panel_17.gridy = 1;
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
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(tab_color1);
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 0;
		gbc_panel_16.gridy = 2;
		panel_1.add(panel_16, gbc_panel_16);
		GridBagLayout gbl_panel_16 = new GridBagLayout();
		gbl_panel_16.columnWidths = new int[]{0, 0};
		gbl_panel_16.rowHeights = new int[]{0, 0};
		gbl_panel_16.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_16.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_16.setLayout(gbl_panel_16);
		
		btnInferCapability_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_6.setModel(new DefaultTableModel(
					new Object[][] {
						{"Tolerance (inch)", fin_exp_min_tolerance + " - " + fin_exp_max_tolerance, fin_inf_min_tolerance + " - " + fin_inf_max_tolerance},
						{"Length (inch)", fin_exp_min_length + " - " + fin_exp_max_length, fin_inf_min_length + " - " + fin_inf_max_length},
						{"Diameter (inch)", fin_exp_min_diameter + " - " + fin_exp_max_diameter, fin_inf_min_diameter + " - " + fin_inf_max_diameter},
						{"Surface roughness (microinch)", fin_exp_min_roughness + " - " + fin_exp_max_roughness, fin_inf_min_roughness + " - " + fin_inf_max_roughness},
						{"Wall thickness (inch)", fin_exp_min_thickness + " - " + fin_exp_max_thickness, fin_inf_min_thickness + " - " + fin_inf_max_thickness},
						{"Maximum weight (lb)", fin_exp_max_weight, fin_inf_max_weight},
						{"Complexity", fin_exp_complexity, fin_inf_complexity},
					},
					new String[] {
						"Capability", "Explicit", "Inferred"
					}
				));
			}
		});
		
		btnReset_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_6.setModel(new DefaultTableModel(
					new Object[][] {
						{"Tolerance (inch)", fin_exp_min_tolerance + " - " + fin_exp_max_tolerance, ""},
						{"Length (inch)", fin_exp_min_length + " - " + fin_exp_max_length, ""},
						{"Diameter (inch)", fin_exp_min_diameter + " - " + fin_exp_max_diameter, ""},
						{"Surface roughness (microinch)", fin_exp_min_roughness + " - " + fin_exp_max_roughness, ""},
						{"Wall thickness (inch)", fin_exp_min_thickness + " - " + fin_exp_max_thickness, ""},
						{"Maximum weight (lb)", fin_exp_max_weight, ""},
						{"Complexity", fin_exp_complexity, ""},
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
		tabbedPane.addTab("<html>Process<br/>Capability</html>", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{200, 0, 200, 0};
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

			},
			new String[] {
				"Explicit Processes"
			}
		));
		for(int x = 0; x < exp_functions.size(); x++)
			((DefaultTableModel)table_1.getModel()).addRow(new Object[] { exp_functions.get(x) });
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

            		},
            		new String[] {
            			"Inferred Processes"
            		}
            	));
            	for(int x = 0; x < inf_functions.size(); x++)
            		((DefaultTableModel)table_2.getModel()).addRow(new Object[] { inf_functions.get(x) });
            }
        });
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(0, 0, 1, 0, tab_color2));
		tabbedPane.addTab("<html>Material<br/>Capability</html>", null, panel_3, null);
		panel_3.setBackground(tab_color1);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{200, 0, 200, 0};
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

        	},
        	new String[] {
        		"Explicit Materials"
        	}
		));
		for(int x = 0; x < exp_materials.size(); x++)
			((DefaultTableModel)table.getModel()).addRow(new Object[] { exp_materials.get(x) });
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
        		"Inferred Materials"
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
                    	
                    },
                    new String[] {
                    	"Inferred Materials"
                    }
            	));
            	for(int x = 0; x < inf_materials.size(); x++)
            		((DefaultTableModel)table_3.getModel()).addRow(new Object[] { inf_materials.get(x) });
            }
        });
		
		btnReset_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	table_3.setModel(new DefaultTableModel(
            		new Object[][] {

                    },
                    new String[] {
                    	"Inferred Materials"
                    }
            	));
            }
        });
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(0, 0, 1, 0, tab_color2));
		tabbedPane.addTab("<html>Production<br/>Capability</html>", null, panel_4, null);
		panel_4.setBackground(tab_color1);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{200, 0, 200, 0};
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
				{"Variety", fin_exp_variety, ""},
				{"Production range", fin_exp_range, ""},
			},
			new String[] {
				"Capability", "Explicit", "Inferred"
			}
		));
		table_4.getColumnModel().getColumn(0).setPreferredWidth(300);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_4.setAutoCreateColumnsFromModel(false);
		table_4.setDragEnabled(false);
		table_4.setEnabled(false);
		table_4.setOpaque(true);
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
		
		btnInferCapability_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	table_4.setModel(new DefaultTableModel(
            		new Object[][] {
            			{"Variety", fin_exp_variety, fin_inf_variety},
            			{"Production range", fin_exp_range, fin_inf_range},
            		},
            		new String[] {
            			"Capability", "Explicit", "Inferred"
            		}
            	));
            }
        });
		
		btnReset_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	table_4.setModel(new DefaultTableModel(
	            	new Object[][] {
						{"Variety", fin_exp_variety, ""},
						{"Production range", fin_exp_range, ""},
					},
					new String[] {
						"Capability", "Explicit", "Inferred"
					}
            	));
            }
        });
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(tab_color1);
		panel_21.setBorder(new MatteBorder(0, 0, 1, 0, tab_color2));
		tabbedPane.addTab("<html>Extracted<br/>Capability</html>", null, panel_21, null);
		GridBagLayout gbl_panel_21 = new GridBagLayout();
		gbl_panel_21.columnWidths = new int[]{0, 0};
		gbl_panel_21.rowHeights = new int[]{0, 0};
		gbl_panel_21.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_21.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_21.setLayout(gbl_panel_21);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(tab_color1);
		GridBagConstraints gbc_panel_20 = new GridBagConstraints();
		gbc_panel_20.fill = GridBagConstraints.BOTH;
		gbc_panel_20.gridx = 0;
		gbc_panel_20.gridy = 0;
		panel_21.add(panel_20, gbc_panel_20);
		GridBagLayout gbl_panel_20 = new GridBagLayout();
		gbl_panel_20.columnWidths = new int[]{0, 0};
		gbl_panel_20.rowHeights = new int[]{300, 0};
		gbl_panel_20.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_20.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_20.setLayout(gbl_panel_20);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(Color.WHITE);
		scrollPane_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane_3.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane_3.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane_3.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane_3.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.insets = new Insets(20, 50, 5, 50);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 0;
		panel_20.add(scrollPane_3, gbc_scrollPane_3);
		
		scrollPane_3.setColumnHeader(new JViewport() {
		    @Override public Dimension getPreferredSize() {
		        Dimension d = super.getPreferredSize();
		        d.height = 30;
		        return d;
		    }
		});
		scrollPane_3.setViewportView(parsing_table);
		
		JLabel lblbaseurl = new JLabel(company.getURL());
		if(company.getURL().length() > 75)
			lblbaseurl = new JLabel(company.getURL().substring(0, 73) + "...");
		lblbaseurl.setForeground(Color.GRAY);
		lblbaseurl.setFont(new Font("Consolas", Font.PLAIN, 12));
		GridBagConstraints gbc_lblbaseurl = new GridBagConstraints();
		gbc_lblbaseurl.fill = GridBagConstraints.BOTH;
		gbc_lblbaseurl.insets = new Insets(0, 56, 10, 0);
		gbc_lblbaseurl.gridx = 0;
		gbc_lblbaseurl.gridy = 1;
		panel_20.add(lblbaseurl, gbc_lblbaseurl);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, tab_color2));
		tabbedPane.addTab("<html>Save and<br>Export</html>", null, panel_5, null);
		panel_5.setBackground(tab_color1);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JButton btnSaveForMatching = new JButton("Save Capability Model");
		btnSaveForMatching.setUI(new ButtonUI2());
		btnSaveForMatching.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnSaveForMatching = new GridBagConstraints();
		gbc_btnSaveForMatching.fill = GridBagConstraints.BOTH;
		gbc_btnSaveForMatching.insets = new Insets(105, 228, 5, 228);
		gbc_btnSaveForMatching.gridx = 0;
		gbc_btnSaveForMatching.gridy = 0;
		panel_5.add(btnSaveForMatching, gbc_btnSaveForMatching);
		
		JPanel panel_99 = new JPanel();
		panel_99.setBackground(tab_color1);
		GridBagConstraints gbc_panel_99 = new GridBagConstraints();
		gbc_panel_99.insets = new Insets(5, 0, 5, 0);
		gbc_panel_99.fill = GridBagConstraints.BOTH;
		gbc_panel_99.gridx = 0;
		gbc_panel_99.gridy = 1;
		panel_5.add(panel_99, gbc_panel_99);
		GridBagLayout gbl_panel_99 = new GridBagLayout();
		gbl_panel_99.columnWidths = new int[]{0, 0};
		gbl_panel_99.rowHeights = new int[]{0, 0};
		gbl_panel_99.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_99.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_99.setLayout(gbl_panel_99);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(tab_color2);
		separator.setBackground(tab_color1);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 222, 0, 222);
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 0;
		panel_99.add(separator, gbc_separator);
		
		JButton btnExport = new JButton("Export Capability Model");
		btnExport.setUI(new ButtonUI2());
		btnExport.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.fill = GridBagConstraints.BOTH;
		gbc_btnExport.insets = new Insets(4, 228, 5, 228);
		gbc_btnExport.gridx = 0;
		gbc_btnExport.gridy = 2;
		panel_5.add(btnExport, gbc_btnExport);
		
		CustomCheckbox chckbxIncludeFactoryFile = new CustomCheckbox();
		chckbxIncludeFactoryFile.setText("Include factory file");
		chckbxIncludeFactoryFile.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_chckbxIncludeFactoryFile = new GridBagConstraints();
		gbc_chckbxIncludeFactoryFile.gridx = 0;
		gbc_chckbxIncludeFactoryFile.gridy = 3;
		panel_5.add(chckbxIncludeFactoryFile, gbc_chckbxIncludeFactoryFile);
		
		btnSaveForMatching.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(crawl_go)
            		JOptionPane.showMessageDialog(frame, new JLabel("Please wait for the parser to finish.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
            	
            	else {
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
							JLabel message_save = new JLabel("<html>Saved capability models for matching are remembered until the program is closed.<br><br>Currently saved capability models:</html>", SwingConstants.LEFT);
							message_save.setFont(new Font("Arial", Font.PLAIN, 12));
							message_panel.add(message_save);
							save_panel.add(message_panel, gbc_message_save);
					    	
					    	JPanel list_panel = new JPanel();
							list_panel.setLayout(new BorderLayout(0, 0));
							list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
							list_panel.setBackground(Color.WHITE);
	
							DefaultListModel<MatchData> list_model_save = new DefaultListModel<>();
							for(MatchData md : saved_match_data) {
								list_model_save.addElement(md);
							}
							
							JList<MatchData> list_save = new JList<>(list_model_save);
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
							JLabel enter_save = new JLabel("Enter save name (if same name exists, it will be overwritten):", SwingConstants.LEFT);
							enter_save.setFont(new Font("Arial", Font.PLAIN, 12));
							GridBagConstraints gbc_enter_save = new GridBagConstraints();
							gbc_enter_save.insets = new Insets(0, 0, 5, 0);
							gbc_enter_save.fill = GridBagConstraints.BOTH;
							gbc_enter_save.gridx = 0;
							gbc_enter_save.gridy = 2;
							enter_panel.add(enter_save);
							save_panel.add(enter_panel, gbc_enter_save);
							
							JTextField name_save = new JTextField();
							name_save.setText(company.getName() + "-Cap");
							GridBagConstraints gbc_name_save = new GridBagConstraints();
							gbc_name_save.insets = new Insets(0, 0, 10, 0);
							gbc_name_save.fill = GridBagConstraints.BOTH;
							gbc_name_save.gridx = 0;
							gbc_name_save.gridy = 3;
							save_panel.add(name_save, gbc_name_save);
					    	
					    	result = JOptionPane.showOptionDialog(frame, save_panel, "Save Capability Model", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Save", "Cancel"}, null);
				            switch(result) {
				                case JOptionPane.OK_OPTION:
				                	ArrayList<IndividualWrapper> materials = new ArrayList<>();
				                	for(int x = 0; x < exp_materials.size(); ++x)
				                		materials.add(new IndividualWrapper(exp_materials.get(x).getIndividual()));
				                	for(int x = 0; x < inf_materials.size(); ++x)
				                		materials.add(new IndividualWrapper(inf_materials.get(x).getIndividual()));
				                	
				                	ArrayList<IndividualWrapper> functions = new ArrayList<>();
				                	for(int x = 0; x < exp_functions.size(); ++x)
				                		functions.add(new IndividualWrapper(exp_functions.get(x).getIndividual()));
				                	for(int x = 0; x < inf_functions.size(); ++x)
				                		functions.add(new IndividualWrapper(inf_functions.get(x).getIndividual()));
				                	
									for(int x = 0; x < saved_match_data.size(); x++) {
										if(saved_match_data.get(x).toString().equals(name_save.getText())) {
											saved_match_data.remove(x);
											break;
										}
									}
				                	saved_match_data.add(new MatchData(name_save.getText(), fin_inf_range, fin_inf_min_tolerance, fin_inf_max_tolerance, fin_inf_max_length, fin_inf_max_diameter, fin_inf_min_roughness, fin_inf_max_roughness, fin_inf_min_thickness, fin_inf_max_thickness, fin_inf_max_weight, final_concepts, materials, functions));
				                    return;
				                case JOptionPane.CANCEL_OPTION:
				                    return;
				                case JOptionPane.CLOSED_OPTION:
				                    return;
					    	}
					    }
					});
            	}
            }
        });
		
		btnExport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(crawl_go)
            		JOptionPane.showMessageDialog(frame, new JLabel("Please wait for the parser to finish.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
            	
            	else {
            		
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
    						if(export_path.equals("\\"))
								export_path = import_path;
    						fc.setCurrentDirectory(new File(export_path));
    						JComboBox save_combo = (JComboBox)(fc.getComponent(0).getAccessibleContext().getAccessibleChild(2));
    						save_combo.setFont(new Font("Arial", Font.PLAIN, 12));
    						save_combo.setUI(new ComboUI(save_combo, true, tab_color1));
    						save_combo.setBorder(new LineBorder(Color.GRAY));
    						save_combo.setBackground(Color.WHITE);
    						configureFileChooserUI(fc.getComponents(), true, 1);
    						
    						result = fc.showSaveDialog(frame);
    						if(result == 0)
    						{
    							try {
    								OntModel exp = generateFinalExport(1, chckbxIncludeFactoryFile.isSelected(), fin_inf_complexity, fin_inf_variety, fin_inf_range,
    										fin_inf_min_tolerance, fin_inf_max_tolerance, fin_inf_min_length, fin_inf_max_length,
    										fin_inf_min_diameter, fin_inf_max_diameter, fin_inf_min_roughness, fin_inf_max_roughness,
    										fin_inf_min_thickness, fin_inf_max_thickness, fin_inf_max_weight, final_concepts);
    								File selected_file = fc.getSelectedFile();
    								String selected_file_path = selected_file.getCanonicalPath();
    								if(selected_file_path.length() < 4 || !(selected_file_path.substring(selected_file_path.length() - 4, selected_file_path.length()).equals(".owl")))
    									selected_file = new File(selected_file_path + ".owl");
    								selected_file.createNewFile();
    								export_path = selected_file.getCanonicalPath();
    								FileOutputStream fos = new FileOutputStream(selected_file, false);
    								OutputStreamWriter osw = new OutputStreamWriter(fos);
    								RDFWriter writer = exp.getWriter("RDF/XML-ABBREV");
    								writer.setProperty("showXmlDeclaration", false);
    								writer.write(exp, osw, null);
    								osw.close();
    								fos.close();
    							} catch(Exception e1) {
									JOptionPane.showMessageDialog(frame, new JLabel("Unable to export.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
								}
    						}
    				    }
    				});
            		
            	}
            }
        });
		
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
				worker.cancel(true);
				crawl_go = false;
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
	
	private void analyzePage3(OntModelWrapper omw1, OntModelWrapper omw2) {
		getContentPane().removeAll();
		
		OntClass class_ProductionMachine = ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000033");
		OntClass class_FeedDrive = ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000119");
		DefaultTableModel dtm = new DefaultTableModel(
			new Object[][] {
				{"Tolerance (inch)"},
				{"Length (inch)"},
				{"Diameter (inch)"},
				{"Surface roughness (microinch)"},
				{"Wall thickness (inch)"},
				{"Maximum weight (lb)"},
				{"Complexity"},
			},
			new String[] {
				"Capability"
			}
		);
		setImportedInfo(omw1.getModel(), 1);
		
		for(int a = 0; a < 2; ++a) {
			if(a == 1)
				setImportedInfo(omw2.getModel(), 1);
			
			int max_feed_drives = 0;
			float exp_min_tolerance = -1, exp_max_tolerance = -1, exp_min_length = -1, exp_max_length = -1, exp_min_diameter = -1, exp_max_diameter = -1, exp_min_roughness = -1, exp_max_roughness = -1, exp_min_thickness = -1, exp_max_thickness = -1, exp_max_weight = -1;
			float inf_min_tolerance = -1, inf_max_tolerance = -1, inf_min_length = -1, inf_max_length = -1, inf_min_diameter = -1, inf_max_diameter = -1, inf_min_roughness = -1, inf_max_roughness = -1, inf_min_thickness = -1, inf_max_thickness = -1, inf_max_weight = -1;
			
			for(int x = 0; x < equipment_individuals.size(); x++) {
				Individual indiv = equipment_individuals.get(x).getIndividual();
				
				int feed_drives = 0;
				for(StmtIterator si = indiv.listProperties(prop_hasMachinePart); si.hasNext(); ) {
					if(isCategoryOf(getOntClassOf(ontology.getIndividual(si.next().getObject().asResource().getURI())), class_FeedDrive, true))
						feed_drives++;
				}
				if(feed_drives > max_feed_drives)
					max_feed_drives = feed_drives;
						
				try { // min tolerance
					Individual MD_minTolerance = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMinTolerance).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
					String val = MD_minTolerance.getPropertyValue(prop_hasMeasurementValue).toString();
					if(val.indexOf("^") != -1)
						val = val.substring(0, val.indexOf("^"));
					float f_val = Float.parseFloat(val);
					if(f_val < exp_min_tolerance || exp_min_tolerance == -1)
						exp_min_tolerance = f_val;
				} catch(Exception property_not_given) {
					OntClass c = getOntClassOf(indiv);
					boolean go_higher = true;
					while(c.hasSuperClass() && go_higher) {
						c = accountRestrictions(c.getSuperClass());
						if(!isCategoryOf(c, class_ProductionMachine, true)) {
							go_higher = false;
							break;
						}
						for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
							Individual inf_indiv = i.next().asIndividual();
							try {
								Individual inf_MD_minTolerance = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMinTolerance).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
								String inf_val = inf_MD_minTolerance.getPropertyValue(prop_hasMeasurementValue).toString();
								if(inf_val.indexOf("^") != -1)
									inf_val = inf_val.substring(0, inf_val.indexOf("^"));
								float inf_f_val = Float.parseFloat(inf_val);
								if(inf_f_val < inf_min_tolerance || inf_min_tolerance == -1)
									inf_min_tolerance = inf_f_val;
							} catch(Exception property_not_given2) {}
						}
					}
				}
				
				try { // max tolerance
					Individual MD_maxTolerance = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxTolerance).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
					String val = MD_maxTolerance.getPropertyValue(prop_hasMeasurementValue).toString();
					if(val.indexOf("^") != -1)
						val = val.substring(0, val.indexOf("^"));
					float f_val = Float.parseFloat(val);
					if(f_val > exp_max_tolerance)
						exp_max_tolerance = f_val;
				} catch(Exception property_not_given) {
					OntClass c = getOntClassOf(indiv);
					boolean go_higher = true;
					while(c.hasSuperClass() && go_higher) {
						c = accountRestrictions(c.getSuperClass());
						if(!isCategoryOf(c, class_ProductionMachine, true)) {
							go_higher = false;
							break;
						}
						for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
							Individual inf_indiv = i.next().asIndividual();
							try {
								Individual inf_MD_maxTolerance = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxTolerance).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
								String inf_val = inf_MD_maxTolerance.getPropertyValue(prop_hasMeasurementValue).toString();
								if(inf_val.indexOf("^") != -1)
									inf_val = inf_val.substring(0, inf_val.indexOf("^"));
								float inf_f_val = Float.parseFloat(inf_val);
								if(inf_f_val > inf_max_tolerance)
									inf_max_tolerance = inf_f_val;
							} catch(Exception property_not_given2) {}
						}
					}
				}
				
				try { // min length
					Individual MD_minLength = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMinLength).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
					String val = MD_minLength.getPropertyValue(prop_hasMeasurementValue).toString();
					if(val.indexOf("^") != -1)
						val = val.substring(0, val.indexOf("^"));
					float f_val = Float.parseFloat(val);
					if(f_val < exp_min_length || exp_min_length == -1)
						exp_min_length = f_val;
				} catch(Exception property_not_given) {
					OntClass c = getOntClassOf(indiv);
					boolean go_higher = true;
					while(c.hasSuperClass() && go_higher) {
						c = accountRestrictions(c.getSuperClass());
						if(!isCategoryOf(c, class_ProductionMachine, true)) {
							go_higher = false;
							break;
						}
						for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
							Individual inf_indiv = i.next().asIndividual();
							try {
								Individual inf_MD_minLength = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMinLength).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
								String inf_val = inf_MD_minLength.getPropertyValue(prop_hasMeasurementValue).toString();
								if(inf_val.indexOf("^") != -1)
									inf_val = inf_val.substring(0, inf_val.indexOf("^"));
								float inf_f_val = Float.parseFloat(inf_val);
								if(inf_f_val < inf_min_length || inf_min_length == -1)
									inf_min_length = inf_f_val;
							} catch(Exception property_not_given2) {}
						}
					}
				}
				
				try { // max length
					Individual MD_maxLength = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxLength).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
					String val = MD_maxLength.getPropertyValue(prop_hasMeasurementValue).toString();
					if(val.indexOf("^") != -1)
						val = val.substring(0, val.indexOf("^"));
					float f_val = Float.parseFloat(val);
					if(f_val > exp_max_length)
						exp_max_length = f_val;
				} catch(Exception property_not_given) {
					OntClass c = getOntClassOf(indiv);
					boolean go_higher = true;
					while(c.hasSuperClass() && go_higher) {
						c = accountRestrictions(c.getSuperClass());
						if(!isCategoryOf(c, class_ProductionMachine, true)) {
							go_higher = false;
							break;
						}
						for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
							Individual inf_indiv = i.next().asIndividual();
							try {
								Individual inf_MD_maxLength = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxLength).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
								String inf_val = inf_MD_maxLength.getPropertyValue(prop_hasMeasurementValue).toString();
								if(inf_val.indexOf("^") != -1)
									inf_val = inf_val.substring(0, inf_val.indexOf("^"));
								float inf_f_val = Float.parseFloat(inf_val);
								if(inf_f_val > inf_max_length)
									inf_max_length = inf_f_val;
							} catch(Exception property_not_given2) {}
						}
					}
				}
				
				try { // min diameter
					Individual MD_minDiameter = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMinDiameter).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
					String val = MD_minDiameter.getPropertyValue(prop_hasMeasurementValue).toString();
					if(val.indexOf("^") != -1)
						val = val.substring(0, val.indexOf("^"));
					float f_val = Float.parseFloat(val);
					if(f_val < exp_min_diameter || exp_min_diameter == -1)
						exp_min_diameter = f_val;
				} catch(Exception property_not_given) {
					OntClass c = getOntClassOf(indiv);
					boolean go_higher = true;
					while(c.hasSuperClass() && go_higher) {
						c = accountRestrictions(c.getSuperClass());
						if(!isCategoryOf(c, class_ProductionMachine, true)) {
							go_higher = false;
							break;
						}
						for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
							Individual inf_indiv = i.next().asIndividual();
							try {
								Individual inf_MD_minDiameter = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMinDiameter).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
								String inf_val = inf_MD_minDiameter.getPropertyValue(prop_hasMeasurementValue).toString();
								if(inf_val.indexOf("^") != -1)
									inf_val = inf_val.substring(0, inf_val.indexOf("^"));
								float inf_f_val = Float.parseFloat(inf_val);
								if(inf_f_val < inf_min_diameter || inf_min_diameter == -1)
									inf_min_diameter = inf_f_val;
							} catch(Exception property_not_given2) {}
						}
					}
				}
				
				try { // max diameter
					Individual MD_maxDiameter = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxDiameter).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
					String val = MD_maxDiameter.getPropertyValue(prop_hasMeasurementValue).toString();
					if(val.indexOf("^") != -1)
						val = val.substring(0, val.indexOf("^"));
					float f_val = Float.parseFloat(val);
					if(f_val > exp_max_diameter)
						exp_max_diameter = f_val;
				} catch(Exception property_not_given) {
					OntClass c = getOntClassOf(indiv);
					boolean go_higher = true;
					while(c.hasSuperClass() && go_higher) {
						c = accountRestrictions(c.getSuperClass());
						if(!isCategoryOf(c, class_ProductionMachine, true)) {
							go_higher = false;
							break;
						}
						for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
							Individual inf_indiv = i.next().asIndividual();
							try {
								Individual inf_MD_maxDiameter = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxDiameter).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
								String inf_val = inf_MD_maxDiameter.getPropertyValue(prop_hasMeasurementValue).toString();
								if(inf_val.indexOf("^") != -1)
									inf_val = inf_val.substring(0, inf_val.indexOf("^"));
								float inf_f_val = Float.parseFloat(inf_val);
								if(inf_f_val > inf_max_diameter)
									inf_max_diameter = inf_f_val;
							} catch(Exception property_not_given2) {}
						}
					}
				}
				
				try { // min roughness
					Individual MD_minRoughness = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMinRoughness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
					String val = MD_minRoughness.getPropertyValue(prop_hasMeasurementValue).toString();
					if(val.indexOf("^") != -1)
						val = val.substring(0, val.indexOf("^"));
					float f_val = Float.parseFloat(val);
					if(f_val < exp_min_roughness || exp_min_roughness == -1)
						exp_min_roughness = f_val;
				} catch(Exception property_not_given) {
					OntClass c = getOntClassOf(indiv);
					boolean go_higher = true;
					while(c.hasSuperClass() && go_higher) {
						c = accountRestrictions(c.getSuperClass());
						if(!isCategoryOf(c, class_ProductionMachine, true)) {
							go_higher = false;
							break;
						}
						for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
							Individual inf_indiv = i.next().asIndividual();
							try {
								Individual inf_MD_minRoughness = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMinRoughness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
								String inf_val = inf_MD_minRoughness.getPropertyValue(prop_hasMeasurementValue).toString();
								if(inf_val.indexOf("^") != -1)
									inf_val = inf_val.substring(0, inf_val.indexOf("^"));
								float inf_f_val = Float.parseFloat(inf_val);
								if(inf_f_val < inf_min_roughness || inf_min_roughness == -1)
									inf_min_roughness = inf_f_val;
							} catch(Exception property_not_given2) {}
						}
					}
				}
				
				try { // max roughness
					Individual MD_maxRoughness = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxRoughness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
					String val = MD_maxRoughness.getPropertyValue(prop_hasMeasurementValue).toString();
					if(val.indexOf("^") != -1)
						val = val.substring(0, val.indexOf("^"));
					float f_val = Float.parseFloat(val);
					if(f_val > exp_max_roughness)
						exp_max_roughness = f_val;
				} catch(Exception property_not_given) {
					OntClass c = getOntClassOf(indiv);
					boolean go_higher = true;
					while(c.hasSuperClass() && go_higher) {
						c = accountRestrictions(c.getSuperClass());
						if(!isCategoryOf(c, class_ProductionMachine, true)) {
							go_higher = false;
							break;
						}
						for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
							Individual inf_indiv = i.next().asIndividual();
							try {
								Individual inf_MD_maxRoughness = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxRoughness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
								String inf_val = inf_MD_maxRoughness.getPropertyValue(prop_hasMeasurementValue).toString();
								if(inf_val.indexOf("^") != -1)
									inf_val = inf_val.substring(0, inf_val.indexOf("^"));
								float inf_f_val = Float.parseFloat(inf_val);
								if(inf_f_val > inf_max_roughness)
									inf_max_roughness = inf_f_val;
							} catch(Exception property_not_given2) {}
						}
					}
				}
				
				try { // min thickness
					Individual MD_minThickness = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMinThickness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
					String val = MD_minThickness.getPropertyValue(prop_hasMeasurementValue).toString();
					if(val.indexOf("^") != -1)
						val = val.substring(0, val.indexOf("^"));
					float f_val = Float.parseFloat(val);
					if(f_val < exp_min_thickness || exp_min_thickness == -1)
						exp_min_thickness = f_val;
				} catch(Exception property_not_given) {
					OntClass c = getOntClassOf(indiv);
					boolean go_higher = true;
					while(c.hasSuperClass() && go_higher) {
						c = accountRestrictions(c.getSuperClass());
						if(!isCategoryOf(c, class_ProductionMachine, true)) {
							go_higher = false;
							break;
						}
						for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
							Individual inf_indiv = i.next().asIndividual();
							try {
								Individual inf_MD_minThickness = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMinThickness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
								String inf_val = inf_MD_minThickness.getPropertyValue(prop_hasMeasurementValue).toString();
								if(inf_val.indexOf("^") != -1)
									inf_val = inf_val.substring(0, inf_val.indexOf("^"));
								float inf_f_val = Float.parseFloat(inf_val);
								if(inf_f_val < inf_min_thickness || inf_min_thickness == -1)
									inf_min_thickness = inf_f_val;
							} catch(Exception property_not_given2) {}
						}
					}
				}
				
				try { // max thickness
					Individual MD_maxThickness = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxThickness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
					String val = MD_maxThickness.getPropertyValue(prop_hasMeasurementValue).toString();
					if(val.indexOf("^") != -1)
						val = val.substring(0, val.indexOf("^"));
					float f_val = Float.parseFloat(val);
					if(f_val > exp_max_thickness)
						exp_max_thickness = f_val;
				} catch(Exception property_not_given) {
					OntClass c = getOntClassOf(indiv);
					boolean go_higher = true;
					while(c.hasSuperClass() && go_higher) {
						c = accountRestrictions(c.getSuperClass());
						if(!isCategoryOf(c, class_ProductionMachine, true)) {
							go_higher = false;
							break;
						}
						for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
							Individual inf_indiv = i.next().asIndividual();
							try {
								Individual inf_MD_maxThickness = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxThickness).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
								String inf_val = inf_MD_maxThickness.getPropertyValue(prop_hasMeasurementValue).toString();
								if(inf_val.indexOf("^") != -1)
									inf_val = inf_val.substring(0, inf_val.indexOf("^"));
								float inf_f_val = Float.parseFloat(inf_val);
								if(inf_f_val > inf_max_thickness)
									inf_max_thickness = inf_f_val;
							} catch(Exception property_not_given2) {}
						}
					}
				}
				
				try { // max weight
					Individual MD_maxWeight = ontology.getIndividual(ontology.getIndividual(indiv.getPropertyValue(prop_hasMaxWeight).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
					String val = MD_maxWeight.getPropertyValue(prop_hasMeasurementValue).toString();
					if(val.indexOf("^") != -1)
						val = val.substring(0, val.indexOf("^"));
					float f_val = Float.parseFloat(val);
					if(f_val > exp_max_weight)
						exp_max_weight = f_val;
				} catch(Exception property_not_given) {
					OntClass c = getOntClassOf(indiv);
					boolean go_higher = true;
					while(c.hasSuperClass() && go_higher) {
						c = accountRestrictions(c.getSuperClass());
						if(!isCategoryOf(c, class_ProductionMachine, true)) {
							go_higher = false;
							break;
						}
						for(ExtendedIterator<? extends OntResource> i = c.listInstances(true); i.hasNext(); ) {
							Individual inf_indiv = i.next().asIndividual();
							try {
								Individual inf_MD_maxWeight = ontology.getIndividual(ontology.getIndividual(inf_indiv.getPropertyValue(prop_hasMaxWeight).asResource().getURI()).getPropertyValue(prop_hasMeasurement).asResource().getURI());
								String inf_val = inf_MD_maxWeight.getPropertyValue(prop_hasMeasurementValue).toString();
								if(inf_val.indexOf("^") != -1)
									inf_val = inf_val.substring(0, inf_val.indexOf("^"));
								float inf_f_val = Float.parseFloat(inf_val);
								if(inf_f_val > inf_max_weight)
									inf_max_weight = inf_f_val;
							} catch(Exception property_not_given2) {}
						}
					}
				}
			}
			
			String inf_complexity = "Low - Medium";
			if(max_feed_drives > 3)
				inf_complexity = "High";
			
			if(inf_min_tolerance > exp_min_tolerance && exp_min_tolerance != -1)
				inf_min_tolerance = exp_min_tolerance;
			if(inf_max_tolerance < exp_max_tolerance)
				inf_max_tolerance = exp_max_tolerance;
			if(inf_min_length > exp_min_length && exp_min_length != -1)
				inf_min_length = exp_min_length;
			if(inf_max_length < exp_max_length)
				inf_max_length = exp_max_length;
			if(inf_min_diameter > exp_min_diameter && exp_min_diameter != -1)
				inf_min_diameter = exp_min_diameter;
			if(inf_max_diameter < exp_max_diameter)
				inf_max_diameter = exp_max_diameter;
			if(inf_min_roughness > exp_min_roughness && exp_min_roughness != -1)
				inf_min_roughness = exp_min_roughness;
			if(inf_max_roughness < exp_max_roughness)
				inf_max_roughness = exp_max_roughness;
			if(inf_min_thickness > exp_min_thickness && exp_min_thickness != -1)
				inf_min_thickness = exp_min_thickness;
			if(inf_max_thickness < exp_max_thickness)
				inf_max_thickness = exp_max_thickness;
			if(inf_max_weight < exp_max_weight)
				inf_max_weight = exp_max_weight;
			
			final String fin_exp_min_tolerance = ("" + exp_min_tolerance).replaceFirst("-1.0", ""), fin_exp_max_tolerance = ("" + exp_max_tolerance).replaceFirst("-1.0", "");
			final String fin_exp_min_length = ("" + exp_min_length).replaceFirst("-1.0", ""), fin_exp_max_length = ("" + exp_max_length).replaceFirst("-1.0", "");
			final String fin_exp_min_diameter = ("" + exp_min_diameter).replaceFirst("-1.0", ""), fin_exp_max_diameter = ("" + exp_max_diameter).replaceFirst("-1.0", "");
			final String fin_exp_min_roughness = ("" + exp_min_roughness).replaceFirst("-1.0", ""), fin_exp_max_roughness = ("" + exp_max_roughness).replaceFirst("-1.0", "");
			final String fin_exp_min_thickness = ("" + exp_min_thickness).replaceFirst("-1.0", ""), fin_exp_max_thickness = ("" + exp_max_thickness).replaceFirst("-1.0", "");
			final String fin_exp_max_weight = ("" + exp_max_weight).replaceFirst("-1.0", " - ");
			
			final String fin_inf_min_tolerance = ("" + inf_min_tolerance).replaceFirst("-1.0", fin_exp_min_tolerance), fin_inf_max_tolerance = ("" + inf_max_tolerance).replaceFirst("-1.0", fin_exp_max_tolerance);
			final String fin_inf_min_length = ("" + inf_min_length).replaceFirst("-1.0", fin_exp_min_length), fin_inf_max_length = ("" + inf_max_length).replaceFirst("-1.0", fin_exp_max_length);
			final String fin_inf_min_diameter = ("" + inf_min_diameter).replaceFirst("-1.0", fin_exp_min_diameter), fin_inf_max_diameter = ("" + inf_max_diameter).replaceFirst("-1.0", fin_exp_max_diameter);
			final String fin_inf_min_roughness = ("" + inf_min_roughness).replaceFirst("-1.0", fin_exp_min_roughness), fin_inf_max_roughness = ("" + inf_max_roughness).replaceFirst("-1.0", fin_exp_max_roughness);
			final String fin_inf_min_thickness = ("" + inf_min_thickness).replaceFirst("-1.0", fin_exp_min_thickness), fin_inf_max_thickness = ("" + inf_max_thickness).replaceFirst("-1.0", fin_exp_max_thickness);
			final String fin_inf_max_weight = ("" + inf_max_weight).replaceFirst("-1.0", fin_exp_max_weight);
			final String fin_inf_complexity = inf_complexity;
			
			String[] new_col = {fin_inf_min_tolerance + " - " + fin_inf_max_tolerance, fin_inf_min_length + " - " + fin_inf_max_length, fin_inf_min_diameter + " - " + fin_inf_max_diameter, fin_inf_min_roughness + " - " + fin_inf_max_roughness, fin_inf_min_thickness + " - " + fin_inf_max_thickness, fin_inf_max_weight, fin_inf_complexity};
			if(a == 0)
				dtm.addColumn(omw1.toString(), new_col);
			else
				dtm.addColumn(omw2.toString(), new_col);
		}
		
		getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[] {0, 75, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0};
		panel.setLayout(gbl_panel);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(20, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCompanyInformation = new JLabel("Compare Factories");
		lblCompanyInformation.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCompanyInformation.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblCompanyInformation, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 0, 1, 0, tab_color2));
		panel_2.setBackground(tab_color1);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(15, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.weightx = 1.0;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{654, 0};
		gbl_panel_2.rowHeights = new int[]{0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0};
		panel_2.setLayout(gbl_panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(15, 50, 15, 50);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_2.add(scrollPane, gbc_scrollPane);
		
		JTable table = new JTable();
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		table.setRowHeight(20);
		table.getTableHeader().setPreferredSize(new Dimension(0, 30));
		table.setModel(dtm);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.setAutoCreateColumnsFromModel(false);
		table.setDragEnabled(false);
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(12, 0, 17, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMenu.weightx = 0.5;
		gbc_btnMenu.insets = new Insets(0, 290, 0, 290);
		gbc_btnMenu.gridx = 0;
		gbc_btnMenu.gridy = 0;
		panel_3.add(btnMenu, gbc_btnMenu);
		btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	menuPage();
                return;
            }
        });
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	private void analyzePage4() {
		getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[] {0, 492, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(20, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCompanyInformation = new JLabel("Query Capability Models");
		lblCompanyInformation.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCompanyInformation.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblCompanyInformation, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 0, 1, 0, tab_color2));
		panel_2.setBackground(tab_color1);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(15, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.weightx = 1.0;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{654, 31, 247, 0};
		gbl_panel_2.rowHeights = new int[]{0, -3, 0, 0, -17, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblMaterialCapabilityFilters = new JLabel("Material capability filters:");
		GridBagConstraints gbc_lblMaterialCapabilityFilters = new GridBagConstraints();
		gbc_lblMaterialCapabilityFilters.insets = new Insets(10, 20, 5, 5);
		gbc_lblMaterialCapabilityFilters.fill = GridBagConstraints.BOTH;
		gbc_lblMaterialCapabilityFilters.gridx = 0;
		gbc_lblMaterialCapabilityFilters.gridy = 0;
		panel_2.add(lblMaterialCapabilityFilters, gbc_lblMaterialCapabilityFilters);
		
		JComboBox<IndividualWrapper> mat = new JComboBox<>();
		mat.setFont(new Font("Arial", Font.PLAIN, 12));
		mat.setForeground(Color.DARK_GRAY);
		mat.setBackground(Color.WHITE);
		mat.setUI(new ComboUI(mat, true, Color.WHITE));
		mat.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		mat.setFocusable(false);
		mat.setRenderer(new PromptComboBoxRenderer("Select material capability"));
		int mat_insert = 0;
		for(IndividualWrapper iw : mat_list) {
			mat.insertItemAt(iw, mat_insert);
			++mat_insert;
		}
		mat.setSelectedIndex(-1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(tab_color1);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.insets = new Insets(0, 12, 0, 6);
		gbc_panel_7.gridheight = 6;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 0;
		panel_2.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{-107, 0};
		gbl_panel_7.rowHeights = new int[]{1, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBackground(tab_color1);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(15, 0, 20, 0);
		gbc_separator.weightx = 1.0;
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 0;
		panel_7.add(separator, gbc_separator);
		
		JLabel lblQueryResults = new JLabel("Query results:");
		GridBagConstraints gbc_lblQueryResults = new GridBagConstraints();
		gbc_lblQueryResults.fill = GridBagConstraints.BOTH;
		gbc_lblQueryResults.insets = new Insets(10, 0, 5, 20);
		gbc_lblQueryResults.gridx = 2;
		gbc_lblQueryResults.gridy = 0;
		panel_2.add(lblQueryResults, gbc_lblQueryResults);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(tab_color1);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridheight = 5;
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 1;
		panel_2.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		DefaultListModel<MatchData> list_model_results = new DefaultListModel<>();
		JList<MatchData> list_results = new JList<>(list_model_results);
		list_results.setFont(new Font("Arial", Font.PLAIN, 12));
		list_results.setVisibleRowCount(6);
		list_results.setFocusable(false);
		list_results.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_results.setSelectionModel(new DefaultListSelectionModel() {
			@Override
			public void setSelectionInterval(int index0, int index1) {
				super.setSelectionInterval(-1, -1);
			}
			@Override
			public void addSelectionInterval(int index0, int index1) {
				super.setSelectionInterval(-1, -1);
			}
		});
		
		for(MatchData md : saved_match_data)
			list_model_results.addElement(md);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
    	scrollPane_2.getVerticalScrollBar().setUnitIncrement(10);
    	scrollPane_2.getHorizontalScrollBar().setUnitIncrement(10);
    	scrollPane_2.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
    	scrollPane_2.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
    	scrollPane_2.setOpaque(false);
    	scrollPane_2.setViewportView(list_results);
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 20, 20);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 0;
		panel_5.add(scrollPane_2, gbc_scrollPane_2);
		
		GridBagConstraints gbc_type = new GridBagConstraints();
		gbc_type.insets = new Insets(0, 20, 5, 5);
		gbc_type.fill = GridBagConstraints.BOTH;
		gbc_type.gridx = 0;
		gbc_type.gridy = 1;
		panel_2.add(mat, gbc_type);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(tab_color1);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(5, 20, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel_2.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		DefaultListModel<IndividualWrapper> list_model_mat = new DefaultListModel<>();
		JList<IndividualWrapper> list_mat = new JList<>(list_model_mat);
		list_mat.setFont(new Font("Arial", Font.PLAIN, 12));
		list_mat.setVisibleRowCount(6);
		list_mat.setFocusable(false);
		list_mat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		DefaultListModel<IndividualWrapper> list_model_proc = new DefaultListModel<>();
		JList<IndividualWrapper> list_proc = new JList<>(list_model_proc);
		list_proc.setFont(new Font("Arial", Font.PLAIN, 12));
		list_proc.setVisibleRowCount(6);
		list_proc.setFocusable(false);
		list_proc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
    	scrollPane_1.getVerticalScrollBar().setUnitIncrement(10);
    	scrollPane_1.getHorizontalScrollBar().setUnitIncrement(10);
    	scrollPane_1.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
    	scrollPane_1.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
    	scrollPane_1.setOpaque(false);
    	scrollPane_1.setViewportView(list_mat);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 10);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		JButton btnAdd_1 = new JButton("Add");
		GridBagConstraints gbc_btnAdd_1 = new GridBagConstraints();
		gbc_btnAdd_1.fill = GridBagConstraints.BOTH;
		gbc_btnAdd_1.gridx = 1;
		gbc_btnAdd_1.gridy = 0;
		panel_1.add(btnAdd_1, gbc_btnAdd_1);
		btnAdd_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAdd_1.setUI(new ButtonUI2());
		btnAdd_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(mat.getSelectedIndex() != -1) {
	            	boolean exists = false;
	            	for(int x = 0; x < list_model_mat.size(); ++x) {
	            		if(list_model_mat.getElementAt(x).toString().equals(((IndividualWrapper)mat.getSelectedItem()).toString())) {
	            			exists = true;
	            			x = list_model_mat.size();
	            		}
	            	}
	            	if(!exists) {
	            		IndividualWrapper added = (IndividualWrapper)mat.getSelectedItem();
	            		list_model_mat.addElement(added);
	            		String added_string = added.toString().toLowerCase();
	            		for(int x = 0; x < list_model_results.size(); ++x) {
	            			boolean filtered = false;
	            			for(int y = 0; y < list_model_results.getElementAt(x).getMaterials().size(); ++y) {
	            				if(list_model_results.getElementAt(x).getMaterials().get(y).toString().toLowerCase().equals(added_string)) {
	            					filtered = true;
	            					break;
	            				}
	            			}
	            			if(!filtered)
	            				list_model_results.removeElementAt(x);
	            		}
	            	}
	            	mat.setSelectedIndex(-1);
            	}
            }
        });
		
		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRemove_1.setUI(new ButtonUI2());
		GridBagConstraints gbc_btnRemove_1 = new GridBagConstraints();
		gbc_btnRemove_1.anchor = GridBagConstraints.NORTH;
		gbc_btnRemove_1.insets = new Insets(10, 0, 0, 0);
		gbc_btnRemove_1.gridx = 1;
		gbc_btnRemove_1.gridy = 1;
		panel_1.add(btnRemove_1, gbc_btnRemove_1);
		btnRemove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list_mat.getSelectedIndex() != -1)
					list_model_mat.remove(list_mat.getSelectedIndex());
				list_model_results.clear();
        		for(MatchData md : saved_match_data) {
        			boolean filtered_mat = list_model_mat.size() == 0;
        			for(int x = 0; x < list_model_mat.size(); ++x) {
        				String mat_required = list_model_mat.getElementAt(x).toString().toLowerCase();
        				boolean found = false;
        				for(int y = 0; y < md.getMaterials().size(); ++y) {
        					if(md.getMaterials().get(y).toString().toLowerCase().equals(mat_required)) {
        						found = true;
        						break;
        					}
        				}
        				if(!found)
        					break;
        				else if(x == list_model_mat.size() - 1)
        					filtered_mat = true;
        			}
        			if(filtered_mat) {
        				boolean filtered_proc = list_model_proc.size() == 0;
            			for(int x = 0; x < list_model_proc.size(); ++x) {
            				String proc_required = list_model_proc.getElementAt(x).toString().toLowerCase();
            				boolean found = false;
            				for(int y = 0; y < md.getFunctions().size(); ++y) {
            					if(md.getFunctions().get(y).toString().toLowerCase().equals(proc_required)) {
            						found = true;
            						break;
            					}
            				}
            				if(!found)
            					break;
            				else if(x == list_model_proc.size() - 1)
            					filtered_proc = true;
            			}
            			if(filtered_proc)
            				list_model_results.addElement(md);
        			}
        		}
			}
		});
		
		JLabel lblProcessCapabilityFilters = new JLabel("Process capability filters:");
		GridBagConstraints gbc_lblProcessCapabilityFilters = new GridBagConstraints();
		gbc_lblProcessCapabilityFilters.insets = new Insets(10, 20, 5, 5);
		gbc_lblProcessCapabilityFilters.fill = GridBagConstraints.BOTH;
		gbc_lblProcessCapabilityFilters.gridx = 0;
		gbc_lblProcessCapabilityFilters.gridy = 3;
		panel_2.add(lblProcessCapabilityFilters, gbc_lblProcessCapabilityFilters);
		
		JComboBox<IndividualWrapper> proc = new JComboBox<>();
		proc.setFont(new Font("Arial", Font.PLAIN, 12));
		proc.setForeground(Color.DARK_GRAY);
		proc.setBackground(Color.WHITE);
		proc.setUI(new ComboUI(proc, true, Color.WHITE));
		proc.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		proc.setFocusable(false);
		proc.setRenderer(new PromptComboBoxRenderer("Select process capability"));
		int proc_insert = 0;
		for(IndividualWrapper iw : proc_list) {
			proc.insertItemAt(iw, proc_insert);
			++proc_insert;
		}
		proc.setSelectedIndex(-1);
		GridBagConstraints gbc_proc = new GridBagConstraints();
		gbc_proc.insets = new Insets(0, 20, 5, 5);
		gbc_proc.fill = GridBagConstraints.BOTH;
		gbc_proc.gridx = 0;
		gbc_proc.gridy = 4;
		panel_2.add(proc, gbc_proc);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(tab_color1);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(5, 20, 20, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 5;
		panel_2.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 1.0};
		panel_6.setLayout(gbl_panel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
    	scrollPane.getVerticalScrollBar().setUnitIncrement(10);
    	scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
    	scrollPane.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
    	scrollPane.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
    	scrollPane.setOpaque(false);
    	scrollPane.setViewportView(list_proc);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_6.add(scrollPane, gbc_scrollPane);
		
		JButton btnAdd = new JButton("Add");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 0;
		panel_6.add(btnAdd, gbc_btnAdd);
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAdd.setUI(new ButtonUI2());
		btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(proc.getSelectedIndex() != -1) {
	            	boolean exists = false;
	            	for(int x = 0; x < list_model_proc.size(); ++x) {
	            		if(list_model_proc.getElementAt(x).toString().equals(((IndividualWrapper)proc.getSelectedItem()).toString())) {
	            			exists = true;
	            			x = list_model_proc.size();
	            		}
	            	}
	            	if(!exists) {
	            		IndividualWrapper added = (IndividualWrapper)proc.getSelectedItem();
	            		list_model_proc.addElement(added);
	            		String added_string = added.toString().toLowerCase();
	            		for(int x = 0; x < list_model_results.size(); ++x) {
	            			boolean filtered = false;
	            			for(int y = 0; y < list_model_results.getElementAt(x).getFunctions().size(); ++y) {
	            				if(list_model_results.getElementAt(x).getFunctions().get(y).toString().toLowerCase().equals(added_string)) {
	            					filtered = true;
	            					break;
	            				}
	            			}
	            			if(!filtered)
	            				list_model_results.removeElementAt(x);
	            		}
	            	}
	            	proc.setSelectedIndex(-1);
            	}
            }
        });
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRemove.setUI(new ButtonUI2());
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(10, 0, 0, 0);
		gbc_btnRemove.anchor = GridBagConstraints.NORTH;
		gbc_btnRemove.gridx = 1;
		gbc_btnRemove.gridy = 1;
		panel_6.add(btnRemove, gbc_btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list_proc.getSelectedIndex() != -1)
					list_model_proc.remove(list_proc.getSelectedIndex());
				list_model_results.clear();
        		for(MatchData md : saved_match_data) {
        			boolean filtered_mat = list_model_mat.size() == 0;
        			for(int x = 0; x < list_model_mat.size(); ++x) {
        				String mat_required = list_model_mat.getElementAt(x).toString().toLowerCase();
        				boolean found = false;
        				for(int y = 0; y < md.getMaterials().size(); ++y) {
        					if(md.getMaterials().get(y).toString().toLowerCase().equals(mat_required)) {
        						found = true;
        						break;
        					}
        				}
        				if(!found)
        					break;
        				else if(x == list_model_mat.size() - 1)
        					filtered_mat = true;
        			}
        			if(filtered_mat) {
        				boolean filtered_proc = list_model_proc.size() == 0;
            			for(int x = 0; x < list_model_proc.size(); ++x) {
            				String proc_required = list_model_proc.getElementAt(x).toString().toLowerCase();
            				boolean found = false;
            				for(int y = 0; y < md.getFunctions().size(); ++y) {
            					if(md.getFunctions().get(y).toString().toLowerCase().equals(proc_required)) {
            						found = true;
            						break;
            					}
            				}
            				if(!found)
            					break;
            				else if(x == list_model_proc.size() - 1)
            					filtered_proc = true;
            			}
            			if(filtered_proc)
            				list_model_results.addElement(md);
        			}
        		}
			}
		});
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(12, 0, 17, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMenu.weightx = 0.5;
		gbc_btnMenu.insets = new Insets(0, 290, 0, 290);
		gbc_btnMenu.gridx = 0;
		gbc_btnMenu.gridy = 0;
		panel_3.add(btnMenu, gbc_btnMenu);
		btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	menuPage();
                return;
            }
        });
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	private void matchPage1() {
		getContentPane().removeAll();
		
		company = new Company();
		equipment_individuals = new ArrayList<>();
		capability_individuals = new ArrayList<>();
		work_order = new WorkOrder();
		thesaurus_tree = new JTree();
		thesaurus_tree.setModel(new DefaultTreeModel(thesaurus_tree_root));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnBuildNewWorkOrder = new JButton("Create New Work Order");
		btnBuildNewWorkOrder.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBuildNewWorkOrder = new GridBagConstraints();
		gbc_btnBuildNewWorkOrder.weightx = 1.0;
		gbc_btnBuildNewWorkOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuildNewWorkOrder.insets = new Insets(105, 225, 10, 225);
		gbc_btnBuildNewWorkOrder.gridx = 0;
		gbc_btnBuildNewWorkOrder.gridy = 0;
		panel.add(btnBuildNewWorkOrder, gbc_btnBuildNewWorkOrder);
		btnBuildNewWorkOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                companyPage(false);
                return;
            }
        });
		
		JButton btnImportWorkOrder = new JButton("Import Work Order");
		btnImportWorkOrder.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnImportWorkOrder = new GridBagConstraints();
		gbc_btnImportWorkOrder.insets = new Insets(0, 225, 10, 225);
		gbc_btnImportWorkOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImportWorkOrder.gridx = 0;
		gbc_btnImportWorkOrder.gridy = 2;
		panel.add(btnImportWorkOrder, gbc_btnImportWorkOrder);
		btnImportWorkOrder.addActionListener(new ActionListener() {
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
						fc.setDialogTitle("Import Work Order");
						fc.setMultiSelectionEnabled(false);
						if(import_path.equals("\\"))
							import_path = export_path;
						fc.setCurrentDirectory(new File(import_path));
						JComboBox open_combo = (JComboBox)(fc.getComponent(0).getAccessibleContext().getAccessibleChild(2));
						open_combo.setFont(new Font("Arial", Font.PLAIN, 12));
						open_combo.setUI(new ComboUI(open_combo, true, tab_color1));
						open_combo.setBorder(new LineBorder(Color.GRAY));
						open_combo.setBackground(Color.WHITE);
						configureFileChooserUI(fc.getComponents(), false, 2);
						
						result = fc.showOpenDialog(frame);
						if(result == 0)
						{
							File selected_file = fc.getSelectedFile();
							if(selected_file.exists())
							{
								int f = 0;
								try {
									import_path = selected_file.getCanonicalPath();
									InputStream in = FileManager.get().open("file:///" + import_path.replace("\\", "/"));
									if(in == null)
							            throw new IllegalArgumentException();
									OntModel model = ModelFactory.createOntologyModel(modelSpec);
									OntDocumentManager model_dm = model.getDocumentManager();
									model_dm.addAltEntry("http://infoneer.txstate.edu/ontology/MSDL.owl", "file:information/MSDL.owl");
									model.read(in, "RDF/XML");
									setImportedInfo(model, 2);
									String name_save = work_order.getPartName() + " Work Order";
									OntModel exp = generateFinalExport(2, false, "", "", "", "", "", "", "", "", "", "", "", "", "", "", work_order.getConcepts());
									for(int x = 0; x < saved_work_orders.size(); x++) {
										if(saved_work_orders.get(x).toString().equals(name_save)) {
											saved_work_orders.remove(x);
											x = saved_work_orders.size();
										}
									}
				                	saved_work_orders.add(new OntModelWrapper(exp, name_save));
				                	in.close();
								} catch(Exception e1) {
									f = 1;
									JOptionPane.showMessageDialog(frame, new JLabel("Unable to import.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
								}
								if(f == 0)
									matchPage2();
							}
						}
				    }
				});	
			
			}
		});
		
		JButton btnEditExistingWorkOrder = new JButton("Edit Saved Work Order");
		btnEditExistingWorkOrder.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnEditExistingWorkOrder = new GridBagConstraints();
		gbc_btnEditExistingWorkOrder.weightx = 1.0;
		gbc_btnEditExistingWorkOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditExistingWorkOrder.insets = new Insets(0, 225, 10, 225);
		gbc_btnEditExistingWorkOrder.gridx = 0;
		gbc_btnEditExistingWorkOrder.gridy = 1;
		panel.add(btnEditExistingWorkOrder, gbc_btnEditExistingWorkOrder);
		btnEditExistingWorkOrder.addActionListener(new ActionListener() {
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
						JLabel message_save = new JLabel("Select a work order to edit:", SwingConstants.LEFT);
						message_save.setFont(new Font("Arial", Font.PLAIN, 12));
						message_panel.add(message_save);
						save_panel.add(message_panel, gbc_message_save);
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<OntModelWrapper> list_model_save = new DefaultListModel<>();
						for(OntModelWrapper omw : saved_work_orders) {
							list_model_save.addElement(omw);
						}
						
						JList<OntModelWrapper> list_save = new JList<>(list_model_save);
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
				    	
				    	result = JOptionPane.showOptionDialog(frame, save_panel, "Open Work Order", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Open", "Cancel"}, null);
			            switch(result) {
			                case JOptionPane.OK_OPTION:
			                	if(list_save.getSelectedValue() != null) {
			                		OntModel model = list_save.getSelectedValue().getModel();
			                		setImportedInfo(model, 2);
			                		matchPage2();
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
		
		JButton btnSupply = new JButton("Build Supply Chains");
		btnSupply.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnSupply = new GridBagConstraints();
		gbc_btnSupply.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupply.insets = new Insets(15, 225, 10, 225);
		gbc_btnSupply.gridx = 0;
		gbc_btnSupply.gridy = 3;
		panel.add(btnSupply, gbc_btnSupply);
		btnSupply.addActionListener(new ActionListener() {
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
						JLabel message_save = new JLabel("Select a work order:", SwingConstants.LEFT);
						message_save.setFont(new Font("Arial", Font.PLAIN, 12));
						message_panel.add(message_save);
						save_panel.add(message_panel, gbc_message_save);
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<OntModelWrapper> list_model_save = new DefaultListModel<>();
						for(OntModelWrapper omw : saved_work_orders) {
							list_model_save.addElement(omw);
						}
						
						JList<OntModelWrapper> list_save = new JList<>(list_model_save);
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
				    	
				    	result = JOptionPane.showOptionDialog(frame, save_panel, "Open Work Order", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Open", "Cancel"}, null);
			            switch(result) {
			                case JOptionPane.OK_OPTION:
			                	if(list_save.getSelectedValue() != null) {
			                		if(saved_match_data.size() == 0)
			                			JOptionPane.showMessageDialog(frame, new JLabel("<html><center>There are no capability models saved.</html>", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
			                		else {
			                			OntModel model = list_save.getSelectedValue().getModel();
				                		setImportedInfo(model, 2);
				                		matchPage4(false);
			                		}
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
		gbc_btnBack.insets = new Insets(-220, 290, 0, 290);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 4;
		panel.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuPage();
                return;
            }
        });
		
		JLabel build_pic = new JLabel(new ImageIcon(getClass().getResource("/images/match.png")));
		GridBagConstraints gbc_buildPic = new GridBagConstraints();
		gbc_buildPic.fill = GridBagConstraints.HORIZONTAL;
		gbc_buildPic.insets = new Insets(-335, 15, 0, 0);
		gbc_buildPic.gridx = 0;
		gbc_buildPic.gridy = 5;
		panel.add(build_pic, gbc_buildPic);
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	private void matchPage2() {
		getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 407, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(20, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCompanyInformation = new JLabel("Work Order Information");
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
		gbl_panel_2.columnWidths = new int[]{149, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 31};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblPart = new JLabel("* Part name:");
		lblPart.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPart = new GridBagConstraints();
		gbc_lblPart.insets = new Insets(15, 35, 5, 15);
		gbc_lblPart.anchor = GridBagConstraints.EAST;
		gbc_lblPart.gridx = 0;
		gbc_lblPart.gridy = 0;
		panel_2.add(lblPart, gbc_lblPart);
		
		JTextField part = new JTextField();
		part.setText(work_order.getPartName());
		GridBagConstraints gbc_part = new GridBagConstraints();
		gbc_part.insets = new Insets(15, 0, 5, 80);
		gbc_part.fill = GridBagConstraints.BOTH;
		gbc_part.gridx = 1;
		gbc_part.gridy = 0;
		panel_2.add(part, gbc_part);
		part.setColumns(10);
		part.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	work_order.setPartName(part.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblVolume = new JLabel("* Production volume:");
		lblVolume.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblVolume = new GridBagConstraints();
		gbc_lblVolume.anchor = GridBagConstraints.EAST;
		gbc_lblVolume.insets = new Insets(5, 0, 5, 15);
		gbc_lblVolume.gridx = 0;
		gbc_lblVolume.gridy = 1;
		panel_2.add(lblVolume, gbc_lblVolume);
		
		JComboBox<String> volume = new JComboBox<>();
		volume.setFont(new Font("Arial", Font.PLAIN, 12));
		volume.setForeground(Color.DARK_GRAY);
		volume.setBackground(Color.WHITE);
		volume.setUI(new ComboUI(volume, true, Color.WHITE));
		volume.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		volume.setFocusable(false);
		volume.setRenderer(new PromptComboBoxRenderer("Select production volume"));
		volume.insertItemAt("Low", 0);
		volume.insertItemAt("Medium", 1);
		volume.insertItemAt("High", 2);
		volume.setSelectedIndex(-1);
		String volume_string = work_order.getProductionVolume();
		for(int x = 0; x < volume.getModel().getSize(); ++x) {
			if(volume.getItemAt(x).equals(volume_string)) {
				volume.setSelectedIndex(x);
				break;
			}
		}
		GridBagConstraints gbc_volume = new GridBagConstraints();
		gbc_volume.insets = new Insets(5, 0, 5, 80);
		gbc_volume.fill = GridBagConstraints.BOTH;
		gbc_volume.gridx = 1;
		gbc_volume.gridy = 1;
		panel_2.add(volume, gbc_volume);
		volume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	work_order.setProductionVolume((String)volume.getSelectedItem());
            }
        });
		
		JLabel lblTolerance = new JLabel("Lower tolerance (in):");
		lblTolerance.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTolerance = new GridBagConstraints();
		gbc_lblTolerance.anchor = GridBagConstraints.EAST;
		gbc_lblTolerance.insets = new Insets(5, 0, 5, 15);
		gbc_lblTolerance.gridx = 0;
		gbc_lblTolerance.gridy = 2;
		panel_2.add(lblTolerance, gbc_lblTolerance);
		
		JTextField lower_tolerance = new JTextField();
		lower_tolerance.setText(work_order.getLowerTolerance());
		GridBagConstraints gbc_tolerance = new GridBagConstraints();
		gbc_tolerance.insets = new Insets(5, 0, 5, 80);
		gbc_tolerance.fill = GridBagConstraints.BOTH;
		gbc_tolerance.gridx = 1;
		gbc_tolerance.gridy = 2;
		panel_2.add(lower_tolerance, gbc_tolerance);
		lower_tolerance.setColumns(10);
		lower_tolerance.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	work_order.setLowerTolerance(lower_tolerance.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblUpperTolerance = new JLabel("Upper tolerance (in):");
		lblUpperTolerance.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblUpperTolerance = new GridBagConstraints();
		gbc_lblUpperTolerance.anchor = GridBagConstraints.EAST;
		gbc_lblUpperTolerance.insets = new Insets(5, 0, 5, 15);
		gbc_lblUpperTolerance.gridx = 0;
		gbc_lblUpperTolerance.gridy = 3;
		panel_2.add(lblUpperTolerance, gbc_lblUpperTolerance);
		
		JTextField upper_tolerance = new JTextField();
		upper_tolerance.setText(work_order.getUpperTolerance());
		GridBagConstraints gbc_upper_tolerance = new GridBagConstraints();
		gbc_upper_tolerance.insets = new Insets(5, 0, 5, 80);
		gbc_upper_tolerance.fill = GridBagConstraints.BOTH;
		gbc_upper_tolerance.gridx = 1;
		gbc_upper_tolerance.gridy = 3;
		panel_2.add(upper_tolerance, gbc_upper_tolerance);
		upper_tolerance.setColumns(10);
		upper_tolerance.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	work_order.setUpperTolerance(upper_tolerance.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblDiameter = new JLabel("Max diameter (in):");
		lblDiameter.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDiameter = new GridBagConstraints();
		gbc_lblDiameter.anchor = GridBagConstraints.EAST;
		gbc_lblDiameter.insets = new Insets(5, 0, 5, 15);
		gbc_lblDiameter.gridx = 0;
		gbc_lblDiameter.gridy = 4;
		panel_2.add(lblDiameter, gbc_lblDiameter);
		
		JTextField diameter = new JTextField();
		diameter.setText(work_order.getMaxDiameter());
		GridBagConstraints gbc_diameter = new GridBagConstraints();
		gbc_diameter.insets = new Insets(5, 0, 5, 80);
		gbc_diameter.fill = GridBagConstraints.BOTH;
		gbc_diameter.gridx = 1;
		gbc_diameter.gridy = 4;
		panel_2.add(diameter, gbc_diameter);
		diameter.setColumns(10);
		diameter.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	work_order.setMaxDiameter(diameter.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblLength = new JLabel("Max length (in):");
		lblLength.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblLength = new GridBagConstraints();
		gbc_lblLength.anchor = GridBagConstraints.EAST;
		gbc_lblLength.insets = new Insets(5, 0, 5, 15);
		gbc_lblLength.gridx = 0;
		gbc_lblLength.gridy = 5;
		panel_2.add(lblLength, gbc_lblLength);
		
		JTextField length = new JTextField();
		length.setText(work_order.getMaxLength());
		GridBagConstraints gbc_length = new GridBagConstraints();
		gbc_length.insets = new Insets(5, 0, 5, 80);
		gbc_length.fill = GridBagConstraints.BOTH;
		gbc_length.gridx = 1;
		gbc_length.gridy = 5;
		panel_2.add(length, gbc_length);
		length.setColumns(10);
		length.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	work_order.setMaxLength(length.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblSurface = new JLabel("Surf. roughness (µin):");
		lblSurface.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSurface = new GridBagConstraints();
		gbc_lblSurface.anchor = GridBagConstraints.EAST;
		gbc_lblSurface.insets = new Insets(5, 0, 5, 15);
		gbc_lblSurface.gridx = 0;
		gbc_lblSurface.gridy = 6;
		panel_2.add(lblSurface, gbc_lblSurface);
		
		JTextField surface = new JTextField();
		surface.setText(work_order.getSurfaceRoughness());
		GridBagConstraints gbc_surface = new GridBagConstraints();
		gbc_surface.insets = new Insets(5, 0, 5, 80);
		gbc_surface.fill = GridBagConstraints.BOTH;
		gbc_surface.gridx = 1;
		gbc_surface.gridy = 6;
		panel_2.add(surface, gbc_surface);
		surface.setColumns(10);
		surface.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	work_order.setSurfaceRoughness(surface.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblWall = new JLabel("Min wall thickness (in):");
		lblWall.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblWall = new GridBagConstraints();
		gbc_lblWall.anchor = GridBagConstraints.EAST;
		gbc_lblWall.insets = new Insets(5, 0, 5, 15);
		gbc_lblWall.gridx = 0;
		gbc_lblWall.gridy = 7;
		panel_2.add(lblWall, gbc_lblWall);
		
		JTextField wall = new JTextField();
		wall.setText(work_order.getMinWallThickness());
		GridBagConstraints gbc_wall = new GridBagConstraints();
		gbc_wall.insets = new Insets(5, 0, 5, 80);
		gbc_wall.fill = GridBagConstraints.BOTH;
		gbc_wall.gridx = 1;
		gbc_wall.gridy = 7;
		panel_2.add(wall, gbc_wall);
		wall.setColumns(10);
		wall.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	work_order.setMinWallThickness(wall.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblWeight = new JLabel("Part weight (lb):");
		lblWeight.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblWeight = new GridBagConstraints();
		gbc_lblWeight.anchor = GridBagConstraints.EAST;
		gbc_lblWeight.insets = new Insets(5, 0, 5, 15);
		gbc_lblWeight.gridx = 0;
		gbc_lblWeight.gridy = 8;
		panel_2.add(lblWeight, gbc_lblWeight);
		
		JTextField weight = new JTextField();
		weight.setText(work_order.getPartWeight());
		GridBagConstraints gbc_weight = new GridBagConstraints();
		gbc_weight.insets = new Insets(5, 0, 5, 80);
		gbc_weight.fill = GridBagConstraints.BOTH;
		gbc_weight.gridx = 1;
		gbc_weight.gridy = 8;
		panel_2.add(weight, gbc_weight);
		weight.setColumns(10);
		weight.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent e) {
            	work_order.setPartWeight(weight.getText());
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
		
		JLabel lblMat = new JLabel("* Material capability:");
		lblMat.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMat = new GridBagConstraints();
		gbc_lblMat.insets = new Insets(5, 0, 5, 15);
		gbc_lblMat.anchor = GridBagConstraints.EAST;
		gbc_lblMat.gridx = 0;
		gbc_lblMat.gridy = 9;
		panel_2.add(lblMat, gbc_lblMat);
		
		JComboBox<IndividualWrapper> mat = new JComboBox<>();
		mat.setFont(new Font("Arial", Font.PLAIN, 12));
		mat.setForeground(Color.DARK_GRAY);
		mat.setBackground(Color.WHITE);
		mat.setUI(new ComboUI(mat, true, Color.WHITE));
		mat.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		mat.setFocusable(false);
		mat.setRenderer(new PromptComboBoxRenderer("Select material capability"));
		int mat_insert = 0;
		for(IndividualWrapper iw : mat_list) {
			mat.insertItemAt(iw, mat_insert);
			++mat_insert;
		}
		mat.setSelectedIndex(-1);
		String mat_string = work_order.getMaterialCapability().toString();
		for(int x = 0; x < mat_list.size(); x++) {
			if(mat_string.equals(mat_list.get(x).toString())) {
				mat.setSelectedIndex(x);
				x = mat_list.size();
			}
		}
		GridBagConstraints gbc_type = new GridBagConstraints();
		gbc_type.insets = new Insets(5, 0, 5, 80);
		gbc_type.fill = GridBagConstraints.BOTH;
		gbc_type.gridx = 1;
		gbc_type.gridy = 9;
		panel_2.add(mat, gbc_type);
		mat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	work_order.setMaterialCapability((IndividualWrapper)mat.getSelectedItem());
            }
        });
		
		JLabel lblProc = new JLabel("* Process capabilities:");
		lblProc.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblProc = new GridBagConstraints();
		gbc_lblProc.anchor = GridBagConstraints.EAST;
		gbc_lblProc.insets = new Insets(5, 0, 5, 15);
		gbc_lblProc.gridx = 0;
		gbc_lblProc.gridy = 10;
		panel_2.add(lblProc, gbc_lblProc);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(5, 0, 5, 80);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 10;
		panel_2.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0};
		panel_5.setLayout(gbl_panel_5);
		
		JComboBox<IndividualWrapper> proc = new JComboBox<>();
		proc.setFont(new Font("Arial", Font.PLAIN, 12));
		proc.setForeground(Color.DARK_GRAY);
		proc.setBackground(Color.WHITE);
		proc.setUI(new ComboUI(proc, true, Color.WHITE));
		proc.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		proc.setFocusable(false);
		proc.setRenderer(new PromptComboBoxRenderer("Select process capability"));
		int proc_insert = 0;
		for(IndividualWrapper iw : proc_list) {
			proc.insertItemAt(iw, proc_insert);
			++proc_insert;
		}
		proc.setSelectedIndex(-1);
		GridBagConstraints gbc_proc = new GridBagConstraints();
		gbc_proc.fill = GridBagConstraints.BOTH;
		gbc_proc.gridx = 0;
		gbc_proc.gridy = 0;
		panel_5.add(proc, gbc_proc);
		
		DefaultListModel<IndividualWrapper> list_model_proc = new DefaultListModel<>();
		JList<IndividualWrapper> list_proc = new JList<>(list_model_proc);
		list_proc.setFont(new Font("Arial", Font.PLAIN, 12));
		list_proc.setVisibleRowCount(6);
		list_proc.setFocusable(false);
		list_proc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for(IndividualWrapper iw : work_order.getProcessCapabilities()) {
			list_model_proc.addElement(iw);
		}
		list_model_proc.addListDataListener(new ListDataListener() {
			public void intervalRemoved(ListDataEvent e) {
				ArrayList<IndividualWrapper> final_proc = new ArrayList<>();
        		for(int x = 0; x < list_model_proc.size(); ++x)
        			final_proc.add(list_model_proc.getElementAt(x));
            	work_order.setProcessCapabilities(final_proc);
			}
			public void intervalAdded(ListDataEvent e) {
				ArrayList<IndividualWrapper> final_proc = new ArrayList<>();
        		for(int x = 0; x < list_model_proc.size(); ++x)
        			final_proc.add(list_model_proc.getElementAt(x));
            	work_order.setProcessCapabilities(final_proc);
			}
			public void contentsChanged(ListDataEvent e) {}
        });
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(5, 0, 0, 80);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 11;
		panel_2.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    	scrollPane.getVerticalScrollBar().setUnitIncrement(10);
    	scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
    	scrollPane.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
    	scrollPane.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
    	scrollPane.setOpaque(false);
    	scrollPane.setViewportView(list_proc);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_6.add(scrollPane, gbc_scrollPane);
		
		JButton btnAdd = new JButton("Add");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.NORTH;
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 0;
		panel_6.add(btnAdd, gbc_btnAdd);
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(proc.getSelectedIndex() != -1) {
	            	boolean exists = false;
	            	for(int x = 0; x < list_model_proc.size(); ++x) {
	            		if(list_model_proc.getElementAt(x).toString().equals(((IndividualWrapper)proc.getSelectedItem()).toString())) {
	            			exists = true;
	            			x = list_model_proc.size();
	            		}
	            	}
	            	if(!exists)
	            		list_model_proc.addElement((IndividualWrapper)proc.getSelectedItem());
	            	proc.setSelectedIndex(-1);
            	}
            }
        });
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(10, 0, 0, 0);
		gbc_btnRemove.anchor = GridBagConstraints.NORTH;
		gbc_btnRemove.gridx = 1;
		gbc_btnRemove.gridy = 1;
		panel_6.add(btnRemove, gbc_btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list_proc.getSelectedIndex() != -1)
					list_model_proc.remove(list_proc.getSelectedIndex());
			}
		});
		
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
            	companyPage(false);
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
            	if(work_order.getPartName().equals("") || work_order.getProductionVolume().equals("") || work_order.getMaterialCapability().getIndividual() == null || work_order.getProcessCapabilities().size() < 1)
        			JOptionPane.showMessageDialog(frame, new JLabel("Please enter all required fields before continuing.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
            	else {
            		matchPage3();
                    return;
            	}
            }
        });
		
		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	private void matchPage3() {
		getContentPane().removeAll();

		DefaultListModel<String> work_order_list_model = new DefaultListModel<>();
		for(String c : work_order.getConcepts())
			work_order_list_model.addElement(c);
		JList<String> work_order_list = new JList<>(work_order_list_model);
		work_order_list.setFont(new Font("Arial", Font.PLAIN, 12));
		work_order_list.setFocusable(false);
		
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
		gbl_panel_1.columnWidths = new int[]{500, 21, 500, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 191, 0, 228, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 0;
		panel_1.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{500, 0};
		gbl_panel_7.rowHeights = new int[]{27, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_13.setBackground(tab_color1);
		panel_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblUntitledWork;
		int work_order_name_max = 38;
		if(work_order.getPartName().length() > work_order_name_max)
			lblUntitledWork = new JLabel(work_order.getPartName().substring(0, work_order_name_max - 2) + "...");
		else if(work_order.getPartName().equals(""))
			lblUntitledWork = new JLabel("[ Untitled Work Order ]");
		else
			lblUntitledWork = new JLabel(work_order.getPartName());
		lblUntitledWork.setFont(new Font("Consolas", Font.PLAIN, 12));
		panel_13.add(lblUntitledWork);
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.insets = new Insets(12, 12, 12, 0);
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 0;
		gbc_panel_13.gridy = 0;
		panel_7.add(panel_13, gbc_panel_13);
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 5, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 2;
		gbc_panel_9.gridy = 0;
		panel_1.add(panel_9, gbc_panel_9);
		
		JPanel panel_25 = new JPanel();
		GridBagConstraints gbc_panel_25 = new GridBagConstraints();
		gbc_panel_25.insets = new Insets(0, 0, 5, 5);
		gbc_panel_25.fill = GridBagConstraints.BOTH;
		gbc_panel_25.gridx = 0;
		gbc_panel_25.gridy = 1;
		panel_1.add(panel_25, gbc_panel_25);
		
		JLabel lblNewLabel = new JLabel("Capability Features:");
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
		
		JLabel lblAddedIndividuals = new JLabel("Added Capability Features:");
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
		gbc_panel_4.gridheight = 3;
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
		
		thesaurus_tree.setFont(new Font("Arial", Font.PLAIN, 12));
		thesaurus_tree.setToggleClickCount(2);
		thesaurus_tree.setSelectionModel(new RootTreeSelectionModel(thesaurus_tree));
		thesaurus_tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    	panel_15.add(thesaurus_tree);
		
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		panel_10.add(scrollPane);
		panel_4.setLayout(gl_panel_4);
		
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
		
		JScrollPane work_order_scrollPane_1 = new JScrollPane();
		work_order_scrollPane_1.setBorder(BorderFactory.createEmptyBorder());
		work_order_scrollPane_1.getVerticalScrollBar().setUnitIncrement(10);
		work_order_scrollPane_1.getHorizontalScrollBar().setUnitIncrement(10);
		work_order_scrollPane_1.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		work_order_scrollPane_1.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		work_order_scrollPane_1.setOpaque(false);
		
		JPanel panel_14 = new JPanel();
		work_order_scrollPane_1.setViewportView(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		panel_14.add(work_order_list);
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
		panel_11.add(work_order_scrollPane_1);
		panel_3.setLayout(gl_panel_3);
		
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{500, 0};
		gbl_panel_9.rowHeights = new int[]{29, 0};
		gbl_panel_9.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_12.setBackground(tab_color1);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		int company_name_max = 38;
		JLabel lblCompanyName_1;
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
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(12, 0, 12, 12);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 0;
		panel_9.add(panel_12, gbc_panel_12);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.insets = new Insets(0, 5, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 3;
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
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(5, 0, 5, 0);
		gbc_panel_5.ipadx = -30;
		gbc_panel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_2.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton arrow_right = new JButton(">>");
		arrow_right.setFont(new Font("Consolas", Font.PLAIN, 15));
		arrow_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode selected_node = (DefaultMutableTreeNode)thesaurus_tree.getLastSelectedPathComponent();
				if(selected_node != null && selected_node.getLevel() > 1) {
					boolean exists = false;
					String selected_name = ((JsonNodeWrapper)selected_node.getUserObject()).toString();
					for(int x = 0; x < work_order_list_model.size(); ++x) {
						if(work_order_list_model.getElementAt(x).toString().equals(selected_name)) {
							exists = true;
							x = work_order_list_model.size();
						}
					}
					if(!exists) {
						work_order_list_model.addElement(((JsonNodeWrapper)selected_node.getUserObject()).toString());
						work_order.addConcept(((JsonNodeWrapper)selected_node.getUserObject()).toString());
					}
				}
			}
		});
		panel_8.add(arrow_right);
		
		JButton arrow_left = new JButton("<<");
		arrow_left.setFont(new Font("Consolas", Font.PLAIN, 15));
		arrow_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected_index = work_order_list.getSelectedIndex();
				if(selected_index != -1) {
					String s = work_order_list.getSelectedValue();
					work_order_list_model.remove(selected_index);
					work_order.removeConcept(s);
				}
			}
		});
		panel_5.add(arrow_left);
		
		JPanel panel_17 = new JPanel();
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 0;
		gbc_panel_17.gridy = 5;
		panel_1.add(panel_17, gbc_panel_17);
		GridBagLayout gbl_panel_17 = new GridBagLayout();
		gbl_panel_17.columnWidths = new int[]{313, 0};
		gbl_panel_17.rowHeights = new int[]{32, 0};
		gbl_panel_17.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_17.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_17.setLayout(gbl_panel_17);
		
		JPanel panel_18 = new JPanel();
		GridBagLayout gbl_panel_18 = new GridBagLayout();
		gbl_panel_18.columnWidths = new int[] {0, 0, 0, 0};
		gbl_panel_18.rowHeights = new int[]{0, 0};
		gbl_panel_18.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
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
		gbc_btnMenu.fill = GridBagConstraints.BOTH;
		gbc_btnMenu.weightx = 1.0;
		gbc_btnMenu.insets = new Insets(0, 27, 17, 10);
		gbc_btnMenu.gridx = 0;
		gbc_btnMenu.gridy = 0;
		panel_18.add(btnMenu, gbc_btnMenu);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.weightx = 1.0;
		gbc_btnSave.fill = GridBagConstraints.BOTH;
		gbc_btnSave.insets = new Insets(0, 10, 17, 10);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 0;
		panel_18.add(btnSave, gbc_btnSave);
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
						JLabel message_save = new JLabel("<html>Saved work orders are remembered until the program is closed.<br><br>Currently saved work orders:</html>", SwingConstants.LEFT);
						message_save.setFont(new Font("Arial", Font.PLAIN, 12));
						message_panel.add(message_save);
						save_panel.add(message_panel, gbc_message_save);
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<OntModelWrapper> list_model_save = new DefaultListModel<>();
						for(OntModelWrapper omw : saved_work_orders) {
							list_model_save.addElement(omw);
						}
						
						JList<OntModelWrapper> list_save = new JList<>(list_model_save);
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
						JLabel enter_save = new JLabel("Enter save name (if same name exists, it will be overwritten):", SwingConstants.LEFT);
						enter_save.setFont(new Font("Arial", Font.PLAIN, 12));
						GridBagConstraints gbc_enter_save = new GridBagConstraints();
						gbc_enter_save.insets = new Insets(0, 0, 5, 0);
						gbc_enter_save.fill = GridBagConstraints.BOTH;
						gbc_enter_save.gridx = 0;
						gbc_enter_save.gridy = 2;
						enter_panel.add(enter_save);
						save_panel.add(enter_panel, gbc_enter_save);
						
						JTextField name_save = new JTextField();
						name_save.setText(work_order.getPartName() + " Work Order");
						GridBagConstraints gbc_name_save = new GridBagConstraints();
						gbc_name_save.insets = new Insets(0, 0, 10, 0);
						gbc_name_save.fill = GridBagConstraints.BOTH;
						gbc_name_save.gridx = 0;
						gbc_name_save.gridy = 3;
						save_panel.add(name_save, gbc_name_save);
				    	
				    	result = JOptionPane.showOptionDialog(frame, save_panel, "Save Work Order", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Save", "Cancel"}, null);
			            switch(result) {
			                case JOptionPane.OK_OPTION:
			                	ArrayList<String> final_concepts = new ArrayList<>();
								for(int x = 0; x < work_order_list_model.size(); ++x)
									final_concepts.add(work_order_list_model.getElementAt(x));
								OntModel exp = generateFinalExport(2, false, "", "", "", "", "", "", "", "", "", "", "", "", "", "", final_concepts);
								for(int x = 0; x < saved_work_orders.size(); x++) {
									if(saved_work_orders.get(x).toString().equals(name_save.getText())) {
										saved_work_orders.remove(x);
										x = saved_work_orders.size();
									}
								}
			                	saved_work_orders.add(new OntModelWrapper(exp, name_save.getText()));
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
		
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.insets = new Insets(0, 5, 0, 0);
		gbc_panel_18.fill = GridBagConstraints.BOTH;
		gbc_panel_18.gridx = 0;
		gbc_panel_18.gridy = 0;
		panel_17.add(panel_18, gbc_panel_18);
		
		JButton btnExport = new JButton("Export");
		btnExport.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.weightx = 1.0;
		gbc_btnExport.fill = GridBagConstraints.BOTH;
		gbc_btnExport.insets = new Insets(0, 10, 17, 27);
		gbc_btnExport.gridx = 2;
		gbc_btnExport.gridy = 0;
		panel_18.add(btnExport, gbc_btnExport);
		btnExport.addActionListener(new ActionListener() {
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
						if(export_path.equals("\\"))
							export_path = import_path;
						fc.setCurrentDirectory(new File(export_path));
						JComboBox save_combo = (JComboBox)(fc.getComponent(0).getAccessibleContext().getAccessibleChild(2));
						save_combo.setFont(new Font("Arial", Font.PLAIN, 12));
						save_combo.setUI(new ComboUI(save_combo, true, tab_color1));
						save_combo.setBorder(new LineBorder(Color.GRAY));
						save_combo.setBackground(Color.WHITE);
						configureFileChooserUI(fc.getComponents(), true, 2);
						
						result = fc.showSaveDialog(frame);
						if(result == 0)
						{
							try {
								ArrayList<String> final_concepts = new ArrayList<>();
								for(int x = 0; x < work_order_list_model.size(); ++x)
									final_concepts.add(work_order_list_model.getElementAt(x));
								OntModel exp = generateFinalExport(2, false, "", "", "", "", "", "", "", "", "", "", "", "", "", "", final_concepts);
								File selected_file = fc.getSelectedFile();
								String selected_file_path = selected_file.getCanonicalPath();
								if(selected_file_path.length() < 4 || !(selected_file_path.substring(selected_file_path.length() - 4, selected_file_path.length()).equals(".owl")))
									selected_file = new File(selected_file_path + ".owl");
								selected_file.createNewFile();
								export_path = selected_file.getCanonicalPath();
								FileOutputStream fos = new FileOutputStream(selected_file, false);
								OutputStreamWriter osw = new OutputStreamWriter(fos);
								RDFWriter writer = exp.getWriter("RDF/XML-ABBREV");
								writer.setProperty("showXmlDeclaration", false);
								writer.write(exp, osw, null);
								osw.close();
								fos.close();
							} catch(Exception e1) {
								JOptionPane.showMessageDialog(frame, new JLabel("Unable to export.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
							}
						}
				    }
				});
				
			}
		});
		
		JPanel panel_16 = new JPanel();
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 2;
		gbc_panel_16.gridy = 5;
		panel_1.add(panel_16, gbc_panel_16);
		GridBagLayout gbl_panel_16 = new GridBagLayout();
		gbl_panel_16.columnWidths = new int[]{200, 0};
		gbl_panel_16.rowHeights = new int[]{0, 0};
		gbl_panel_16.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_16.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_16.setLayout(gbl_panel_16);
		
		JPanel panel_19 = new JPanel();
		GridBagConstraints gbc_panel_19 = new GridBagConstraints();
		gbc_panel_19.insets = new Insets(0, 0, 0, 5);
		gbc_panel_19.fill = GridBagConstraints.BOTH;
		gbc_panel_19.gridx = 0;
		gbc_panel_19.gridy = 0;
		panel_16.add(panel_19, gbc_panel_19);
		GridBagLayout gbl_panel_19 = new GridBagLayout();
		gbl_panel_19.columnWidths = new int[] {0, 0, 0};
		gbl_panel_19.rowHeights = new int[]{27, 0};
		gbl_panel_19.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_19.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_19.setLayout(gbl_panel_19);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.weightx = 0.5;
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.insets = new Insets(0, 25, 17, 10);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		panel_19.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matchPage2();
				return;
			}
		});
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 10, 17, 27);
		gbc_btnNext.weightx = 0.5;
		gbc_btnNext.fill = GridBagConstraints.BOTH;
		gbc_btnNext.gridx = 1;
		gbc_btnNext.gridy = 0;
		panel_19.add(btnNext, gbc_btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(saved_match_data.size() == 0)
        			JOptionPane.showMessageDialog(frame, new JLabel("<html><center>There are no capability models saved.</html>", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
            	else {
            		matchPage4(true);
                    return;
            	}
			}
		});

		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	private void matchPage4(boolean back_flag) {
		getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{500, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(20, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSupplyTitle = new JLabel("Match work order with supply chains");
		lblSupplyTitle.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSupplyTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblSupplyTitle, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(20, 75, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.weightx = 1.0;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{188, 64, 210, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblMaxSupplyChainSize = new JLabel("Max supply chain size:");
		lblMaxSupplyChainSize.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMaxSupplyChainSize = new GridBagConstraints();
		gbc_lblMaxSupplyChainSize.insets = new Insets(0, 55, 0, 5);
		gbc_lblMaxSupplyChainSize.anchor = GridBagConstraints.EAST;
		gbc_lblMaxSupplyChainSize.gridx = 0;
		gbc_lblMaxSupplyChainSize.gridy = 0;
		panel_2.add(lblMaxSupplyChainSize, gbc_lblMaxSupplyChainSize);
		
		JComboBox<Integer> comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setBackground(Color.WHITE);
		comboBox.setUI(new ComboUI(comboBox, true, Color.WHITE));
		comboBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		comboBox.setFocusable(false);
		comboBox.insertItemAt(1, 0);
		comboBox.insertItemAt(2, 1);
		comboBox.insertItemAt(3, 2);
		comboBox.insertItemAt(4, 3);
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 10, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel_2.add(comboBox, gbc_comboBox);
		
		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.weightx = 1.0;
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 2;
		panel.add(panel_10, gbc_panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[] {0, 0};
		gbl_panel_10.rowHeights = new int[] {2, 0};
		gbl_panel_10.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_10.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_10.setLayout(gbl_panel_10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(tab_color2);
		separator.setForeground(tab_color2);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(10, 70, 10, 70);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		gbc_separator.gridy = 0;
		gbc_separator.gridx = 0;
		gbc_separator.weightx = 1.0;
		panel_10.add(separator, gbc_separator);
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 3;
		panel.add(panel_9, gbc_panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0};
		gbl_panel_9.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JLabel lblSelectSupplyChain = new JLabel("Select supply chain to export:");
		GridBagConstraints gbc_lblSelectSupplyChain = new GridBagConstraints();
		gbc_lblSelectSupplyChain.insets = new Insets(0, 72, 0, 0);
		gbc_lblSelectSupplyChain.gridx = 0;
		gbc_lblSelectSupplyChain.gridy = 0;
		panel_9.add(lblSelectSupplyChain, gbc_lblSelectSupplyChain);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 70, 5, 70);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 5;
		panel.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 145, 0, 145);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_5.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{400, 400, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getVerticalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane.getHorizontalScrollBar().setUI(new ScrollUI(Color.WHITE));
		scrollPane.setOpaque(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		DefaultListModel<CustomRadioButton> chain_list_model = new DefaultListModel<>();
		JList<CustomRadioButton> chain_list = new JList<>(chain_list_model);
		chain_list.setCellRenderer(new RadioButtonListRenderer());
		chain_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		chain_list.setSelectedIndex(0);
		chain_list.setFont(new Font("Arial", Font.PLAIN, 12));
		chain_list.setVisibleRowCount(20);
		chain_list.setFocusable(false);
		scrollPane.setViewportView(chain_list);
		
		ButtonGroup radioGroup = new ButtonGroup();
		CustomRadioButton rdbtnFeaturebasedOptimization = new CustomRadioButton("Feature-based optimization", true, background_color);
		rdbtnFeaturebasedOptimization.setSelected(true);
		rdbtnFeaturebasedOptimization.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_rdbtnFeaturebasedOptimization = new GridBagConstraints();
		gbc_rdbtnFeaturebasedOptimization.fill = GridBagConstraints.BOTH;
		gbc_rdbtnFeaturebasedOptimization.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnFeaturebasedOptimization.gridx = 0;
		gbc_rdbtnFeaturebasedOptimization.gridy = 0;
		panel_6.add(rdbtnFeaturebasedOptimization, gbc_rdbtnFeaturebasedOptimization);
		radioGroup.add(rdbtnFeaturebasedOptimization);
		rdbtnFeaturebasedOptimization.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	opt_flag = 0;
            	chain_list_model.clear();
            	Collections.sort(chains, new Comparator() {
        			public int compare(Object o1, Object o2) {
        				if(((CustomRadioButton)o1).getConceptCount() < ((CustomRadioButton)o2).getConceptCount())
        					return 1;
        				else
        					return -1;
                    }
                });
            	for(CustomRadioButton crb : chains)
            		chain_list_model.addElement(crb);
            	chain_list.setSelectedIndex(0);
            }
        });
		
		CustomRadioButton rdbtnDistancebasedOptimization = new CustomRadioButton("Distance-based optimization", true, background_color);
		rdbtnDistancebasedOptimization.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_rdbtnDistancebasedOptimization = new GridBagConstraints();
		gbc_rdbtnDistancebasedOptimization.fill = GridBagConstraints.BOTH;
		gbc_rdbtnDistancebasedOptimization.gridx = 1;
		gbc_rdbtnDistancebasedOptimization.gridy = 0;
		panel_6.add(rdbtnDistancebasedOptimization, gbc_rdbtnDistancebasedOptimization);
		radioGroup.add(rdbtnDistancebasedOptimization);
		rdbtnDistancebasedOptimization.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	opt_flag = 1;
            }
        });
		
		int temp_work_cap = 0;
    	if(work_order.getProductionVolume().equals("Medium"))
    		temp_work_cap = 1;
    	else if(work_order.getProductionVolume().equals("High"))
    		temp_work_cap = 2;
    	
    	final int work_cap = temp_work_cap;
    	double temp_work_dia = Integer.MIN_VALUE;
    	try { temp_work_dia = Double.parseDouble(work_order.getMaxDiameter().replaceAll("[^\\d.]", "")); } catch(Exception e) {}
    	final double work_dia = temp_work_dia;
    	double temp_work_len = Integer.MIN_VALUE;
    	try { temp_work_len = Double.parseDouble(work_order.getMaxLength().replaceAll("[^\\d.]", "")); } catch(Exception e) {}
    	final double work_len = temp_work_len;
    	double temp_work_wei = Integer.MIN_VALUE;
    	try { temp_work_wei = Double.parseDouble(work_order.getPartWeight().replaceAll("[^\\d.]", "")); } catch(Exception e) {}
    	final double work_wei = temp_work_wei;
    	double temp_work_sur = Integer.MIN_VALUE;
    	try { temp_work_sur = Double.parseDouble(work_order.getSurfaceRoughness().replaceAll("[^\\d.]", "")); } catch(Exception e) {}
    	final double work_sur = temp_work_sur;
    	double temp_work_thi = Integer.MIN_VALUE;
    	try { temp_work_thi = Double.parseDouble(work_order.getMinWallThickness().replaceAll("[^\\d.]", "")); } catch(Exception e) {}
    	final double work_thi = temp_work_thi;
    	double temp_work_lo_tol = Integer.MAX_VALUE;
    	try { temp_work_lo_tol = Double.parseDouble(work_order.getLowerTolerance().replaceAll("[^\\d.]", "")); } catch(Exception e) {}
    	final double work_lo_tol = temp_work_lo_tol;
    	double temp_work_up_tol = Integer.MAX_VALUE;
    	try { temp_work_up_tol = Double.parseDouble(work_order.getUpperTolerance().replaceAll("[^\\d.]", "")); } catch(Exception e) {}
    	final double work_up_tol = temp_work_up_tol;
		
		JButton btnBuildSupplyChains = new JButton("Build Supply Chains");
		btnBuildSupplyChains.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBuildSupplyChains = new GridBagConstraints();
		gbc_btnBuildSupplyChains.insets = new Insets(0, 20, 0, 0);
		gbc_btnBuildSupplyChains.fill = GridBagConstraints.BOTH;
		gbc_btnBuildSupplyChains.gridx = 2;
		gbc_btnBuildSupplyChains.gridy = 0;
		panel_2.add(btnBuildSupplyChains, gbc_btnBuildSupplyChains);
		btnBuildSupplyChains.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	chains = new ArrayList<>();
            	int max_size = (int)comboBox.getSelectedItem();
            	ArrayList<ArrayList<MatchData>> available_subsets = new ArrayList<>();
            	final ArrayList<MatchData> input = saved_match_data;
            	for(int k = 1; k <= max_size; ++k) {
            		int[] index_list = new int[k];
            		if(k <= input.size()) {
            			for(int i = 0; (index_list[i] = i) < k - 1; ++i);
            			available_subsets.add(getChainFromIndexes(index_list));
            			for(;;) {
                	        int i;
                	        for(i = k - 1; i >= 0 && index_list[i] == input.size() - k + i; i--); 
                	        if(i < 0)
                	            break;
                	        ++index_list[i];
                	        for(++i; i < k; ++i)
                	            index_list[i] = index_list[i - 1] + 1;
                	        available_subsets.add(getChainFromIndexes(index_list));
                	    }
            		}
            	}
            	System.out.println(available_subsets);
            	
            	for(int x = 0; ; ++x) {
            		if(x >= available_subsets.size())
            			break;
            		
            		ArrayList<MatchData> subset = available_subsets.get(x);
            		int md_cap = 0;
                	double md_dia = Integer.MIN_VALUE;
                	double md_len = Integer.MIN_VALUE;
                	double md_wei = Integer.MIN_VALUE;
                	double md_lo_sur = Integer.MAX_VALUE;
                	double md_up_sur = Integer.MIN_VALUE;
                	double md_lo_thi = Integer.MAX_VALUE;
                	double md_up_thi = Integer.MIN_VALUE;
                	double md_lo_tol = Integer.MAX_VALUE;
                	double md_up_tol = Integer.MAX_VALUE;
            		
            		for(int y = 0; y < subset.size(); ++y) {
            			MatchData md = subset.get(y);
            			
            			int temp_cap = 0;
                    	if(md.getCapacity().equals("Medium"))
                    		temp_cap = 1;
                    	else if(md.getCapacity().equals("High"))
                    		temp_cap = 2;
            			if(temp_cap > md_cap)
            				md_cap = temp_cap;
            			
            			try {
            				double temp_dia = Double.parseDouble(md.getDiameter().replaceAll("[^\\d.]", ""));
            				if(temp_dia > md_dia)
            					md_dia = temp_dia;
            			} catch(Exception e1) {}
            			
            			try {
            				double temp_len = Double.parseDouble(md.getLength().replaceAll("[^\\d.]", ""));
            				if(temp_len > md_len)
            					md_len = temp_len;
            			} catch(Exception e1) {}
            			
            			try {
            				double temp_wei = Double.parseDouble(md.getWeight().replaceAll("[^\\d.]", ""));
            				if(temp_wei > md_wei)
            					md_wei = temp_wei;
            			} catch(Exception e1) {}
            			
            			try {
            				double temp_sur = Double.parseDouble(md.getLowerSurface().replaceAll("[^\\d.]", ""));
            				if(temp_sur < md_lo_sur)
            					md_lo_sur = temp_sur;
            			} catch(Exception e1) {
            				md_lo_sur = Integer.MIN_VALUE;
            			}
            			
            			try {
            				double temp_sur = Double.parseDouble(md.getUpperSurface().replaceAll("[^\\d.]", ""));
            				if(temp_sur > md_up_sur)
            					md_up_sur = temp_sur;
            			} catch(Exception e1) {}
            			
            			try {
            				double temp_thi = Double.parseDouble(md.getLowerThickness().replaceAll("[^\\d.]", ""));
            				if(temp_thi < md_lo_thi)
            					md_lo_thi = temp_thi;
            			} catch(Exception e1) {
            				md_lo_thi = Integer.MIN_VALUE;
            			}
            			
            			try {
            				double temp_thi = Double.parseDouble(md.getUpperThickness().replaceAll("[^\\d.]", ""));
            				if(temp_thi > md_up_thi)
            					md_up_thi = temp_thi;
            			} catch(Exception e1) {}
            			
            			try {
            				double temp_tol = Double.parseDouble(md.getLowerTolerance().replaceAll("[^\\d.]", ""));
            				if(temp_tol < md_lo_tol)
            					md_lo_tol = temp_tol;
            			} catch(Exception e1) {}
            			
            			try {
            				double temp_tol = Double.parseDouble(md.getUpperTolerance().replaceAll("[^\\d.]", ""));
            				if(temp_tol < md_up_tol)
            					md_up_tol = temp_tol;
            			} catch(Exception e1) {}
            		}
            		
            		if(md_cap >= work_cap && md_dia >= work_dia && md_len >= work_len && md_wei >= work_wei && md_lo_tol <= work_lo_tol && md_up_tol <= work_up_tol &&
            				((md_lo_sur <= work_sur || work_sur == Integer.MIN_VALUE) && md_up_sur >= work_sur) &&
            				((md_lo_thi <= work_thi || work_thi == Integer.MIN_VALUE) && md_up_thi >= work_thi)) {
            			
            			ArrayList<String> total_conc = new ArrayList<>();
            			boolean mat_matched = false;
            			ArrayList<IndividualWrapper> req_func = work_order.getProcessCapabilities();
            			OntClass mat_class = getOntClassOf(work_order.getMaterialCapability().getIndividual());
            			
            			for(MatchData md : subset) {
            				ArrayList<IndividualWrapper> mat = md.getMaterials();
            				ArrayList<IndividualWrapper> func = md.getFunctions();
            				ArrayList<String> conc = md.getConcepts();
            				for(IndividualWrapper iw : mat) {
            					if(isCategoryOf(mat_class, getOntClassOf(iw.getIndividual()), true)) {
            						mat_matched = true;
            						break;
            					}
            				}
            				for(IndividualWrapper iw : func) {
            					for(int z = 0; z < req_func.size(); ++z) {
	            					if(isCategoryOf(getOntClassOf(req_func.get(z).getIndividual()), getOntClassOf(iw.getIndividual()), true)) {
	            						req_func.remove(z);
	            						z = -1;
	            					}
            					}
            				}
            				for(String s : conc)
            					total_conc.add(s);
            			}

            			if(mat_matched && req_func.size() == 0) {
            				String chain_text = subset.get(0).toString();
            				for(int z = 1; z < subset.size(); ++z)
            					chain_text += " + " + subset.get(z);
            				ArrayList<String> req_conc = work_order.getConcepts();
            				int concept_count = 0;
            				for(String s : req_conc) {
            					if(total_conc.contains(s.trim().toLowerCase()))
            						++concept_count;
            				}
            				ArrayList<String> caps = new ArrayList<>();
            				for(MatchData md : subset)
                				caps.add(md.toString().trim());
                    		chains.add(new CustomRadioButton(chain_text, caps, concept_count, false, Color.WHITE));
                    		available_subsets.remove(x--);
                    		for(int z = x + 1; ; ++z) {
                    			if(z >= available_subsets.size())
                    				break;
                    			ArrayList<MatchData> check_subset = available_subsets.get(z);
                    			boolean contains_all = true;
                    			for(MatchData md : subset) {
                    				if(!check_subset.contains(md)) {
                    					contains_all = false;
                    					break;
                    				}
                    			}
                    			if(contains_all)
                    				available_subsets.remove(z--);
                    		}
            			}
            		}
            	}
            	if(opt_flag == 0)
            		rdbtnFeaturebasedOptimization.doClick();
            	else if(opt_flag == 1)
            		rdbtnDistancebasedOptimization.doClick();
            }
        });
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(35, 0, 0, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 6;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{27, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 0, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 0;
		panel_3.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 220, 0, 10);
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		panel_7.add(btnBack, gbc_btnBack);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(back_flag)
            		matchPage3();
            	else
            		matchPage1();
            	return;
            }
        });
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 0;
		panel_3.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JButton btnNext = new JButton("Export");
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 10, 0, 220);
		gbc_btnNext.fill = GridBagConstraints.BOTH;
		gbc_btnNext.gridx = 0;
		gbc_btnNext.gridy = 0;
		panel_8.add(btnNext, gbc_btnNext);
		btnNext.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNext.addActionListener(new ActionListener() {
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
						fc.setDialogTitle("Export Supply Chain");
						fc.setMultiSelectionEnabled(false);
						if(export_path.equals("\\"))
							export_path = import_path;
						fc.setCurrentDirectory(new File(export_path));
						JComboBox save_combo = (JComboBox)(fc.getComponent(0).getAccessibleContext().getAccessibleChild(2));
						save_combo.setFont(new Font("Arial", Font.PLAIN, 12));
						save_combo.setUI(new ComboUI(save_combo, true, tab_color1));
						save_combo.setBorder(new LineBorder(Color.GRAY));
						save_combo.setBackground(Color.WHITE);
						configureFileChooserUI(fc.getComponents(), true, 3);
						
						result = fc.showSaveDialog(frame);	
						if(result == 0)
						{
							try {
								OntModel exp = ModelFactory.createOntologyModel(modelSpec);
								exp.setStrictMode(false);
								Individual supply_chain_indiv = exp.createIndividual(generateID(exp), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0001011"));
								supply_chain_indiv.setLabel("Supply chain 1", "en");
								String supply_chain_comment = "\n----- Supply chain information -----";
								ArrayList<String> caps = chain_list.getSelectedValue().getChain();
								for(String s : caps) {
									Individual fact = exp.createIndividual(generateID(exp), ontology.getOntClass("http://infoneer.txstate.edu/ontology/MSDL_0000090"));
									fact.setLabel(s, "en");
									supply_chain_indiv.addProperty(prop_hasMember, fact);
									supply_chain_comment += "\nFactory: " + s;
								}
								supply_chain_indiv.addComment(supply_chain_comment, "en");
								
								File selected_file = fc.getSelectedFile();
								String selected_file_path = selected_file.getCanonicalPath();
								if(selected_file_path.length() < 4 || !(selected_file_path.substring(selected_file_path.length() - 4, selected_file_path.length()).equals(".owl")))
									selected_file = new File(selected_file_path + ".owl");
								selected_file.createNewFile();
								export_path = selected_file.getCanonicalPath();
								FileOutputStream fos = new FileOutputStream(selected_file, false);
								OutputStreamWriter osw = new OutputStreamWriter(fos);
								RDFWriter writer = exp.getWriter("RDF/XML-ABBREV");
								writer.setProperty("showXmlDeclaration", false);
								writer.write(exp, osw, null);
								osw.close();
								fos.close();
							} catch(Exception e1) {
								JOptionPane.showMessageDialog(frame, new JLabel("Unable to export.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
							}
						}
				    }
				});
            	
            }
        });

		setBounds(this.getX() + (this.getWidth() / 2) - (screenWidth / 2), this.getY() + (this.getHeight() / 2) - (screenHeight / 2), screenWidth, screenHeight);
		validate();
	}
	
	private void listPage() {
		getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnComp = new JButton("List Company Models");
		btnComp.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnComp = new GridBagConstraints();
		gbc_btnComp.weightx = 1.0;
		gbc_btnComp.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnComp.insets = new Insets(105, 225, 10, 225);
		gbc_btnComp.gridx = 0;
		gbc_btnComp.gridy = 0;
		panel.add(btnComp, gbc_btnComp);
		btnComp.addActionListener(new ActionListener() {
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
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<CompanyWrapper> list_model_save = new DefaultListModel<>();
						for(CompanyWrapper cw : saved_companies) {
							list_model_save.addElement(cw);
						}
						
						JList<CompanyWrapper> list_save = new JList<>(list_model_save);
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
						gbc_list_panel.gridy = 0;
						save_panel.add(list_panel, gbc_list_panel);
						
						JButton btnDelete = new JButton("Delete");
						btnDelete.setFont(new Font("Arial", Font.PLAIN, 12));
						GridBagConstraints gbc_btnDelete = new GridBagConstraints();
						gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
						gbc_btnDelete.insets = new Insets(5, 140, 0, 140);
						gbc_btnDelete.gridx = 0;
						gbc_btnDelete.gridy = 1;
						save_panel.add(btnDelete, gbc_btnDelete);
						btnDelete.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				            	if(list_save.getSelectedValue() != null) {
				            		CompanyWrapper deleted = list_save.getSelectedValue();
					            	for(int x = 0; x < saved_companies.size(); ++x) {
										if(saved_companies.get(x).toString().toLowerCase().equals(deleted.toString().toLowerCase())) {
											saved_companies.remove(x);
											list_model_save.removeElementAt(x);
											break;
										}
									}
				            	}
				            }
				        });
				    	
				    	JOptionPane.showOptionDialog(frame, save_panel, "Company Models", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Close"}, null);
				    }
				});
            	
            }
        });
		
		JButton btnFact = new JButton("List Factory Models");
		btnFact.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnFact = new GridBagConstraints();
		gbc_btnFact.weightx = 1.0;
		gbc_btnFact.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFact.insets = new Insets(0, 225, 10, 225);
		gbc_btnFact.gridx = 0;
		gbc_btnFact.gridy = 1;
		panel.add(btnFact, gbc_btnFact);
		btnFact.addActionListener(new ActionListener() {
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
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<OntModelWrapper> list_model_save = new DefaultListModel<>();
						for(OntModelWrapper omw : saved_factories) {
							list_model_save.addElement(omw);
						}
						
						JList<OntModelWrapper> list_save = new JList<>(list_model_save);
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
						gbc_list_panel.gridy = 0;
						save_panel.add(list_panel, gbc_list_panel);
						
						JButton btnDelete = new JButton("Delete");
						btnDelete.setFont(new Font("Arial", Font.PLAIN, 12));
						GridBagConstraints gbc_btnDelete = new GridBagConstraints();
						gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
						gbc_btnDelete.insets = new Insets(5, 140, 0, 140);
						gbc_btnDelete.gridx = 0;
						gbc_btnDelete.gridy = 1;
						save_panel.add(btnDelete, gbc_btnDelete);
						btnDelete.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				            	if(list_save.getSelectedValue() != null) {
					            	OntModelWrapper deleted = list_save.getSelectedValue();
					            	for(int x = 0; x < saved_factories.size(); ++x) {
										if(saved_factories.get(x).toString().toLowerCase().equals(deleted.toString().toLowerCase())) {
											saved_factories.remove(x);
											list_model_save.removeElementAt(x);
											break;
										}
									}
				            	}
				            }
				        });
				    	
				    	JOptionPane.showOptionDialog(frame, save_panel, "Factory Models", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Close"}, null);
				    }
				});
            	
            }
        });
		
		JButton btnCap = new JButton("List Capability Models");
		btnCap.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnCap = new GridBagConstraints();
		gbc_btnCap.insets = new Insets(0, 225, 10, 225);
		gbc_btnCap.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCap.gridx = 0;
		gbc_btnCap.gridy = 2;
		panel.add(btnCap, gbc_btnCap);
		btnCap.addActionListener(new ActionListener() {
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
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<MatchData> list_model_save = new DefaultListModel<>();
						for(MatchData md : saved_match_data) {
							list_model_save.addElement(md);
						}
						
						JList<MatchData> list_save = new JList<>(list_model_save);
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
						gbc_list_panel.gridy = 0;
						save_panel.add(list_panel, gbc_list_panel);
						
						JButton btnDelete = new JButton("Delete");
						btnDelete.setFont(new Font("Arial", Font.PLAIN, 12));
						GridBagConstraints gbc_btnDelete = new GridBagConstraints();
						gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
						gbc_btnDelete.insets = new Insets(5, 140, 0, 140);
						gbc_btnDelete.gridx = 0;
						gbc_btnDelete.gridy = 1;
						save_panel.add(btnDelete, gbc_btnDelete);
						btnDelete.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				            	if(list_save.getSelectedValue() != null) {
					            	MatchData deleted = list_save.getSelectedValue();
					            	for(int x = 0; x < saved_match_data.size(); ++x) {
										if(saved_match_data.get(x).toString().toLowerCase().equals(deleted.toString().toLowerCase())) {
											saved_match_data.remove(x);
											list_model_save.removeElementAt(x);
											break;
										}
									}
				            	}
				            }
				        });
				    	
				    	JOptionPane.showOptionDialog(frame, save_panel, "Capability Models", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Close"}, null);
				    }
				});
			
			}
		});
		
		JButton btnWork = new JButton("List Work Order Models");
		btnWork.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnWork = new GridBagConstraints();
		gbc_btnWork.weightx = 1.0;
		gbc_btnWork.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWork.insets = new Insets(0, 225, 10, 225);
		gbc_btnWork.gridx = 0;
		gbc_btnWork.gridy = 3;
		panel.add(btnWork, gbc_btnWork);
		btnWork.addActionListener(new ActionListener() {
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
				    	
				    	JPanel list_panel = new JPanel();
						list_panel.setLayout(new BorderLayout(0, 0));
						list_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, etched_color1, etched_color2));
						list_panel.setBackground(Color.WHITE);

						DefaultListModel<OntModelWrapper> list_model_save = new DefaultListModel<>();
						for(OntModelWrapper omw : saved_work_orders) {
							list_model_save.addElement(omw);
						}
						
						JList<OntModelWrapper> list_save = new JList<>(list_model_save);
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
						gbc_list_panel.gridy = 0;
						save_panel.add(list_panel, gbc_list_panel);
						
						JButton btnDelete = new JButton("Delete");
						btnDelete.setFont(new Font("Arial", Font.PLAIN, 12));
						GridBagConstraints gbc_btnDelete = new GridBagConstraints();
						gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
						gbc_btnDelete.insets = new Insets(5, 140, 0, 140);
						gbc_btnDelete.gridx = 0;
						gbc_btnDelete.gridy = 1;
						save_panel.add(btnDelete, gbc_btnDelete);
						btnDelete.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				            	if(list_save.getSelectedValue() != null) {
					            	OntModelWrapper deleted = list_save.getSelectedValue();
					            	for(int x = 0; x < saved_work_orders.size(); ++x) {
										if(saved_work_orders.get(x).toString().toLowerCase().equals(deleted.toString().toLowerCase())) {
											saved_work_orders.remove(x);
											list_model_save.removeElementAt(x);
											break;
										}
									}
				            	}
				            }
				        });
				    	
				    	JOptionPane.showOptionDialog(frame, save_panel, "Work Order Models", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Close"}, null);
				    }
				});
				
            }
        });
		
		JButton btnLoad = new JButton("Import Session");
		btnLoad.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLoad.weightx = 1.0;
		gbc_btnLoad.insets = new Insets(15, 225, 5, 225);
		gbc_btnLoad.gridx = 0;
		gbc_btnLoad.gridy = 4;
		panel.add(btnLoad, gbc_btnLoad);
		btnLoad.addActionListener(new ActionListener() {
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
						
						FileNameExtensionFilter filter = new FileNameExtensionFilter("CaMDiF Session (*.cmdf)", "cmdf");
						fc.setFileFilter(filter);
						fc.setFocusable(false);
						fc.setDialogTitle("Import Session");
						fc.setMultiSelectionEnabled(false);
						if(import_path.equals("\\"))
							import_path = export_path;
						fc.setCurrentDirectory(new File(import_path));
						JComboBox open_combo = (JComboBox)(fc.getComponent(0).getAccessibleContext().getAccessibleChild(2));
						open_combo.setFont(new Font("Arial", Font.PLAIN, 12));
						open_combo.setUI(new ComboUI(open_combo, true, tab_color1));
						open_combo.setBorder(new LineBorder(Color.GRAY));
						open_combo.setBackground(Color.WHITE);
						configureFileChooserUI(fc.getComponents(), false, 0);
						
						result = fc.showOpenDialog(frame);
						if(result == 0)
						{
							File selected_file = fc.getSelectedFile();
							if(selected_file.exists())
							{
								try {
									import_path = selected_file.getCanonicalPath();
									InputStream in = FileManager.get().open("file:///" + import_path.replace("\\", "/"));
									if(in == null)
							            throw new IllegalArgumentException();
									ObjectInputStream ois = new ObjectInputStream(in);
									ArrayList<ArrayList> models = (ArrayList)ois.readObject();
									
									ArrayList<CompanyWrapper> comp = models.get(0);
									saved_companies.clear();
									for(CompanyWrapper cw : comp)
										saved_companies.add(cw);
									
									ArrayList<OntModelWrapper> fact = models.get(1);
									saved_factories.clear();
									for(OntModelWrapper omw : fact)
										saved_factories.add(omw);
									
									ArrayList<MatchData> cap = models.get(2);
									saved_match_data.clear();
									for(MatchData md :cap)
										saved_match_data.add(md);
									
									ArrayList<OntModelWrapper> work = models.get(3);
									saved_work_orders.clear();
									for(OntModelWrapper omw : work)
										saved_work_orders.add(omw);
									in.close();
								} catch(Exception e1) {
									e1.printStackTrace(System.out);
									JOptionPane.showMessageDialog(frame, new JLabel("Unable to import.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
								}
							}
						}
				    }
				});
            	
            }
        });
		
		JButton btnSave = new JButton("Export Session");
		btnSave.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.weightx = 1.0;
		gbc_btnSave.insets = new Insets(5, 225, 10, 225);
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 5;
		panel.add(btnSave, gbc_btnSave);
		btnSave.addActionListener(new ActionListener() {
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
						
						FileNameExtensionFilter filter = new FileNameExtensionFilter("CaMDiF Session (*.cmdf)", "cmdf");
						fc.setFileFilter(filter);
						fc.setFocusable(false);
						fc.setDialogTitle("Export Session");
						fc.setMultiSelectionEnabled(false);
						if(export_path.equals("\\"))
							export_path = import_path;
						fc.setCurrentDirectory(new File(export_path));
						JComboBox save_combo = (JComboBox)(fc.getComponent(0).getAccessibleContext().getAccessibleChild(2));
						save_combo.setFont(new Font("Arial", Font.PLAIN, 12));
						save_combo.setUI(new ComboUI(save_combo, true, tab_color1));
						save_combo.setBorder(new LineBorder(Color.GRAY));
						save_combo.setBackground(Color.WHITE);
						configureFileChooserUI(fc.getComponents(), true, 4);
						
						result = fc.showSaveDialog(frame);	
						if(result == 0)
						{
							try {
								File selected_file = fc.getSelectedFile();
								String selected_file_path = selected_file.getCanonicalPath();
								if(selected_file_path.length() < 5 || !(selected_file_path.substring(selected_file_path.length() - 5, selected_file_path.length()).equals(".cmdf")))
									selected_file = new File(selected_file_path + ".cmdf");
								selected_file.createNewFile();
								export_path = selected_file.getCanonicalPath();
								FileOutputStream fos = new FileOutputStream(selected_file, false);
								ObjectOutputStream oos = new ObjectOutputStream(fos);
								ArrayList<ArrayList> models = new ArrayList<>();
								models.add(saved_companies);
								models.add(saved_factories);
								models.add(saved_match_data);
								models.add(saved_work_orders);
								oos.writeObject(models);
								oos.close();
								fos.close();
							} catch(Exception e1) {
								JOptionPane.showMessageDialog(frame, new JLabel("Unable to export.", SwingConstants.CENTER), "Notice", JOptionPane.PLAIN_MESSAGE, null);
								e1.printStackTrace(System.out);
							}
						}
				    }
				});
            	
            }
        });
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBack.insets = new Insets(-152, 290, 0, 290);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 6;
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
}
