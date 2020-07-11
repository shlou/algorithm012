// rotate an array k times, imagine the array is a circle.
public class Rotate extends BaseRunner {

    // leet code
    // 1. straight-forward. time complexity O(n*k), space complexity O(1)
    class Solution1 implements Tester {
        public void rotate (int[] nums, int k) {
            int temp, prev;
            while (k > 0) {
                prev = nums[nums.length - 1];
                for (int i = 0; i < nums.length; i++) {
                    temp = nums[i];
                    nums[i] = prev;
                    prev = temp;
                }
                k--;
            }
        }
    }

    // 2. introduce staging array, time complexity O(n), space complexity O(n)
    class Solution2MyFirstTry implements Tester {
        public void rotate (int[] nums, int k) {
            k = k % nums.length;
            int[] temp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i > k) {
                    temp[i - k - 1] = nums[i];
                } else {
                    temp[k + i] = nums[i];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }
    }

    // cleverer way, reminder.
    class Solution2Official implements Tester {
        public void rotate (int[] nums, int k) {
            int[] temp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                temp[(k + i) % nums.length] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }
    }

    // #region SMART THOUGHTS AND HANDLING
    // 3. replace 1 by 1. time complexity O(n), space complexity O(1)
    class Solution3 implements Tester {
        public void rotate (int[] nums, int k) {
            k = k % nums.length;
            int count = 0;
            for (int start = 0; count < nums.length; start++) {
                int current = start;
                int prev = nums[current];
                do {
                    int next = (current + k) % nums.length;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    current = next;
                    count++;
                } while (start != current);
            }
        }
    }

    // 4. reverse k times, time complexity O(n), space complexity O(1)
    class Solution4 implements Tester {
        public void rotate (int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse (int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

    // #endregion

    public String getName () { 
        return "Rotate"; 
    }

    public void run () {
        Tester leetCode = new Solution4();
        leetCode.rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
    }

    interface Tester {
        void rotate (int[] nums, int k);
    }
}