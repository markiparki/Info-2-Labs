import java.util.LinkedList;

public class HashTable {
	LinkedList<String>[] hashTable;
	
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		hashTable = (LinkedList<String>[]) new LinkedList[size];
	}
	
	public void addWord(String word) {
		
	}
}
