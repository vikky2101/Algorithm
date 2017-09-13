package main;
import graph.Graph;
import math.LexicographicalRank;
import math.Mathematical_Algo;
import backtracking.KnightTourProblem;
import backtracking.NQueenProblem;
import backtracking.PrintAllPermutStrings;
import dynamicprogramming.DP;

public class Main {

	public static void main(String[] args) {
		
		// Graph start
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		System.out.print("DFS - ");
		graph.printDFS();
		System.out.println("");
		System.out.print("BFS - ");
		graph.printBFS(2);
		Graph g = new Graph(6);
	    g.addEdge(5, 2);
	    g.addEdge(5, 0);
	    g.addEdge(4, 0);
	    g.addEdge(4, 1);
	    g.addEdge(2, 3);
	    g.addEdge(3, 1);
		System.out.println("");
		System.out.println("TropLogical Sorting - ");
		g.tropologicalSorting(2);
		System.out.println("");
		System.out.println("Prims MST - ");
		
		
		// print MST
	     int mstgraph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
             {4, 0, 8, 0, 0, 0, 0, 11, 0},
             {0, 8, 0, 7, 0, 4, 0, 0, 2},
             {0, 0, 7, 0, 9, 14, 0, 0, 0},
             {0, 0, 0, 9, 0, 10, 0, 0, 0},
             {0, 0, 4, 14, 10, 0, 2, 0, 0},
             {0, 0, 0, 0, 0, 2, 0, 1, 6},
             {8, 11, 0, 0, 0, 0, 1, 0, 7},
             {0, 0, 2, 0, 0, 0, 6, 7, 0}
            };
	 
            System.out.println("");
	        // Print the solution
	       graph.primeMST(mstgraph);
	       System.out.println("");
	       System.out.println("Dijkstra Algo");
	      // Dijkstra Algo           
	        graph.Dijkstra(mstgraph, 0);
	        
	        // Graph end
	        
	        
	        //Maths Algo
	        String number = "534976";
	        int n = number.length();
	        System.out.print(number+" ");
	        Mathematical_Algo.nextGreaterNumberSameDigit(number.toCharArray(), n);
	        
	        //Lexigo rank
	        LexicographicalRank lex = new LexicographicalRank();
	        System.out.println("Lexical Rank " + lex.findRank("string"));    
	}
}
