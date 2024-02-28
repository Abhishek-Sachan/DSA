package graph;

import java.util.ArrayList;

import graph.GraphQues.Edge;

public class CycleDetect {
	
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
				graph[0].add(new Edge(0, 2));
				
				
				graph[1].add(new Edge(1, 0));
				
				
				graph[2].add(new Edge(2, 3));
			
				
				graph[3].add(new Edge(3, 0));
		}
	
		
	// cycle detection for only directed graph
		// o(v+e)
	
	public static boolean isCycleDirected(ArrayList<Edge> graph[],boolean vis[],int curr,boolean rec[]) {
		
		vis[curr]=true;
		rec[curr]=true;
		
		
		for(int i=0; i<graph[curr].size();i++) {
			Edge e= graph[curr].get(i);
			if(rec[e.dest]) { // cycle detect condition
				return true;
			}
			else if(vis[e.dest]==false) {
				if(isCycleDirected(graph, vis, e.dest, rec)) {
					return true;
				}
			}
		}
		rec[curr]=false;
		return false;
	}
	
	
	/// CYCLE DETECTION FOR UNDIRECTED GRAPH
	
	
	public static void main(String[] args) {


		int v=4;  // v= vertex
		ArrayList<Edge> graph[]= new ArrayList[v];
	
		
		createGraph(graph);
		
		boolean vis[]= new boolean[v];
		boolean rec[]= new boolean[v];
		for(int i=0; i<v; i++) {
			if(vis[i]==false) {
				boolean amp= isCycleDirected(graph, vis, 0, rec);
				if(amp) {
					System.out.println(amp);
					break;
				}
			}
		}
		
	}

}
}
