import java.util.Random;

public class RandomGraph {
	private WeightedGraph graph;
	private int possibleEdges;
	private Random r;
	
	public RandomGraph(int numberOfNodes, int numberOfEdges) throws Exception {
		graph = new WeightedGraph(numberOfNodes);
		possibleEdges = (int) Math.pow(graph.getNumberOfNodes(), 2)-graph.getNumberOfNodes();
		r = new Random();
		
		connectRandomNodes(numberOfEdges);
	}
	
	//Connects random nodes
	private void connectRandomNodes(int numberOfEdges) throws Exception {		
		if(numberOfEdges > possibleEdges) {
			throw new Exception("Too many Edges.");
		} else {
			
			for(int i = 0; i < numberOfEdges; i++) {
				int node1 = r.nextInt(graph.getNumberOfNodes());
				int node2 = r.nextInt(graph.getNumberOfNodes());
				
				if(node1 == node2 || graph.isConnected(node1, node2)) {
					//One more step
					i--;
				}else {
					int weight = r.nextInt(100);
					//Undirected Graph -> Both Ways get connected
					graph.connectNodes(node1, node2, weight);
					graph.connectNodes(node2, node1, weight);
				}
			}
		}
	}
	
	//Calls the toString() method of the graph
	public String toString() {
		return graph.toString();
	}
}
