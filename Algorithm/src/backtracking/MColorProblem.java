package backtracking;

public class MColorProblem {

	// TC v^m
	private static final int V = 4;

	private void graphColor(int graph[][], int m) {
		int color[] = new int[V];
		for (int i = 0; i < V; i++) {
			color[i] = 0;
		}
		if (graphColorUtil(graph, color, m, 0)) {
			System.out.println("Solution possible");
			for (int i = 0; i < V; i++) {
				System.out.println(color[i]);
			}
		} else {
			System.out.println("Solution is not possible");
		}
	}

	private boolean graphColorUtil(int[][] graph, int[] color, int m, int vertex) {
		if (vertex == V)
			return true;
		for (int col = 1; col <= m; col++) {
			if (isSafe(graph, vertex, color, col)) {
				color[vertex] = col;
				if (graphColorUtil(graph, color, m, vertex + 1))
					return true;
				color[vertex] = 0;
			}
		}
		return false;
	}

	private boolean isSafe(int[][] graph, int i, int[] color, int col) {
		for (int j = 0; j < V; j++) {
			if (graph[i][j] == 1 && color[j] == col)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		int m = 3; // Number of colors
		int graph[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		MColorProblem obj = new MColorProblem();
		obj.graphColor(graph, m);

	}
}
