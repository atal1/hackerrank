package me.algos.hackerrank.palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.stream.IntStream;

class Result {

	/*
	 * Complete the 'initialize' function below.
	 *
	 * The function accepts STRING s as parameter.
	 */

	static String str;

	public static void initialize(String s) {
		// This function is called once before all queries.
		str = s;

	}

	/*
	 * Complete the 'answerQuery' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER l 2. INTEGER r
	 */

	public static int answerQuery(int l, int r) {
		HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
		for (int i = l - 1; i < r; i++) {
			Character c = str.charAt(i);
			if (myMap.containsKey(c))
				myMap.put(c, myMap.get(c) + 1);
			else
				myMap.put(c, 1);
		}
		int numberOfDoubles = 0;
		int numberOfSingles = 0;
		int[] arr = new int[myMap.size()];
		int i = 0;
		for (Character c : myMap.keySet()) {
			int value = myMap.get(c);
			numberOfDoubles += value / 2;
			arr[i] = value / 2;
			i++;
			numberOfSingles += value % 2;
		}

		BigInteger numberOfDoubles1 = fact(numberOfDoubles);
		for (int j = 0; j < arr.length; j++)
			numberOfDoubles1 = numberOfDoubles1.divide(fact(arr[j]));
		if (numberOfSingles > 0)
			numberOfDoubles1=numberOfDoubles1.multiply(BigInteger.valueOf(numberOfSingles
					));

		numberOfDoubles1 = numberOfDoubles1.mod(new BigInteger("1000000007"));
		return numberOfDoubles1.intValue();

	}

	static BigInteger fact(int i) {
		BigInteger k = new BigInteger("1");
		for (int j = 2; j <= i; j++)
			k = k.multiply(new BigInteger(String.valueOf(j)));
		return k;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String s = bufferedReader.readLine();

		Result.initialize(s);

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, q).forEach(qItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int l = Integer.parseInt(firstMultipleInput[0]);

				int r = Integer.parseInt(firstMultipleInput[1]);

				int result = Result.answerQuery(l, r);

				System.out.println(result);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();

	}
}
