package graph;

// Adjacency Matrix is used for representing undirected graph
public class AdjacencyMatrix {

	private int V;
	private int E;
	private int[][] adjMat;
	
	public AdjacencyMatrix(int nodes) {
		// TODO Auto-generated constructor stub
		adjMat = new int[nodes][nodes];
		V=nodes;
		E=0;
	}
	
	public void addEdge(int u, int v) {
		this.adjMat[u][v]=1;
		this.adjMat[v][u]=1;
		E++;
	}
   
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V +" vertices "+E+" edges "+"\n");
		for(int v=0;v<V;v++) {
			sb.append(v+" : ");
			for(int w:adjMat[v]) {
				sb.append(w+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AdjacencyMatrix adj = new AdjacencyMatrix(4);
		adj.addEdge(0, 1);
		adj.addEdge(1, 2);
		adj.addEdge(2, 3);
		adj.addEdge(3, 0);
		System.out.println();
	}

}
