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
        
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode currA = headA;
        ListNode currB = headB;
        
        if (lenB > lenA) {
            int diff = lenB - lenA;
            
            while (diff != 0) {
                currB = currB.next;
                diff--;
            }
        }
        else {
            int diff = lenA - lenB;
            
            while (diff != 0) {
                currA = currA.next;
                diff--;
            }
        }
        
        while(currB != null) {
            if (currA == currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }
        
        return null;
    }
    
    public int getLength(ListNode head) {
        int l = 0;
        while (head != null) {
            head = head.next;
            l++;
        }
        
        return l;
    }
}
