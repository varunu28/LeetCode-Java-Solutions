/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    while (curr != null) {
      if (curr.next != null && curr.val == curr.next.val) {
        int currVal = curr.val;
        while (curr != null && curr.val == currVal) {
          curr = curr.next;
        }
        if (prev == null) {
          head = curr;
        }
        else {
          prev.next = curr;
        }
      }
      else {
        prev = curr;
        curr = curr.next;
      }
    }
    return head;
  }
}
