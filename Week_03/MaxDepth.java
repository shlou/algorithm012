import java.util.LinkedList;
import java.util.Queue;
import javax.util;

public class MaxDepth implements Debugger {
    public void run () {}

    // solution #1
    // recursion
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            else {
                int left_height = maxDepth(root.left);
                int right_height = maxDepth(root.right);
                return java.lang.Math.max(left_height, right_height) + 1;
            }
        }
    }

    // solution #2
    // iteration
    class Solution2 {
        public int maxDepth(TreeNode root) {
            Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
            if (root != null) 
                stack.add(new Pair(root, 1));
            int depth = 0;
            while (!stack.isEmpty()) {
                Pair<TreeNode, Integer> cur = stack.poll();
                root = cur.getKey();
                int cur_depth = cur.getValue();
                if (root != null) {
                    depth = Math.max(depth, cur_depth);
                    stack.add(new Pair(root.left, cur_depth + 1));
                    stack.add(new Pair(root.right, cur_depth + 1));
                }
            }
            return depth;
        }
    }
}