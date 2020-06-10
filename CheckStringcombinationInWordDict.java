import java.util.*;
public class CheckStringcombinationInWordDict {

	public static void main(String[] args) {
		List<String> wordDict = new LinkedList<String>();
		wordDict.add("cat");
		wordDict.add("dog");
		wordDict.add("and");

		String word = "catandsdog";
		System.out.println(wordBreak(word, wordDict));

	}

	public static boolean wordBreak(String word, List<String> wordDict){

		Set<String> uniqueWordDict = new HashSet(wordDict);

		boolean[] dp = new boolean[word.length()+1];

		dp[0] = true;

		for( int i = 1; i <= word.length(); i++){
			for ( int j = 0; j  < i ; j++){
				if(dp[j] && uniqueWordDict.contains(word.substring(j,i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[word.length()];
	}
}
