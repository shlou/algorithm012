import java.util.HashMap;
import java.util.Map;

public class TwoSum implements Testable {
    public void run () {
        Solution3 runner = new Solution3();
        int[] positions = runner.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(positions);
    }

    // solution #1
    // brute force:
    // TC: O(N^2), SC: O(1)
    class Solution {
        public int[] twoSum (int nums[], int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] {i, j};
                    }
                }
            }
            return new int[2];
        }
    }

    // solution #2
    // 2 pass hash table.
    // TC: O(N), SC: O(N)
    class Solution2 {
        public int[] twoSum (int nums[], int target) {
            Map<Integer,Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                hashMap.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (hashMap.containsKey(target - nums[i]))
                    return new int[]{i, hashMap.get(target - nums[i])};
            }
            return new int[2];
        }
    }

    // solution #3
    // 1 pass hash table.
    class Solution3 {
        public int[] twoSum (int[] nums, int target) {
            Map<Integer,Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashMap.containsKey(target - nums[i]))
                    return new int[]{hashMap.get(target - nums[i]), i};
                hashMap.put(nums[i], i);
            }
            return new int[2];
        }
    }
}