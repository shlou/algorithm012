import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LeastInterval {

    public void debug() {
        Solution3 sol = new Solution3();
        int time = sol.leastInterval(new char[] {'A','A','A','B','B','B'}, 2);
        System.out.print(time);
    }

    // solution 1, sort
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char c : tasks)
                map[c - 'A']++;
            Arrays.sort(map);
            int time = 0;
            while (map[25] > 0) {
                int i = 0;
                while (i <= n) {
                    if (map[25] == 0)
                        break;
                    if (i < 26 && map[25 - i] > 0)
                        map[25 - i]--;
                    time++;
                    i++;
                }
                Arrays.sort(map);
            }
            return time;
        }
    }

    // solution 2, priority queue
    class Solution2 {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char c : tasks) 
                map[c - 'A']++;
            PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
            for (int f : map) {
                if (f > 0)
                    queue.add(f);
            }
            int time = 0;
            while (!queue.isEmpty()) {
                int i = 0;
                List<Integer> temp = new ArrayList<>();
                while (i <= n) {
                    if (!queue.isEmpty()) {
                        if (queue.peek() > 1)
                            temp.add(queue.poll() - 1);
                        else
                            queue.poll();
                    }
                    time++;
                    if (queue.isEmpty() && temp.size() == 0)
                        break;
                    i++;
                }
                for (int l : temp)
                    queue.add(l);
            }
            return time;
        }
    }

    // solution 3, dp
    class Solution3 {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char c : tasks) 
                map[c - 'A']++;
            Arrays.sort(map);
            int max_val = map[25] - 1, idle_slots = max_val * n;
            for (int i = 24; i >= 0 && map[i] > 0; i--) 
                idle_slots -= Math.min(map[i], max_val);
            return idle_slots > 0 ? (idle_slots + tasks.length) : tasks.length;
        }
    }
}