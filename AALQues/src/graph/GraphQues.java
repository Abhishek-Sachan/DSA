package graph;

import java.util.ArrayList;



public class GraphQues {
	
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
				graph[0].add(new Edge(0, 2));
				
				graph[1].add(new Edge(1, 0));
				graph[1].add(new Edge(1, 3));
				
				graph[2].add(new Edge(2, 0));
				graph[2].add(new Edge(2, 4));
				
				graph[3].add(new Edge(3, 1));
				graph[3].add(new Edge(3, 4));
				graph[3].add(new Edge(3, 5));
				
				graph[4].add(new Edge(4, 2));
				graph[4].add(new Edge(4, 3));
				graph[4].add(new Edge(4, 5));
				
				graph[5].add(new Edge(5, 3));
				graph[5].add(new Edge(5, 4));
				graph[5].add(new Edge(5, 6));
				
				graph[6].add(new Edge(6, 5));
				
		}
		
		  ///  ALL PATHS FROM SOURCES(0) TO TARGET(5)
				// time complexity - o(v^v)
				// it is modified dfs
		
		 
				public static void printAllPaths(ArrayList<Edge> graph[],boolean vis[],int curr,String path,int tar) {
					// base case
					
					if(curr==tar) {
						System.out.println(path);
						return;
					}
					
					for(int i=0; i<graph[curr].size();i++) {
						Edge e= graph[curr].get(i);
						if(vis[curr]==false) {
							// since for a one node, we can travel many times 
							// so here first true, then false 
							vis[curr]=true;
							printAllPaths(graph, vis, e.dest, path+e.dest, tar);
						vis[curr]=false;
						}
					}
					
				}
		

	public static void main(String[] args) {
		
		int v=7;  // v= vertex
		ArrayList<Edge> graph[]= new ArrayList[v];
	
		createGraph(graph);
		/// for which grah, whose have disconnected components
		// because you can not decide starting point
		boolean vis[]=new boolean[v];
		
		int tar=5;
		int src=0;
		
		printAllPaths(graph, vis, src, "0", tar);
		System.out.println();
	}
		

	}

}
