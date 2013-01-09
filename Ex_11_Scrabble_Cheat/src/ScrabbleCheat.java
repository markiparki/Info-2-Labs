import java.io.IOException;


public class ScrabbleCheat {
	
	public ScrabbleCheat() throws IOException {
		Dictionary dic = new Dictionary("words.txt", 500);
		String[] perms = dic.lookup("Wurst");
		
		for(int i = 0; i < perms.length; i++) {
			System.out.println(perms[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new ScrabbleCheat();
	}
}