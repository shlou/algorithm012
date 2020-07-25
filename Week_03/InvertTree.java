import java.util.LinkedList;
import java.util.Queue;

public class InvertTree implements Debugger {
    public void run() {

    }

    // solution #1
    // recursion
    // TC: O(N), SC: O(N)
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode right = invertTree(root.left);
            TreeNode left = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }

    // solution #2
    // iteration, BFS
    // TC: O(N), SC: O(N)
    class Solution2 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) 
                return null;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode cur =  queue.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            return root;
        }
    }
}