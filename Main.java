import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		int size = 0;
		int[][] m = null;
		String Ifilename;
		String Ofilename;
		FileReader FR = null;
		BufferedReader BR = null;
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Input a file name: ");
		Ifilename = kb.nextLine();
		System.out.print("\n");
		System.out.print("Input an out file name: ");
		Ofilename = kb.nextLine();
		System.out.print("\n");

		
		//reading the file and constructor
		try{
			int t = 0;
			FR = new FileReader("input.txt");
			BR = new BufferedReader(FR);
			String line;
			line = BR.readLine();
			while(line != null)
			{
				String[] words = line.split("\\ ");
				
				if(t == 0)
				{					
					size = Integer.parseInt(words[0]);
					//System.out.println("size: "+ size);
					m = new int[size][size];
					t++;
				}
				else
				{
					//System.out.println("words: "+ words[0]);
					//System.out.println("while");
					for(int i = 0; i < size; i++)
			    	{
			    		m[t-1][i] = Integer.parseInt(words[i]);
			    	}
			    	t++;
				}

				if(size == 0)
				{
					
				}
				else if(t == size+1)
			    {
			    	Matrix m1= new Matrix(m);
			    	System.out.println("Matri:");
			    	for(int i = 0; i < size; i++)
			    	{
			    		for(int j = 0; j < size; j++)
			    		{
			    			System.out.print(m[i][j]+ "");
			    		}
			    		System.out.println("");
			    	}
			    	t = 0;
			    }
			    line = BR.readLine();
			    //System.out.println("line"+line);
			}
			BR.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}


