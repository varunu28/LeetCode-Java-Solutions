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
  public int getDecimalValue(ListNode head) {
    int nodeLength = -1;
    ListNode curr = head;
    while (curr != null) {
      nodeLength++;
      curr = curr.next;
    }
    int decimalValue = 0;
    curr = head;
    while (curr != null) {
      decimalValue += curr.val * Math.pow(2, nodeLength--);
      curr = curr.next;
    }
    return decimalValue;
  }
}
