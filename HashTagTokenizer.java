

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
		
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
	public static String lowerCase(String s) {
		String str = "";
		   for(int var3 = 0; var3 < s.length(); var3++) {
			   char var2 = s.charAt(var3);
		   if (s.charAt(var3) >= 'A' && s.charAt(var3) <= 'Z') {
			   var2 = (char)(s.charAt(var3) + 32);
		   }
   
		   str = str + var2;
		   }
   
		   return str;
	   }
   

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
        int N = hashtag.length();
		String hashtag1 = lowerCase(hashtag);
		//new word to use after evry print of the single word from hashtag
		String hashtag2 = "";
        for (int i = 1; i <= N; i++) {
			if(existInDictionary(hashtag1.substring(0,i), dictionary)){
				System.out.println(hashtag1.substring(0, i));
				//develop word2
				 for(int j = i + 1; j <= N; j++){
					char var2 = hashtag1.charAt(j - 1);
					hashtag2 = hashtag2 + var2;
				 } 
				 N = hashtag2.length();
				 break;
			}
        }
		breakHashTag(hashtag2, dictionary);
    }

}
