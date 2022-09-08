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
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode newHead = null;
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode start = curr;
      int idx = 1;
      for (idx = 1; idx < k && curr.next != null; idx++) {
        curr = curr.next;
      }
      if (idx != k) {
        curr = null;
        continue;
      }
      ListNode next = curr.next;
      curr.next = null;
      ListNode reversedNode = reverse(start);
      if (newHead == null) {
        newHead = reversedNode;
      }
      if (prev != null) {
        prev.next = reversedNode;
      }
      prev = start;
      start.next = next;
      curr = next;
    }
    return newHead;
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
