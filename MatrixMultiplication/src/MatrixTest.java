

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class MatrixTest {
	@Rule
    public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void test01() throws IOException {
		// file: create & add matrix
		File file1 = folder.newFile("matrix1.txt");
		PrintWriter matrix1 = new PrintWriter(file1);
		File file2 = folder.newFile("matrix2.txt");
		PrintWriter matrix2 = new PrintWriter(file2);
		matrix1.println( "4x2" );
		matrix1.println( "1 2" );
		matrix1.println( "3 4" );
		matrix1.println( "5 6" );
		matrix1.println( "7 8" );
		matrix1.close();
		matrix2.println( "2x3" );
		matrix2.println( "1 2 3" );
		matrix2.println( "4 5 6" );
		matrix2.close();
		// invoke method
		File file = Matrix.multiply( file1, file2);
		// file: check results
		assertTrue( "File does not exist", file1.exists() );
		assertTrue( "File does not exist", file2.exists() );
		assertNotNull("Returned null instead of a File", file);
		String  actual, expected;
		Scanner scan = new Scanner( file );
		actual   = scan.nextLine().trim(); 
		expected = "4x3";
		assertEquals( "Incorrect result", expected, actual );
		actual   = scan.nextLine().trim(); 
		expected = "9 12 15";
		assertEquals( "Incorrect result", expected, actual );
		actual   = scan.nextLine().trim();
		expected = "19 26 33";
		assertEquals( "Incorrect result", expected, actual );
		actual   = scan.nextLine().trim();
		expected = "29 40 51";
		assertEquals( "Incorrect result", expected, actual );
		actual   = scan.nextLine().trim();
		expected = "39 54 69";
		assertEquals( "Incorrect result", expected, actual );
		assertFalse ( "File shouldn't have more data", scan.hasNext() );
		scan.close();
	}

	@Test
	public void test02() throws IOException {
		// file: create & add matrix
		File file1 = folder.newFile("matrixa.txt");
		PrintWriter matrix1 = new PrintWriter(file1);
		File file2 = folder.newFile("matrixb.txt");
		PrintWriter matrix2 = new PrintWriter(file2);
		matrix1.println( "2x3" );
		matrix1.println( "1 2 1" );
		matrix1.println( "3 4 4" );
		matrix1.close();
		matrix2.println( "3x2" );
		matrix2.println( "2 3" );
		matrix2.println( "5 6" );
		matrix2.println( "7 8" );
		matrix2.close();
		// invoke method
		File file = Matrix.multiply( file1, file2);
		// file: check results
		assertTrue( "File does not exist", file1.exists() );
		assertTrue( "File does not exist", file2.exists() );
		assertNotNull("Returned null instead of a File", file);
		String  actual, expected;
		Scanner scan = new Scanner( file );
		actual   = scan.nextLine().trim(); 
		expected = "2x2";
		assertEquals( "Incorrect result", expected, actual );
		actual   = scan.nextLine().trim(); 
		expected = "19 23";
		assertEquals( "Incorrect result", expected, actual );
		actual   = scan.nextLine().trim();
		expected = "54 65";
		assertEquals( "Incorrect result", expected, actual );
		assertFalse ( "File shouldn't have more data", scan.hasNext() );
		scan.close();
	}

	@Test
	public void test03() throws IOException {
		// file: create & add matrix
		File file1 = folder.newFile("matrixa.txt");
		PrintWriter matrix1 = new PrintWriter(file1);
		File file2 = folder.newFile("matrixb.txt");
		PrintWriter matrix2 = new PrintWriter(file2);
		matrix1.println( "2x2" );
		matrix1.println( "1 2" );
		matrix1.println( "5 6" );
		matrix1.close();
		matrix2.println( "2x2" );
		matrix2.println( "3 4" );
		matrix2.println( "7 8" );
		matrix2.close();
		// invoke method
		File file = Matrix.multiply( file1, file2);
		// file: check results
		assertTrue( "File does not exist", file1.exists() );
		assertTrue( "File does not exist", file2.exists() );
		assertNotNull("Returned null instead of a File", file);
		String  actual, expected;
		Scanner scan = new Scanner( file );
		actual   = scan.nextLine().trim(); 
		expected = "2x2";
		assertEquals( "Incorrect result", expected, actual );
		actual   = scan.nextLine().trim(); 
		expected = "17 20";
		assertEquals( "Incorrect result", expected, actual );
		actual   = scan.nextLine().trim();
		expected = "57 68";
		assertEquals( "Incorrect result", expected, actual );
		assertFalse ( "File shouldn't have more data", scan.hasNext() );
		scan.close();
	}

	@Test(expected = IllegalMultiplicationException.class)
	public void test04() throws IOException {
		File file1 = folder.newFile("matrixa.txt");
		PrintWriter matrix1 = new PrintWriter(file1);
		File file2 = folder.newFile("matrixb.txt");
		PrintWriter matrix2 = new PrintWriter(file2);
		matrix1.println( "2x2" );
		matrix1.println( "1 2" );
		matrix1.println( "5 6" );
		matrix1.close();
		matrix2.println( "3x3" );
		matrix2.println( "3 4 0" );
		matrix2.println( "7 8 0" );
		matrix2.println( "0 0 0" );
		matrix2.close();
		// invoke method
		File file = Matrix.multiply( file1, file2);
		fail("IllegalMultiplicationException should have been thrown");
	}

}

