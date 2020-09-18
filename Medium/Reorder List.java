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
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode secondHalf = reverse(slow.next);
    slow.next = null;
    ListNode firstHalf = head;
    ListNode firstNext = null;
    ListNode secondNext = null;
    while (firstHalf != null && secondHalf != null) {
      firstNext = firstHalf.next;
      secondNext = secondHalf.next;
      firstHalf.next = secondHalf;
      secondHalf.next = firstNext;
      firstHalf = firstNext;
      secondHalf = secondNext;
    }
  }
  
  private ListNode reverse(ListNode node) {
    ListNode curr = node;
    ListNode prev = null;
    ListNode next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
