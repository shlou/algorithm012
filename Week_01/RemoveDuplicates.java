// remove the duplicate item in an ordered array, and return the array size.
public class RemoveDuplicates extends BaseRunner {

    // leet code
    // fast and slow pointer: time complexity O(n), space complexity O(n)
    class Solution {
        public int removeDuplicates (int[] nums) {
            if (nums.length == 0) return 0;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i++;
        }
    }

    public String getName () { 
        return "RemoveDuplicates"; 
    }

    public void run () {
        Solution leetCode = new Solution();
        leetCode.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 });
    }
}
