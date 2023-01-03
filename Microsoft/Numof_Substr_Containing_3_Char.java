package com.microsoft;

public class Numof_Substr_Containing_3_Char {
	
	public int numberOfSubstrings(String s) {
		int[] arr = new int[3];
		int ans = 0;
		int left = 0;

		for (int right = 0; right < s.length(); right++) {
			arr[s.charAt(right) - 'a']++;

			while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0)
				arr[s.charAt(left++) - 'a']--;

			ans += left;
		}

		return ans;
	}
}
