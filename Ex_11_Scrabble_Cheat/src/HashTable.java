import java.util.LinkedList;

public class HashTable {
	LinkedList<String>[] hashTable;
	
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		hashTable = (LinkedList<String>[]) new LinkedList[size];
	}
	
	public void addWord(String word) {
		hashTable[getHashValue(word)].add(word);
	}
	
	public LinkedList<String> getWordList(int index) {
		return hashTable[index];
	}
	
	public int getHashValue(String word) {
		char[] letters = word.toCharArray();
		int hashValue = 0;
		for(int i = 0; i < letters.length; i++) {
			hashValue *= letters[i]*(Math.pow(31, letters.length-(i+1)));
		}
		return hashValue;
	}
}
