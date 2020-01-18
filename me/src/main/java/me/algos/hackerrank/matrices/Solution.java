package me.algos.hackerrank.matrices;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the formingMagicSquare function below.
	static int formingMagicSquare(int[][] s) {
		int[][] magicSet = { { 8, 1, 6, 6, 1, 8, 4, 9, 2, 2, 9, 4, 8, 3, 4, 4, 3, 8, 6, 7, 2, 2, 7, 6 },
				{ 3, 5, 7, 7, 5, 3, 3, 5, 7, 7, 5, 3, 1, 5, 9, 9, 5, 1, 1, 5, 9, 9, 5, 1 },
				{ 4, 9, 2, 2, 9, 4, 8, 1, 6, 6, 1, 8, 6, 7, 2, 2, 7, 6, 8, 3, 4, 4, 3, 8 } };
		int cost = 100;
		int sum = 0;
		for (int k = 0; k < 24; k += 3) {
			for (int j = 0; j < 3; j++) {
				for (int l = k; l < k + 3; l++) {
					sum += Math.abs(s[j][l % 3] - magicSet[j][l]);
				}

			}
			if (sum < cost)
				cost = sum;
			sum = 0;
		}

		return cost;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int[][] s = new int[3][3];

		for (int i = 0; i < 3; i++) {
			String[] sRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int sItem = Integer.parseInt(sRowItems[j]);
				s[i][j] = sItem;
			}
		}

		int result = formingMagicSquare(s);
		System.out.println(result);
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
