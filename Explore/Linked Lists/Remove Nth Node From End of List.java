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
        int l = 0;
        ListNode curr = head;
        
        while (curr != null) {
            l++;
            curr = curr.next;
        }
        
        if (l -n == 0) {
            ListNode tmp = head.next;
            head = null;
            return tmp;
        }
        
        curr = head;
        int c = 1;
        l = l-n;
        
        while(c != l) {
            c++;
            curr = curr.next;
        }
        
        curr.next = curr.next.next;
        
        return head;
    }
}
