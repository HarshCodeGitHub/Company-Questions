package com.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Divisible_Subset {
	static List<Integer> ans;
	static int[] arr;

	public static List<Integer> largestDivisibleSubset(int[] nums) {
		ans = new ArrayList<>();
		Arrays.sort(nums);

		arr = new int[nums.length];
		Arrays.fill(arr, -1);

		getAnswer(nums, 0, new ArrayList<>(), 1);
		return ans;
	}

	public static void getAnswer(int[] nums, int index, List<Integer> list, int prev) {
		if (list.size() > ans.size())
			ans = new ArrayList<>(list);

		for (int i = index; i < nums.length; i++) {
			if (list.size() > arr[i] && nums[i] % prev == 0) {
				arr[i] = list.size();
				list.add(nums[i]);
				getAnswer(nums, i + 1, list, nums[i]);
				list.remove(list.size() - 1);
			}
		}
	}
}
