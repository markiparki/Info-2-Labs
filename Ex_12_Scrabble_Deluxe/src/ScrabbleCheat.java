import java.util.Random;

public class ScrabbleCheat {
	
	public ScrabbleCheat() throws Exception {
		//Create 7 letter random word
		Random r = new Random();
		String random_word = "";
		for(int i = 0; i < 7; i++) {
			char x = (char) (r.nextInt(26) + 65);
			random_word += "" + x;
		}
		System.out.println(random_word);
		
		Dictionary dic = new Dictionary("words.txt", 20000);
		System.out.println(dic.lookup(random_word));
	}
	
	public static void main(String[] args) throws Exception {
		new ScrabbleCheat();
	}
}