public class PatternMatching {
	public static void main(String[] args){
		PatternMatching pm = new PatternMatching();
		boolean output = pm.isMatch("xmlpz","x?nl");
		System.out.println(output);
	}

	public boolean isMatch(String string, String pattern){
		boolean table[][] = new boolean[string.length()+1][pattern.length()+1];

		table[0][0]=true;

		char[] string_char = string.toCharArray();
		char[] pattern_char = pattern.toCharArray();
		for(int i = 1; i <= string_char.length; i++){
			for(int j = 1; j <= pattern_char.length; j++){
				//to check ? or both letters are same
				if(pattern_char[j-1] == '?' || string_char[i-1] == pattern_char[j-1]){
					table[i][j] = table[i-1][j-1];
				}//to check if it is *
				if(pattern_char[j-1] == '*'){
					table[i][j] = (table[i-1][j] || table[i][j-1]);
				}
			}
		}
		return table[string.length()][pattern.length()];
	}
}
