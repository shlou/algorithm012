// merge 2 ascending ordered list nodes in ascending order, and return
public class MergeTwoLists extends BaseRunner {

    // leet code
    // 1. recursively. time complexity O(n + m), space complexity O(n + m)
    class Solution1 {

        public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val > l2.val) {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            } else {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
        }
    }

    // #region SKILLFUL
    // 2. iterate. time complexity O(n + m), space complexity O(1) 
    class Solution2 {
        public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode(-1);
            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }
            prev.next = l1 == null ? l2 : l1;
            return prehead.next;
        }
    }

    // #endregion

    public String getName () { 
        return "MergeTwoLists"; 
    }

    public void run () {
        Solution2 leetCode = new Solution2();
        leetCode.mergeTwoLists(
            new ListNode(1, new ListNode(2, new ListNode(4, null))), 
            new ListNode(1, new ListNode(3, new ListNode(4, null))));
    }

    public class ListNode {
        int val;
        ListNode next;
        public ListNode () {}
        public ListNode (int value) {
            val = value;
        }
        public ListNode (int value, ListNode next) {
            this.val = value;
            this.next = next;
        }
    }
}