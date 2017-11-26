import java.util.Stack;

public abstract class dataStruct 
{
	private int keylength;
	
	
	public int getKeylenght()
	{
		return keylength;
	}
	
	public void setKeylenght(int x)
	{
		keylength = x;
	} 
	
	public abstract void allKeys();
	
	public abstract void add(String key, String value);
	
	public abstract void remove(String key);
	
	public abstract String getValues(String key);
	
	public abstract String nextKey(String key);
	
	public abstract String prevKey(String key);
	
	public abstract Stack<String> previousCar(String key);
	
}