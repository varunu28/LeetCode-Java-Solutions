/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode plusOne(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode notNine = dummy;
    while (head != null) {
      if (head.val != 9) {
        notNine = head;
      }
      head = head.next;
    }
    notNine.val++;
    notNine = notNine.next;
    while (notNine != null) {
      notNine.val = 0;
      notNine = notNine.next;
    }
    return dummy.val != 0 ? dummy : dummy.next;
  } 
}
