
public class Driver 
{

	public static void main(String[] args)
	{
		
		
		SmartAR testAr = new SmartAR(6, 10, 500);
		System.out.println(testAr.getKeyLength());
		String[] generatedKey = testAr.generate(10);
		
		System.out.println(testAr.getKeyLength());
		
		
		for(int i = 0; i < generatedKey.length; i++)
		{
			System.out.println(generatedKey[i]);
		}
		
		
		
		
		
	}
	

}

