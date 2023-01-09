package com.microsoft;

import java.util.Arrays;

public class Longest_Happy_Prefix {
	public String longestPrefix(String str) {
		int i = 1, j = 0;
		int max = -1;
		int[] prefix = new int[str.length()];

		Arrays.fill(prefix, -1);

		while (i < str.length()) {
			if (str.charAt(i) == str.charAt(j)) {
				prefix[i] = j;
				i++;
				j++;
			} else if (j > 0)
				j = prefix[j - 1] + 1;
			else
				i++;

		}

		max = prefix[str.length() - 1];

		return str.substring(0, max + 1);
	}
}
