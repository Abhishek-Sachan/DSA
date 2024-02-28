package graph;

import java.util.ArrayList;

public class CreateGraph {
	 
	// CREATING GRAPH THROUGH ADJACENCY LIST
	// SPACE O(V),   FINDING NEIGHBOUR  O(X),  X=SIZE OF ARRAYLIST FOR THAT PARTICULAR VERTEX OR NODE
	
	
	
	static class Edge{
		int src;
		int dest;
		int wt;
		
		public Edge(int s,int d) {
			this.src=s;
			this.dest=d;
		}
		
		public Edge(int s,int d,int wt) {
			this.src=s;
			this.dest=d;
			this.wt=wt;
		}
	}
	/// craeting graph( un directed and un weighted graph
//	public static void createGraph(ArrayList<Edge> graph[]) {
//	// loop for creating empty arraylist , because in array first it will be null
//		
//		for(int i=0; i<graph.length;i++) {
//			graph[i]=new ArrayList<Edge>();
//		}
//			graph[0].add(new Edge(0, 2));
//			
//			graph[1].add(new Edge(1, 2));
//			graph[1].add(new Edge(1, 3));
//			
//			graph[2].add(new Edge(2, 0));
//			graph[2].add(new Edge(2, 1));
//			graph[2].add(new Edge(2, 3));
//			
//			graph[3].add(new Edge(3, 1));
//			graph[3].add(new Edge(3, 2));
		
		// creating graph (un directed and weighted graph)
			public static void createWeightedGraph(ArrayList<Edge> graph[]) {
				// loop for creating empty arraylist , because in array first it will be null
					
					for(int i=0; i<graph.length;i++) {
						graph[i]=new ArrayList<Edge>();
					}
						graph[0].add(new Edge(0, 2, 2));
						
						graph[1].add(new Edge(1, 2,10));
						graph[1].add(new Edge(1, 3,0));
						
						graph[2].add(new Edge(2, 0,2));
						graph[2].add(new Edge(2, 1,10));
						graph[2].add(new Edge(2, 3,-1));
						
						graph[3].add(new Edge(3, 1,0));
						graph[3].add(new Edge(3, 2,-1));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v=4;  // v= vertex
		ArrayList<Edge> graph[]= new ArrayList[v];
	
		createWeightedGraph(graph);
		// print 2's neighbours
		for(int i=0; i<graph[2].size();i++) {
			Edge e=graph[2].get(i);
			System.out.println(e.dest+ " "+e.wt);
		}

	}

}
