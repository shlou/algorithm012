import java.util.Map;
import java.util.HashMap;

// get find out the 2 numbers' index that sum is equal to target.
public class TwoSum extends BaseRunner {

    // leet code
    // 1. straight forward. time complexity O(n^2), space complexity O(1)
    class Solution1 {
        public int[] twoSum (int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == target - nums[j]) {
                        return new int[]{i, j};
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution.");
        }
    }

    // 2. 2 times hash table. time complexity O(n), space complexity O(n), acquire from hash table time cost is O(1)
    class Solution2 {
        public int[] twoSum (int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] {i, map.get(complement)};
                }
            }
            throw new IllegalArgumentException("No two sum solution.");
        }
    }

    // 3. 1 time hash table. simpler code. time complexity O(n), space complexity O(n)
    class Solution3 {
        public int[] twoSum (int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] {map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution.");
        }
    }


    public String getName () { 
        return "TwoSum"; 
    }

    public void run () {
        Solution1 leetCode = new Solution1();
        leetCode.twoSum(new int[]{2, 7, 11, 15}, 9);
    }
}