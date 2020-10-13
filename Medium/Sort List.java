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
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode mid = getMid(head);
    ListNode left = sortList(head);
    ListNode right = sortList(mid);
    return merge(left, right);
  }
  
  private ListNode getMid(ListNode head) {
    ListNode prev = null;
    while (head != null && head.next != null) {
      prev = prev == null ? head : prev.next;
      head = head.next.next;
    }
    ListNode mid = prev.next;
    prev.next = null;
    return mid;
  }
  
  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode();
    ListNode tail = dummyHead;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        tail.next = l1;
        l1 = l1.next;
      }
      else {
        tail.next = l2;
        l2 = l2.next;
      }
      tail = tail.next;
    }
    tail.next = l1 != null ? l1 : l2;
    return dummyHead.next;
  }
}
