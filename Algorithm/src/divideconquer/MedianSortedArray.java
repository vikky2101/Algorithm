package divideconquer;

import java.util.Arrays;

public class MedianSortedArray {

	// TC o(logn)
	private int getMedian(int arr1[], int arr2[], int n) {
		if (n == 0)
			return -1;
		if (n == 1) {
			return (arr1[0] + arr2[0]) / 2;
		}
		if (n == 2) {
			return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[0], arr2[1])) / 2;
		}

		int m1 = median(arr1, n);
		int m2 = median(arr1, n);
		if (m1 == m2) {
			return m1;
		} else if (m1 < m2) {
			if (n % 2 == 0)
				return getMedian(Arrays.copyOfRange(arr1, n / 2 - 1, n), arr2, n - n / 2 + 1);
			else
				return getMedian(Arrays.copyOfRange(arr1, n / 2, n), arr2, n - n / 2);
		} else {
			if (n % 2 == 0)
				return getMedian(Arrays.copyOfRange(arr2, n / 2, n), arr1, n - n / 2 + 1);
			else
				return getMedian(Arrays.copyOfRange(arr2, n / 2, n), arr1, n - n / 2);
		}
	}

	private int median(int[] arr, int n) {
		if (n % 2 == 0)
			return (arr[n / 2] + arr[n / 2 - 1]) / 2;
		else
			return arr[n / 2];
	}

	public static void main(String[] args) {
		MedianSortedArray obj = new MedianSortedArray();
		int ar1[] = { 1, 2, 3, 6 };
		int ar2[] = { 4, 6, 8, 10 };
		System.out.println(obj.getMedian(ar1, ar2, ar1.length));
	}

}
