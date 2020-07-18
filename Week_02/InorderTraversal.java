import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal implements Testable {
    public void run () {
        Solution2 runner = new Solution2();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        runner.inorderTraversal(root);
    }

    // solution #1
    // recursive:
    // TC: O(N), SC: O(logN), worst case O(N)
    class Solution {
        public List<Integer> inorderTraversal (TreeNode root) {
            List<Integer> result = new ArrayList<>();
            traversal(root, result);
            return result;
        }

        private void traversal (TreeNode root, List<Integer> result) {
            if (root == null) return;
            if (root.left != null) traversal(root.left, result);
            result.add(root.val);
            if (root.right != null) traversal(root.right, result);
        }
    }

    // solution #2
    // iterative:
    // TC: O(N), SC: O(N)
    class Solution2 {
        public List<Integer> inorderTraversal (TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
            return result;
        }
    }
}