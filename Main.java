import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
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
		File file;
		FileReader FR = null;
		BufferedReader BR = null;
		FileWriter FW = null;
		BufferedWriter BW = null;
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Input a file name: ");
		Ifilename = kb.nextLine();
		System.out.print("\n");
		System.out.print("Input an out file name: ");
		Ofilename = kb.nextLine();
		System.out.print("\n");
		file = new File(Ofilename);

		
		//reading the file and construct both the matrix and its inverse matrix
		//then write the matrix, determinant, and inverse into a file
		try{
			int t = 0;
			FR = new FileReader(Ifilename);
			BR = new BufferedReader(FR);
			String line;
			line = BR.readLine();
			while(line != null)
			{
				String[] words = line.split("\\ ");
				
				if(t == 0)
				{					
					size = Integer.parseInt(words[0]);
					m = new int[size][size];
					t++;
				}
				else
				{
					for(int i = 0; i < size; i++)
			    	{
			    		m[t-1][i] = Integer.parseInt(words[i]);
			    	}
			    	t++;
				}

				if(size == 0)
				{
					continue;
				}
				else if(t == size+1)
			    {
			    	Matrix m1 = new Matrix(size);
			    	for(int i = 0; i < size; i++)
			    	{
			    		for(int j = 0; j < size; j++)
			    		{
			    			m1.setEntry(i, j, m[i][j]);
			    		}
			    	}
			    	Matrix inv = m1.inverse();
			    	t = 0;
			    	
			    	//start to write the output file
			    	try{
						FW = new FileWriter(file.getAbsoluteFile(), true);
						BW = new BufferedWriter(FW);
						
						BW.write("M=");
						BW.newLine();
						for(int i = 0; i< m1.getSize(); i++)
						{
							for(int j = 0; j < m1.getSize(); j++)
							{
								BW.write(m1.getEntry(i, j) + " ");
							}
							BW.newLine();
						}
						BW.write("DET: "+ m1.determinant());
						BW.newLine();
						BW.write("Minv= ");
						BW.newLine();
						for(int i = 0; i< m1.getSize(); i++)
						{
							for(int j = 0; j < m1.getSize(); j++)
							{
								BW.write(inv.getEntry(i, j) + " ");
							}
							BW.newLine();
						}
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
			    	finally 
			    	{
						try 
						{
							if (BW != null)
								BW.close();

							if (FW != null)
								FW.close();
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
						}
					}
			    }
			    line = BR.readLine();
			}
			BR.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}	
}


