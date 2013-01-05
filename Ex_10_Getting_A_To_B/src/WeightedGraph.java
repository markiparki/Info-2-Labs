public class WeightedGraph {
	private int[][] graph;
	
	public WeightedGraph(int numberOfNodes) throws Exception {
		//Initialize Graph
		graph = new int[numberOfNodes][numberOfNodes];
		
		for(int y = 0; y < numberOfNodes; y++) {
			for(int x = 0; x < numberOfNodes; x++) {
				if(x == y) {
					connectNodes(x, y, 0);
				} else {
					connectNodes(x, y, -1);
				}
			}
		}
	}
	
	public void connectNodes(int node1, int node2, int weight) throws Exception {
		if(weight < 0) {
			throw new Exception("Negative weight.");
		}else {
			graph[node1][node2] = weight;
		}
	}
	
	public void deleteEdge(int node1, int node2) {
		graph[node1][node2] = -1;
	}
	
	public int getNumberOfNodes() {
		return graph.length;
	}
	
	public boolean isConnected(int node1, int node2) {
		return graph[node1][node2] != -1;
	}
}
