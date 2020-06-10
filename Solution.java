import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.intToRoman(13));
		char[] str ={'j','b','z'};
		Arrays.sort(str);
		System.out.println(str);
	}
	public String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		while(num > 0){
			if(num >1000){
				num = num -1000;
				result.append(provideRomanSymbol(1000));
			}else if(num >500){
				num =num -500;
				result.append(provideRomanSymbol(500));
			}else if(num > 5){
				num = num -5;
				result.append(provideRomanSymbol(5));
			}else{
				num = num -1;
				result.append(provideRomanSymbol(1));

			}

		}
		return result.toString();
	}

	public char provideRomanSymbol(int number){
		switch(number){
			case 1000: return 'M';
			case 500: return 'D';
			case 100: return 'C';
			case 50 :return 'L';
			case 10: return 'X';
			case 5: return 'V';
			case 1: return 'I';
		}
		return ' ';
	}
}