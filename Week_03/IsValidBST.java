import java.util.Stack;

public class IsValidBST implements Debugger{
    public void run() {

    }

    // solution #1
    // recursion
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        public boolean helper(TreeNode node, Integer lower, Integer upper) {
            if (node == null)
                return true;
            int val = node.val;
            if (lower != null && val <= lower)
                return false;
            if (upper != null && val >= upper)
                return false;
            if (!helper(node.right, val, upper))
                return false;
            if (!helper(node.left, lower, val))
                return false;
            return true;
        }
    }


    // solution #2
    // DLR
    class Solution2 {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            double inorder = - Double.MAX_VALUE;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.val <= inorder)
                    return false;
                inorder = root.val;
                root = root.right;
            }
            return true;
        }
    }
}