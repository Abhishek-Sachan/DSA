package graph;

import java.util.ArrayList;

import graph.CycleDetect.Edge;

public class CycleDetect1 {
	
	static class Edge{
		int src;
		int dest;
		
		
		public Edge(int s,int d) {
			this.src=s;
			this.dest=d;
		}
		
		public static void createGraph(ArrayList<Edge> graph[]) {
		// loop for creating empty arraylist , because in array first it will be null
			
			for(int i=0; i<graph.length;i++) {
				graph[i]=new ArrayList<Edge>();
			}
				graph[0].add(new Edge(0, 1));
				graph[0].add(new Edge(0, 4));
				
				
				graph[1].add(new Edge(1, 0));
				graph[1].add(new Edge(1, 2));
				graph[1].add(new Edge(1, 4));
				
				
				graph[2].add(new Edge(2, 1));
				graph[2].add(new Edge(2, 3));
			
				
				graph[3].add(new Edge(3, 2));
				
				graph[4].add(new Edge(4, 0));
				graph[4].add(new Edge(4, 1));
				graph[4].add(new Edge(4, 5));
				
				graph[5].add(new Edge(5, 4));
		}
	
		
	
	
	/// CYCLE DETECTION FOR UNDIRECTED GRAPH
	
	public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int par)
	{
		vis[curr]=true;
		
		
		
		for(int i=0; i<graph[curr].size();i++) {
			Edge e= graph[curr].get(i);
			
			if(vis[e.dest]&& e.dest!=par) {
				return true;
			}
			else if(!vis[e.dest]) {
				/// here parent(par) will be curr value
				if(isCycleUndirected(graph, vis, e.dest, curr)==true) {
					return true;
				}
			}
			
		}
		
		return false;
	}

	public static void main(String[] args) {
		int v=6;  // v= vertex
		ArrayList<Edge> graph[]= new ArrayList[v];
	
		
		createGraph(graph);
		
		System.out.println(isCycleUndirected(graph, new boolean[v], 0, -1));

	}

}
}
