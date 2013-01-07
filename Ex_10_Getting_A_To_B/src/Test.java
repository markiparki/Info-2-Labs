
public class Test {

	public static void main(String[] args) throws Exception {
		new Test();
	}

	public Test() throws Exception {
		RandomGraph graph = new RandomGraph(20, 45);
		System.out.println(graph.toString());
		
		int[] path = graph.getShortestPaths(0);
		
		for(int i = 0; i < path.length; i++) {
			System.out.print(i+":");
			System.out.println("["+path[i]+"]");
		}
	}
}