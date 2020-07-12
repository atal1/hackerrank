/**
 * 
 */
package me.algos.hackerrank.hard;

import java.util.Scanner;

/**
 * @author Atal
 *
 */
public class DNA_Solution {

	/**
	 * @param args
	 */
	 private static final Scanner scanner = new Scanner(System.in);
	 static int min=0;
	 static int max=0;

	    public static void main(String[] args) {
	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        String[] genes = new String[n];

	        String[] genesItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            String genesItem = genesItems[i];
	            genes[i] = genesItem;
	        }

	        int[] health = new int[n];

	        String[] healthItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int healthItem = Integer.parseInt(healthItems[i]);
	            health[i] = healthItem;
	        }

	        int s = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int sItr = 0; sItr < s; sItr++) {
	            String[] firstLastd = scanner.nextLine().split(" ");

	            int first = Integer.parseInt(firstLastd[0]);

	            int last = Integer.parseInt(firstLastd[1]);

	            String d = firstLastd[2];
	            calculateHealth(first, last, d);
	        }
	        
	        
	        System.out.println(min+","+max);
	        
	        

	        scanner.close();
	    }
	    
	    static void calculateHealth(int first, int last, String d) {
	    	
	    	
	    	
	    }
	}