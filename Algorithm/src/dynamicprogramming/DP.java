package dynamicprogramming;

public class DP {

	public static void longestIncreasingSubsequence(int arr[], int n) {
		int lis[] = new int[n];
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[j] + 1 > lis[i])
					lis[i] = lis[j] + 1;
			}
		}
		int max = lis[0];
		for (int i = 1; i < n; i++) {
			max = Math.max(lis[i], max);
		}
		System.out.println("Longest Increasing Subsequence " + max);
	}

	public static void countWaystoReachNStair(int n, int m) {
		int arr[] = new int[n + 1];
		arr[0] = arr[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			arr[i] = 0;
			for (int j = 1; j <= m && j <= i; j++)
				arr[i] += arr[i - j];
		}
		System.out.println("Total no of steps " + arr[n]);
	}

	public static int mincostPath(int mat[][], int size) {
		int dp[][] = new int[size][size];
		dp[0][0] = mat[0][0];
		for (int i = 1; i < size; i++)
			dp[0][i] = mat[0][i] + dp[0][i - 1];
		for (int i = 1; i < size; i++)
			dp[i][0] = mat[i][0] + dp[i - 1][0];
		for (int i = 1; i < size; i++) {
			for (int j = 1; j < size; j++) {
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
			}
		}
		return dp[size - 1][size - 1];
	}

	public static int maxcostPath(int mat[][], int size) {
		int dp[][] = new int[size][size];
		dp[0][0] = mat[0][0];
		for (int i = 1; i < size; i++)
			dp[0][i] = mat[0][i] + dp[0][i - 1];
		for (int i = 1; i < size; i++)
			dp[i][0] = mat[i][0] + dp[i - 1][0];
		for (int i = 1; i < size; i++) {
			for (int j = 1; j < size; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
			}
		}
		return dp[size - 1][size - 1];
	}

	public static int minCutMaxValue(int arr[], int n) {
		int dp[] = new int[n + 1];
		int max_so_far = Integer.MIN_VALUE;
		int curr_max = 0;
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				curr_max = arr[j] + dp[i - j - 1];
				if (curr_max > max_so_far)
					max_so_far = curr_max;
			}
			dp[i] = max_so_far;
		}
		return dp[n];
	}

	public static boolean partitionEqualSubsetSum(int arr[], int n) {

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		if (sum % 2 != 0)
			return false;

		boolean dp[][] = new boolean[sum / 2 + 1][n + 1];
		for (int i = 0; i < n; i++)
			dp[0][i] = true;

		for (int i = 1; i <= sum / 2; i++)
			dp[i][0] = false;

		for (int i = 1; i <= sum / 2; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i][j - 1];
				if (i >= arr[j-1]) {
					dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
				}
			}
		}
		return dp[sum / 2][n];
	}

	public static int findMinimumDiffSubsetSum(int arr[], int n) {

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		boolean dp[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i < n; i++)
			dp[i][0] = true;

		for (int i = 1; i <= n; i++)
			dp[0][i] = false;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= arr[i - 1]) {
					dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
				}
			}
		}

		int diff = Integer.MAX_VALUE;
		for (int j = sum / 2; j >= 0; j--) {
			if (dp[n][j] == true)
				diff = sum - 2 * j;
		}
		return diff;
	}

	public static int coinChange(int sum, int arr[], int n) {
		int dp[][] = new int[sum + 1][n];
		for (int i = 0; i < n; i++)
			dp[0][i] = 1;
		for (int i = 1; i < sum + 1; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = 0;
				int x = i - arr[j] >= 0 ? dp[i - arr[j]][j] : 0;
				int y = j >= 1 ? dp[i][j - 1] : 0;
				dp[i][j] = x + y;
			}
		}
		return dp[sum][n-1];
	}

	public static int optimalStrategy(int arr[], int n) {
		int table[][] = new int[n][n];
		for (int gap = 0; gap < n; ++gap) {
			for (int i = 0, j = gap; j < n; ++i, ++j) {
				// x is value of F(i+2, j)
				// y is F(i+1, j-1) and
				// z is F(i, j-2) 
				int x = ((i + 2) <= j) ? table[i + 2][j] : 0;
				int y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0;
				int z = (i <= (j - 2)) ? table[i][j - 2] : 0;
				table[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
			}
		}
		return table[0][n - 1];
	}
}
