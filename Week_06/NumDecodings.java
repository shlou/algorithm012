public class NumDecodings implements Debug {

    public void debug() {
        Solution sol = new Solution();
        int num = sol.numDecodings("226");
        System.out.println(num);
    }

    class Solution {
        public int numDecodings(String s) {
            int len = s.length();
            if (len == 0) {
                return 0;
            }
            int[] dp = new int[len];
            char[] charArray = s.toCharArray();
            if (charArray[0] == '0') {
                return 0;
            }

            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                if (charArray[i] != '0') {
                    dp[i] = dp[i - 1];
                }
                int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
                if (num >= 10 && num <= 26) {
                    if (i == 1) {
                        dp[i]++;
                    } else {
                        dp[i] += dp[i - 2];
                    }
                }
            }
            return dp[len -1];
        }
    }
}