import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Levelorder implements Testable {

    public void run () {
        Solution runner = new Solution();
        List<List<Integer>> result = runner.levelOrder(new Node().getTestCase());
        System.out.println(result);
    }

    // solution #1
    // traversal
    // TC: O(N), SC: O(N)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> levelOrder (Node root) {
            if (root != null) 
                traverseNode(root, 0);
            return result;
        }
        private void traverseNode (Node node, int level) {
            if (result.size() <= level) 
                result.add(new ArrayList<>());
            result.get(level).add(node.val);
            for (Node child : node.children) 
                traverseNode(child, level + 1);
        } 
    }

    // solution #2
    // queue based BFS
    // TC: O(N), SC: O(N)
    class Solution2 {
        public List<List<Integer>> levelOrder (Node root) {
            List<List<Integer>> values = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    level.add(node.val);
                    queue.addAll(node.children);
                }
                values.add(level);
            }
            return values;
        }
    }

    // solution #3
    // optimized solution based on #1
    // TC: O(N), SC: O(N)
    class Solution3 {
        public List<List<Integer>> levelOrder (Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            List<Node> prevLayer = Arrays.asList(root);
            while (!prevLayer.isEmpty()) {
                List<Node> curLayer = new ArrayList<>();
                List<Integer> prevValues = new ArrayList<>();
                for (Node node : prevLayer) {
                    prevValues.add(node.val);
                    curLayer.addAll(node.children);
                }
                result.add(prevValues);
                prevLayer = curLayer;
            }
            return result;
        }
    }
}