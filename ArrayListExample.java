import java.util.*;

public class ArrayListExample {
	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
		stack.push("abc");
		stack.push("cde");
		stack.push("zfgh");
		stack.push("ijk");
		Iterator itr = stack.iterator();

		while(itr.hasNext()){
			System.out.println(itr.next() + stack.pop());
		}


	}
}
