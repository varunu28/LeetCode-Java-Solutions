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
  public ListNode reverseEvenLengthGroups(ListNode head) {
    if (head == null) {
      return head;
    }
    int numOfNodes = 1;
    ListNode prev = null;
    ListNode curr = head;
    int totalNumOfNodes = 0;
    while (curr != null) {
      totalNumOfNodes++;
      curr = curr.next;
    }
    curr = head;
    while (curr != null) {
      numOfNodes = Math.min(numOfNodes, totalNumOfNodes);
      totalNumOfNodes -= numOfNodes;
      if (numOfNodes % 2 == 0) {
        ListNode[] res = reverseList(curr, numOfNodes);
        prev.next = res[0];
        prev = curr;
        curr = res[1];
      } else {
        for (int i = 0; i < numOfNodes && curr != null; i++) {
          prev = curr;
          curr = curr.next;
        }
      }
      numOfNodes++;
    }
    return head;
  }
  
    private ListNode[] reverseList(ListNode node, int n) {
      ListNode prev = null;
      ListNode curr = node;
      ListNode post = null;
      while (n-- > 0) {
        post = curr.next;
        curr.next = prev;
        prev = curr;
        curr = post;
      }
      node.next = curr;
      return new ListNode[]{prev, post};
  }
}
