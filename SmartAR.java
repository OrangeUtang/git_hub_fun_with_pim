import java.util.Arrays;

public class SmartAR 
{
	
	private dataStruct dataStructure;
	private int keyLength;
	private boolean initKeyLenght;
	private long threshold;
	private long expectedDataCount;
	private long dataCount;
	
	
	SmartAR(int keylength, int numbrData)
	{
		expectedDataCount = numbrData;
		this.keyLength = keylength; 
		
		
	}
	

	
	public void setThreshold(long thres)
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
		
		//for n entries
		for(int i = 0; i<n; i++)
		{
			int lenghtCounter = 0;
			String genKey = "";
			
			
			//creating a random alpha-numerical String
			while(lenghtCounter != keyLength)
			{
				String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
				int charLocation = (int)(Math.random() * possibleChars.length());
				String charAt = possibleChars.substring(charLocation, charLocation);
				genKey.concat(charAt);
				lenghtCounter++;
			}
			
			//look in the generated key array for existing occurrence of the Key
			for(int j = 0; j< n; j++)
			{
				if(generatedKey[j].equals(genKey))
				{
					previouslyCreated = true;
				}
			}
			
			//verifying if Key is in data Structure.
			if(dataStructure.getValues(genKey).equals("_") && !previouslyCreated)
			{
				generatedKey[i] = genKey;
			}
			
			//if it is we will have to generate a new key.
			else
			{
				i--;
			}
		}
		
		return generatedKey;
		
	}
	
	
	
	public void allKeys()
	{
		dataStructure.allKeys();
	}
	
	
	
	public void add(String key, String value)
	{
		if(key.length() != keyLength)
		{
			System.out.println("KeyLenght is invalid");
			return;
		}
		
		if(dataCount > expectedDataCount)
		{
			System.out.println("dataCount has exceded expected data count, will have to change data structure");
			return;
		}
		dataStructure.add(key, value);
		dataCount++;
	}
	
	
	
	
	public void remove(String key)
	{
		if(key.length() != keyLength)
		{
			System.out.println("KeyLenght is invalid");
			return;
		}
		dataCount--;
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

	
	
	
	//mutators and accessors
	public dataStruct getDataStructure() {
		return dataStructure;
	}



	public void setDataStructure(dataStruct dataStructure) {
		this.dataStructure = dataStructure;
	}



	public int getKeyLength() {
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



	public long getDataCount() {
		return dataCount;
	}



	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}



	public long getThreshold() {
		return threshold;
	}
	
	
	
	
	
}
