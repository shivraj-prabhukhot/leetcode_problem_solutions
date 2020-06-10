import javafx.util.Pair;

import java.util.*;
public class ThreeSum {
	public static void main(String[] args) {
		int[] nums = {10,-20,3,-2,-1,34,50,20,0,-10};
		List<List<Integer>> res = new ArrayList<>();
		Set<Pair> found = new HashSet<>();
		for (int i = 0; i < nums.length; ++i) {
			Set<Integer> seen = new HashSet<>();
			for (int j = i + 1; j < nums.length; ++j) {
				int complement = -nums[i] - nums[j];
				if (seen.contains(complement)) {
					int v1 = Math.min(nums[i], Math.min(complement, nums[j]));
					int v2 = Math.max(nums[i], Math.max(complement, nums[j]));
					if (found.add(new Pair(v1, v2)))
						res.add(Arrays.asList(nums[i], complement, nums[j]));
				}
				seen.add(nums[j]);
			}
		}
		System.out.println(found);
	}
}
