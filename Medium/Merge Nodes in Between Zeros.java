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
  public ListNode mergeNodes(ListNode head) {
    ListNode newHead = null;
    ListNode prev = null;
    ListNode curr = head.next;
    while (curr != null) {
      prev = curr;
      if (newHead == null) {
        newHead = prev;
      }
      int sum = 0;
      while (curr != null && curr.val != 0) {
        sum += curr.val;
        curr = curr.next;
      }
      prev.val = sum;
      curr = curr.next;
      prev.next = curr;
    }
    return newHead;
  }
}
