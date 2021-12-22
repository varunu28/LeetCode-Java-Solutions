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
    if (head.next == null) {
      return;
    }
    // Find mid point
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    // Reverse the second half & break the two halves
    ListNode secondHalf = reverse(slow.next);
    slow.next = null;
    ListNode firstHalf = head;
    // Merge first half and second half
    while (firstHalf != null && secondHalf != null) {
      ListNode firstHalfNext = firstHalf.next;
      ListNode secondHalfNext = secondHalf.next;
      firstHalf.next = secondHalf;
      secondHalf.next = firstHalfNext;
      firstHalf = firstHalfNext;
      secondHalf = secondHalfNext;
    }
  }
  
  private ListNode reverse(ListNode head) {
    ListNode curr = head;
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
