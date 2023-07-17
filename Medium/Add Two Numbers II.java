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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev1 = reverse(l1);
        ListNode rev2 = reverse(l2);
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while (rev1 != null || rev2 != null || carry > 0) {
            if (rev1 != null && rev2 != null) {
                carry += rev1.val + rev2.val;
                rev1 = rev1.next;
                rev2 = rev2.next;
            } else if (rev1 == null && rev2 != null) {
                carry += rev2.val;
                rev2 = rev2.next;
            } else if (rev1 != null && rev2 == null) {
                carry += rev1.val;
                rev1 = rev1.next;
            }
            curr.next = new ListNode(carry % 10);
            curr = curr.next;
            carry /= 10;
        }
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
