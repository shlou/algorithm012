import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesis implements Test {
    public void run() {
        Solution4 sol = new Solution4();
        List<String> list = sol.generateParenthesis(3);
        System.out.println(list);
    }

    // solution #1
    // dfs
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            dfs(0, 0, n, list, "");
            return list;
        }

        private void dfs(int right, int left, int max, List<String> list, String cur) {
            if (right == max && left == max) {
                list.add(cur);
                return;
            }

            if (left < right)
                return;
            
            if (left < max)
                dfs(right, left + 1, max, list, cur + "(");
            if (right < max)
                dfs(right + 1, left, max, list, cur + ")");
        }
    }

    // solution #2
    // brute force
    class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<String>();
            generateAll(0, new char[2 * n], result);
            return result;
        }

        private void generateAll(int pos, char[] cur, List<String> result) {
            if (pos == cur.length) {
                if (isValid(cur)) {
                    result.add(new String(cur));
                }
            } else {
                cur[pos] = '(';
                generateAll(pos + 1, cur, result);
                cur[pos] = ')';
                generateAll(pos + 1, cur, result);
            }           
        }

        private boolean isValid(char[] cur) {
            int balance = 0;
            for (char c : cur) {
                if (c == '(') balance++;
                else balance--;
                if (balance < 0) return false;
            }
            return balance == 0;
        }
    }

    // solution #3
    // bfs
    class Solution3 {
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

        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node("", n, n));
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.left == 0 && cur.right == 0) {
                    res.add(cur.res);
                }
                if (cur.left > 0) {
                    queue.add(new Node(cur.res + "(", cur.left - 1, cur.right));
                }
                if (cur.right > 0) {
                    queue.add(new Node(cur.res + ")", cur.left, cur.right - 1));
                }
            }
            return res;
        }
    }

    // solution #4
    // dynamic programming
    class Solution4 {
        public List<String> generateParenthesis(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            List<List<String>> dp = new ArrayList<>();
            List<String> dp0 = new ArrayList<>();
            dp0.add("");
            dp.add(dp0);
            for (int i = 1; i <= n; i++) {
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
}