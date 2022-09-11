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
    ListNode curr = head;
    while (n-- > 0) {
      curr = curr.next;
    }
    if (curr == null) {
      return head.next;
    }
    ListNode slowNode = head;
    while (curr.next != null) {
      slowNode = slowNode.next;
      curr = curr.next;
    }
    slowNode.next = slowNode.next.next;
    return head;
  }
}
