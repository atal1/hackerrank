package me.algos.hackerrank.hired;

import java.util.*;

/*
 * Your CheckpointArray object will be instantiated and called as such:
 * CheckpointArray obj = new CheckpointArray(length);
 * obj.set(index,intVal);
 * String checkpoint = obj.checkpoint(); 
 * int value = obj.get(index,checkpoint);
 */
class CheckpointArray {
	
	Integer[] array ;
	static int checkPoint=0;
	HashMap< Integer, Integer[]> myMap = new HashMap<Integer, Integer[]>();
    public CheckpointArray(int length) {
    	array=new Integer [length];
        
    }
    
    public void set(int index, int intVal) {
        array[index]=intVal;
        myMap.put(checkPoint, array);
    }
    
    public int checkpoint() {
    	return checkPoint++;
    }
    
    public int get(int index, int checkpointId) {
    	return myMap.get(checkpointId)[index];
        }
}

public class Solution1 {
	
	public static void main (String[] args) {
		String [] commands = {"new 4", "set 0 100","set 1 200","set 2 300","set 3 400","checkpoint","get 1 0","set 1 201","checkpoint","get 1 1","get 1 0"};
		for(Integer i : solution(commands))
			System.out.println(i);;
		}
    
  public static int[] solution(String[] commands) {

    CheckpointArray obj = new CheckpointArray(0);
    Set<Integer> checkpoints = new HashSet<>();
    int[] output = new int[commands.length];
    
    
    for (int i = 0; i < commands.length; i++) {
      output[i] = -1;
    }

    for (int i = 0; i < commands.length; i++) {
      String command = commands[i];
      String[] tokens = command.split("\\s+");

      if ("new".equalsIgnoreCase(tokens[0])) {
        obj = new CheckpointArray(Integer.valueOf(tokens[1]));

      } else if ("set".equalsIgnoreCase(tokens[0])) {
        obj.set(Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]));

      } else if ("checkpoint".equalsIgnoreCase(tokens[0])) {
        output[i] = obj.checkpoint();
        checkpoints.add(output[i]);

      } else if ("get".equalsIgnoreCase(tokens[0])) {
        int cpId = Integer.valueOf(tokens[2]);
        if (checkpoints.contains(cpId)) {
          output[i] = obj.get(Integer.valueOf(tokens[1]), cpId);
        }
      }
    }
    return output;
  }
}

