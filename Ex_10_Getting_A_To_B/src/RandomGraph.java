import java.util.Random;

public class RandomGraph {
	private WeightedGraph graph;
	private int possibleEdges;
	
	public RandomGraph(int numberOfNodes, int numberOfEdges) throws Exception {
		graph = new WeightedGraph(numberOfNodes);
		possibleEdges = (int) Math.pow(graph.getNumberOfNodes(), 2)-graph.getNumberOfNodes();
		
		connectRandomNodes(numberOfEdges);
	}
	
	private void connectRandomNodes(int numberOfEdges) throws Exception {
		Random r = new Random();
		
		if(numberOfEdges > possibleEdges) {
			throw new Exception("Too many Edges.");
		} else {
			
			for(int i = 0; i < numberOfEdges; i++) {
				int node1 = r.nextInt(graph.getNumberOfNodes());
				int node2 = r.nextInt(graph.getNumberOfNodes());
				
				if(node1 == node2 || graph.isConnected(node1, node2)) {
					i--;
				}else {
					graph.connectNodes(node1, node2, r.nextInt(100));
				}
			}
		}
	}
}
