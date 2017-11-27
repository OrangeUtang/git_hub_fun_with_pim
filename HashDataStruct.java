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
	public ArrayList<DataNode> allKeys() 
	{
		Enumeration<DataNode> en = hashStruct.elements();
		ArrayList<DataNode> list = new ArrayList<DataNode>();
		while (en.hasMoreElements()) {
			list.add(en.nextElement());
		}
		
		// loop over characters starting at last one for lexicographic order
		for (int k = keylenght-1; k >= 0; k--) {
			
			// loop over Array
			for (int i = 0; i < list.size(); i++) {			
				
				// loop over Array again to compare
				for (int j = i+1; j < list.size(); j++) {
					char[] keyI = list.get(i).getKey().toCharArray();
					char[] keyJ = list.get(j).getKey().toCharArray();
					
					if (keyI[k] > keyJ[k]) {
						DataNode dnI = list.get(i);
						DataNode dnJ = list.get(j);
						list.set(i, dnJ);
						list.set(j, dnI);
					}
				}
			}
		}
		return list;
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

}
