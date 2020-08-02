public class CoinChange implements Test {
    public void run() {}

    // solution #1
    // dfs
    class Solution {
        int res = Integer.MAX_VALUE;
        public int coinChange(int [] coins, int amount) {
            if (coins.length == 0) {
                return -1;
            }
            dfs(coins, amount, 0);
            if (res == Integer.MAX_VALUE){
                return -1;
            }
            return res;
        }

        private void dfs(int[] coins, int amount, int count) {
            if (amount < 0) 
                return;
            if (amount == 0)
                res = Math.min(res, count);
            for (int i = 0; i < coins.length; i++) {
                dfs(coins, amount - coins[i], count + 1);
            }
        }
    }
}