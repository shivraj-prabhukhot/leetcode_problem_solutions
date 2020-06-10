import java.util.List;
import java.util.*;
import java.util.ArrayList;
import java.lang.*;

public class LogFile_Sort_By_AlphaNumeric {

		static boolean isAplha = false;
		public static List<String> reorderLines(int logFileSize, List<String> logLines)
		{
			PriorityQueue<List<String>> pq = new PriorityQueue<>((a,b) -> {
				if(a.get(1).equals(b.get(1)))
					return a.get(0).compareTo(b.get(0));
				return a.get(1).compareTo(b.get(1));
			});

			List<List<String>> pqNormal = new ArrayList<>();

			for(int i = 0 ; i < logFileSize ; i++){
				List<String> split = helperFunction(logLines.get(i));
				if(isAplha)
					pq.add(new ArrayList<>(split));
				else
					pqNormal.add(new ArrayList<>(split));
			}

			List<String> output = new ArrayList<>();

			while(!pq.isEmpty()){
				List<String> ans = pq.poll();
				output.add(ans.get(0) + " " + ans.get(1));
			}

			for(int i = 0 ; i < pqNormal.size() ; i++){
				output.add(pqNormal.get(i).get(0) + " " + pqNormal.get(i).get(1));
			}

			return output;
		}
		public static List<String> helperFunction(String orderNumber){
			List<String> lst = new ArrayList<>();
			int index = orderNumber.indexOf(' ');
			lst.add(orderNumber.substring(0, index));
			lst.add(orderNumber.substring(index + 1));

			isAplha = false;
			while(index + 1 < orderNumber.length()){
				index++;
				if(orderNumber.charAt(index) == ' ') continue;
				if(!Character.isDigit(orderNumber.charAt(index))){
					isAplha = true;
					break;
				}
			}

			return lst;
		}
		public static void main(String[] args) {
			List<String> logList = new ArrayList<>(Arrays.asList("a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a1 act car"));
			System.out.println("Ans : " + reorderLines(logList.size(),logList));
		}
}
