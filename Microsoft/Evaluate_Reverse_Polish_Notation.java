package com.microsoft;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
	
	static Stack<Integer> st = new Stack<>();
	
	public static void main(String[] args) {
		String [] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(evaluate(tokens));
	}

	private static int evaluate(String[] tokens) {
		// TC:O(n) & SC:O(n)
		
		for(String str:tokens) {
			if(str.equals("+"))
				st.push(st.pop() + st.pop());
			else if(str.equals("-"))
				st.push(st.pop() - st.pop());
			else if(str.equals("*"))
				st.push(st.pop() * st.pop());
			else if(str.equals("/"))
				st.push((int)(1D/st.pop() * st.pop()));
			else
				st.push(Integer.valueOf(str));
		}
		return st.pop();
	}
	

}
