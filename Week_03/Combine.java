import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Combine implements Debugger {

    public void run(){}

    // solution #1
    // back track
    class Solution {
        List<List<Integer>> output = new LinkedList<>();
        int n;
        int k;

        private void backTrack(int first, LinkedList<Integer> curr) {
            if (curr.size() == k) {
                output.add(new LinkedList<>(curr));
            }
            for (int i = first; i < n + 1; ++i) {
                curr.add(i);
                backTrack(i + 1, curr);
                curr.removeLast();
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;

            backTrack(1, new LinkedList<Integer>());
            return output;
        }
    }

    class Solution2 {
        public List<List<Integer>> combine(int n, int k) {
            LinkedList<Integer> nums = new LinkedList<Integer>();
            for (int i = 1; i < k + 1; ++i) {
                nums.add(i);
            }
            nums.add(n + 1);

            List<List<Integer>> output = new ArrayList<List<Integer>>();
            int j = 0;
            while (j < k) {
                output.add(new LinkedList(nums.subList(0, k)));
                j = 0;
                while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1)) {
                    nums.set(j, j++ + 1);
                }
                nums.set(j, nums.get(j) + 1);
            }
            return output;
        }
    }
}

