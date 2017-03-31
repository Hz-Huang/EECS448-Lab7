
public class Matrix {
	
	private int size;
	private double[][] x;
	
	//Constructor of the Matrix
	public Matrix(int s)
	{
		size = s;
		x = new double[size][size];
	}
	
	//return the size of the matrix
	public int getSize()
	{
		return size;
	}
	
	public void setEntry(int r, int c,int n)
	{
		x[r][c] = n;
	}
	
	//get the entry in the matrix
	public double getEntry(int a, int b)
	{
		return x[a][b];
	}
	
	
	//create sub matrix of this matrix
	public Matrix subMatrix(int r, int c)
	{
		Matrix sub = new Matrix(size-1);
		int row = 0; 
		for (int i = 0; i < size; ++i)
		{
			if (i == r) continue;
			
			int col = 0;
			for (int j = 0; j < size; ++j)
			{
				if (j == c) continue;
				
				sub.x[row][col] = x[i][j];
				++col;
			}
			
			++row;
		}
		
		return sub;
	}
	
	//calculate determinant
	public double determinant()
	{
		double det = 0;
		if(x.length == 1)
		{
			det = x[0][0];
		}
		else if(x.length == 2)
		{
			det = (x[0][0] * x[1][1] - x[0][1] * x[1][0]);
		}
		else
		{
			for(int i = 0; i < size; i++)
			{
				det += Math.pow(-1.0, (double)i) * x[0][i] * subMatrix(0, i).determinant();
			}
		}
		return det;
	}
	
	public Matrix inverse()
	{
		Matrix inv = new Matrix(size);
		double det = determinant();
		
		for (int i = 0; i < size; ++i)
		{
			for (int j = 0; j < size; ++j)
			{
				inv.x[i][j] = Math.pow(-1.0, (double)i + j) * subMatrix(j, i).determinant() / det;
			}
		}
		
		return inv;
	}
	
	public void print()
	{
		for(int i = 0; i < size; i++)
    	{
    		for(int j = 0; j < size; j++)
    		{
    			System.out.print(x[i][j] + " ");
    		}
    		System.out.println("");
    	}
	}
}
