package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;

public class Graph {

	private int no_vertex;
	private LinkedList<Integer> adjList[];
	private int V = 5;
	private int V2 = 9;

	public Graph(int num) {
		this.no_vertex = num;
		adjList = new LinkedList[num];
		for (int i = 0; i < num; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	private void addEdge(int src, int des) {
		adjList[src].add(des);
	}

	private void printBFS(int source) {
		boolean[] visit = new boolean[no_vertex];
		for (int i = 0; i < no_vertex; i++)
			visit[i] = false;

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < no_vertex; i++) {
			if (!visit[i])
				pritnBFSUtil(queue, visit, i);
		}
	}

	private void pritnBFSUtil(Queue<Integer> queue, boolean[] visit, int source) {
		visit[source] = true;
		queue.add(source);
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print(temp + " ");
			Iterator<Integer> itr = adjList[temp].iterator();
			while (itr.hasNext()) {
				int v = itr.next();
				if (!visit[v]) {
					visit[v] = true;
					queue.add(v);
				}
			}
		}
	}

	private void printDFS(int source) {
		boolean[] visit = new boolean[no_vertex];
		for (int i = 0; i < no_vertex; i++)
			visit[i] = false;

		for (int i = 0; i < no_vertex; i++) {
			if (!visit[i])
				pritnDFSUtil(visit, i);
		}
	}

	private void pritnDFSUtil(boolean[] visit, int source) {
		visit[source] = true;
		System.out.print(source + " ");
		Iterator<Integer> itr = adjList[source].iterator();
		while (itr.hasNext()) {
			int v = itr.next();
			if (!visit[v]) {
				pritnDFSUtil(visit, v);
			}
		}
	}

	private boolean isCycleDirected() {
		boolean visit[] = new boolean[no_vertex];
		boolean recStack[] = new boolean[no_vertex];
		for (int i = 0; i < no_vertex; i++) {
			if (isCycleDirectedUtil(visit, recStack, i))
				return true;
		}
		return false;
	}

	private boolean isCycleDirectedUtil(boolean[] visit, boolean[] recStack, int source) {
		if (visit[source] == false) {
			visit[source] = true;
			recStack[source] = true;
			Iterator<Integer> itr = adjList[source].iterator();
			while (itr.hasNext()) {
				int v = itr.next();
				if (!visit[v] && isCycleDirectedUtil(visit, recStack, v))
					return true;
				else if (recStack[v])
					return true;
			}
		}
		recStack[source] = false;
		return false;
	}

	private boolean isCycleUnDirected() {
		boolean visit[] = new boolean[no_vertex];
		for (int i = 0; i < no_vertex; i++) {
			if (isCycleUnDirectedUtil(visit, i, -1))
				return true;
		}
		return false;
	}

	private boolean isCycleUnDirectedUtil(boolean[] visit, int source, int parent) {
		if (visit[source] == false) {
			visit[source] = true;
			Iterator<Integer> itr = adjList[source].iterator();
			while (itr.hasNext()) {
				int v = itr.next();
				if (!visit[v] && isCycleUnDirectedUtil(visit, v, v))
					return true;
				else if (v != parent)
					return true;
			}
		}
		return false;
	}

	private void troposort() {
		Stack stack = new Stack<>();
		boolean visit[] = new boolean[no_vertex];
		for (int i = 0; i < no_vertex; i++) {
			if (!visit[i])
				troposortUtil(stack, visit, i);
		}

		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");

	}

	private void troposortUtil(Stack stack, boolean visit[], int source) {
		visit[source] = true;
		Iterator<Integer> itr = adjList[source].iterator();
		while (itr.hasNext()) {
			int v = itr.next();
			if (!visit[v])
				troposortUtil(stack, visit, v);
		}
		stack.push(source);
	}

	private boolean isGraphTree() {
		boolean visit[] = new boolean[no_vertex];
		if (isCycleUnDirectedUtil(visit, 0, -1))
			return false;
		for (int i = 0; i < no_vertex; i++) {
			if (!visit[i])
				return false;
		}
		return true;
	}

