import java.util.Arrays;

public class IsAnagram implements Testable {

    public void run () {
        String s = "anagram";
        String t = "nagaram";

        Solution3 runner = new Solution3();
        System.out.println("2 arrays have " + (runner.isAnagram(s, t) ? "the same" : "different") + "chars.");
    }
    
    // solution #1: ordered array.
    // time complexity: O(NlogN), order will cost O(NlogN), compare 2 strings O(N), so O(NlogN) in total.
    // space complexity: O(1) the best case is heap sort, toCharArray actually use O(N).
    class Solution1 {
        public boolean isAnagram (String s, String t) {
            if (s.length() != t.length())
                return false;

            char[] str1 = s.toCharArray();
            char[] str2 = t.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            return Arrays.equals(str1, str2);
        }
    }

    // solution #2: hash table.
    // NICE! use an array to represent the alphabet table and the count.
    // time complexity: O(N)
    // space complexity: O(1)
    class Solution2 {
        public boolean isAnagram (String s, String t) {
            if (s.length() != t.length())
                return false;
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
                counter[t.charAt(i) - 'a']--;
            }
            for (int count : counter) {
                if (count != 0)
                    return false;
            }
            return true;
        }
    }

    // better performance than solution #2
    class Solution3 {
        public boolean isAnagram (String s, String t) {
            if (s.length() != t.length()) 
                return false;
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                counter[t.charAt(i) - 'a']--;
                if (counter[t.charAt(i) - 'a'] < 0)
                    return false;
            }
            return true;
        }
    }
}