package com.microsoft;

public class Airplane_Seat_Assignment_Probability {
	public double nthPersonGetsNthSeat(int n) {
		return getProbability(n);
	}

	public double getProbability(int n) {
		if (n == 1)
			return 1d;
		return 1d / n + (n - 2d) / n * getProbability(n - 1);
	}
	/*
	 * Best Explanation i got for this question:
	 * 
	 * For any case, we can get rid of those sitting on own seats (except the first
	 * passenger) and get a problem of n' (= n - k, where k is the number of
	 * passengers sitting on own seats), then re-number (without changing the
	 * relative order) them as passenger 1, 2, ..., n', hence the result is in same
	 * form, the only difference is to change n to n'.
	 * 
	 * Except n' = 1, results for n' of other values are independent on n'. In
	 * short, changing from n to n' will not influence the result.
	 * 
	 * For the 1st passenger, there are 2 cases that the nth passenger could take
	 * the right seat: 1st passenger
	 * 
	 * Take his own seat, the probability is 1 / n; Take a seat neither his own nor
	 * the one of the nth passenger, and the corresponding probability is (n - 2) /
	 * n; In addition, other passengers (except the nth one) should not occupy the
	 * nth seat; Now there are n - 1 passengers and n - 1 seats remaining, and the
	 * 2nd passenger, like the 1st one, have 2 options to make it possible the nth
	 * passenger take the right seat: a) take the 1st passenger's seat, the
	 * probability is 1 / (n - 1); b) Take a seat that is neither the 1st
	 * passenger's nor the nth passenger's, and the corresponding probability is 
	 * ((n- 1) - 2) /( n - 1);
	 * Obviouly, we recurse to subproblem of (n - 1)
	 * 
	 * 
	 * 
	 * therefore we can reduced this problem to ground level that :
	 * 
	 * if (n == 1)
	 * 	return 1;
	 * else
	 * 	return 0.5;
	 * 
	 * i.e for every another num we get 0.5 probability of seating
	 */
}
