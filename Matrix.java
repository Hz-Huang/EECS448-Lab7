
public class Matrix {
	
	private int size;
	private int[][] x;
	
	//Constructor of the Matrix
	public Matrix(int s)
	{
		size = s;
		x = new int[size][size];
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
	public int getEntry(int a, int b)
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
}
