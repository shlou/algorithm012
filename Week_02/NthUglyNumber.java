public class NthUglyNumber implements Testable {
    public void run () {
        Solution runner = new Solution();
        System.out.println(runner.nthUglyNumber(10));
    }

    // solution #1
    // brute force
    // TC: O(NlogN)?, SC: O(N)
    class Solution {
        public int nthUglyNumber (int n) {
            int i = 1, j = 0;
            while (true) {
                if (isUgly_version_C(i))
                    j++;
                if (j == n)
                    break;
                i++;
            }
            return i;
        }

        private boolean isUgly_version_A(int num) {
            if (num <= 0) return false;
            int[] divisors = {2, 3, 5};
            for(int d : divisors) {
                while (num % d == 0) {
                    num /= d;
                }
            }
            return num == 1;
        }

        private boolean isUgly_version_B(int num) {
            for (int i = 2; i < 6 && num > 0; i++) {
                while (num % i == 0) {
                    num /= i;
                }
            }
            return num == 1;
        }

        private boolean isUgly_version_C(int num) {
            if (num <= 0) return false;
            if (num == 1) return true;
            if (num % 2 == 0) return isUgly_version_C(num / 2);
            if (num % 3 == 0) return isUgly_version_C(num / 3);
            if (num % 5 == 0) return isUgly_version_C(num / 5);
            return false;
        } 
    }

    // solution #2
    // ToDo: dynamic programming
    class Solution2 {

    }
}