package me.algos.hackerrank.hired;

class Solution {

	public static String solution(String[] suits, String[] ranks, long k) {
		long sizeOfRanks = (ranks.length) ;
		return (ranks[(int) (k % sizeOfRanks)] + "-of-" + suits[(int) (k / sizeOfRanks)]);
	}

	public static void main(String[] args) {

		String[] suits = { "foo", "bar", "baz" };
		String[] ranks = { "10", "11", "12", "13", "14", "15", "16", "17" };
		long k = 9;
		System.out.println(solution(suits, ranks, k));
	}
}
