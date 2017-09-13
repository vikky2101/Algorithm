package backtracking;

public class RatMazeProblem {

	// time complexity O(2^(2N)
	private static final int size = 4;

	private void solveRatMaze(int maze[][]) {

		int sol[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sol[i][j] = 0;
			}
		}

		if (isSolveRatMazeUtil(maze, sol, 0, 0)) {
			System.out.println("Solution possible");
			printSol(sol);
		} else {
			System.out.println("Solution not possible");
		}
	}

	private void printSol(int[][] arr) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	private boolean isSolveRatMazeUtil(int[][] maze, int[][] sol, int curX, int curY) {
		if (curX == size - 1 && curY == size - 1) {
			sol[curX][curY] = 1;
			return true;
		}

		if (isSafe(curX, curY, maze)) {
			sol[curX][curY] = 1;
			if (isSolveRatMazeUtil(maze, sol, curX + 1, curY))
				return true;
			if (isSolveRatMazeUtil(maze, sol, curX, curY + 1))
				return true;
			sol[curX][curY] = 0;
			return false;
		}
		return false;
	}

	private boolean isSafe(int i, int j, int[][] maze) {
		if (i >= 0 && i < size && j >= 0 && j < size && maze[i][j] == 1)
			return true;
		else
			return false;
	}

	public static void main(String args[]) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		RatMazeProblem obj = new RatMazeProblem();
		obj.solveRatMaze(maze);
	}
}
