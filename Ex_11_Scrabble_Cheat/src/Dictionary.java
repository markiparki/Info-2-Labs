import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class Dictionary {
	HashTable hT;
	
	//Initializes the HashTable and fills the Dictionary with the words from the textfile 
	public Dictionary(String textFile, int hashTableSize) throws IOException {
		hT = new HashTable(hashTableSize);
		fillDictionary(textFile);
	}
	
	//Fills dictionary's hash table with all the words seperated by a space from the textfile
	private void fillDictionary(String textFile) throws IOException {
		ArrayList<String> lineList = getFileLines(textFile);
		
		for(String s : lineList) {
			String[] words = s.split(" ");
			
			for(int i = 0; i < words.length; i++) {
				hT.addWord(words[i]);
			}
		}
	}
	
	//Returns each line from the textfile as an ArrayList
	private ArrayList<String> getFileLines(String textFile) throws IOException {
		FileReader fr = new FileReader(textFile);
	    BufferedReader br = new BufferedReader(fr);
	    ArrayList<String> lineList = new ArrayList<String>();
	    
	    String thisLine;
	    //While the line read is not null, save it to the array list
		while ((thisLine = br.readLine()) != null) {
	         lineList.add(thisLine);
	    }
	        
	    br.close();
	    return lineList;
	}
	
	//Returns all the permutations from the word passed in, which are stored in the dictionary
	public String[] lookup(String word) {
		int index = hT.getHashValue(word);
		LinkedList<String> wordList = hT.getWordList(index);
		String[] words = new String[wordList.size()];

		for(int i = 0; i < wordList.size(); i++) {
			words[i] = wordList.get(i);
		}
		return words;
	}
}
