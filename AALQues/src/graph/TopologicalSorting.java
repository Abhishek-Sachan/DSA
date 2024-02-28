package graph;

import java.util.ArrayList;
import java.util.Stack;

import graph.CycleDetect.Edge;

public class TopologicalSorting {
	
	// TOPOLOGICAL SORTING
	
	//1.   DIRECTED ACYCLIC GRAPH(DAG) IS A DIRECTED GRAPH WITH NO CYCLES.
	// 2.  TOPOLOGICAL SORTING IS USED ONLY FOR DAGS.
	
	
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
				graph[2].add(new Edge(2, 3));
				
				
				graph[3].add(new Edge(3, 1));
				
				
				graph[4].add(new Edge(4, 0));
				graph[4].add(new Edge(4, 1));
			
				
				graph[5].add(new Edge(5, 0));
				graph[5].add(new Edge(5, 2));
		}
	

		
		// TOPO;OGICAL SORTING
		
		public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[],Stack<Integer> stack) {
			vis[curr]=true;
		
			for(int i=0; i<graph[curr].size();i++) {
				Edge e= graph[curr].get(i);
				if(vis[e.dest]==false) {
					topSortUtil(graph, e.dest, vis, stack);
				}
			}
			stack.push(curr);
			
		}
		
		
		public static void topSort(ArrayList<Edge> graph[],int v) {
			
			boolean vis[]= new boolean[v];
			Stack<Integer> s1= new Stack<>();
			for(int i=0; i<v;i++) {
				if(!vis[i]) {
					topSortUtil(graph, i, vis, s1);
				}
			}
			
			while(!s1.isEmpty()) {
				System.out.print(s1.pop()+ " ");
			}
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int v=6;  // v= vertex
		ArrayList<Edge> graph[]= new ArrayList[v];
	
		
		createGraph(graph);
		topSort(graph, v);
		

	}
	}

}
