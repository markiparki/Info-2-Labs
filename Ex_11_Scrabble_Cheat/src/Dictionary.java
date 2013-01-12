import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Dictionary {
	HashTable hT;
	private int wordCounter = 0;
	
	//Initializes the HashTable and fills the Dictionary with the words from the textfile 
	public Dictionary(String textFile, int hashTableSize) throws Exception {
		hT = new HashTable(hashTableSize);
		fillDictionary(textFile);
		System.out.println("The hash table has a size of " + hashTableSize + ".");
		System.out.println("There are " + wordCounter + " words stored in it.");
	}
	
	//Fills dictionary's hash table with all the words seperated by a space from the textfile
	private void fillDictionary(String textFile) throws Exception {
		ArrayList<String> lineList = readFileLines(textFile);
		
		//For each line from the file
		for(String s : lineList) {
			//Split it in words
			String[] words = s.split(" ");
			
			//Add each word to the hash table
			for(String word : words) {
				hT.addWord(word);
				wordCounter++;
			}
		}
	}
	
	//Returns each line from the textfile as an ArrayList
	private ArrayList<String> readFileLines(String textFile) throws IOException {
		FileReader fr = new FileReader(textFile);
	    BufferedReader br = new BufferedReader(fr);
	    ArrayList<String> lineList = new ArrayList<String>();
	    
	    String thisLine;
	    //As long as the line read is not null, save it to the array list
		while ((thisLine = br.readLine()) != null) {
	         lineList.add(thisLine);
	    }
	    
	    br.close();
	    return lineList;
	}
	
	public LinkedList<String> lookup(String word) {
		int index = hT.getHashValue(word);
		
		//As long as there's a collision, check the next index (index+1)
		while(hT.isCollision(word, index)) {
			index++;
			//If index is bigger than the hash table size, we didn't find any word list
			if(index > hT.getHashTableSize()-1) {
				return null;
			}
		}
		//Take the word list at the collision-free index from the hash table
		LinkedList<String> wordList = hT.getWordList(index);
		//If it's null, there exists no word list for our word
		if(wordList == null) {
			return null;
		} else {
			return wordList;
		}
	}
}
