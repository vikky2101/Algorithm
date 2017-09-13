package backtracking;

public class NQueenProblem {

	// T.C N^N
	private static final int size = 4;

	private void solveNQueen() {
		int board[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = 0;
			}
		}
		if (solveNQUtil(board, 0)) {
			System.out.println("Solution possible");
			printBoard(board);
		}
	}

	private void printBoard(int[][] board) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

	private boolean solveNQUtil(int[][] board, int col) {
		if (col >= size)
			return true;
		for (int i = 0; i < size; i++) {
			if (issafe(board, i, col)) {
				board[i][col] = 1;
				if (solveNQUtil(board, col + 1))
					return true;
				else
					board[i][col] = 0;
			}
		}
		return false;
	}

	private boolean issafe(int[][] board, int row, int col) {
		if (row > size && row < 0 && col > size && col < 0)
			return false;
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1)
				return false;
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}
		for (int i = row, j = col; i < size && j >= 0; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		NQueenProblem obj = new NQueenProblem();
		obj.solveNQueen();
	}

}
