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
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode oddIdxNode = head;
    ListNode evenIdxNodeStart = head.next;
    ListNode evenIdxNode = evenIdxNodeStart;
    while (evenIdxNode != null && evenIdxNode.next != null) {
      oddIdxNode.next = evenIdxNode.next;
      oddIdxNode = oddIdxNode.next;
      evenIdxNode.next = oddIdxNode.next;
      evenIdxNode = evenIdxNode.next;
    }
    oddIdxNode.next = evenIdxNodeStart;
    return head;
  }
}
