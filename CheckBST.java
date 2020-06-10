import java.util.*;

public class CheckBST {


	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
	}

	LinkedList<TreeNode> stack = new LinkedList();
	LinkedList<Integer> uppers = new LinkedList(),
						lowers = new LinkedList();

	public void update(TreeNode root, Integer lower, Integer upper) {
		stack.add(root);
		lowers.add(lower);
		uppers.add(upper);
	}

	public boolean isValidBST(TreeNode root) {
		Integer lower = null, upper = null, val;
		update(root, lower, upper);

		while (!stack.isEmpty()) {
			root = stack.poll();
			lower = lowers.poll();
			upper = uppers.poll();

			if (root == null) continue;
			val = root.val;
			if (lower != null && val <= lower) return false;
			if (upper != null && val >= upper) return false;
			update(root.right, val, upper);
			update(root.left, lower, val);
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode tmain = new TreeNode(5);
		TreeNode tleft1 = new TreeNode(4);
		TreeNode tright = new TreeNode(10);
		tmain.left = tleft1;
		tmain.right = tright;
		CheckBST test = new CheckBST();
		System.out.println(test.isValidBST(tmain));
	}

}
