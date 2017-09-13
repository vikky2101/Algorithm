package math;

public class LexicographicalRank {

	private int fact(int n) {
		return n <= 1 ? 1 : n * fact(n - 1);
	}

	private int findSmallerNoRightSide(String str, int low, int high) {
		int count = 0;
		for (int i = low + 1; i < high; i++) {
			if (str.charAt(low) > str.charAt(i))
				count++;
		}
		return count;
	}

	public int findRank(String str) {
		int len = str.length();
		int pro = fact(len);
		int rank = 1;
		for (int i = 0; i < len; i++) {
			pro = pro / (len - i);
			rank += findSmallerNoRightSide(str, i, len) * pro;
		}
		return rank;
	}
}
