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
        if (headA == null || headB == null) return null;
        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                return headA;
            }
            else if (headA.val < headB.val) {
                headA = headA.next;
            }
            else if (headA.val > headB.val) {
                headB = headB.next;
            }
        }
        return null;
    }
}