/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head ==  null || head.next == null) return null;
        
        ListNode curr = head;
        int i = 0;
        
        while (curr != null) {
            curr = curr.next;
            i++;
        }
        
        if (i == n) {
            return head.next;
        }
        
        n = i - n;
        i = 1;
        curr = head;
        
        while (i != n) {
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        
        return head;
    }
}
