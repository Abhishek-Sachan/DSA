package graph;

import java.util.ArrayList;

import graph.TarjansAlgo.Edge;

public class ArticulationPoint {
	
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
				graph[0].add(new Edge(0, 3));
				
				
				graph[1].add(new Edge(1, 0));
				graph[1].add(new Edge(1, 2));
				
				
				graph[2].add(new Edge(2, 0));
				graph[2].add(new Edge(2, 1));
				
				
				graph[3].add(new Edge(3, 0));
				graph[3].add(new Edge(3, 4));
				
				
				
				graph[4].add(new Edge(4, 3));
				
		}
		
		public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[],boolean ap[],int dt[],int low[],int time,int par) {
		
			vis[curr]=true;
			dt[curr]=low[curr]=++time;
			int children=0;
			for(int i=0; i<graph[curr].size();i++) {
				Edge e= graph[curr].get(i);
				if(e.dest==par) {
					continue;
				}
				else if(!vis[e.dest]) {
					dfs(graph, e.dest, vis,ap, dt, low, time, curr);
					low[curr]=Math.min(low[curr], low[e.dest]);
					if(dt[curr]<=low[e.dest] && par!=-1) {// condition for bridge and cycle form
						ap[curr]=true;
					}
					children++;
				}
				else {  // backedge case (means already visited)
					low[curr]=Math.min(low[curr], dt[e.dest]);
				}
			}
			if(par==-1 && children>1) { // starting point of dfs
				ap[curr]=true;
			}
			
		}
		/// o(v+e)
		public static void getAp(ArrayList<Edge> graph[],int v) {
			int dt[]= new int[v]; // discovery time
			int low[]=new int[v]; // lowest discovery time of neighbour
			int time=0;
			boolean vis[ ]=new boolean[v];
			boolean ap[]= new boolean[v];
			for(int i=0; i<v;i++) {
				if(!vis[i]) {
					dfs(graph,i,vis,ap,dt,low,time,-1); // -1 for parent node value
				}
			}
			
			for(int i=0; i<v;i++) {
				if(ap[i]) {
					System.out.println("ARTICULATION POINT"+i);
				}
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int v=5;  // v= vertex
		ArrayList<Edge> graph[]= new ArrayList[v];
	
		createGraph(graph);
		getAp(graph, v);

	}

}
}
