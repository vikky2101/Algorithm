package backtracking;

public class KnightTourProblem {

	// Time Complexity is O(8^(n*n-1))

	private static final int size = 8;

	private void solveKT() {
		int arr[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = -1;
			}
		}
		int xarr[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yarr[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		arr[0][0] = 0;

		if (isSolveKTUtil(arr, xarr, yarr, 1, 0, 0)) {
			System.out.println("Yes possible");
		} else {
			System.out.println("Not possible");
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private boolean isSolveKTUtil(int[][] arr, int[] xarr, int[] yarr, int move, int currX, int currY) {
		if (move == size * size)
			return true;
		for (int i = 0; i < size; i++) {
			int nextX = currX + xarr[i];
			int nextY = currY + yarr[i];
			if (isSafe(nextX, nextY, arr)) {
				arr[nextX][nextY] = move;
				if (isSolveKTUtil(arr, xarr, yarr, move + 1, nextX, nextY))
					return true;
				else {
					arr[nextX][nextY] = -1;
				}
			}
		}
		return false;
	}

	private boolean isSafe(int nextX, int nextY, int sol[][]) {
		if (nextX >= 0 && nextX < size && nextY >= 0 && nextY < size && sol[nextX][nextY] == -1)
			return true;
		else
			return false;
	}

	public static void main(String args[]) {
		KnightTourProblem kt = new KnightTourProblem();
		kt.solveKT();
	}
}