	private int minKey(int key[], boolean mst[], int no) {
		int minIndex = -1;
		int min = 9999;
		for (int i = 0; i < no; i++) {
			if (mst[i] == false && key[i] < min) {
				min = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private void primsMST(int graph[][]) {
		boolean mstSet[] = new boolean[V];
		int keySet[] = new int[V];
		int parent[] = new int[V];
		for (int i = 0; i < V; i++) {
			mstSet[i] = false;
			parent[i] = -1;
			keySet[i] = Integer.MAX_VALUE;
		}
		keySet[0] = 0;
		parent[0] = -1;

		for (int count = 0; count < V - 1; count++) {
			int minKey = minKey(keySet, mstSet, V);
			mstSet[minKey] = true;
			for (int j = 0; j < V; j++) {
				if (graph[minKey][j] != 0 && mstSet[j] == false && graph[minKey][j] < keySet[j]) {
					keySet[j] = graph[minKey][j];
					parent[j] = minKey;
				}
			}
		}

		for (int i = 1; i < V; i++) {
			System.out.println("Edge-" + parent[i] + i + " Weight-" + graph[parent[i]][i]);
		}

	}

	private void dijkstra(int[][] graph, int source) {
		boolean mstSet[] = new boolean[V2];
		int keySet[] = new int[V2];
		int parent[] = new int[V2];
		for (int i = 0; i < V2; i++) {
			mstSet[i] = false;
			parent[i] = -1;
			keySet[i] = Integer.MAX_VALUE;
		}
		keySet[source] = 0;
		parent[source] = -1;

		for (int count = 0; count < V2 - 1; count++) {
			int minKey = minKey(keySet, mstSet, V2);
			mstSet[minKey] = true;
			for (int j = 0; j < V2; j++) {
				if (graph[minKey][j] != 0 && mstSet[j] == false && keySet[minKey] != Integer.MAX_VALUE
						&& keySet[minKey] + graph[minKey][j] < keySet[j]) {
					keySet[j] = graph[minKey][j] + keySet[minKey];
					parent[j] = minKey;
				}
			}
		}

		for (int i = 1; i < V2; i++) {
			System.out.println("Key-" + i + " DIstance-" + keySet[i]);
		}

	}

	public static void main(String args[]) {
		// Graph start
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(3, 3);
		System.out.println("");
		System.out.print("BFS - ");
		graph.printBFS(2);
		System.out.println("");
		System.out.print("DFS - ");
		graph.printDFS(0);
		System.out.println("");
		if (graph.isCycleDirected())
			System.out.println("Cycle exists");
		else
			System.out.println("Cycle not exists");
		if (graph.isCycleUnDirected())
			System.out.println("Cycle exists");
		else
			System.out.println("Cycle not exists");
		if (graph.isGraphTree())
			System.out.println("Graph is tree");
		else
			System.out.println("Graph is not tree");

		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.print("TropLogical Sorting - ");
		g.troposort();
		System.out.println("");
		System.out.println("Prims MST - ");

		// print MST
		int mstgraph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 }, };

		System.out.println("");
		// Print the solution
		graph.primsMST(mstgraph);
		 int dgraph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                 {4, 0, 8, 0, 0, 0, 0, 11, 0},
                 {0, 8, 0, 7, 0, 4, 0, 0, 2},
                 {0, 0, 7, 0, 9, 14, 0, 0, 0},
                 {0, 0, 0, 9, 0, 10, 0, 0, 0},
                 {0, 0, 4, 14, 10, 0, 2, 0, 0},
                 {0, 0, 0, 0, 0, 2, 0, 1, 6},
                 {8, 11, 0, 0, 0, 0, 1, 0, 7},
                 {0, 0, 2, 0, 0, 0, 6, 7, 0}};
		System.out.println("");
		System.out.println("Dijkstra Algo");
		graph.dijkstra(dgraph, 0);

	}

}
