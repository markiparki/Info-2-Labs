public class WeightedGraph {
	private int[][] graph;
	
	public WeightedGraph(int numberOfNodes) throws Exception {
		//Initialize Graph
		graph = new int[numberOfNodes][numberOfNodes];
		
		//Each Edge initialized with -1 (not connected) or 0 if it's the same node
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
	
	//Connects two nodes
	public void connectNodes(int node1, int node2, int weight) throws Exception {
		if(weight < -1) {
			throw new Exception("Negative weight.");
		}else {
			graph[node1][node2] = weight;
		}
	}
	
	//Deletes an edge
	public void deleteEdge(int node1, int node2) {
		graph[node1][node2] = -1;
	}
	
	//Returns number of nodes of the graph
	public int getNumberOfNodes() {
		return graph.length;
	}
	
	//Returns true if both nodes are connected or are the same
	public boolean isConnected(int node1, int node2) {
		return (graph[node1][node2] != -1)? true:(graph[node2][node1] != -1)? true:false;
	}
	
	//Returns a string containing the graph formatted as a adjacency matrix
	public String toString() {
		String string = "Nodes\t";
		for(int i = 0; i < graph.length; i++) {
			if(i < 10){
				string += " " + i + "   ";
			} else {
				string += " " + i + "  ";
			}
		}
		string += "\n\n";
		for(int y = 0; y < graph.length; y++) {
			string += "\n";
			for(int x = 0; x < graph.length; x++) {
				if(x == 0) {
					string += "  " + y + "\t";
				}
				if(graph[x][y] < 0 || graph[x][y] > 9) {
					string += "[" + graph[x][y] + "] ";
				}else {
					string += "[0" + graph[x][y] + "] ";
				}
			}
		}
		return string;
	}
}
