/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (l1 != null || l2 != null) {
            int val = -1;
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    val = l2.val;
                    l2 = l2.next;
                } else {
                    val = l1.val;
                    l1 = l1.next;
                }
            } else if (l1 != null && l2 == null) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
}
