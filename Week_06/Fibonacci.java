public class Fibonacci {
    class Solution {
        public int fib(int n) {
            if (n <= 2)
                return n;
            int[] mem = new int[n];
            mem[0] = 0; 
            mem[1] = 1;
            for (int i = 2; i <= n; i++) {
                mem[i] = fib(i - 1) + fib(i - 2);
            }
            return mem[n];
        }
    }
}