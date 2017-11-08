package com.coding.samples;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

/**
 * This class contains solutions to some of Euler project problems.
 * @author Puneet
 *
 */
public class EulerSolutions {

	public static void main(String[] args) {
		findSum(1000);
		findLargestPalindrome(100, 1000);
		findSmallestMultiple();
		findSumSqDiff(100);
		findLargestCollatzSeq(1000000);
		findAmicableNumbers(10000);
		findDistinctPowers(2,100);
		findSelfPowers(1000);
		findPowerfulDigitSum(100);
	}
	
	/**
	 * Euler Problem: 1
	 * Multiples of 3 and 5
	 * @param number
	 */
	private static void findSum(int number) {
		int sum = 0;

		for (int i = 1; i < number; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		System.out.println("sum ==" + sum);
	}

	/**
	 * Euler Problem: 4
	 * Largest palindrome product
	 * @param num1
	 * @param num2
	 */
	private static void findLargestPalindrome(int num1, int num2) {

		int largestPalindrome = 0;
		for (int i = num1; i < num2; i++) {
			int tmp1 = i;

			for (int j = num1; j < num2; j++) {
				int tmp2 = j;

				int prod = tmp1 * tmp2;
				String reverse = StringUtils.reverse(Integer.valueOf(prod)
						.toString());
				if (reverse.equalsIgnoreCase(Integer.valueOf(prod).toString())) {

					if (prod > largestPalindrome) {
						largestPalindrome = prod;
					}
				}

			}

		}
		System.out.println("largestPalindrome ==" + largestPalindrome);
	}
	
	/**
	 * Euler Problem: 5
	 * Smallest multiple
	 */
	private static void findSmallestMultiple() {
		int num = 2520;
		int newNum = 1;
		// start with 11
		while (num % 11 != 0 || num % 12 != 0 || num % 13 != 0 || num % 14 != 0
				|| num % 15 != 0 || num % 16 != 0 || num % 17 != 0
				|| num % 18 != 0 || num % 19 != 0 || num % 20 != 0) {
			num += 1;
			newNum = num;
		}
		System.out.println(newNum);
	}

	/**
	 * Euler Problem: 6
	 * Sum square difference
	 * @param num
	 */
	private static void findSumSqDiff(int num) {
		// sum of square numbers
		int numSq = 0;
		for (int i = 1; i <= num; i++) {
			numSq += i * i;
		}
		System.out.println("numSq = " + numSq);

		int sumNumSq = 0;
		for (int i = 1; i <= num; i++) {
			sumNumSq += i;
		}
		sumNumSq = sumNumSq * sumNumSq;

		System.out.println("sumNumSq = " + sumNumSq);
		System.out.println(sumNumSq - numSq);
	}
	
	/**
	 * Euler Problem: 14
	 * Longest Collatz sequence
	 * @param num
	 */
	private static void findLargestCollatzSeq(long num) {
		List<Long> finalChain = new ArrayList<Long>();
		for (long i = 2; i <= num; i++) {
			List<Long> temp = new ArrayList<Long>();
			temp.add(i);
			List<Long> chain = getCollatzSeq(i, temp);
			if (chain.size() > finalChain.size()) {
				finalChain.clear();
				finalChain.addAll(chain);
				chain = null;
			}
		}
		System.out.println("finalChain = " + finalChain);
		System.out.println("Starting Number = " + finalChain.get(0));
	}
	
	/**
	 * Euler Problem: 21
	 * Amicable numbers
	 * @param num
	 */
	private static void findAmicableNumbers(long num) {
		long total = 0;
		Set<Long> set = new HashSet<Long>();
		for (int i = 0; i < num; i++) {
			getSumOfAmicableNumbers(i, set);
		}

		for (Long i : set) {
			total += i;
		}

		System.out.println("total = " + total);
	}
	
	private static void getSumOfAmicableNumbers(long num, Set<Long> set) {
		long suma = 0;
		long sumb = 0;

		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				suma += i;
			}
		}

		if (suma != num) {
			for (int j = 1; j < suma; j++) {
				if (suma % j == 0) {
					sumb += j;
				}
			}
		}
		if (num == sumb) {
			set.add(num);
			set.add(suma);
		}
	}
	
	/**
	 * Euler Problem: 29
	 * Distinct powers
	 * @param a
	 * @param b
	 */
	private static void findDistinctPowers(int a, int b) {
		Set<Double> set = new HashSet<Double>();

		for (int i = a; i <= b; i++) {

			for (int j = a; j <= b; j++) {

				double d = Math.pow(i, j);

				set.add(d);
			}
		}
		
		System.out.println("set size = " + set.size());
	}
	
	/**
	 * Euler Problem: 48
	 * Self powers
	 * @param num
	 */
	private static void findSelfPowers(int num) {
		BigInteger sum = new BigInteger("0");
		for (int i = 1; i <= num; i++) {

			BigInteger bNum = new BigInteger(i + "");
			sum = sum.add(bNum.pow(i));
		}
		
		String numString = String.valueOf(sum);
		String reverseString = StringUtils.reverse(numString);
		reverseString = reverseString.substring(0, 10);
		System.out.println("last10 = " + StringUtils.reverse(reverseString));
	}
	
	/**
	 * Euler Problem: 56
	 * Powerful digit sum
	 * @param num
	 */
	private static void findPowerfulDigitSum(int num) {
		long digitSum = 0;
		for (int i = 1; i < num; i++) {
			BigInteger bNum = new BigInteger(i + "");

			for (int j = 1; j < num; j++) {
				int numSum = getSumOfDigits(bNum.pow(j));
				if (numSum > digitSum) {
					digitSum = numSum;
				}
			}
		}

		System.out.println("digitSum = " + digitSum);

	}

	private static int getSumOfDigits(BigInteger b) {
		int sum = 0;
		String numStr = b.toString();
		char[] charArray = numStr.toCharArray();

		for (char c : charArray) {
			sum += Integer.valueOf(String.valueOf(c));
		}

		return sum;
	}


	private static List<Long> getCollatzSeq(long num, List<Long> chain) {

		long evenNum = 0;
		long oddNum = 0;
		if (num == 1) {
			return chain;
		} else {
			if (num % 2 == 0) {
				evenNum = num / 2;
				chain.add(evenNum);
				getCollatzSeq(evenNum, chain);
			} else {
				oddNum = (3 * num + 1);
				chain.add(oddNum);
				getCollatzSeq(oddNum, chain);
			}
		}
		return chain;
	}
	
}
