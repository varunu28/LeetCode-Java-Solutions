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
  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode currList1 = list1;
    // Stop just before a and record the pointer
    for (int i = 0; i < a - 1; i++) {
      currList1 = currList1.next;
    }
    ListNode currCopy = currList1;
    // Cover a to b
    for (int i = a; i <= b; i++) {
      currList1 = currList1.next;
    } 
    // Record what is remaining after b
    ListNode remaining = currList1.next;
    // Find end of list2
    ListNode list2End = list2;
    while (list2End != null && list2End.next != null) {
      list2End = list2End.next;
    }
    // Pointer manipulation
    currCopy.next = list2;
    list2End.next = remaining;
    return list1;
  }
}
