public class AToI {
	public static void main(String[] args) {

		String s =" 23365";
//		int index = 0;
//		int digit = 0, total = 0;
//		for(int i = 0; i < test.length(); i++) {
//			digit = test.charAt(index) - '0';
//			if(digit < 0 || digit > 9)
//				break;
//			total = total*10 + digit;
//			index++;
//		}
		int i = 0, output = 0;
		boolean sign = true;
		while(s.charAt(i) == ' '){
			i++;
		}
		if(s.charAt(i) == '-') {
			sign = false;
			i++;
		}
		else if(s.charAt(i) == '+'){
			sign = true;
			i++;
		}
		for (int j =i; j < s.length(); j++){
			int currentNumber = s.charAt(j) - '0';
			if(Integer.MAX_VALUE/10 < output || Integer.MAX_VALUE/10 == output && Integer.MAX_VALUE %10 < currentNumber) {
				output = (sign == true) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				break;
			}

				if(0 <= currentNumber  && currentNumber <= 9){
					output = (output * 10) + currentNumber;
				}
			else{
				break;
			}
		}

		if (!sign)
			System.out.println(output * -1);
		else
			System.out.println(output);

	}
}
