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
  public ListNode deleteNodes(ListNode head, int m, int n) {
    ListNode curr = head;
    ListNode prev = null;
    boolean toDelete = false;
    int deleteCount = 0;
    int skipCount = 0;
    while (curr != null) {
      if (toDelete) {
        prev.next = curr.next;
        deleteCount++;
        curr = prev.next;
        if (deleteCount == n) {
          deleteCount = 0;
          toDelete = false;
        }
      }
      else {
        prev = curr;
        curr = curr.next;
        skipCount++;
        if (skipCount == m) {
          skipCount = 0;
          toDelete = true;
        }
      }
    }
    return head;
  }
}
