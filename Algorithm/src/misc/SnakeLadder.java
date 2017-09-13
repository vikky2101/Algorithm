package misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {

	static class Cell {
		int distance;
		int vertex;
	}
	
	public static void main(String args[]) {
		// Let us construct the board given in above diagram
		int N = 30;
		int moves[] = new int[N];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		System.out.println("Min Dice throws required is " + findMinJumps(moves, N));

		int A[] = { -2, 4, 45, 6, 10, 8, -3 };
		int n = -5;
		findPair(A, n);
	}

	private static int findMinJumps(int[] moves, int n) {
		Queue<Cell> qVertices = new LinkedList<>();
		boolean visited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = false;
		}
		Cell cell = new Cell();
		cell.distance = 0;
		cell.vertex = 0;
		qVertices.add(cell);
		visited[0] = true;

		while (!qVertices.isEmpty()) {
			cell = qVertices.poll();
			int v = cell.vertex;
			if (v == n - 1)
				break;
			for (int i = v + 1; i <= v + 6 && i < n; i++) {
				if (visited[i] == false) {
					Cell temp = new Cell();
					if (moves[i] != -1)
						v = moves[i];
					else
						v = i;
					temp.distance = cell.distance + 1;
					temp.vertex = v;
					qVertices.add(temp);
					visited[i] = true;
				}
			}
		}
		return cell.distance;
	}

	private static void findPair(int arr[], int k) {
		HashMap<Integer, Boolean> hashMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (hashMap.containsKey(k - arr[i])) {
				int ele = k - arr[i];
				System.out.println("Pairs :" + arr[i] + " " + ele);
				return;
			}
			hashMap.put(arr[i], true);
		}
	}
}
