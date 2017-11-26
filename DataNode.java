
public class DataNode 

{
	
	
	private String key;
	private String value;
	private boolean validEmplacement;
	


	DataNode previousOwner;
	DataNode SuccessorOwner;
	
	
	DataNode next;
	DataNode previous;
	
	
	
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


	public DataNode getNext() {
		return next;
	}


	public void setNext(DataNode next) {
		this.next = next;
	}


	public DataNode getPrevious() {
		return previous;
	}


	public void setPrevious(DataNode previous) {
		this.previous = previous;
	}
	
	public boolean isValidEmplacement() {
		return validEmplacement;
	}



	public void setValidEmplacement(boolean validEmplacement) {
		this.validEmplacement = validEmplacement;
	}
	
	
	
}
