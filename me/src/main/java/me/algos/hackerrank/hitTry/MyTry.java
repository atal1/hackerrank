package me.algos.hackerrank.hitTry;

public class MyTry {

	
	 static void modularInverse(int n, int prime) 
	    { 
	        int dp[]=new int[n + 1]; 
	        dp[0] = dp[1] = 1; 
	        for (int i = 2; i <= n; i++)  
	            dp[i] = dp[prime % i] *  
	                (prime - prime / i) % prime;  
	      
	        for (int i = 1; i <= n; i++)  ;
//	            System.out.print(dp[i] + " ");  
	    } 
	 
	  
	    // Driver Program 
	    public static void main(String args[]) 
	    { 
	    	long s = System.currentTimeMillis();
	        int n = 100005, prime = 1000000007; 
	        modularInverse(n, prime); 
	        System.out.println(System.currentTimeMillis()-s);
	    }
}
