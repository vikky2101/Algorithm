package backtracking;

public class PrintAllPermutStrings {

	private static void printAllPermutations(char[] input, int i, int j) {
		if (i == j - 1) {
			System.out.println(input);
			return;
		}
		for (int low = i; low < j; low++) {
			swap(input, i, low);
			printAllPermutations(input, i + 1, j);
			swap(input, i, low);
		}
	}

	private static void swap(char[] input, int index1, int index2) {
		char temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}

	public static void main(String args[]) {
		String input = "ABC";
		printAllPermutations(input.toCharArray(), 0, input.length());
	}

}
