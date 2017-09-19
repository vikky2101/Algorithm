package sorting;

public class SortingDemo {

	private static void selectionSort(int arr[]) {

		// T.C o(n^2)
		// Swaps - o(n)
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			int min_Index = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[min_Index]) {
					min_Index = j;
				}
				int temp = arr[i];
				arr[i] = arr[min_Index];
				arr[min_Index] = temp;
			}
		}
	}

	private static void bubbleSort(int arr[]) {
		// T.C - o(n^2)
		// Swaps - o(n^2)
		int len = arr.length;
		boolean swapped;
		for (int i = 0; i < len - 1; i++) {
			swapped = false;
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			if (swapped == true)
				break;
		}
	}

	private static void insertionSort(int arr[]) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

	private static void mergePartition(int temp[], int l, int h) {
		if (l < h) {
			int mid = (l + h) / 2;
			mergePartition(temp, l, mid);
			mergePartition(temp, mid + 1, h);
			mergesort(temp, l, mid, h);

		}
	}

	private static void mergesort(int[] temp, int l, int mid, int h) {
		int n1 = mid - l + 1;
		int n2 = h - mid;

		int left[] = new int[n1];
		int right[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			left[i] = temp[l + i];
		}

		for (int j = 0; j < n2; j++) {
			right[j] = temp[mid + 1 + j];
		}
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				temp[k] = left[i];
				i++;
			} else {
				temp[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			temp[k] = left[i];
			i++;
			k++;
		}

		while (j < n2) {
			temp[k] = right[j];
			j++;
			k++;
		}
	}

	private static int partition(int[] arr, int l, int h) {
		int pivot = arr[h];
		int i = l - 1;
		for (int j = l; j <= h - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[h];
		arr[h] = arr[i + 1];
		arr[i + 1] = temp;
		return i + 1;
	}

	private static void quicksort(int arr[], int l, int h) {
		if (l < h) {
			int p = partition(arr, l, h);
			quicksort(arr, l, p - 1);
			quicksort(arr, p + 1, h);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 64, 25, 12, 22, 11 };
		// selectionSort(arr);
		// bubbleSort(arr);
		// insertionSort(arr);
		quicksort(arr, 0, arr.length - 1);
		// mergePartition(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}

}
