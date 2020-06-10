import java.util.*;

public class PhoneDigitToTextFormation {
	static List<String> output = new LinkedList<String>();
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		PhoneDigitToTextFormation pdtf = new PhoneDigitToTextFormation();
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("abcd");
		stringList.add("pqrs");
		ArrayList<String> stringList1 = new ArrayList<String>();
		stringList1.add("abcde");
		stringList1.add("pqrs");
		Map<Integer, ArrayList<String>> dict = new HashMap<Integer,ArrayList<String>>(){{
			put(2,stringList);
			put(3, stringList1);
		}};

		Set keySet = dict.entrySet();
		Iterator itr = keySet.iterator();

		while(itr.hasNext()){
			Map.Entry<Integer, ArrayList<String>> mapEntry = (Map.Entry) itr.next();
			System.out.println("key is: "+ mapEntry.getKey()+" & values are: ");
			System.out.println(mapEntry.getValue());
		}

		System.out.println(dict.containsValue(stringList));
	}

}
