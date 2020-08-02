import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues implements Test {
    public void run() {}

    // solution #1
    // bfs
    class Solution {
        public List<Integer> LargestValues(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null)
                queue.add(root);
            list.add(root.val);
            while (!queue.isEmpty()) { 
                int max = Integer.MIN_VALUE;
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode curNode = queue.poll();
                    max = Math.max(max, curNode.val);
                    if (curNode.left != null)
                        queue.add(curNode.left);
                    if (curNode.right != null)
                        queue.add(curNode.right);
                }
                list.add(max);
            }
            return list;
        }
    }

    // solution #2
    // dfs
    class Solution2 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            dfs(root, result, 1);
            return result;
        }

        private void dfs(TreeNode node, List<Integer> result, int level) {
            if (node == null) {
                return;
            }
            if (level == result.size() + 1) {
                result.add(node.val);
            } else {
                result.set(level - 1, Math.max(node.val, result.get(level - 1)));
            }
            dfs(node.left, result, level + 1);
            dfs(node.right, result, level + 1);
        }
    }
}