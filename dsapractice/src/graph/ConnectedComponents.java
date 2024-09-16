package graph;

import java.util.LinkedList;

public class ConnectedComponents {

	private int V;
	private int E;
	private LinkedList<Integer>[] list;
	private int compId[];
	private boolean[] visited;
	private int count;
	
	public ConnectedComponents(int vertices) {
		// TODO Auto-generated constructor stub
		V = vertices;
		E=0;
		compId= new int[vertices];
		visited = new boolean[vertices];
		list = new LinkedList[vertices];
		count=0;
		for(int i=0;i<vertices;i++) {
			list[i]= new LinkedList<>();
		}
	}
	
	
	public void addEdge(int u, int v) {
		if(u!=v) {
			if(!list[u].contains(v)) {
			list[u].add(v);
			list[v].add(u);
			}
		}else {
			list[u].add(v);
		}
	
		E++;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V+" vetices "+ E+" edges "+" \n");
		for(int i=0;i<V;i++) {
			sb.append(i+": ");
			for(int w: list[i]) {
				sb.append(w+"-");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void dfs() {
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				dfs(i,visited);
				count++;
			}
		}
	}
	
	private void dfs(int i, boolean[] visited) {
		visited[i]=true;
		compId[i]=count;
		for(int w:list[i]) {
			if(!visited[w]) {
				dfs(w, visited);
			}
		}
	}

	
	public void printConnectComponents() {
		for(int i=0;i<V;i++) {
			System.out.print(i+" "+ compId[i]+": & visited ? : "+ visited[i]+" / ");	
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		ConnectedComponents adj = new ConnectedComponents(4);
////		adj.addEdge(3, 0);
//		adj.addEdge(0, 1);
//		adj.addEdge(3, 0);
////		adj.addEdge(1, 2);
////		adj.addEdge(2, 3);
//		adj.addEdge(2, 4);
		int[][] arr = {
				{1,1,0,0},{1,0,0,0},{0,0,1,0},{0,0,0,1}
		};
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]!=0 ) {
//					System.out.println(i+" "+j+" ");
					adj.addEdge(i, j);
				}
			}
		}
		
	
		System.out.println(adj);
		adj.printConnectComponents();
		adj.dfs();
		adj.printConnectComponents();
	}
}
