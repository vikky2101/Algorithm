package math;

import java.util.Arrays;

public class Mathematical_Algo {

	public static void nextGreaterNumberSameDigit(char[] digits, int n) {
		int i;
		for (i = n - 1; i > 0; i--) {
			if (digits[i - 1] < digits[i])
				break;
		}
		if (i == 0)
		{
			System.out.println("Number not possible");
			return ;
		}
		char ch = digits[i - 1];
		int min = i ; 
		for (int j = i + 1; j < n; j++) {
			if (ch < digits[j] && digits[j]< digits[min])
				  min = j;

		}
		digits[i - 1] = digits[min];
		digits[min] = ch;
		Arrays.sort(digits, i, n);
		System.out.println(Arrays.toString(digits));
	}
}
