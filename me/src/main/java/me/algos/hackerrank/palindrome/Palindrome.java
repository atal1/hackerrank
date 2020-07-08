package me.algos.hackerrank.palindrome;

import java.math.BigInteger;
import java.util.HashMap;

public class Palindrome {

	public static void main(String[] args) {

		System.out.println(maxCount("",1, 77540));

	}

	public static int maxCount(String str, int l, int r) {
		HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
		for (int i = l - 1; i < r; i++) {
			Character c = str.charAt(i);
			if (myMap.containsKey(c))
				myMap.put(c, myMap.get(c) + 1);
			else
				myMap.put(c, 1);
		}
		System.out.println(myMap);
		int numberOfDoubles = 0;
		int numberOfSingles = 0;
		int[] arr = new int[myMap.size()];
		int i =0;
		
		for (Character c : myMap.keySet()) {
			int value = myMap.get(c);
			int dividedValue = value / 2;
			numberOfDoubles += dividedValue;
			arr[i]=value/2;
			i++;
			System.out.println(dividedValue);
//			for (int j = 0; j < dividedValue; j++)
//				myString += c.toString();
			numberOfSingles += value % 2;
		}
//		printDistinctPermutn(myString, "");

		BigInteger numberOfDoubles1= fact(numberOfDoubles);
		for(int j =0; j< arr.length;j++)
			numberOfDoubles1=numberOfDoubles1.divide(fact(arr[j]));
		if (numberOfSingles > 0)
			numberOfDoubles1 = numberOfDoubles1.multiply(new BigInteger(String.valueOf(numberOfSingles)));

		return numberOfDoubles1.intValue();
	}

	static BigInteger fact(int N) {
	      BigInteger f = new BigInteger("1"); // Or BigInteger.ONE 
	      
	        // Multiply f with 2, 3, ...N 
	        for (int i = 2; i <= N; i++) 
	            f = f.multiply(BigInteger.valueOf(i)); 
	  
	        return f; 
	}

	static void printDistinctPermutn(String str, String ans) {

// If string is empty 
		if (str.length() == 0) {

// print ans 
			System.out.print(ans + " ");
			return;
		}

// Make a boolean array of size '26' which 
// stores false by default and make true  
// at the position which alphabet is being 
// used 
		boolean alpha[] = new boolean[26];

		for (int i = 0; i < str.length(); i++) {

// ith character of str 
			char ch = str.charAt(i);

// Rest of the string after excluding  
// the ith character 
			String ros = str.substring(0, i) + str.substring(i + 1);

// If the character has not been used  
// then recursive call will take place.  
// Otherwise, there will be no recursive 
// call 
			if (alpha[ch - 'a'] == false)
				printDistinctPermutn(ros, ans + ch);
			alpha[ch - 'a'] = true;
		}
	}

	static void printPermutn(String str, String ans) {

		// If string is empty
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String ros = str.substring(0, i) + str.substring(i + 1);

			// Recurvise call
			printPermutn(ros, ans + ch);
		}
	}

}
