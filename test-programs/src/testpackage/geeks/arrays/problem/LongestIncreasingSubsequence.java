package testpackage.geeks.arrays.problem;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 
 given an array find out the length of largest sub array with below condition

 every element in sub-array must be greater than previous element
 
 
 ex-1
 
 array -> [1,4,3]
 sub -> [1,4], [1,3]
 
 array -> [1,2,2,7,5,6]
 
 * 
 * 
 */

public class LongestIncreasingSubsequence {
	
	
	public static void main(String[] args) {
		longestIncreasingSubsequence(new int[] {0,4,12,2,10,6,9,13,3,11,7,15});
	}
	
	
	 static int longestIncreasingSubsequence(int[] arr) {
		 List<Integer>[] dataArr = new ArrayList[arr.length];
		 
		 for (int i = 0; i < dataArr.length; i++) { 
			 dataArr[i] = new ArrayList<Integer>(); 
		 }
		 dataArr[0].add(arr[0]);
		 
		 for(int i=1; i< arr.length; i++) {
			 
			 for(int j=0; j<i; j++) {
				 if(arr[j] < arr[i] && dataArr[i].size() <= dataArr[j].size()) {
					 dataArr[i].clear();
					 dataArr[i].addAll(dataArr[j]);
				 }
			 }
			 dataArr[i].add(arr[i]);
		 }
		 
		 for (int i = 0; i < dataArr.length; i++) { 
			 System.out.println(dataArr[i]);
	     }
		 
		 return 0;
	 }
	
}
