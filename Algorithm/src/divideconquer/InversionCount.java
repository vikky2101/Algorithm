package divideconquer;

public class InversionCount {

	private static int countUtil(int arr[], int temp[], int low, int high) {
		int inv_count = 0;
		if (low < high) {
			int mid = low + (high - low) / 2;
			inv_count = countUtil(arr, temp, low, mid);
			inv_count += countUtil(arr, temp, mid + 1, high);
			inv_count += count(arr, temp, low, mid + 1, high);
		}
		return inv_count;
	}

	private static int count(int arr[], int temp[], int low, int mid, int high) {
		int i, j, index, inv_count = 0;
		i = low;
		j = mid;
		index = low;
		while (i <= mid - 1 && j <= high) {
			if (arr[i] <= arr[j]) {
				temp[index++] = arr[i++];
			} else {
				temp[index++] = arr[j++];
				inv_count += (mid - i);
			}
		}
		while (i <= mid - 1) {
			temp[index++] = arr[i++];
		}
		while (j <= high) {
			temp[index++] = arr[j++];
		}

		for (i = low; i <= high; i++)
			arr[i] = temp[i];

		return inv_count;
	}

	public static void main(String[] args) {
		int arr[] = { 8, 9, 10, 4, 5, 9 };
		int length = arr.length;
		int temp[] = new int[length];
		System.out.println(countUtil(arr, temp, 0, length-1));

	}
}
