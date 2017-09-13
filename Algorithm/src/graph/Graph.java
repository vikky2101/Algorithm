package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;

public class Graph {

	private static final int V = 9;
	private int numberOfVertices;
	private LinkedList<Integer> adjList[];

	public Graph(int n) {
		numberOfVertices = n;
		adjList = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adjList[u].add(v);
	}

	private void BFSUtil(int source, boolean[] arr, Queue<Integer> queue) {
		arr[source] = true;
		queue.add(source);
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print(temp + " ");
			Iterator<Integer> itr = adjList[temp].listIterator();
			while (itr.hasNext()) {
				int v = itr.next();
				if (!arr[v]) {
					arr[v] = true;
					queue.add(v);
				}
			}
		}
	}

	public void printBFS(int source) {
		boolean arr[] = new boolean[numberOfVertices];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numberOfVertices; i++) {
			if (!arr[i])
				BFSUtil(i, arr, queue);
		}
	}

	private void DFSUtil(int source, boolean[] arr) {
		arr[source] = true;
		System.out.print(source + " ");
		Iterator<Integer> itr = adjList[source].listIterator();
		while (itr.hasNext()) {
			int v = itr.next();
			if (!arr[v]) {
				DFSUtil(v, arr);
			}
		}
	}

	public void printDFS() {
		boolean arr[] = new boolean[numberOfVertices];
		for (int i = 0; i < numberOfVertices; i++) {
			if (!arr[i])
				DFSUtil(i, arr);
		}
	}

	public void tropoUtil(int source, boolean[] arr, Stack<Integer> stack) {
		arr[source] = true;
		Iterator<Integer> itr = adjList[source].listIterator();
		while (itr.hasNext()) {
			int v = itr.next();
			if (!arr[v]) {
				tropoUtil(v, arr, stack);
			}
		}
		stack.push(source);
	}

	public void tropologicalSorting(int source) {
		boolean arr[] = new boolean[numberOfVertices];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < numberOfVertices; i++) {
			if (!arr[i])
				tropoUtil(i, arr, stack);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private int minKey(int key[], boolean mst[]) {
		int minIndex = -1;
		int min = 9999;
		for (int i = 0; i < V; i++) {
			if (mst[i] == false && key[i] < min) {
				min = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public void primeMST(int graph[][]) {
		int parent[] = new int[V];
		boolean mst[] = new boolean[V];
		int key[] = new int[V];

		for (int i = 0; i < V; i++) {
			mst[i] = false;
			parent[i] = -1;
			key[i] = 99999;
		}
		key[0] = 0;
		parent[0] = -1;

		for (int count = 0; count < V - 1; count++) {
			int minKey = minKey(key, mst);
			mst[minKey] = true;
			for (int i = 0; i < V; i++) {
				if (graph[minKey][i] != 0 && mst[i] == false && graph[minKey][i] < key[i]) {
					key[i] = graph[minKey][i];
					parent[i] = minKey;
				}
			}
		}
		// print MST
		for (int i = 1; i < V; i++) {
			System.out.println("Edge-" + i + "," + parent[i] + " Weight-" + graph[i][parent[i]]);
		}
	}

	public void Dijkstra(int graph[][], int src) {
		int parent[] = new int[V];
		boolean mst[] = new boolean[V];
		int key[] = new int[V];

		for (int i = 0; i < V; i++) {
			mst[i] = false;
			parent[i] = -1;
			key[i] = 99999;
		}

		key[src] = 0;
		parent[src] = -1;

		for (int count = 0; count < V - 1; count++) {

			int minKey = minKey(key, mst);
			mst[minKey] = true;
			for (int i = 0; i < V; i++) {
				if (graph[minKey][i] != 0 && mst[i] == false && key[minKey] != 9999
						&& key[minKey] + graph[minKey][i] < key[i]) {
					key[i] = key[minKey] + graph[minKey][i];
					parent[i] = minKey;
				}
			}
		}

		System.out.println("Distance of all Vertices from Src");
		System.out.println("Vertex  - Distance from Src");
		for (int i = 0; i < V; i++) {
			System.out.println(i + " " + key[i]);
		}
	}
}
