import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> results = new ArrayList<>();
            if (root == null) return results;
            
            Deque<TreeNode> queue = new LinkedList<>();
            queue.push(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) 
                        queue.push(node.left);
                    if (node.right != null) 
                        queue.push(node.right);

                }
                results.add(level);
            }
            return results;
        }
    }
}