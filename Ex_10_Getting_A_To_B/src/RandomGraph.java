import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RandomGraph {
	private WeightedGraph graph;
	private int possibleEdges;
	private Random r;
	
	public RandomGraph(int numberOfNodes, int numberOfEdges) throws Exception {
		graph = new WeightedGraph(numberOfNodes);
		// No. of possible edges in an undirected graph:
		possibleEdges = ((int) Math.pow(graph.getNumberOfNodes(), 2)-graph.getNumberOfNodes())/2;
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
	
	//http://www.inf.fh-flensburg.de/lang/algorithmen/graph/breadth-first-tree.htm
	public int[] getShortestPaths(int startNode) {
		int[] distance = new int[graph.getNumberOfNodes()];
		int[] prev = new int[graph.getNumberOfNodes()];
		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		
		distance[startNode] = 0;
		prev[startNode] = -1;
		visited.add(startNode);
		q.add(startNode);
		
		while(!q.isEmpty()) {
			int head = q.remove();
			for(int i = 0; i < graph.getNumberOfNodes(); i++) {
				if(graph.isConnected(head, i) && !visited.contains(i)) {
					distance[i] = distance[head]++;
					prev[i] = head;
					visited.add(i);
					q.add(i);
				}
			}
		}
		return prev;
	}
}
