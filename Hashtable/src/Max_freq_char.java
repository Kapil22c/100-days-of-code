import java.util.HashMap;
import java.util.Set;

public class Max_freq_char {

	public static void main(String[] args) {
		
		String str1= "kapilbavisiya";
		String str2 = "abcdbbbcdcdacdcaaacd";
		String str3 = "thinkandgrowrich";
		System.out.println(maxFreqChar(str1));
		System.out.println(maxFreqChar(str2));
		System.out.println(maxFreqChar(str3));

	}
	
	private static char maxFreqChar(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
			if(map.containsKey(ch)) {
				int val = map.get(ch);
				map.put(ch, val+1);
			}else {
				map.put(ch, 1);
			}
		}
		// the keyset function basically gives you all the key
		// present in hashmap and store it in a set.
		Set<Character> keyset = map.keySet();
		int maxFreq = Integer.MIN_VALUE;
		
		char maxChar =' ';
		for(char key:keyset) {
			if(map.get(key) > maxFreq) {
				maxFreq = map.get(key);
				maxChar = key;
			}
		}
		
		return maxChar;
	}

}
