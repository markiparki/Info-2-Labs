
public class ScrabbleCheat {
	
	public ScrabbleCheat() throws Exception {
		Dictionary dic = new Dictionary("words.txt", 20000);
		
		System.out.println(dic.lookup("Papierkorb"));
	}
	
	public static void main(String[] args) throws Exception {
		new ScrabbleCheat();
	}
}