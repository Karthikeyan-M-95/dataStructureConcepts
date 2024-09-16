package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyList {

	private int V;
	private int E;
	private LinkedList<Integer>[] list;
	
//	@SuppressWarnings("unchecked")
	AdjacencyList(int node){
		list = new LinkedList[node];
		for(int i=0;i<node;i++) {
			list[i]=new LinkedList<>();
		}
		V=node;
		E=0;
	}
	
	
	public void addEdge(int u, int v) {
//		System.out.println(" U is : "+u+" V is : "+v);
		list[u].add(v);
		list[v].add(u);
		E++;
	}
	// TODO Auto-generated method stub
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V +" vertices "+E+" edges "+"\n");
		for(int i=0;i<V;i++) {
			sb.append(i+" : ");
			for(int w:list[i]) {
				sb.append("- "+w+" ");
					
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	//Breadth First Search
	public void bfs(int source) {
		boolean[] isVisited=new boolean[V];
		Queue<Integer> q= new LinkedList<>();
		isVisited[source]=true;
		q.offer(source);
		while(!q.isEmpty()) {
			int u=q.poll();
			System.out.print(u+" ");
			for(int w: list[u]) {
				if(!isVisited[w]) {
					isVisited[w]=true;
					q.offer(w);
				}
			}
		}
		System.out.println();
		
	}
	
//	Depth first Search
	public void dfs(int s) {
		Stack<Integer> stk = new Stack<>();
		boolean[] visited= new boolean[V];
		stk.push(s);
		while(!stk.isEmpty()) {
			int res =  stk.pop();
			if(!visited[res]) {
				System.out.print( res + " ");
				visited[res]= true;
				for(int w : list[res]) {
					if(!visited[w]) {
						stk.push(w);
					}
				}
			}
		}
		System.out.println();
		
	}
	
	public void dfsRecursive() {
		boolean[] visited= new boolean[V];
		for(int v=0;v<V;v++) {
			if(!visited[v]) {
				dfs(v,visited);
			}
		}
	}
	
	private void dfs(int v, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[v]=true;
		System.out.print(v+" ");
		for(int w:list[v]) {
//			System.out.print(" "+ w+" ");
			if(!visited[w]) {
				dfs(w,visited);
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		AdjacencyList adj = new AdjacencyList(6);
//		adj.addEdge(3, 0);
		adj.addEdge(0, 1);
		adj.addEdge(1, 2);
		adj.addEdge(2, 3);
		adj.addEdge(3, 0);
		adj.addEdge(2, 4);
		System.out.println(adj);
//		adj.bfs(0);
		adj.dfs(0);
		adj.dfsRecursive();
		}
	
}
