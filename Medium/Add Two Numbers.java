/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            ListNode curr = new ListNode(0);
            int sum = 0;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            curr.val = (sum + carry)%10;
            carry = (sum + carry)/10;
            prev.next = curr;
            prev = curr;
        }
        
        return head.next;
    }
}
