// bar chart, with width, calculate the water that can be trapped after rainining.
// https://leetcode-cn.com/problems/trapping-rain-water/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
public class Trap extends BaseRunner {

    // #region leet code
    // 1. fast and slow pointer.
    //  - time complexity: O(n)
    //  - space complexity: O(1)
    class Solution {
        public int trap (int[] height) {
            int sum = 0;
            for (int slow = 0, fast = 1; fast < height.length; fast++) {
                if (height[slow] > height[fast]) {
                    sum += height[slow] - height[fast];
                } else {
                    slow++;
                }
            }
            return sum;
        }
    }

    // ToDo: 2. stack

    // ToDo: 3. dynamic programming?

    // #endregion
    
    // #region local testing

    public String getName () { 
        return "Trap"; 
    }

    public void run () {
        Solution leetCode = new Solution();
        int result = leetCode.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        System.out.println(result);
    }

    // #endregion
}