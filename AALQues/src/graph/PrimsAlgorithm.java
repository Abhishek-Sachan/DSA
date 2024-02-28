package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

import graph.BellmanFordAlgorithm.Edge;
import graph.DijkstrasAlgorithm.Edge.pair;

public class PrimsAlgorithm {
	
	// MINIMUM SPANNING TREE(MST)
	//1.   SUBGRAPH WITH ALL VERTICES AND ALL NODE CONNECTED AND NO CYCLE AND MIMI. EDGE WEIGHT
///  2.   UNDIRECTED,CONNECTED AND WEIGHTED GRAPH FOR MST

	
	
	static class Edge{
		int src;
		int dest;
		int wt;
		
		
		public Edge(int s,int d,int w) {
			this.src=s;
			this.dest=d;
			this.wt=w;
		}
		
		public static void createGraph(ArrayList<Edge> graph[]) {
		// loop for creating empty arraylist , because in array first it will be null
			
			for(int i=0; i<graph.length;i++) {
				graph[i]=new ArrayList<Edge>();
			}
				graph[0].add(new Edge(0, 1, 10));
				graph[0].add(new Edge(0, 2, 15));
				graph[0].add(new Edge(0, 3, 30));
				
				
				graph[1].add(new Edge(1, 0, 10));
				graph[1].add(new Edge(1, 3, 40));
				
				
				
				graph[2].add(new Edge(2, 0, 15));
				graph[2].add(new Edge(2, 3, 50));
				
				
				graph[3].add(new Edge(3, 0, 30));
				graph[3].add(new Edge(3, 1, 40));
				graph[3].add(new Edge(3, 2, 50));
		}
		
		public static class pair implements Comparable<pair>{
			int node;
			int cost;
			
			public pair(int n, int d) {
				this.cost=d;
				this.node=n;
			}

			@Override
			public int compareTo(pair p2) {
				
				return this.cost-p2.cost;  // ascending order
			}
		}
		
		// PRIM'S ALGORITHM
		// FIND MINI. WEIGHT FOR MST
		// o(ElogE)
		
		public static void prims(ArrayList<Edge> graph[],int v) {
			
			PriorityQueue<pair> pq= new PriorityQueue<>(); // act as non mst set
			
			boolean vis[]= new boolean[v];  // act as mst set
			
			pq.add(new pair(0,0));
			int mstcost=0;
			while(!pq.isEmpty()) {
				pair curr= pq.remove(); // gives shortest value
				if(!vis[curr.node]) {
					vis[curr.node]=true;
					mstcost+= curr.cost;
					
					for(int i=0; i<graph[curr.node].size();i++) {
						Edge e= graph[curr.node].get(i);
						if(!vis[e.dest]) {
							pq.add(new pair(e.dest,e.wt));
						}
						
					}
				}
				
			}
			System.out.println("mst cost"+ " "+mstcost);
		}
		
	public static void main(String[] args) {
	
		int v=4;  // v= vertex
		ArrayList<Edge> graph[]= new ArrayList[v];
	
		
		createGraph(graph);
		prims(graph, v);

	}

}
}
