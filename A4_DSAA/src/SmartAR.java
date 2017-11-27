import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;

public class SmartAR 
{
	
	private dataStruct dataStructure;
	private int keyLength;
	private boolean initKeyLenght;
	private int threshold;
	private long expectedDataCount;
	private long dataCount;
	
	
	SmartAR(int keylength, int numbrData, int thresh)
	{
		expectedDataCount = numbrData;
		this.keyLength = keylength;
		setThreshold(thresh);
		
		dataCount = 0;
		
		if(thresh > numbrData)
		{
			dataStructure = new SequenceDataStruct(keylength, numbrData);
		}
		
		else
		{
			dataStructure = new HashDataStruct(keylength, numbrData);
		}
		
		setKeyLength(keylength);
		
	}
	
	public void setThreshold(int thres)
	{
		//must check if threshold is an acceptable value.
		if(thres < 100)
			return;
		
		if(thres > 500000)
			return;
		
		//if it is, set it.
		threshold = thres;
	}
	
	
	
	public void setKeyLength(int length)
	{
		//must check if length is an acceptable value.
		if(length < 6)
			return;
		
		if(length >12)
			return;
		
		//if it is change length in both dataStructure object and the value contained in this object
		keyLength = length;
		dataStructure.setKeylenght(length);
	}
	
	
	
	public String[] generate(int n)
	{
		boolean previouslyCreated = false;
		String[] generatedKey = new String[n];
		int successfulGeneration = 0;
		
		//for n entries
		for(int i = 0; i<n; i++)
		{
			int lenghtCounter = 0;
			String genKey = new String("");
			
			
			//creating a random alpha-numerical String
			while(lenghtCounter != keyLength)
			{
				String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
				int charLocation = (int)(Math.random() * possibleChars.length());
				String charAt = new String(possibleChars.substring(charLocation, charLocation+1));
				genKey = genKey + charAt;
				lenghtCounter++;
			}
			
			//look in the generated key array for existing occurrence of the Key
			for(int j = 0; j< successfulGeneration; j++)
			{
				if(generatedKey[j].equals(genKey))
				{
					previouslyCreated = true;
				}
			}
			
			//verifying if Key is in data Structure.
			if((dataStructure.getValues(genKey).equals("_") || dataStructure.getValues(genKey).equals("*")) && !previouslyCreated)
			{
				generatedKey[i] = genKey;
				successfulGeneration++;
			}
			
			//if it is we will have to generate a new key.
			else
			{
				i--;
			}
		}
		
		return generatedKey;
		
	}
	
	
	
	public Link allKeys()
	{
		return dataStructure.allKeys();
	}
	
	
	
	public void add(String key, String value)
	{
		if(key.length() != keyLength)
		{
			System.out.println("KeyLenght is invalid");
			return;
		}
		
		if(dataCount == threshold && dataStructure instanceof SequenceDataStruct)
		{
			System.out.println("dataCount has exceded expected data count, changing data structure");
			upDataStruct(threshold*2);
		}
		
		if(dataStructure.getValues(key).equals("*"))
		{
		dataStructure.add(key, value);
		dataCount++;
		}
		
		else if(dataStructure.getValues(key).equals("_"))
		{
			dataStructure.add(key, value);
		}
		
	}
	
	
	
	
	public void remove(String key)
	{
		if(key.length() != keyLength)
		{
			System.out.println("KeyLenght is invalid");
			return;
		}
		dataStructure.remove(key);
	}
	
	
	
	
	public String getValues(String key)
	{
		if(key.length() != keyLength)
		{
			System.out.println("KeyLenght is invalid");
			return "";
		}
		return dataStructure.getValues(key);
		
	}
	
	
	
	
	public String nextKey(String key)
	{
		if(key.length() != keyLength)
		{
			System.out.println("KeyLenght is invalid");
			return "";
		}
		return dataStructure.nextKey(key);
		
	}
	
	
	
	
	public String prevKey(String key)
	{
		if(key.length() != keyLength)
		{
			System.out.println("KeyLenght is invalid");
			return "";
		}
		return dataStructure.prevKey(key);
		
	}
	
	public Stack<String> previousCar(String key) 
	{
		return dataStructure.previousCar(key);
	}
	

	
	
	
	//mutators and accessors
	public dataStruct getDataStructure() 
	
	{
		return dataStructure;
	}



	public void setDataStructure(dataStruct dataStructure) 
	{
		this.dataStructure = dataStructure;
	}



	public int getKeyLength() 
	{
		return keyLength;
	}



	public void setKeyLenght(int keyLenght) 
	
	{
		if(initKeyLenght)
		{
			System.out.println("KeyLenght has already been defined");
			return;
		}
		
		this.keyLength = keyLenght;
	}



	public long getExpectedDataCount() 
	{
		return expectedDataCount;
	}



	public void setExpectedDataCount(int expectedDataCount) 
	{
		if(dataCount > expectedDataCount)
		{
			System.out.println("Number of entries is larger than the expected data numbers, try again");
			return;
		}
		
		this.expectedDataCount = expectedDataCount;
	}



	public long getDataCount() 
	{
		return dataCount;
		
	}



	public void setDataCount(int dataCount) 
	{
		this.dataCount = dataCount;
		
	}



	public long getThreshold() 
	{
		return threshold;
		
	}
	
	
	//size related functions
	public void upDataStruct(int expectedDataNumbr)
	{
		SequenceDataStruct temporaryArray = (SequenceDataStruct)this.getDataStructure(); 
		
		HashDataStruct newDataStruct = new HashDataStruct(keyLength, expectedDataNumbr);
		
		//pushing all data from array to hashtable
		for(int i = 0; i < temporaryArray.getSize(); i++)
		{	
			DataNode tempNode = temporaryArray.getNodeAt(i);
			
			newDataStruct.add(tempNode.getKey(), tempNode);
			
		}
		
		dataStructure = newDataStruct;
	}
	
	
	public void downDataStruct(int expectedDataNumbr)
	{
		HashDataStruct temporaryStruct = (HashDataStruct)this.getDataStructure();
		
		SequenceDataStruct newDataStruct = new SequenceDataStruct(keyLength, expectedDataNumbr); 
		
		//pushing all data from hash to arraylist
		Set<String> hashKeySet = temporaryStruct.getKeySet();
		for(String value : hashKeySet)
		{				
            DataNode tempNode = temporaryStruct.getTable().get(value);
            
            newDataStruct.add(tempNode);
        
        }
		
		//finalizing switch
		dataStructure = newDataStruct;
	}
	
	
}
