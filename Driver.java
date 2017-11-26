import java.util.Arrays;

public class Driver {

<<<<<<< HEAD
	public static void main(String[] args) {
		//SmartAR jp = new SmartAR(6, 10, 250);
		//String[] keys = jp.generate(10);
		String[] keys = {"XIUFA7", "3847SJ", "234987", "HDSWIEU", "2K8H8G", "3KLDO3"};
		System.out.println(Arrays.toString(keys));
		//for (int i = 0; i < keys.length; i++) {		
=======
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
		
		
		
		
>>>>>>> ce6ee2014325e49115c2c8591be3c37fa5db698d
		
	}

}

