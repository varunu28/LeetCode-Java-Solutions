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
    ListNode fast = null;
    ListNode curr = head;
    int currCount = 1;
    while (currCount != k) {
      curr = curr.next;
      currCount++;
    }
    fast = curr;
    ListNode slow = head;
    while (curr.next != null) {
      slow = slow.next;
      curr = curr.next;
    }
    int temp = fast.val;
    fast.val = slow.val;
    slow.val = temp;
    return head;
  }
}
