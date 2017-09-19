package patternsearching;

public class KMP {

	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		kmpsearch(txt, pattern);

	}

	private static void kmpsearch(String txt, String pattern) {
		int txtLen = txt.length();
		int patlen = pattern.length();
		int lps[] = new int[patlen];
		computeLPS(lps, pattern, patlen);
		int i = 0;
		int j = 0;
		while (i < txtLen) {
			if (txt.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			if (j == patlen) {
				System.out.println("Pattern found at index " + (i - j));
				j = lps[j - 1];
			} else if (i < txtLen && txt.charAt(i) != pattern.charAt(j)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
	}

	private static void computeLPS(int[] lps, String pattern, int patlen) {
		int len = 0;
		int i = 1;
		lps[0] = 0;
		while (i < patlen) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}

	}

}
