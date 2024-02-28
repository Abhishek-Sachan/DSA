package graph;

import java.util.ArrayList;



public class BellmanFordAlgorithm {
	
	/// SAME AS DIJKSTRAS ,BUT THIS IS ALSO WORKING FOR NEGATIVE WEIGHTED GRAPH
	// WHILE DIJKSTRAS WORKING FOR POSITIVE WEIGHTED GRAPH
	/// BASED ON DYNAMIC PROGRAMMING
	// shortest didtance from sources to all vertices
	// time complexity o(v*e)  is higher than dijkstras
	// this does not work for negative weight cycles.
	
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
				
				
				
				graph[1].add(new Edge(1, 2, -4));
				
				
				
				graph[2].add(new Edge(2, 3, 2));
				
			
				
				graph[3].add(new Edge(3, 4, 4));
				
				graph[4].add(new Edge(4, 1, -1));
				
				
					
		}
		
		public static void bellmanFord(ArrayList<Edge> graph[], int src,int v) {
			
			int dist[]= new int[v];
			for(int i=0;i<v;i++) {
				if(i !=src) {
					dist[i]=Integer.MAX_VALUE;
				}
			}
				// v-1 times loop for all graph
				for(int k=0; k<v-1;k++) {
					for(int j=0; j<v;j++) {// for all nodes
						for(int p=0; p<graph[j].size();p++) {
							Edge e= graph[j].get(p);
							int U=e.src;
							int V=e.dest;
							
							if(dist[U] != Integer.MAX_VALUE &&dist[U]+e.wt<dist[V]) {
								dist[V]= dist[U]+e.wt;
							}
						}
						
					}
					
				}
			
			
			for(int i=0;i<dist.length;i++) {
				System.out.print(dist[i]+" ");
			}
			System.out.println();
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int v=5;  // v= vertex
		ArrayList<Edge> graph[]= new ArrayList[v];
	
		
		createGraph(graph);
		bellmanFord(graph, 0, v);

	}
	}

}
