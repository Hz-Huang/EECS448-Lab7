
public class Matrix {
	
	private int[][] x;
	
	//Constructor of the Matrix
	public Matrix(int s)
	{
		x = new int[s][s];
	}
	
	//return the size of the matrix
	public int getSize()
	{
		return x.length;
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
		sub = 
		
		return sub;
	}
}
