package camdif;

public class TreeNode {
	
	private String label;
	private String ID;
	
	public TreeNode(String label, String ID) {
		this.label = label;
		this.ID = ID;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String getID() {
		return ID;
	}
	
	public String toString() {
		return label;
	}
	
}
