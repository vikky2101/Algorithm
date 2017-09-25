package dynamicprogramming;

public class main {

	public static void main ( String[] args) {
		// Dynamic Programming
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int n = arr.length;
		
		DP.longestIncreasingSubsequence(arr);

		DP.countWaystoReachNStair(4, 2);
		
		//Cut rrod
		int rod[] = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println("Maximum Obtainable Value is "+ DP.minCutMaxValue(rod));
		
		int arr1[] = {8, 15, 3, 7};
	    System.out.println("Winner value "+ DP.optimalStrategy(arr1, arr1.length));
	}
}
