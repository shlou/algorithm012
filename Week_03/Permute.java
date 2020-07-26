import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permute implements Debugger {
    public void run(){}

    // solution #1
    // back track
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();
            ArrayList<Integer> output = new ArrayList<>();
            for (int num : nums) 
                output.add(num);
            int n = nums.length;
            backTrack(n, output, res, 0);
            return res;
        }

        private void backTrack(int n, 
                               ArrayList<Integer> output, 
                               List<List<Integer>> res, 
                               int first) {
            if (first == n)
                res.add(new ArrayList<Integer>(output));
            for (int i = first; i < n; i++) {
                Collections.swap(output, first, i);
                backTrack(n, output, res, first + 1);
                Collections.swap(output, first, i);
            }
        }
    }
}