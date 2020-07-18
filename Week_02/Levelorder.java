import java.util.ArrayList;
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
    // queue based BFS
    // TC: O(N), SC: O(N)
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
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

    // solution #2
}