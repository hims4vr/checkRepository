package testpackage.geeks.arrays.problem;

import java.util.Arrays;

public class CoinChangeProblem {

	static long getNumberOfWays(long N, long[] Coins) {
		// Create the ways array to 1 plus the amount
		// to stop overflow
		long[] ways = new long[(int) N + 1];

		// Set the first way to 1 because its 0 and
		// there is 1 way to make 0 with 0 coins
		ways[0] = 1;

		// Go through all of the coins
		for (int i = 0; i < Coins.length; i++) {

			// Make a comparison to each index value
			// of ways with the coin value.
			
			for (int j = 0; j < ways.length; j++) {
				if (Coins[i] <= j) {

					// Update the ways array
					ways[j] += ways[(int) (j - Coins[i])];
				}
			}
			
			for (int j = 0; j < ways.length; j++) {
				System.out.print(ways[j]);
				System.out.print(",");
			}
			System.out.println("");
		}

		// return the value at the Nth position
		// of the ways array.
		return ways[(int) N];
	}

	static void printArray(long[] coins) {
		for (long i : coins)
			System.out.println(i);
	}

	public static void main(String args[]) {
		long Coins[] = { 2, 3, 4 };
		
		Arrays.sort(Coins);

//		System.out.println("The Coins Array:");
//		printArray(Coins);

//		System.out.println("Solution:");
		System.out.println(getNumberOfWays(12, Coins));
	}
	
	
	static int formingMagicSquare(int[][] s) {
        int totalElem = 0;
        
        if(s.length != s[0].length){
        	return 0;
        }
 
        totalElem = s.length*s[0].length;

        int totalSum = 0;
        for(int i= totalElem;i>0;i--) {
        	totalSum += totalElem;
        }
        
        totalSum = totalSum/s.length;
        
        
        int[] nums = new int[totalElem];
        nums[0] = 0;
        
        
        for (int i = 0; i < s.length; i++) {
        	int rowSum = 0;
        	for (int j = 0; j < s[i].length; j++) {
        		nums[s[i][j]]++;
        		
			}
		}
        
    return 0;

    }
	
	
	
	static int equal(int[] arr) {
		
		
		
		
		return 0;
    }
	
	
	
}
