import java.util.*;
public class DeepCopy_linkedList {
	public static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public static List<List<Integer>> output = new ArrayList<>();
	public static List<Integer> node = new ArrayList<Integer>();

	public static void main(String[] args) {

		Node head = new Node(20);

		for(int i = 0; i <5; i++){
			node.add(i);
			node.add(i+2);
			output.add(node);
		}

		System.out.println(output);
	}
}
