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
    if (head == null) {
      return null;
    }
    ListNode start = head;
    ListNode curr = head;
    ListNode prev = null;
    ListNode revHead = null;
    while (curr != null) {
      int count = 1;
      while (curr.next != null && count < k) {
        curr = curr.next;
        count++;
      }
      if (count == k) {
        ListNode next = curr.next;
        curr.next = null;
        if (revHead == null) {
          revHead = curr;
        }
        ListNode reverse = reverse(start);
        if (prev != null) {
          prev.next = reverse;
        }
        start.next = next;
        prev = start;
        start = next;
        curr = next;
      }
      else {
        curr = curr.next;
      }
    }
    return revHead == null ? head : revHead;
  } 
  
  private ListNode reverse(ListNode root) {
    ListNode curr = root;
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
