import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Driver 
{

	public static void main(String[] args)
	{
		
		
		SmartAR testAr = new SmartAR(6, 10, 25);
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
		
		
		//testing sorting
		Link sortedList= testAr.allKeys();
		DataNode dn = sortedList.getHead();
		while(dn.hasNext())
		{
			System.out.println(dn.getKey());
			dn = dn.getNext();
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
		Link sortedList2= testAR2.allKeys();
		DataNode dn2 = sortedList2.getHead();
		while(dn2.hasNext())
		{
			System.out.println(dn2.getKey());
			dn2 = dn2.getNext();
		}
		
		
		
		
		System.out.println();
		
		System.out.println("Strating Dynamic test, adding enough entry to initial test array to trigger dataStructure change");
		
		//Dynamic test
		String[] generatedKey3 = testAr.generate(30);
		for(int i = 0; i < generatedKey3.length; i++)
		{
			testAr.add(generatedKey3[i], "value" + i);
			System.out.print(generatedKey3[i] + "  ");
			System.out.println(testAr.getValues(generatedKey3[i]));
		}
		
		
		for(int i = 0; i < generatedKey.length; i++)
		{
			System.out.print(generatedKey[i] + "  ");
			System.out.println(testAr.getValues(generatedKey[i]));
		}
		
		for(int i = 0; i < generatedKey3.length; i++)
		{
			System.out.print(generatedKey3[i] + "  ");
			System.out.println(testAr.getValues(generatedKey3[i]));
		}
		
		System.out.println();
		
		if(testAr.getDataStructure() instanceof HashDataStruct)
		{
			System.out.println("Initial sequence is a HashStructure now");
		}
		
		System.out.println();
		System.out.println("Another test because apparently its necessary");
		
		SmartAR testAr4 = new SmartAR(7, 50, 100);
		String[] generatedKey4 = testAr4.generate(50);
		for(int i = 0; i < generatedKey4.length; i++)
		{
			testAr4.add(generatedKey4[i], "value" + i);
			System.out.print(generatedKey4[i] + "  ");
			System.out.println(testAr4.getValues(generatedKey4[i]));
		}
		
		System.out.println();
		System.out.println("Another test because apparently its necessary");
		
		SmartAR testAr5 = new SmartAR(8, 50, 100);
		String[] generatedKey5 = testAr5.generate(75);
		for(int i = 0; i < generatedKey5.length; i++)
		{
			testAr5.add(generatedKey5[i], "value" + i);
			System.out.print(generatedKey5[i] + "  ");
			System.out.println(testAr5.getValues(generatedKey5[i]));
		}
		
		
		System.out.println();
		System.out.println("reading the file first file and inputing them into a SmartAR objects");
		
		SmartAR testAr6 = new SmartAR(8, 5000, 10000);
		
		
		try {
			File file = new File("ar_test_file1.txt");
			
			FileReader fileReader = new FileReader(file);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			
			String line;
			while (bufferedReader.readLine() != null) 
			{
				line = bufferedReader.readLine();
				System.out.println(line);
				testAr6.add(line, "time value: " + System.currentTimeMillis());
				System.out.println(testAr6.getValues(line));
			}
			fileReader.close();
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	

}

