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
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || n == 0) {
      return head;
    }
    ListNode slow = head;
    int count = 0;
    while (count < n) {
      slow = slow.next;
      count++;
    }
    if (slow == null) {
      return head.next;
    }
    ListNode fast = head;
    while (slow.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    fast.next = fast.next.next;
    return head;
  }
}
