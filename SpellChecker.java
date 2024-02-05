
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
		//System.out.println(levenshtein("SPELL", "spell"));
	}


	public static String tail(String str) {
		
		return str.substring(1);
	}

	public static int levenshtein(String word1, String word2) {
		//convert the words to lower case
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		//check the words length
		int a = word1.length();
		int b = word2.length();
		if (a == 0){
			return b;
		}
		if(b == 0){
			return a;
		}
		if(word1.charAt(0) == word2.charAt(0)){
			return levenshtein(tail(word1), tail(word2));
		}
	
		return 
		1 + Math.min(Math.min(levenshtein(tail(word1), word2),levenshtein(word1, tail(word2))), levenshtein(tail(word1), tail(word2)));
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for(int i = 0; i < dictionary.length; i++){
			String word = in.readString();
			dictionary[i] = word;	
		}
		return dictionary;
	}
	public static boolean existInDictionary(String word, String []dictionary) {
		for(int i = 0; i < dictionary.length; i++){
			if(dictionary[i].equals(word)){
				return true;
			}
		}
		return false;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		if(existInDictionary(word, dictionary)){
			return word;
		}
		for(int i = 0; i < dictionary.length; i++){
			if(levenshtein(word, dictionary[i]) == threshold)
			return dictionary[i];
		}
		return word;
	}


}
