import java.util.ArrayList;
import java.util.Stack;

public class Driver 
{

	public static void main(String[] args)
	{
		
		
		SmartAR testAr = new SmartAR(6, 10, 500);
		String[] generatedKey = testAr.generate(10);
		
		System.out.println(testAr.getKeyLength());
		
		
		
		//testing the random generator
		for(int i = 0; i < generatedKey.length; i++)
		{
			System.out.println(generatedKey[i]);
		}
		
		System.out.println();
		
		//testing the add method
		for(int i = 0; i < generatedKey.length; i++)
		{
			testAr.add(generatedKey[i], "value" + i);
			System.out.print(generatedKey[i] + "  ");
			System.out.println(testAr.getValues(generatedKey[i]));
		}
		
		System.out.println();
		
		//testing remove methods
		for(int i =0; i<generatedKey.length; i++)
		{
			testAr.remove(generatedKey[i]);
			System.out.print(generatedKey[i] + "  ");
			System.out.println(testAr.getValues(generatedKey[i]));
		}
		
		System.out.println();
		
		//testing re-adding keys
		for(int i =0; i<generatedKey.length; i++)
		{
			testAr.add(generatedKey[i], "value" + i + i);
			System.out.print(generatedKey[i] + "  ");
			System.out.println(testAr.getValues(generatedKey[i]));
		}
		
		System.out.println();
		
		//testing get previous
		for(int i =0; i<generatedKey.length; i++)
		{
			System.out.print(generatedKey[i] + "  ");
			System.out.println(testAr.prevKey(generatedKey[i]));
		}
		
		System.out.println();
		
		//testing getNext
		for(int i =0; i<generatedKey.length; i++)
		{
			System.out.print(generatedKey[i] + "  ");
			System.out.println(testAr.nextKey(generatedKey[i]));
		}
		
		System.out.println();
		
		//testing getCar method
		for(int i =0; i<generatedKey.length; i++)
		{
			Stack<String> previousStack = testAr.previousCar(generatedKey[i]);
			
			System.out.println(generatedKey[i]);
			while(!previousStack.isEmpty())
			{
			System.out.println(previousStack.peek());
			previousStack.pop();
			}
			
			System.out.println();
			
		}
		
		System.out.println();
		
		ArrayList<DataNode> sortedList= testAr.allKeys();
		for(int i = 0; i < sortedList.size(); i++)
		{
			System.out.println(sortedList.get(i).getKey());
			
		}
		
		
		
		
		
		//____________________________Second test case ______________________________________________\\
		
		SmartAR testAR2 = new SmartAR(6, 51, 50);
		String[] generatedKey2 = testAR2.generate(51);
		
		System.out.println(testAR2.getKeyLength());
		
		//testing the random generator
		for(int i = 0; i < generatedKey2.length; i++)
		{
			System.out.println(generatedKey2[i]);
		}
				
		System.out.println();
				
		//testing the add method
		for(int i = 0; i < generatedKey2.length; i++)
		{
			testAR2.add(generatedKey2[i], "value" + i);
			System.out.print(generatedKey2[i] + "  ");
			System.out.println(testAR2.getValues(generatedKey2[i]));
		}
		
		System.out.println();
				
		//testing remove methods
		for(int i =0; i<generatedKey2.length; i++)
		{
			testAR2.remove(generatedKey2[i]);
			System.out.print(generatedKey2[i] + "  ");
			System.out.println(testAR2.getValues(generatedKey2[i]));
		}
				
		System.out.println();
				
		//testing re-adding keys
		for(int i =0; i<generatedKey2.length; i++)
		{
			testAR2.add(generatedKey2[i], "value" + i + i);
			System.out.print(generatedKey2[i] + "  ");
			System.out.println(testAR2.getValues(generatedKey2[i]));
		}
		
		System.out.println();
				
		//testing get previous
		for(int i =0; i<generatedKey2.length; i++)
		{
			System.out.print(generatedKey2[i] + "  ");
			System.out.println(testAR2.prevKey(generatedKey2[i]));
		}
				
		System.out.println();
		
		//testing NextKey
		for(int i =0; i<generatedKey2.length; i++)
		{
			System.out.print(generatedKey2[i] + "  ");
			System.out.println(testAR2.nextKey(generatedKey2[i]));
		}
				
		System.out.println();
				
		//testing getCar method
		for(int i =0; i<generatedKey2.length; i++)
		{
			Stack<String> previousStack = testAR2.previousCar(generatedKey2[i]);
					
			System.out.println(generatedKey2[i]);
			while(!previousStack.isEmpty())
			{
			System.out.println(previousStack.peek());
			previousStack.pop();
			}
					
			System.out.println();
		}
		
		
		//testing sorting
		ArrayList<DataNode> sortedList2= testAR2.allKeys();
		for(int i = 0; i < sortedList2.size(); i++)
		{
			System.out.println(sortedList2.get(i).getKey());
			
		}
		
	}
	

}

