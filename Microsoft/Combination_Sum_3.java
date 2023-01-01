package com.microsoft;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_3 {
	public List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> ans = new ArrayList();

		calculate(ans, 1, new ArrayList(), k, n);

		return ans;
	}

	void calculate(List<List<Integer>> ans, int index, List<Integer> current, int k, int target) {

		if (current.size() == k) {
			if (target == 0) {
				ans.add(new ArrayList(current));
			}
			return;
		}

		for (int i = index; i <= 9; i++) {
			current.add(i);
			calculate(ans, i + 1, current, k, target - i);
			current.remove(current.size() - 1);
		}
	}
}
