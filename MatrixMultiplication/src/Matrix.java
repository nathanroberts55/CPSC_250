import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Matrix {

	public static File multiply(File file1, File file2) {

		File outFile = new File("outFile.txt");

		try {
			Scanner scnr1 = new Scanner(file1);
			Scanner scnr2 = new Scanner(file2);

			String name = "outFile.txt";

			PrintWriter print = new PrintWriter(name);

			// Creating first file array
			String firstLine1 = scnr1.next();
			
			String[] arrayOneSize = firstLine1.split("x");
			int arrayOneRows = Integer.parseInt(arrayOneSize[0]);
			int arrayOneCols = Integer.parseInt(arrayOneSize[1]);
			
			int[][] fileOneArray = new int[arrayOneRows][arrayOneCols];
			

			// Creating first file array
			String firstLine2 = scnr2.next();
			
			String[] arrayTwoSize = firstLine2.split("x");
			int arrayTwoRows = Integer.parseInt(arrayTwoSize[0]);
			int arrayTwoCols = Integer.parseInt(arrayTwoSize[1]);
			int[][] fileTwoArray = new int[arrayTwoRows][arrayTwoCols];
			

			
			for (int i = 0; i < arrayTwoRows; i++) {
				for (int j = 0; j < arrayTwoCols; j++) {
					fileTwoArray[i][j] = Integer.parseInt(scnr2.next());
				}
			}
			
			for (int i = 0; i < arrayOneRows; i++) {
				for (int j = 0; j < arrayOneCols; j++) {
					fileOneArray[i][j] = Integer.parseInt(scnr1.next());
				}
			}
			

			int[][] newMatrix = new int[arrayOneRows][arrayTwoCols];
			int sum = 0;
			
			
				

				for (int a = 0; a < arrayOneRows; a++) {
					for (int b = 0; b < arrayTwoCols; b++) {
						for (int c = 0; c < arrayTwoRows; c++) {
							sum = sum + fileOneArray[a][c] * fileTwoArray[c][b];
						}

						newMatrix[a][b] = sum;
						sum = 0;
					}
				}
			
				
			
			
			print.println(arrayOneRows + "x" + arrayTwoCols);
			for (int d = 0; d < arrayOneRows; d++) {
				for (int e = 0; e < arrayTwoCols; e++) {
					
					print.print(newMatrix[d][e] + " ");
				}
				
				print.println(" ");
			}

			scnr1.close();
			scnr2.close();
			print.close();

		} catch (FileNotFoundException e) {

		}catch(IllegalMultiplicationException e){
			throw new IllegalMultiplicationException();
		} catch(RuntimeException e){
			throw new IllegalMultiplicationException();
		}

		return outFile;
	}

}
