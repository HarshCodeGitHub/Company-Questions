package com.microsoft;

import java.util.HashMap;
import java.util.Map;

public class Bulls_and_Cows {
	public String getHint(String secret, String guess) {
		Map<Character, Integer> secretMap = new HashMap<>();
		Map<Character, Integer> guessMap = new HashMap<>();

		int bulls = 0, cows = 0;

		for (int i = 0; i < secret.length(); i++) {
			char sec = secret.charAt(i);
			char gs = guess.charAt(i);

			if (sec == gs)
				bulls++;
			else {
				secretMap.put(sec, secretMap.getOrDefault(sec, 0) + 1);
				guessMap.put(gs, guessMap.getOrDefault(gs, 0) + 1);
			}
		}

		for (char c : secretMap.keySet())
			if (guessMap.containsKey(c))
				cows += Math.min(secretMap.get(c), guessMap.get(c));

		return (bulls + "A" + cows + "B");
	}
}
