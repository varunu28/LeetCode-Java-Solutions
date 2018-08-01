/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int l = getLengthOfLinkedList(head);
        int mid = l/2;
        
        while (mid > 0) {
            head = head.next;
            mid--;
        }
        
        return head;
    }
    
    private int getLengthOfLinkedList(ListNode head) {
        int c = 0;
        while(head != null) {
            head = head.next;
            c++;
        }
        
        return c;
    }
}
