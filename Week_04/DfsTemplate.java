import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.HashMap;

public class DfsTemplate {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        travel(root, 0, allResults);
        return allResults;
    }

    // recursively
    private void travel(TreeNode root, int level, List<List<Integer>> results) {
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if (root.left != null) {
            travel(root.left, level + 1, results);
        }
        if (root.right != null) {
            travel(root.right, level + 1, results);
        }
    }

    // stack
    private void dfs(TreeNode root) {
        Map<Integer, Integer> visited = new HashMap<>();
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (visited.containsKey(node.val)) 
                continue;
            visited.put(node.val, 1);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }
}