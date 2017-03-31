
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
	
	public Matrix subMatrix(int r, int c)
	{
		Matrix sub = new Matrix(size-1);
		int row = 0;
		for (int i = 0; i < size; ++i)
		{
			if (i != r)
			{
				int col = 0;
				for (int j = 0; j < size; ++j)
				{
					if (j != c)
					{
						sub.setEntry(row, col, x[i][j]);
					}
					col++;
				}
			}
			++row;
		}
		
		
		return sub;
	}
}
