import java.util.LinkedList;
import java.util.Random;

public class ScrabbleCheat {
	Dictionary dic;
	
	public ScrabbleCheat() throws Exception {
		dic = new Dictionary("words.txt", 20000);
		scrabbleCheatDeluxe(getRandomWord(7));
	}
	
	//Create a random word with x amount of letters
	private String getRandomWord(int letters) {
		Random r = new Random();
		String randomWord = "";
		//choose x random character between A and Z and append them to the string
		for(int i = 0; i < letters; i++) {
		char x = (char) (r.nextInt(26) + 65);
			randomWord += "" + x;
		}
		return randomWord;
	}
	
	//Look up all the Substrings of the word and print if there was somthing stored in the hash table
	public void scrabbleCheatDeluxe(String word) {
		Substring ss = new Substring(word);
		boolean smthnFound = false;
		
		for(String subString : ss.getSubStrings()) {
			LinkedList<String> wordList;
			if((wordList = dic.lookup(subString)) != null) {
				System.out.println(dic.lookup(subString));
				smthnFound = true;
			}
		}
		if(smthnFound == false) {
			System.out.println("Sorry, nothing was found for '" + word + "'.");
		}
	}
	
	public static void main(String[] args) throws Exception {
		new ScrabbleCheat();
	}
}