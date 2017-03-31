import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixTest {

	@Test
	public void testGetSize() {
		Matrix m = new Matrix(5);
		assertEquals(5, m.getSize(), 0.001);
	}

	@Test
	public void testGetEntry() {
		Matrix m = new Matrix(4);
		m.setEntry(2, 3, 25);
		assertEquals(25, m.getEntry(2, 3), 0.001);
	}

	@Test
	public void testSubMatrix() {
		Matrix m = new Matrix(3);
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				m.setEntry(i, j, i);
			}
		}
		assertEquals(1, m.subMatrix(0, 1).getEntry(0, 0), 0.001);
		assertEquals(1, m.subMatrix(0, 1).getEntry(0, 1), 0.001);
		assertEquals(2, m.subMatrix(0, 1).getEntry(1, 0), 0.001);
		assertEquals(2, m.subMatrix(0, 1).getEntry(1, 1), 0.001);

	}

	@Test
	public void testDeterminant() {
		Matrix m = new Matrix(3);
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				m.setEntry(i, j, i+2);
			}
		}
		assertEquals(0, m.determinant(), 0.001);
		
	}

	@Test
	public void testInverse() {
		Matrix m = new Matrix(2);
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				m.setEntry(i, j, j+i);
			}
		}
		assertEquals(-2, m.inverse().getEntry(0, 0), 0.001);
		assertEquals(1, m.inverse().getEntry(0, 1), 0.001);
		assertEquals(1, m.inverse().getEntry(1, 0), 0.001);
		assertEquals(0, m.inverse().getEntry(1, 1), 0.001);
	}

}
