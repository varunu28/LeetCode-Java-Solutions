/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode copyA = headA;
    ListNode copyB = headB;
    while (copyA != copyB) {
      copyA = copyA == null ? headB : copyA.next;
      copyB = copyB == null ? headA : copyB.next;
    }
    return copyA;
  }
}
