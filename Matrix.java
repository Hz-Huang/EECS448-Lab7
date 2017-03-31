
public class Matrix {
	
	private int[][] x;
	
	//Constructor of the Matrix
	public Matrix(int[][] m)
	{
		x = m;
	}
	
	//return the size of the matrix
	public int getSize()
	{
		return x.length;
	}
	
	//get the entry in the matrix
	public int getEntry(int a, int b)
	{
		return x[a][b];
	}
}
