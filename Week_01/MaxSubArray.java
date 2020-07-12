// given array, find a sub-array with more than 1 element, and largest sum value.
public class MaxSubArray extends BaseRunner {
    
    // leet code
    // 1. simple way. 
    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
            return maxSum;
        }
    }

    // ToDo: dynamic programming

    // ToDo: divide and conquer

    // #region local testing

    public String getName () { 
        return "MaxSubArray"; 
    }

    public void run () {
        Solution leetCode = new Solution();
        int result = leetCode.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        System.out.println(result);
    }

    // #endregion

}