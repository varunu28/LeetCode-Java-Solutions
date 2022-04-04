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
  public ListNode swapNodes(ListNode head, int k) {
    int listLength = 0;
    ListNode curr = head;
    while (curr != null) {
      listLength++;
      curr = curr.next;
    }
    ListNode startPrev = null;
    ListNode start = head;
    ListNode endPrev = null;
    ListNode end = head;
    int count = k - 1;
    while (count > 0) {
      startPrev = start;
      start = start.next;
      count--;
    }
    count = listLength - k;
    while (count > 0) {
      endPrev = end;
      end = end.next;
      count--;
    }
    if (startPrev != null) {
      startPrev.next = end;
    }
    if (endPrev != null) {
      endPrev.next = start;
    }
    ListNode temp = start.next;
    start.next = end.next;
    end.next = temp;
    // Updating head pointers if required
    if (k == 1) {
      head = end;
    } 
    if (k == listLength) {
      head = start;
    }
    return head;
  }
}
