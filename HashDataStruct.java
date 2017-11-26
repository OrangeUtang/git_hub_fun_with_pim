import java.util.Hashtable;
import java.util.Stack;

public class HashDataStruct extends dataStruct 
{
	private int keylenght;
	private DataNode nullNode;
	private int expectedEntries;
	Hashtable<String, DataNode> hashStruct;
	
	HashDataStruct(int keylenght,int expectedEntries)
	{
		this.expectedEntries = expectedEntries;
		this.keylenght = keylenght;
		hashStruct = new Hashtable<String, DataNode>(expectedEntries);
	}
	
	
	public int getKeylenght() 
	{
		return keylenght;
	}



	
	public void setKeylength(int x) 
	{
		keylenght = x;
	}
	
	
	@Override
	public void allKeys() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void add(String key, String value) 
	{
		
		//if the key is already in the system
		if(hashStruct.containsKey(key))
		{
			//if the value associated with the key is equal to '_'
			if(hashStruct.get(key).getValue().equals("_"))
			{
				//create new data node, attach it to existing Node possessing the same key
				//when its done replace that node with new Node
				DataNode tempNode = new DataNode(key, value);
				hashStruct.get(key).setSuccessorOwner(tempNode);
				tempNode.setPreviousOwner(hashStruct.get(key));
				hashStruct.remove(key);
				hashStruct.put(key, tempNode);
			}
			
			else
			{
				System.out.println("Key is unavailable");
				return;
			}
			
		}
		
		else
		{
			//Create a nullNode, make it successor, then link it with entry Node.
			DataNode nullNode = new DataNode("_", "_");
			DataNode entryNode = new DataNode(key, value);
			entryNode.setPreviousOwner(nullNode);
			hashStruct.put(key, entryNode);
			
		}
		
		
	}

	@Override
	public void remove(String key) 
	{
		if(hashStruct.containsKey(key))
		{
			if(hashStruct.get(key).getValue().equals("_"))
			{
				System.out.println("Node associated with this key is already available");
				return;
			}
			
			else
			{
				DataNode availableNode = new DataNode(key, "_");
				hashStruct.get(key).setSuccessorOwner(availableNode);
				availableNode.setPreviousOwner(hashStruct.get(key));
				hashStruct.remove(key);
				hashStruct.put(key,availableNode);
			}
			
			
			
			
		}

	}

	@Override 
	public String getValues(String key) 
	{
		if(hashStruct.containsKey(key) && !hashStruct.get(key).getValue().equals("_"))	
			return hashStruct.get(key).getValue();
		
		return "There are either no entries associated with that key, or it is currently not holding any Value";
	}

	@Override
	public String nextKey(String key) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prevKey(String key) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stack<DataNode> previousCar(String key) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
