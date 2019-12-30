package me.algos.hackerrank.palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.TreeMap;
import java.util.stream.IntStream;

class Result1 {

	/*
	 * Complete the 'initialize' function below.
	 *
	 * The function accepts STRING s as parameter.
	 */

	static String str;
	static TreeMap<Integer,BigInteger> myMap= new TreeMap<Integer, BigInteger>();

	public static void initialize(String s) {
		// This function is called once before all queries.
		str = s.toLowerCase();
		myMap.put(0, BigInteger.valueOf(1)); 

	}

	/*
	 * Complete the 'answerQuery' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER l 2. INTEGER r
	 */

	public static int answerQuery(int l, int r) {
		int [] array = new int[26];
		for (int i = l - 1; i < r; i++) {
			int index = str.charAt(i);
			index%=97;
			array[index]+=1;
		}
	
		int numberOfDoubles = 0;
		int numberOfSingles = 0;
		for (int k =0; k < 26 ; k++) {
			numberOfSingles += array[k] % 2;
			array[k] = array[k]/2;
			numberOfDoubles += array[k] ;	
		}

		BigInteger numberOfDoubles1 = fact(numberOfDoubles);
		for (int j = 0; j < 26; j++)
			numberOfDoubles1 = numberOfDoubles1.divide(fact(array[j]));
		if (numberOfSingles > 0)
			numberOfDoubles1=numberOfDoubles1.multiply(BigInteger.valueOf(numberOfSingles
					));

		numberOfDoubles1 = numberOfDoubles1.mod(new BigInteger("1000000007"));
		return numberOfDoubles1.intValue();

	}

	static BigInteger fact(int i) {
		int m =myMap.floorKey(i);
		if(m==i)
			return myMap.get(i);                                  
		int j =i;
		BigInteger k = myMap.get(m);
		for (; i> m; i--)
			k = k.multiply(BigInteger.valueOf(i));
		myMap.put(j, k);
		return k;

	}

}

public class Solution2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String s = bufferedReader.readLine();

		Result1.initialize(s);

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, q).forEach(qItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int l = Integer.parseInt(firstMultipleInput[0]);

				int r = Integer.parseInt(firstMultipleInput[1]);

				int result = Result1.answerQuery(l, r);

				System.out.println(result);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();

	}
}
