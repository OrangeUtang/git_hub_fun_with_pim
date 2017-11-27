
public class DataNode 

{
	
	
	private String key;
	private String value;
	
	


	DataNode previousOwner;
	DataNode SuccessorOwner;
	
	
	DataNode(String key, String value)
	{
		this.key = key;
		this.value = value;
		
	}
	
	
	
	//getters and setters
	public String getKey() 
	{
		return key;
	}
	
	public void setKey(String key)
	{
		this.key = key;
	}
	
	public String getValue() 
	{
		return value;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}


	public DataNode getPreviousOwner() {
		return previousOwner;
	}


	public void setPreviousOwner(DataNode previousOwner) {
		this.previousOwner = previousOwner;
	}


	public DataNode getSuccessorOwner() {
		return SuccessorOwner;
	}


	public void setSuccessorOwner(DataNode successorOwner) {
		SuccessorOwner = successorOwner;
	}
	
	public boolean hasPreviousOwner()
	{
		if(previousOwner == null)
		{
			return false;
		}
		return true;
	}
	
	private DataNode next = null;
	private DataNode prev = null;

	public DataNode getNext() {
		return next;
	}
	public void setNext(DataNode dn) {
		next = dn;
	}
	public DataNode getPrev() {
		return prev;
	}
	public void setPrev(DataNode dn) {
		prev = dn;
	}
	public boolean hasNext() {
		if (next == null) {
			return false;
		}
		return true;
	}
	
}
