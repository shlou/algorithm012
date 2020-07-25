import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class GenerateParenthesis implements Debugger {
    public void run () {
        Solution2 runner = new Solution2();
        System.out.println(runner.generateParenthesis(3));
    }

    // solution #1
    // dfs
    // TC: O(N)?
    class Solution {
        public List<String> generateParenthesis (int n) {
            List<String> list = new ArrayList<>();
            dfs(0, 0, n, list, "");
            return list;
        }

        void dfs (int left, int right, int max, List<String> list, String cur) {
            if (left == max && right == max) {
                list.add(cur);
                return;
            }
                
            if (left < right) 
                return;
            if (left < max)
                dfs(left + 1, right, max, list, cur + "(");
            if (right < left) 
                dfs(left, right + 1, max, list, cur + ")");
        }
    }

    // solution #2
    // bfs
    public class Solution2 {
        class Node {
            private String res;
            private int left;
            private int right;
            public Node(String str, int left, int right) {
                this.res = str;
                this.left = left;
                this.right = right;
            }
        }

        public List<String> generateParenthesis (int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node("", n, n));
            while (!queue.isEmpty()) {
                Node curNode = queue.poll();
                if (curNode.left == 0 && curNode.right == 0)
                    res.add(curNode.res);
                if (curNode.left > 0)
                    queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
                if (curNode.right > 0 && curNode.left < curNode.right)
                    queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
            return res;
        }
    }

    // solution #3 
    // dp
    public List<String> generateParenthesis (int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i = 0; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }
}