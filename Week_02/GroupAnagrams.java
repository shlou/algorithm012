import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// make clear: 1. need to ignore case.
//             2. need to consider the output list order.
public class GroupAnagrams implements Testable {
    public void run () {
        Solution2 runner = new Solution2();
        List<List<String>> groups = runner.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(groups);
    }

    // solution #1
    // order and classify
    // TC: O(NKlogK),strs length is N, str order is KlogK. SC: O(NK)
    class Solution {
        public List<List<String>> groupAnagrams (String[] strs) {
            if (strs.length == 0)
                return new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] c = str.toCharArray();
                Arrays.sort(c);
                String key = String.valueOf(c);
                if (!map.containsKey(key)) 
                    map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }

    // solution #2:
    // use frequency table of chars instead of sort the string and compare.
    // TC: O(KN), SC: O(KN)
    class Solution2 {
        public List<List<String>> groupAnagrams (String[] strs) {
            if (strs.length == 0)
                return new ArrayList<>();
            int[] counter = new int[26];
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                Arrays.fill(counter, 0);
                for (char c : str.toCharArray())
                    counter[c - 'a']++;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    sb.append("#");
                    sb.append(counter[i]);
                }
                String key = sb.toString();
                if (!map.containsKey(key))
                    map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
}