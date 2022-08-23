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
  public boolean isPalindrome(ListNode head) {
    if (head.next == null) {
      return true;
    }
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;
    while (fast != null && fast.next != null) {
      prev = slow;
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode revNode = reverse(slow);
    while (revNode != null) {
      if (revNode.val != head.val) {
        return false;
      }
      revNode = revNode.next;
      head = head.next;
    }
    return true;
  }
  
  private ListNode reverse(ListNode node) {
    ListNode prev = null;
    ListNode curr = node;
    ListNode next = node;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
