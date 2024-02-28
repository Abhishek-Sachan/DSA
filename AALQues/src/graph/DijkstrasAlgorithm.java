package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;



public class DijkstrasAlgorithm {
	
	//  SHORTEST DISTANCE FROM SOURCES TO ALL VERTICES
	// ALWAYS positive WEIGHTED GRAPH FOR THIS ALGORITHM
	///  BASED ON BFS
	/// BASED ON GREEDY(MAX OUT IN MIN EFFORT) ALGORITHM
	

	
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
				graph[0].add(new Edge(0, 1, 2));
				graph[0].add(new Edge(0, 2, 4));
				
				
				graph[1].add(new Edge(1, 3, 7));
				graph[1].add(new Edge(1, 2, 1));
				
				
				
				graph[2].add(new Edge(2, 4, 3));
				
			
				
				graph[3].add(new Edge(3, 5, 1));
				
				graph[4].add(new Edge(4, 3, 2));
				graph[4].add(new Edge(4, 5, 5));
				
					
		}
		public static class pair implements Comparable<pair>{
			int node;
			int dist;
			
			public pair(int n, int d) {
				this.dist=d;
				this.node=n;
			}

			@Override
			public int compareTo(pair p2) {
				
				return this.dist-p2.dist;  // ascending order
			}
		}
		///// O(E+ELOG V)
		
		public static void dijkstra(ArrayList<Edge> graph[], int src,int v) {
			// pariority queue gives more priority to less integer value
			
			
			PriorityQueue<pair> pq= new PriorityQueue<>();
			int dist[]= new int[v];
			for(int i=0;i<v;i++) {
				if(i!=src) {
					dist[i]= Integer.MAX_VALUE;
				}
			}
			boolean vis[]= new boolean[v];
			
			pq.add(new pair(0,0));
			while(!pq.isEmpty()) {
				pair curr= pq.remove(); // gives shortest value
				if(!vis[curr.node]) {
					vis[curr.node]=true;
					
					for(int i=0; i<graph[curr.node].size();i++) {
						Edge e= graph[curr.node].get(i);
						int U=e.src;
						int V=e.dest;
						/// relaxtation 
						if(dist[U]+e.wt<dist[V]) {
							dist[V]= dist[U]+ e.wt;
							pq.add(new pair(V,dist[V]));
						}
					}
				}
				
			}
				for(int i=0; i<v;i++) {
					System.out.print(dist[i]+ " ");
				}
				System.out.println();
			
			
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int v=6;  // v= vertex
		ArrayList<Edge> graph[]= new ArrayList[v];
	
		
		createGraph(graph);
		
		dijkstra(graph, 0, v);
	}

}
}
