package main;

import math.LexicographicalRank;
import math.Mathematical_Algo;

public class Main {

	public static void main(String[] args) {

		// Maths Algo
		String number = "534976";
		int n = number.length();
		System.out.print(number + " ");
		Mathematical_Algo.nextGreaterNumberSameDigit(number.toCharArray(), n);

		// Lexigo rank
		LexicographicalRank lex = new LexicographicalRank();
		System.out.println("Lexical Rank " + lex.findRank("string"));
	}
}
