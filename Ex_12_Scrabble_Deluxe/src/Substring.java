import java.util.Arrays;
import java.util.HashSet;


public class Substring {
	HashSet<String> subStrings;
	HashSet<String> stringPerms;
	
	public Substring(String stringLetters) {
		subStrings = new HashSet<String>();
		stringPerms = new HashSet<String>();
		
		createStringPerms("", stringLetters);
		
		for(String perm : stringPerms) {
			createSubStrings(perm);
		}
	}
	
	public HashSet<String> getSubStrings() {
		return subStrings;
	}
	
	private void createStringPerms(String beginningString, String endingString) {
		
		if (endingString.length() <= 1) {
			
			stringPerms.add(beginningString + endingString);
		}
		else {
			for (int i = 0; i < endingString.length(); i++) {
				String newString = endingString.substring(0, i) + endingString.substring(i + 1);
				createStringPerms(beginningString + endingString.charAt(i), newString);
			}
		}
	}
	
	private void createSubStrings(String sub) {
		char[] perm = sub.toUpperCase().toCharArray();
		Arrays.sort(perm);
		subStrings.add(String.valueOf(perm));
		
		if((sub.length()-2) <= 0) {
		} else {
			createSubStrings(sub.substring(0, sub.length()-1));
		}
	}
}
