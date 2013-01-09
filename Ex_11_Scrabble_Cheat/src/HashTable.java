import java.util.LinkedList;

public class HashTable {
	LinkedList<String>[] hashTable;
	
	//Initializes the hash table with the sized passed in
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		hashTable = (LinkedList<String>[]) new LinkedList[size];
		
		for(int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new LinkedList<>();
		}
	}
	
	//Adds the word passed in to the HashTable at the index according to the hash value
	public void addWord(String word) {
		word = word.toUpperCase();
		hashTable[getHashValue(word)].add(word);
	}
	
	//Returns all the permuations stored at the specific index
	public LinkedList<String> getWordList(int index) {
		return hashTable[index];
	}
	
	//Returns the hash value of the word passed in
	public int getHashValue(String word) {
//		char[] letters = word.toCharArray();
//		int hashValue = 0;
//		for(int i = 0; i < letters.length; i++) {
//			hashValue += (letters[i]-64)*(Math.pow(31, letters.length-(i+1)));
//		}
		return 1;
	}
}
