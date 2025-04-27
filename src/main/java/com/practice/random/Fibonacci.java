package com.practice.random;

public class Fibonacci {
    
    public static void main(String[] args) {

        // 0 1 1 2 3 5 8 13 21
        int n = 30;
        int first = 0;
        int second = 1;
        int sum = 0;
        int[] memo = new int[999];
        
        System.out.println(fibUsingRecursion(first, second, n, sum));
        System.out.println(fibUsingMemoization(n, memo));    
    }
    
    public static int fibUsingRecursion(int first, int second, int n, int sum) {
        if(n == 1) {
            return sum;
        }
        sum = first + second;
        return fibUsingRecursion(second, sum, n - 1, sum);
    }
    
    public static int fibUsingMemoization(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n <= 2) {
            return 1;
        }
        int res = fibUsingMemoization(n-1, memo) + fibUsingMemoization(n-2, memo);
        memo[n] = res;
        return res;
    }
 
}
