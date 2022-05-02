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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null || list2 == null) {
      return list1 == null ? list2 : list1;
    }
    ListNode prev = null;
    ListNode head = null;
    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        prev = list1;
        if (head == null) {
          head = list1;
        }
        list1 = list1.next;
      } else {
        ListNode node = list2;
        list2 = list2.next;
        if (prev == null) {
          node.next = list1;
          prev = node;
          head = prev;
        } else {
          prev.next = node;
          node.next = list1;
          prev = node;
        }
      }
    }
    if (list2 != null) {
      prev.next = list2;
    }
    if (list1 != null) {
      prev.next = list1;
    }
    return head;
  }
}
