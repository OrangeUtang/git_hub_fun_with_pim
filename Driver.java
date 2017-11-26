import java.util.Arrays;

public class Driver 
{

	public static void main(String[] args)
	{
		SmartAR jp = new SmartAR(6, 10, 250);
		String[] keys = jp.generate(10);
		System.out.println(Arrays.toString(keys));
		for (int i = 0; i < keys.length; i++) {
			jp.add(keys[i], "Value: " + i);
		}
		
		
		
		
		
	}
	

}

