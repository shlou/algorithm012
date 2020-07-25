import java.util.LinkedList;

import sun.net.www.content.text.plain;

public class MinDepth implements Debugger {
    public void run() {}

    // solution #1
    // recursion
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) 
                return 0;
            if ((root.left == null) && (root.right == null)) 
                return 1;
            int min_depth = Integer.MAX_VALUE;
            if (root.left != null) 
                min_depth = Math.min(minDepth(root.left), min_depth);
            if (root.right != null) 
                min_depth = Math.min(minDepth(root.right), min_depth);
            return min_depth + 1;
        }
    }

    // solution #2
    // DFS iteration
    class Solution2 {
        public int minDepth(TreeNode root) {
            LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
            if (root == null) 
                return 0;
            else 
                stack.add(new Pair(root, 1));

            int min_depth = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                Pair<TreeNode, Integer> cur = stack.pollLast();
                root = cur.getKey();
                int cur_depth = cur.getValue();
                if ((root.left == null) && (root.right == null))
                    min_depth = Math.min(min_depth, cur_depth);
                if (root.left != null)
                    stack.add(new Pair(root.left, cur_depth + 1));
                if (root.right != null)
                    stack.add(new Pair(root.right, cur_depth + 1));
            }
            return min_depth;
        }
    }

    // solution #3
    // BFS iteration
    class Solution3 {
        public int minDepth(TreeNode root) {
            LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
            if (root == null) 
                return 0;
            else
                stack.add(new Pair(root, 1));

            int cur_depth = 0;
            while (!stack.isEmpty()) 
            {
                Pair<TreeNode, Integer> cur = stack.poll();
                root = cur.getKey();
                cur_depth = cur.getValue();
                if ((root.left == null) && (root.right == null))
                    break;
                if (root.left != null)
                    stack.add(new Pair(root.left, cur_depth + 1));
                if (root.right != null)
                    stack.add(new Pair(root.right, cur_depth + 1));
            }
            return cur_depth;
        }
    }
}