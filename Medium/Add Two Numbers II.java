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
    ListNode revL1 = reverse(l1);
    ListNode revL2 = reverse(l2);
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    int carry = 0;
    while (revL1 != null || revL2 != null || carry != 0) {
      if (revL1 != null && revL2 != null) {
        carry += revL1.val + revL2.val;
        revL1 = revL1.next;
        revL2 = revL2.next;
      } else if (revL1 != null && revL2 == null) {
        carry += revL1.val;
        revL1 = revL1.next;
      } else if (revL1 == null && revL2 != null) {
        carry += revL2.val;
        revL2 = revL2.next;
      }
      curr.next = new ListNode(carry % 10);
      carry /= 10;
      curr = curr.next;
    }
    return reverse(dummy.next);
  }
  
  private ListNode reverse(ListNode root) {
    ListNode curr = root;
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
