package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class GraphTraversal {
	
	//1.  BFS(BREADTH FIRST SEARCH)
	// TIME COMPLEXITY, O(VERTEX+ EDGES)
	
	// GO TO IMMEDIATE NEIGHBOURS FIRST
	// YOU CAN SAY BFS TO INDIRECT LEVEL ORDER TRAVERSAL
	
	
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
		
		public static void bfs(ArrayList<Edge> graph[],int v,boolean vis[],int start) {
			Queue<Integer> q= new LinkedList<>();
			
			q.add(start); // starting point or node
			while(!q.isEmpty()) {
				int curr=q.remove();
				if(vis[curr]==false) {
					System.out.print(curr+" ");
					vis[curr]=true;
					// find neighbour of curr node
					for(int i=0; i<graph[curr].size();i++) {
						Edge e= graph[curr].get(i);
						q.add(e.dest);
					}
				}
			}
			
		}
		
		   /// DFS(DEPTH FIRST SEARCH)
		// TIME COMPLEXITY-  O(V+E)
		
		// KEEP GOING TO THE 1ST NEIGHBOUR
		
		public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[]) {
			// print curr 
			System.out.print(curr+" ");
			// make true the current
			vis[curr]=true;
			// visiting neighbour 
			for(int i=0; i<graph[curr].size();i++) {
				Edge e= graph[curr].get(i);
				if(vis[e.dest]==false) {
				dfs(graph,e.dest,vis);
				}
			}
		}
		
		 
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int v=7;  // v= vertex
		ArrayList<Edge> graph[]= new ArrayList[v];
	
		createGraph(graph);
		/// for which grah, whose have disconnected components
		// because you can not decide starting point
		boolean vis[]=new boolean[v];
		for(int i=0; i<v;i++) {
			if(vis[i]== false) {
				//bfs(graph, v,vis,i);
				dfs(graph,i,vis);
			}
		}
		
		System.out.println();
		
		}
	}

}

