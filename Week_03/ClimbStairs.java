public class ClimbStairs implements Debugger {
    public void run () {
        Solution3 solution = new Solution3();
        System.out.println(solution.climbStairs(10));
    }

    // solution #1
    // recursion Fibonacci
    // TC: O(N^2), SC: O(1)
    class Solution {
        public int climbStairs (int n) {
            return fib(n);
        }

        int fib (int n) {
            if (n <= 1) 
                return 1;
            if (n < 3)
                return n;
            return fib(n - 1) + fib(n - 2);
        }
    }

    // solution #2:
    // tail recursion
    // TC: O(N^2)
    class Solution2 {
        public int climbStairs (int n) {
            return fib(n, 1, 1);
        }

        int fib (int n, int a, int b) {
            if (n < 2) 
                return b;
            return fib(n - 1, b, a + b);
        }
    }

    // solution #3:
    // dynamic programming:
    // TC: O(N), SC: O(1)
    class Solution3 {
        public int climbStairs (int n) {
            int x, y = 0, z = 1;
            for (int i = 1; i <= n; ++i) {
                x = y;
                y = z;
                z = x + y;
            }
            return z;
        }
    }
}