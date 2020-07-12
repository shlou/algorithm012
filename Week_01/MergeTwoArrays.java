import java.util.Arrays;

/* merge 1 ordered array into another, and result is still kept in order.
    1. nums1 length is m, nums2 length is n.
    2. assume nums1 have enough capacity to be merged by nums2.
*/
public class MergeTwoArrays extends BaseRunner {
    
    // leet code
    // 1. merge then order, but not fully use given informations that arrays are ordered.
    // time complexity O((n + m)log(n + m)), space complexity O(1)
    class Solution1 {
        public void merge (int[] nums1, int m, int[] nums2, int n) {
            System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1);
        }
    }

    // #region GOOD IDEAS!!!
    // 2. 2 pointers and a temporary array. time complexity O(n + m), space complexity O(m)
    class Solution2 {
        public void merge (int[] nums1, int m, int[] nums2, int n) {
            int[] nums1_copy = new int[m];
            System.arraycopy(nums1, 0, nums1_copy, 0, m);
            int p = 0, p1 = 0, p2 = 0;
            while ((p1 < m) && (p2 < n)) {
                nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
            }
            if (p1 < m) System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 -p2);
            if (p2 < n) System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    // 3. same to 2, but only considering when modifying nums1(longer one) need additional space, 
    // can be avoid by visit array in descending order. time complexity O(n + m), space complexity O(1)
    class Solution3 {
        public void merge (int[] nums1, int m, int[] nums2, int n) {
            int p = m + n - 1, p1 = m - 1, p2 = n - 1;
            while ((p1 >= 0) && (p2 >= 0)) {
                nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
            }
            if (p2 != 0) System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }

    // #endregion

    public String getName () { 
        return "MergeTwoArrays"; 
    }

    public void run () {
        Solution3 leetCode = new Solution3();
        leetCode.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}