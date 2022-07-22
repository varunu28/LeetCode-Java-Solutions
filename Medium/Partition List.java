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
  public ListNode partition(ListNode head, int x) {
    ListNode lessThanHead = null;
    ListNode lessThan = null;
    ListNode greaterThan = null;
    ListNode greaterThanHead = null;
    while (head != null) {
      ListNode nextNode = head.next;
      if (head.val < x) {
        if (lessThan == null) {
          lessThan = head;
          lessThanHead = lessThan;
        } else {
          lessThan.next = head;
          lessThan = lessThan.next;
        }
        lessThan.next = null;
      } else {
        if (greaterThan == null) {
          greaterThan = head;
          greaterThanHead = greaterThan;
        } else {
          greaterThan.next = head;
          greaterThan = greaterThan.next;
        }
        greaterThan.next = null;
      }
      head = nextNode;
    }
    if (lessThanHead == null || greaterThanHead == null) {
      return lessThan == null ? greaterThanHead : lessThanHead;
    }
    lessThan.next = greaterThanHead;
    return lessThanHead;
  }
}
