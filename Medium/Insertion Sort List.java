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
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode curr = head;
    ListNode prev = dummy;
    ListNode next = null;
    while (curr != null) {
      next = curr.next;
      while (prev.next != null && prev.next.val < curr.val) {
        prev = prev.next;
      }
      curr.next = prev.next;
      prev.next = curr;
      prev = dummy;
      curr = next;
    }
    return dummy.next; 
  }
}
