import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorder implements Testable {
    public void run () {
        Node n6 = new Node(6);
        Node n5 = new Node(5);
        List<Node> n3c = new LinkedList<>();
        n3c.add(n5);
        n3c.add(n6);
        Node n3 = new Node(3, n3c);
        Node n2 = new Node(2);
        Node n4 = new Node(4); 
        List<Node> n1c = new LinkedList<>();
        n1c.add(n3);
        n1c.add(n2);
        n1c.add(n4);
        Node n1 = new Node(1, n1c);
        
        Solution2 runner = new Solution2();
        System.out.println(runner.preorder(n1));
    }

    // solution #1
    // recursive
    // TC: O(N^2), SC: O(N)
    class Solution {
        private List<Integer> result;
        public List<Integer> preorder (Node root) {
            result = new LinkedList<>();
            dfs(root);
            return result;
        }

        private void dfs (Node root) {
            if (root == null) return;
            result.add(root.val);
            for (var child : root.children)
                dfs(child);
        }
    }

    // solution #2
    // iterate using stack
    // 
    class Solution2 {
        public List<Integer> preorder (Node root) {
            List<Integer> result = new LinkedList<>();
            if (root == null) return result;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                result.add(cur.val);
                List<Node> list = cur.children;
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
            return result;
        }
    }
}