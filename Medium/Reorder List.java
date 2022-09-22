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
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode secondHalf = reverse(slow.next);
    slow.next = null;
    ListNode firstHalf = head;
    while (firstHalf != null && secondHalf != null) {
      ListNode firstHalfNext = firstHalf.next;
      ListNode secondHalfNext = secondHalf.next;
      firstHalf.next = secondHalf;
      secondHalf.next = firstHalfNext;
      firstHalf = firstHalfNext;
      secondHalf = secondHalfNext;
    }
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
