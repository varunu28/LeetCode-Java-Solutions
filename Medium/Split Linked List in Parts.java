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
  public ListNode[] splitListToParts(ListNode head, int k) {
    ListNode[] arr = new ListNode[k];
    int nodeLength = 0;
    for (ListNode curr = head; curr != null; curr = curr.next) {
      nodeLength++;
    }
    int n = nodeLength / k;
    int remaining = nodeLength % k;
    ListNode prev = null;
    for (int i = 0; i < k && head != null; i++, remaining--) {
      arr[i] = head;
      for (int j = 0; j < n + (remaining > 0 ? 1 : 0); j++) {
        prev = head;
        head = head.next;
      }
      prev.next = null;
    }
    return arr;
  }
}
