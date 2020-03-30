package me.algos.hackerrank.leaderboard;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class ClimbLeaderBoard {

	
	



	    // Complete the climbingLeaderboard function below.
	    static int[] climbingLeaderboard(int[] scores, int[] alice) {
	    	
	    	TreeMap<Integer, Integer> myMap= new TreeMap<Integer, Integer>();
	    	int tempKey=-1;
	    	int value =1;
	    	for(int score:scores) {
	    		if(score!=tempKey) {
	    			myMap.put(score, value);
	    			tempKey= score;
	    			value++;
	    		}
	    	}
	    	int length = alice.length;
	    	for(int i=0;i < length; i++) {
	    		if(alice[i] < tempKey) {
	    			alice[i]=myMap.get(tempKey)+1;
	    			continue;
	    		}
	    		if(myMap.containsKey(alice[i]))
	    			alice[i]= myMap.get(alice[i]);
	    		else {
	    			alice[i]=myMap.floorEntry(alice[i]).getValue();
	    			
	    		}
	    	}
			return alice;


	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
//	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int scoresCount = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] scores = new int[scoresCount];

	        String[] scoresItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < scoresCount; i++) {
	            int scoresItem = Integer.parseInt(scoresItems[i]);
	            scores[i] = scoresItem;
	        }

	        int aliceCount = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] alice = new int[aliceCount];

	        String[] aliceItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < aliceCount; i++) {
	            int aliceItem = Integer.parseInt(aliceItems[i]);
	            alice[i] = aliceItem;
	        }

	        int[] result = climbingLeaderboard(scores, alice);

	        for (int i = 0; i < result.length; i++) {
	            System.out.println(result[i]);

	          
	        }

//	        bufferedWriter.newLine();

//	        bufferedWriter.close();

	        scanner.close();
	    }
	}


