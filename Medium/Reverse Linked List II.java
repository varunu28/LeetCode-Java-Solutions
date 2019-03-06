/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n || m > n) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = dummy.next;
        
        for (int i = 1; i < m; i++) {
            pre = curr;
            curr = curr.next;
        }
        
        ListNode node = pre;
        
        for (int i = m; i <= n; i++) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        
        node.next.next = curr;
        node.next = pre;
        
        return dummy.next;
    }
}
