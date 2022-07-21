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
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode prev = null;
    ListNode start = head;
    for (int i = 1; i < left; i++) {
      prev = start;
      start = start.next;
    }
    ListNode end = start;
    for (int i = left; i < right; i++) {
      end = end.next;
    }
    ListNode nextToEnd = end.next;
    end.next = null;
    ListNode reverseStart = reverse(start);
    if (prev != null) {
      prev.next = reverseStart;
    }
    ListNode curr = reverseStart;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = nextToEnd;
    return prev == null ? reverseStart : head;
  }
  
  private ListNode reverse(ListNode node) {
    ListNode prev = null;
    ListNode next = null;
    ListNode curr = node;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
