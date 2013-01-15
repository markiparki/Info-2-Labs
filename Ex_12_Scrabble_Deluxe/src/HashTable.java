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
	public void addWord(String word) throws Exception {
		word = word.toUpperCase();
		int index = getHashValue(word);
		
		//If theres a collision, check next index
		while(isCollision(word, index)) {
			index++;
			if(index > getHashTableSize()-1) {
				throw new Exception("No space left in hash table.");
			}
		}
		//Is at the index already a list? If no create one
		if(hashTable[index] == null) {
			hashTable[index] = new LinkedList<String>();
		}
		System.out.println(word + " am index " + index);
		//Store the word in the list
		hashTable[index].add(word);
	}
	
	//Returns all the permuations stored at the specific index
	public LinkedList<String> getWordList(int index) {
		return hashTable[index];
	}
	
	//Returns the hash value of the word passed in
	public int getHashValue(String word) {
		//Seperate each letter of the Word and normalize it to upper cases
		char[] letters = word.toUpperCase().toCharArray();
		//Sort the letters alphabetically
		Arrays.sort(letters);
		//Calculate the hash value. ('A'-1) normalizes the value of the chars to A = 1, B = 2, C = 3 ..
		int hashValue = 0;
		for (int i = 0; i < word.length(); i++) {
			hashValue += (letters[i] - ('A'-1)) * 17 ^ i;
		}
		//Prevent negative values (Why do they even occur?)
		hashValue = (hashValue < 0)? hashValue*-1:hashValue; 
		return hashValue%9973;
	}
	
	//Returns true if the first word in the list at a specific index is not a permutation with the specific word
	public boolean isCollision(String word, int index) {
		//Nothing in here yet? No collision
		if(hashTable[index] == null) {
			return false;
		} else {
			char[] tableWord = hashTable[index].getFirst().toCharArray();
			Arrays.sort(tableWord);
			char[] myWord = word.toCharArray();
			Arrays.sort(myWord);

			//Are both words permutations of each other? No collision!
			if(tableWord.equals(myWord)) {
				return false;
			} else {
				//If they are not a permutation of each other: Collision!
				return true;
			}
		}
	}
	
	//Returns the size of the hash table
	public int getHashTableSize() {
		return hashTable.length;
	}
	
	public boolean isPermutation (String a, String b){
		
		return true;
		
		
	}
}
