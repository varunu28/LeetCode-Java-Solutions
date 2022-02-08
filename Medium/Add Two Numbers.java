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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode root = new ListNode(-1);
    ListNode curr = root;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int currSum = carry;
      if (l1 != null && l2 != null) {
        currSum += l1.val + l2.val;
        l1 = l1.next;
        l2 = l2.next;
      } else if (l1 != null && l2 == null) {
        currSum += l1.val;
        l1 = l1.next;
      } else if (l1 == null && l2 != null) {
        currSum += l2.val;
        l2 = l2.next;
      }
      carry = currSum > 9 ? 1 : 0;
      currSum %= 10;
      curr.next = new ListNode(currSum);
      curr = curr.next;
    }
    return root.next;
  }
}
