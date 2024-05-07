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
    public ListNode doubleIt(ListNode head) {
        ListNode rev = reverse(head);
        ListNode curr = rev;
        int carry = 0;
        while (curr != null) {
            int val = curr.val * 2 + carry;
            carry = val / 10;
            curr.val = val % 10;
            if (curr.next == null && carry != 0) {
                curr.next = new ListNode(carry);
                break;
            }
            curr = curr.next;
        }
        return reverse(rev);
    }

    private ListNode reverse(ListNode curr) {
        ListNode next = null;
        ListNode prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
