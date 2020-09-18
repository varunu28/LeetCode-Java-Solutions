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
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while (l1 != null || l2 != null) {
      int val = Math.min(
        (l1 == null ? Integer.MAX_VALUE : l1.val),
        (l2 == null ? Integer.MAX_VALUE : l2.val)
      );
      curr.next = new ListNode(val);
      curr = curr.next;
      if (l1 != null && l1.val == val) {
        l1 = l1.next;
      }
      else {
        l2 = l2.next;
      }
    }
    return dummy.next;
  }
}
