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
    int lenA = getLength(headA);
    int lenB = getLength(headB);
    ListNode currA = headA;
    ListNode currB = headB;
    if (lenA > lenB) {
      int diff = lenA - lenB;
      while (diff-- > 0) {
        currA = currA.next;
      }
    }
    if (lenB > lenA) {
      int diff = lenB - lenA;
      while (diff-- > 0) {
        currB = currB.next;
      }
    }
    while (currA != null && currB != null) {
      if (currA == currB) {
        return currA;
      }
      currA = currA.next;
      currB = currB.next;
    }
    return null;
  }
  
  private int getLength(ListNode node) {
    int len = 0;
    while (node != null) {
      node = node.next;
      len++;
    }
    return len;
  }
}
