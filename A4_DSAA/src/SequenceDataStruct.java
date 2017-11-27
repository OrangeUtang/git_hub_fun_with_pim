import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class SequenceDataStruct extends dataStruct
{
	private int keylenght;
	private DataNode nullNode;
	private int expectedEntries;
	private ArrayList<DataNode> sequenceArray;
	
	SequenceDataStruct(int keylength, int expectedEntries)
	{
		sequenceArray = new ArrayList<>(expectedEntries);
		this.keylenght = keylength;
		
		//setting up the place holder node
		nullNode = new DataNode("_","_");
		
		
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
		//setting index
		int i = 0;
		
		
		//look through the array
		while( i < sequenceArray.size())
		{
			//if it finds the key and the value associated with the key is _
			if( sequenceArray.get(i).getValue().equals("_") && sequenceArray.get(i).getKey().equals(key))
			{
				sequenceArray.get(i).setValue(value);
				return;
			}
			i++;
		}
		
		//create new data node with desired key and value
		//set previous successor pointer to null Node.
		//add the new entry to the array list
		DataNode newEntries = new DataNode(key,value);
		newEntries.setPreviousOwner(nullNode);
		sequenceArray.add(newEntries);
		
	}
	
	//node adding for easy datasize switching
	public void add(DataNode aNode)
	{
		sequenceArray.add(aNode);
	}
	
	
	
	@Override
	public void remove(String key) 
	{
		int i = 0;
				
		while( i < sequenceArray.size())
		{
			//if the data node entries at position i key value is equal to the searched key
			if(sequenceArray.get(i).getKey().equals(key))
			{
				//this code block create a new dataNode with the same key, but without value
				DataNode tempDataNode = new DataNode(key, "_");
				tempDataNode.setPreviousOwner(sequenceArray.get(i));
				sequenceArray.get(i).setSuccessorOwner(tempDataNode);
				sequenceArray.set(i, tempDataNode);
				
				return;
			}
			i++;
		}
		
		System.out.println("No value associated with that key at the moment");
	}
	
	
	@Override
	public String getValues(String key) 
	{
		int i = 0;
		String value = "";
		
		while( i < sequenceArray.size())
		{
			//if the data node entries at position i key value is equal to the searched key
			if(sequenceArray.get(i).getKey().equals(key))
			{
				value = new String(sequenceArray.get(i).getValue());
				return value;
			}
			i++;
		}
		
		return "*";
	}
	
	
	@Override
	public String prevKey(String key) 
	{
		int i = 0;
		
		
		while( i < sequenceArray.size())
		{
			//if the data node entries at position i key value is equal to the searched key
			if(sequenceArray.get(i).getKey().equals(key))
			{
				if(i == 0)
				{
					return "No Predecessor Key";
				}
				
				else
				{
					return (sequenceArray.get(i-1).getKey());
				}
				
			}
			i++;
		}
		
		return "Key not Found";
	}
	
	
	@Override
	public String nextKey(String key) 
	{
		int i = 0;
		while( i < sequenceArray.size())
		{
			//if the data node entries at position i key value is equal to the searched key
			if(sequenceArray.get(i).getKey().equals(key))
			{
				if(i == sequenceArray.size()-1)
				{
					return "No Next Key";
				}
				
				else
				{
					return sequenceArray.get(i+1).getKey();
				}
				
			}
			
			i++;
		}
		
		return "Key not Found";
	}
	
	public Stack<String> previousCar(String key)
	{
		Stack<String> previousValues = new Stack<String>();
		int i = 0;
		while( i < sequenceArray.size())
		{
			//if the data node entries at position i key value is equal to the searched key
			if(sequenceArray.get(i).getKey().equals(key))
			{
				
				DataNode tempNode = sequenceArray.get(i);
				previousValues.push(tempNode.getValue());
				
				while(!tempNode.getPreviousOwner().getKey().equals("_"))
				{
					tempNode = tempNode.getPreviousOwner();
					previousValues.push(tempNode.getValue());
				}
				
				return previousValues;
				
			}
			i++;
		}
		
		previousValues.push("Invalid key");
		return previousValues;
	}
	
	public int getSize()
	{
		return sequenceArray.size();
	}
	
	public DataNode getNodeAt(int i)
	{
		return sequenceArray.get(i);
	}
	
	@Override
	public Link allKeys() {
		Link list = new Link();
		for (int i = 0; i < sequenceArray.size(); i++) {
			list.addToStart(sequenceArray.get(i));
		}	
		for (int k = keylenght-1; k >= 0; k--) {
			DataNode cur1 = list.getHead();
			DataNode cur2 = cur1.getNext();
			while (cur2.hasNext()) {
				System.out.println("cur1: " + (int) cur1.getKey().charAt(k));
				System.out.println("cur2: " + (int) cur2.getKey().charAt(k));
				if (cur1.getKey().charAt(k) > cur2.getKey().charAt(k)) {
					cur2.getPrev().setNext(cur2.getNext());
					cur2.getNext().setPrev(cur2.getPrev());
					DataNode cur3 = list.getHead();
					System.out.println("cur3: " + (int) cur3.getKey().charAt(k));
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
