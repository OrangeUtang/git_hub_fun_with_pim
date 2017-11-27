
public class Link{

	private DataNode head;
	private int size;
	
	public Link() {
		head = null;
	}
	
	public Link(DataNode dn) {
		head = dn;
		size++;
	}
	
	
	
	public int size() {
		return size;
	}
	
	public void addToStart(DataNode dn) {
		if (head == null) {
			head = dn;
		}else {
			head.setPrev(dn);
			dn.setNext(head);
			head = dn;
		}
		size++;
	}
	
	public DataNode getHead() {
		return head;
	}
	public void setHead(DataNode dn) {
		head = dn;
	}

}
