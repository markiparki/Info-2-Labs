import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Dictionary {
	HashTable hT;
	
	public Dictionary(String textFile) throws IOException {
		hT = new HashTable(20);
		fillDictionary(textFile);
	}
	
	private void fillDictionary(String textFile) throws IOException {
		ArrayList<String> lineList = getFileLines(textFile);
		Iterator<String> it = lineList.iterator();
		
		while(it.hasNext()) {
			String line = it.next();
			String[] words = line.split(" ");
			
			for(int i = 0; i < words.length; i++) {
				hT.addWord(words[i].toUpperCase());
			}
		}
	}
	
	private ArrayList<String> getFileLines(String textFile) throws IOException {
		FileReader fr = new FileReader(textFile);
	    BufferedReader br = new BufferedReader(fr);
	    ArrayList<String> lineList = new ArrayList<String>();
	    
	    String line = "";
	    while(line != null) {
	    	line = br.readLine();
	    	lineList.add(line);
	    }
	    
	    br.close();
	    return lineList;
	}
	
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
