package bits;

public class BitsProblem {

	public static int nextHigherSamBit(int n) {
		int rightMostSetBit = n & ~(n - 1);
		int leftPart = n + rightMostSetBit;
		int right1pattern = leftPart ^ rightMostSetBit;
		right1pattern = (right1pattern) / rightMostSetBit;
		right1pattern >>= 2;
		return leftPart | right1pattern;
	}

	public static int swapOddEvenBits(int n) {
		int evenBits = n & 0xAAAAAAAA;
		int oddBits = n & 0x55555555;
		evenBits >>= 1;
		oddBits <<= 1;
		return evenBits | oddBits;
	}

	public static int nextSmallerSamBit(int n) {
		int rightMostSetBit = n & ~(n - 1);
		int leftPart = n + rightMostSetBit;
		int right1pattern = leftPart ^ rightMostSetBit;
		right1pattern = (right1pattern) / rightMostSetBit;
		right1pattern >>= 2;
		return leftPart | right1pattern;
	}

	public static void main(String[] args) {
		System.out.println(nextHigherSamBit(4));
		System.out.println("Swapped even odd bits " + swapOddEvenBits(23));
	}

	private static void findTwoNumbers(int arr[], int n) {
		int xor = arr[0];
		for (int i = 1; i < n; i++) {
			xor ^= arr[i];
			xor ^= i;
		}
		int rightMostSetBit = xor & ~(xor - 1);
		int x = 0, y = 0;
		for (int i = 0; i < n; i++) {
			if ((arr[i] & rightMostSetBit) == rightMostSetBit)
				x = x ^ arr[i];
			else
				y = y ^ arr[i];
		}

		for (int i = 1; i < n; i++) {
			if ((i & rightMostSetBit) == rightMostSetBit)
				x = x ^ arr[i];
			else
				y = y ^ arr[i];
		}

		System.out.println("Elemnt are " + x + y);
	}
}
