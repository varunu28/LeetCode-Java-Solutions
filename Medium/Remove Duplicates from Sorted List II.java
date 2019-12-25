/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode curr = head;
    while (curr != null) {
      int val = curr.val;
      int count = 0;
      ListNode temp = curr;
      // Track the number of occurrences of value of current node
      while (temp != null && temp.val == val) {
        temp = temp.next;
        count++;
      }
      // Update prev.next to the temp which can be a null or node with different value
      if (count > 1) {
        prev.next = temp;
        curr = temp;
      }
      else {
        prev = curr;
        curr = curr.next;
      }
    }
    return dummy.next;
  }
}
