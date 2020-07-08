/**
 * 
 */
package me.algos.hackerrank.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Atal
 *
 */
public class MatrixRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int m = Integer.parseInt(mnr[0]);

		int n = Integer.parseInt(mnr[1]);

		int r = Integer.parseInt(mnr[2]);

		int[][] matrix = new int[m][n];
		String[] numbers;
		for (int i = 0; i < m; i++) {
			numbers = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(numbers[j]);
			}

		}

		matrixRotation(matrix, m, n, r);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}

		bufferedReader.close();
	}

	public static int[][] matrixToArray(int row, int column, int currentRow, int currentColumn, int matrix[][],
			int numberOfTimes) {
		int[] matrixArray = new int[2 * (row + column - 2)];
		row += currentRow;
		column += currentColumn;
		int k = 0;
		int startRow = currentRow;
		int startColumn = currentColumn;
		while (currentRow < row - 1) {

			matrixArray[k] = matrix[currentRow][currentColumn];
			currentRow++;
			k++;
		}
		while (currentColumn < column - 1) {

			matrixArray[k] = matrix[currentRow][currentColumn];
			currentColumn++;
			k++;
		}
		while (currentRow - startRow != 0) {

			matrixArray[k] = matrix[currentRow][currentColumn];
			currentRow--;
			k++;
		}
		while (currentColumn - startColumn != 0) {
			matrixArray[k] = matrix[currentRow][currentColumn];
			currentColumn--;
			k++;
		}
		int length = matrixArray.length;
		for (int each : matrixArray)
			System.out.print(each + " ");
		System.out.println();

		numberOfTimes = numberOfTimes % (length);
//		System.out.println(numberOfTimes);
		int[] tempMatrixArray = new int[length];
		for (int i = 0; i < length; i++) {
			tempMatrixArray[(i + numberOfTimes) % (length)] = matrixArray[i];

		}
		matrixArray = tempMatrixArray;
		for (int each : matrixArray)
			System.out.print(each + " ");
		System.out.println();

		currentRow = startRow;
		currentColumn = startColumn;
		k = 0;

		while (currentRow < row - 1) {

			matrix[currentRow][currentColumn] = matrixArray[k];
			currentRow++;
			k++;
		}
		while (currentColumn < column - 1) {

			matrix[currentRow][currentColumn] = matrixArray[k];
			currentColumn++;
			k++;
		}
		while (currentRow - startRow != 0) {

			matrix[currentRow][currentColumn] = matrixArray[k];
			currentRow--;
			k++;
		}
		while (currentColumn - startColumn != 0) {
			matrix[currentRow][currentColumn] = matrixArray[k];
			currentColumn--;
			k++;
		}

		return matrix;
	}

	static void matrixRotation(int matrix[][], int n, int m, int r) {

		int half = (n<m)?(n/2): m/2;
		for (int i = 0; i < half; i++) {
			matrixToArray(n - (2 * i), m - (2 * i), i, i, matrix, r);
			System.out.println(
					"-----------------------------------------------------------------------------------------------------");
		}

		return;

	}

}
