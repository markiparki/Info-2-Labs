import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {
	private LinkedList<String>[] hashTable;
	
	//Initializes the hash table with the sized passed in
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		hashTable = (LinkedList<String>[]) new LinkedList[size];
	}
	
	//Adds the word passed in to the HashTable at the index according to the hash value
	public void addWord(String word) {
		word = word.toUpperCase();
		int index = getHashValue(word);
		
		//If theres a collision, check next index
		while(isCollision(word, index)) {
			index++;
		}
		//Is at the index still a list? If no create one
		if(hashTable[index] == null) {
			hashTable[index] = new LinkedList<String>();
		}
		//Store the word in the list
		hashTable[index].add(word);
	}
	
	//Returns all the permuations stored at the specific index
	public LinkedList<String> getWordList(int index) {
		return hashTable[index];
	}
	
	//Returns the hash value of the word passed in
	public int getHashValue(String word) {
		char[] letters = word.toUpperCase().toCharArray();
		Arrays.sort(letters);
		int hashValue = 0;
		for (int i = 0; i < word.length(); i++) {
			hashValue += (letters[i] - ('A'-1)) * 17 ^ i;
		}
		hashValue = (hashValue < 0)? hashValue*-1:hashValue; 
		return hashValue%9999;
	}
	
	public boolean isCollision(String word, int index) {
		//Nothing in here yet? No collision
		if(hashTable[index] == null) {
			return false;
		} else {
			//Are both words permutations of each other? No collision!
			String tableWord = hashTable[index].getFirst();
			
			if(getHashValue(tableWord) == getHashValue(word)) {
				return false;
			} else {
				//If they are not a permutation of each other: Collision!
				return true;
			}
		}
	}
	
	public int getHashTableSize() {
		return hashTable.length;
	}
}
