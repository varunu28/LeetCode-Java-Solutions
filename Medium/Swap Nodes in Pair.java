/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode temp = head.next;
        ListNode prev = null;
        
        while(head != null && head.next != null) {
            
            if(prev != null) {
                prev.next = head.next;
            }
            
            ListNode temp1 = head.next;
            ListNode temp2 = head;
            head.next = head.next.next;
            head = temp1;
            head.next = temp2;
            prev = head.next;
            head = head.next.next;
        }
        
        return temp;
    }
}
