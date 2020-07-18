import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal implements Testable {
    public void run () {
        Solution2 runner = new Solution2();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        runner.preorderTraversal(root);
    }

    // solution #1
    // traversive
    // TC: O(N), SC: O(N)
    class Solution {
        public List<Integer> preorderTraversal (TreeNode root) {
            List<Integer> result = new ArrayList<>();
            traversal(root, result);
            return result;
        }

        private void traversal (TreeNode root, List<Integer> result) {
            if (root == null) return;
            result.add(root.val);
            if (root.left != null) traversal(root.left, result);
            if (root.right != null) traversal(root.right, result);
        }
    }

    // solution #2
    // iterative
    // TC: O(N), SC: O(N)
    class Solution2 {
        public List<Integer> preorderTraversal (TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
            return result;
        }
    }
    
    // ToDo: Morris 
}