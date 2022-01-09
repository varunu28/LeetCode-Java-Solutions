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
  public int pairSum(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    fast = reverse(slow.next);
    slow.next = null;
    slow = head;
    int maxSum = 0;
    for (; slow != null && fast != null; slow = slow.next, fast = fast.next) {
      maxSum = Math.max(maxSum, slow.val + fast.val);
    }
    return maxSum;
  }
  
  private ListNode reverse(ListNode node) {
    ListNode curr = node;
    ListNode prev = null;
    ListNode next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
