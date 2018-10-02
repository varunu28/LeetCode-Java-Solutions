/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode rev = reverse(head);
        ListNode prev = null;
        int carry = 1;
        ListNode curr = rev;
        while (curr != null) {
            int temp = curr.val + carry;
            if (temp > 9) {
                carry = 1;
                temp = temp - 10;
            }
            else {
                carry = 0;
            }
            
            prev = curr;
            
            curr.val = temp;
            curr = curr.next;
        }
        
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }
        
        ListNode ans = reverse(rev);
        
        return ans;
    }
    
    private ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        ListNode next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
