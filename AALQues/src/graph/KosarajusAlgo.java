package graph;

import java.util.ArrayList;
import java.util.Stack;

import graph.PrimsAlgorithm.Edge;

public class KosarajusAlgo {
	// SCC- STRONGLY CONNECTED COMPONENET
	// 1. ONLY FOR DIRECTED GRAPH
	// SCC MEANS , FOR WHICH PART, IN WHICH WE CAN GO THROUGH ANY NODE
	
	
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
				graph[0].add(new Edge(0, 3));
				
				
				
				graph[1].add(new Edge(1, 0));
				
				
				
				
				graph[2].add(new Edge(2, 1));
				
				
				
				graph[3].add(new Edge(3, 4));
				
		}
		
		public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[],Stack<Integer> stack) {
			vis[curr]=true;
		
			for(int i=0; i<graph[curr].size();i++) {
				Edge e= graph[curr].get(i);
				if(vis[e.dest]==false) {
					topSort(graph, e.dest, vis, stack);
				}
			}
			stack.push(curr);
			
		}
		
		public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
			vis[curr]=true;
			System.out.print(curr+" ");
			for(int i=0; i<graph[curr].size();i++) {
				Edge e= graph[curr].get(i);
				if(vis[e.dest]==false) {
					dfs(graph, e.dest, vis );
				}
			}
		}
		/// to find strongly connected component
		public static void kosarajualgo(ArrayList<Edge> graph[],int v) {
			
			// step 1-- topological sorting--o(e+v)
			Stack<Integer> s= new Stack<>();
			boolean vis[]= new boolean[v];
			for(int i=0; i<v;i++) {
				if(!vis[i]) {
					topSort(graph,i,vis,s);
				}
			}
			// step 2. transpose graph(opposite direction)--o(e+v)
		
			ArrayList<Edge> transpose[]= new ArrayList[v];
			for(int i=0; i<graph.length;i++) {
				vis[i]=false;
				transpose[i]=new ArrayList<Edge>();
			}
			for(int i=0; i<v;i++) {
				for(int j=0; j<graph[i].size();j++) {
					Edge e= graph[i].get(j);
					transpose[e.dest].add(new Edge(e.dest,e.src));
				}
			}
			
			// step 3. perform dfs---o(e+v)
			while(!s.isEmpty()) {
				int curr=s.pop();
				if(!vis[curr]) {
					dfs(transpose, curr, vis);
					System.out.println();
				}
				
			}
		}

	public static void main(String[] args) {
		int v=5;  // v= vertex
		ArrayList<Edge> graph[]= new ArrayList[v];
	
		createGraph(graph);
		kosarajualgo(graph, v);

	}
	}

}
