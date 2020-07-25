import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// todo: need to review
public class BuildTree implements Debugger {
    public void run() {}

    // solution #1
    // recursion
    class Solution {
        private Map<Integer, Integer> indexMap;

        private TreeNode rBuildTree(int[] preorder, int[] inorder, 
                                    int preorder_left, int preorder_right,
                                    int inorder_left, int inorder_right) {
            if (preorder_left > preorder_right) 
                return null;
            int preorder_root = preorder_left;
            int inorder_root = indexMap.get(preorder[preorder_root]);
            TreeNode root = new TreeNode(preorder[preorder_root]);
            int size_left_subtree = inorder_root - inorder_left;
            root.left = rBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
            root.right = rBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            indexMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return rBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        }
    }

    // solution #2
    // iteration
    class Solution2 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            int inorderIndex = 0;
            for (int i = 1; i < preorder.length; i++) {
                int preorderVal = preorder[i];
                TreeNode node = stack.peek();
                if (node.val != inorder[inorderIndex]) {
                    node.left = new TreeNode(preorderVal);
                    stack.push(node.left);
                } else {
                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                        node = stack.pop();
                        inorderIndex++;
                    }
                    node.right = new TreeNode(preorderVal);
                    stack.push(node.right);
                }
            }
            return root;
        }
    }
}