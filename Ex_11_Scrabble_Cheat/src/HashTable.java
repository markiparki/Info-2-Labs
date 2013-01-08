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
		
		return 0;
	}
}
