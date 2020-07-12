// move zeros to the end of an array, other non-zeros keep in the original order.
// 1. operations should be made in given array.
// 2. try to reduce operations count. 
public class MoveZeros extends BaseRunner {

    // leet code
    // 1. 1 time traverse.
    //  - time complexity: O(n)
    //  - space complexity: O(1)
    class Solution1 implements Tester {
        public void moveZeroes(int[] nums) {
            int numZeros = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0){
                    System.arraycopy(nums, i + 1, nums, i, nums.length - i - 1);
                    numZeros++;
                } 
            }
            for (int i = 0; i < numZeros; i++) {
                nums[nums.length - i - 1] = 0;
            }
        }
    }

    // optimization of solution 1
    //  - time complexity: O(n)
    //  - space complexity: O(1)
    class Solution2 implements Tester {
        public void moveZeroes(int[] nums) {
            int lastNonZeroAt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[lastNonZeroAt++] = nums[i];
                }
            }
            for (int i = lastNonZeroAt; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    // optimization of solution 2
    //  - time complexity: O(n)
    //  - space complexity: O(1)
    class Solution3 implements Tester {
        public void moveZeroes (int[] nums) {
            for (int lastNonZeroAt = 0, cur = 0; cur < nums.length; cur++) {
                if (nums[cur] != 0) {
                    swap(nums, lastNonZeroAt++, cur);
                }
            }
        }
        private void swap (int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

    //#region local debugging

    public String getName () { 
        return "MoveZeros"; 
    }

    public void run () {
        Tester leetCode = new Solution3();
        leetCode.moveZeroes(new int[] { 0, 1, 0, 3, 12 });
    }

    interface Tester {
        void moveZeroes(int[] nums);
    }

    //#endregion
}