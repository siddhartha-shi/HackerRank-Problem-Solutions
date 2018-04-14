package iOS;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q15_MinimumWeightPathInADirectedGraph {
	
	public static int minCost(int gNodes, int[] gFrom, int[] gTo, int[] gWeights, int start, int end) {
		// making a array to store shortest length and filling it with infinity except
		// the first one
		int[] shortest = new int[gNodes];
		for (int i = 0; i < gNodes; i++) {
			shortest[i] = Integer.MAX_VALUE;
		}
		shortest[start] = 0;
		// filling the Queue with all vertices
		Queue<Integer> theQ = new PriorityQueue<>();
		for (int i = 0; i < gNodes; i++) {
			theQ.add(i + 1);
		}
		int loopCount = 0;
		// following the algorithm
		while (!theQ.isEmpty()) {
			int u = theQ.poll();
			// making a list of adjacent vertices

			List<Integer> adjacent = new ArrayList<>();
			for (int i = 0; i < gFrom.length; i++) {
				if (gFrom[i] == u) {
					adjacent.add(gTo[i]);
				} else if (gTo[i] == u) {
					adjacent.add(gFrom[i]);
				}
			}
			for (int v : adjacent) {
				int weight = 0;
				for (int i = 0; i < gFrom.length; i++) {
					if ((gFrom[i] == u && gTo[i] == v) || (gFrom[i] == v && gTo[i] == u)) {
						weight = gWeights[i];
					}
				}

				// relaxing the verices
				if (shortest[v] > shortest[u] + weight) {
					shortest[v] = shortest[u] + weight;
				}
				if (v == end) {
					return shortest[v];
				}
				theQ.add(v);
			}
			loopCount++;
			//System.out.println(loopCount);
			if (loopCount>=end*gNodes) {
				System.out.println(1);
				break;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		final int node = in.nextInt();
		final int NumberOfEdge = in.nextInt();
		
		int gNodes = node+1;
		int[] gFrom = new int[NumberOfEdge];
		// gNodes = gFrom.length + 1;
		int[] gTo = new int[NumberOfEdge];
		int[] gWeights = new int[NumberOfEdge];
		int start = 1;
		int end = node;
		
		for (int i = 0; i < NumberOfEdge; i++) {
			gTo[i] = in.nextInt();
			gFrom[i] = in.nextInt();
			gWeights[i] = in.nextInt();
		}
		
		int sid = minCost(gNodes, gFrom, gTo, gWeights, start, end);
		if (sid != -1) {
			System.out.println(sid);
		}
	}

}
