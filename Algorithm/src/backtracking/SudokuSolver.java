package backtracking;

public class SudokuSolver {

	private static final int size = 9;
	private static int row = 0, col = 0;

	private boolean solveSudoku(int grid[][]) {

		//
		if (!findemptyCell(grid))
			return true;

		for (int i = 1; i <= 9; i++) {
			if (isSafe(grid, i)) {
				grid[row][col] = i;
				if (solveSudoku(grid))
					return true;
				else
					grid[row][col] = 0;
			}
		}
		return false;
	}

	private boolean isSafe(int[][] grid, int num) {

		for (int i = 0; i < size; i++) {
			if (grid[row][i] == num)
				return false;
		}

		for (int i = 0; i < size; i++) {
			if (grid[i][col] == num)
				return false;
		}

		int rowBoxX = row - (row % 3);
		int rowBoxY = col - (col % 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[rowBoxX + i][rowBoxY + j] == num)
					return false;
			}
		}
		
		return true;
	}

	private boolean findemptyCell(int[][] grid) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (grid[i][j] == 0) {
					row = i;
					col = j;
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {
		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		SudokuSolver obj = new SudokuSolver();
		if (obj.solveSudoku(grid)) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.println(grid[i][j]);
				}
			}
		}
		else{
			System.out.println("Solution not possible");
		}
	}
}
