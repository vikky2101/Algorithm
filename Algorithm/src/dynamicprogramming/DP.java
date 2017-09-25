package dynamicprogramming;

public class DP {

	public static void longestIncreasingSubsequence(int arr[]) {
		int len = arr.length;
		int[] lis = new int[len];
		int max = 0;
		for (int i = 0; i < len; i++) {
			lis[i] = 1;
		}
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[j] + 1 > lis[i]) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		for (int i = 0; i < len; i++) {
			max = Math.max(max, lis[i]);
		}
		System.out.println("Longest Increasing Subsequence " + max);
	}

	public static void longestCommonSubsequence(String input1, String input2) {
		int m = input1.length();
		int n = input2.length();
		int lcs[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					lcs[i][j] = 0;
				if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		System.out.println("Longest Common subsequcene " + lcs[m][n]);
	}

	public static void convertString(String input1, String input2) {
		int m = input1.length();
		int n = input2.length();
		int dis[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0)
					dis[i][j] = j;
				else if (j == 0)
					dis[i][j] = i;
				else if (input1.charAt(i - 1) == input2.charAt(j - 1))
					dis[i][j] = dis[i - 1][j - 1];
				else {
					dis[i][j] = 1 + Math.min(dis[i - 1][j], Math.min(dis[i][j - 1], dis[i - 1][j - 1]));
				}
			}
		}
		System.out.println("Min operation required to Convert " + input1 + " to " + input2 + " is " + dis[m][n]);
	}

	public static int minCostpath(int mat[][], int size) {
		int path[][] = new int[size][size];
		path[0][0] = 0;
		for (int i = 1; i < size; i++)
			path[0][i] = path[0][i - 1] + mat[0][i];
		for (int i = 1; i < size; i++)
			path[i][0] = path[i - 1][0] + mat[0][i];
		;
		for (int i = 1; i < size; i++) {
			for (int j = 1; j < size; j++) {
				path[i][j] = Math.min(path[i - 1][j], Math.min(path[i][j - 1], path[i - 1][j - 1])) + mat[i][j];
			}
		}
		return path[size][size];
	}

	public static int coinChange(int arr[], int sum) {
		int len = arr.length;
		int[][] res = new int[sum + 1][len];
		for (int i = 0; i < len; i++)
			res[0][i] = 1;
		for (int i = 1; i < sum + 1; i++) {
			for (int j = 0; j < len; j++) {
				// exclude arr[j]
				int x = j >= 1 ? res[i][j - 1] : 0;
				// include arr[j]
				int y = i - arr[j] >= 0 ? res[i - arr[j]][j] : 0;
				res[i][j] = x + y;
			}
		}
		return res[sum][len - 1];
	}

	public static int minimumMultiplications(int arr[]) {
		int len = arr.length;
		int res[][] = new int[len][len];
		for (int i = 1; i < len; i++)
			res[i][i] = 0;
		for (int i = 2; i < len; i++) {
			for (int j = 1; j < len - i + 1; j++) {
				int k = j + i - 1;
				if (k == len)
					continue;
				res[i][j] = Integer.MAX_VALUE;
				for (int p = j; p <= k - 1; p++) {
					int q = res[j][p] + res[p + 1][k] + arr[j - 1] * arr[p] * arr[k];
					if (q < res[i][j])
						res[i][j] = q;
				}
			}
		}
		return res[1][len - 1];
	}

	public static int binomialcoefficeint(int n, int k) {
		int c[][] = new int[n + 1][k + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || i == j)
					c[i][j] = 1;
				else
					c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
			}
		}
		return c[n][k];
	}

	public static int knapsack(int weight, int w[], int val[], int n) {
		if (weight == 0)
			return 0;
		int knapsack[][] = new int[n + 1][weight + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= weight; j++) {
				if (i == 0 || j == 0)
					knapsack[i][j] = 0;
				else if (w[i - 1] <= weight)
					knapsack[i][j] = Math.max(knapsack[i - 1][j - w[i - 1]] + val[i - 1], knapsack[i - 1][j]);
				else
					knapsack[i][j] = knapsack[i - 1][j];
			}
		}
		return knapsack[weight][n];
	}

	public static int longestPalindromicSequecne(String str) {
		int len = str.length();
		int lps[][] = new int[len][len];
		for (int i = 0; i < len; i++)
			lps[i][i] = 1;
		for (int i = 2; i <= len; i++) {
			for (int j = 0; j < len - i + 1; j++) {
				int k = j + i - 1;
				if (str.charAt(i) == str.charAt(j) && i == 2)
					lps[i][j] = 2;
				else if (str.charAt(i) == str.charAt(j))
					lps[i][j] = 1 + lps[i + 1][j - 1];
				else
					lps[i][j] = Math.max(lps[i + 1][j], lps[i][j - 1]);
			}
		}
		return lps[0][len - 1];
	}

	public static int minCutMaxValue(int arr[]) {
		int len = arr.length;
		int dp[] = new int[len + 1];
		dp[0] = 0;
		for (int i = 1; i <= len; i++) {
			int max = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				max = Math.max(max, arr[j] + dp[i - j - 1]);
				dp[i] = max;
			}
		}
		return dp[len];
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
				if (i >= arr[j - 1]) {
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
