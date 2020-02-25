/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode next = head.next;
    head.next = swapPairs(head.next.next);
    next.next = head;
    return next;
  }
  
  private ListNode reverseHeadPair(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode next = head.next;
    head.next = reverseHeadPair(head.next.next);
    next.next = head;
    return next;
  }
}
