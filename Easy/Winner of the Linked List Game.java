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
    public String gameResult(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            int even = curr.val;
            int odd = curr.next.val;
            count += even == odd ? 0 : (even > odd ? 1 : -1);
            curr = curr.next.next;
        }
        return count == 0 ? "Tie" : (count > 0 ? "Even" : "Odd");
    }
}
