import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;
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
	public void add(String key, String value) 
	{
		
		//if the key is already in the system
		if(hashStruct.containsKey(key))
		{
			//if the value associated with the key is equal to '_'
			if(hashStruct.get(key).getValue().equals("_"))
			{
				hashStruct.get(key).setValue(value);
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
	
	//Size Change add
	public void add(String key, DataNode node)
	{
		hashStruct.put(key, node);
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
				//
				DataNode availableNode = new DataNode(key, "_");
				hashStruct.get(key).setSuccessorOwner(availableNode);
				availableNode.setPreviousOwner(hashStruct.get(key));
				hashStruct.put(key,availableNode);
			}
		}

	}

	@Override 
	public String getValues(String key) 
	{
		if(hashStruct.containsKey(key))
		{
			return hashStruct.get(key).getValue();
		}
		
		return "*";
	}

	@Override
	public String nextKey(String key) 
	{
		Set<String> hashKeySet = hashStruct.keySet();
		boolean found = false;
		
		//iterate through hash table
		for(String value : hashKeySet)
		{
			
			//if found i
			if(found)
			{
				return hashStruct.get(value).getKey();
			}
			
			
            if(hashStruct.get(value).getKey().equals(key))
            {
            	found = true;
            }
            
        }
		return "Not found";

	}

	@Override
	public String prevKey(String key) 
	{
		
		Set<String> hashKeySet = hashStruct.keySet();
		DataNode tempNode = nullNode;
		int counter = 0;
		
		for(String value : hashKeySet)
		{		
			
					
            if(hashStruct.get(value).getKey().equals(key) && counter != 0)
            {
            	return tempNode.getKey();
            }
			
			tempNode = hashStruct.get(value);
            
			counter++;
        }
		return "Not found";
	}

	@Override
	public Stack<String> previousCar(String key) 
	{
		
		Stack<String> previousOwnerStack = new Stack<String>();
		DataNode curdn = hashStruct.get(key);
		
		while(!curdn.getKey().equals("_")) 
		{
			previousOwnerStack.push(curdn.getValue());
			curdn = curdn.getPreviousOwner();
		}		
		return previousOwnerStack;
	}
	
	
	//Size Change  helper
	
	public Set<String> getKeySet()
	{
		return hashStruct.keySet();
	}
	
	public Hashtable<String, DataNode> getTable()
	{
		return hashStruct;
	}
	
	@Override
	public Link allKeys() {
		Link list = new Link();
		Enumeration<DataNode> en = hashStruct.elements();
		while (en.hasMoreElements()) {
			list.addToStart(en.nextElement());
		}

		for (int k = keylenght-1; k >= 0; k--) {
			DataNode cur1 = list.getHead();
			DataNode cur2 = cur1.getNext();
			while (cur2.hasNext()) {
				if (cur1.getKey().charAt(k) > cur2.getKey().charAt(k)) {
					cur2.getPrev().setNext(cur2.getNext());
					cur2.getNext().setPrev(cur2.getPrev());
					DataNode cur3 = list.getHead();
					while (cur2.getKey().charAt(k) >= cur3.getKey().charAt(k)) {
						cur3 = cur3.getNext();					
					}
					if (cur3 == list.getHead()) {
						list.addToStart(cur2);
					}else {
						cur3.getPrev().setNext(cur2);
						cur2.setPrev(cur3.getPrev());
						cur3.setPrev(cur2);
						cur2.setNext(cur3);
					}
				}
				cur1 = cur2;
				cur2 = cur2.getNext();
			}	
		}
		return list;	
	}
	

}
