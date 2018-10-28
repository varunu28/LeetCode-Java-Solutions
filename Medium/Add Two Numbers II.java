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
        ListNode l1Rev = reverse(l1);
        ListNode l2Rev = reverse(l2);
        
        ListNode ans = new ListNode(-1);
        ListNode curr = ans;
        int carry = 0;
        
        while (l1Rev != null || l2Rev != null) {
            int temp = 0;
            if (l1Rev != null && l2Rev != null) {
                temp = l1Rev.val + l2Rev.val + carry;
                l1Rev = l1Rev.next;
                l2Rev = l2Rev.next;
            }
            else if(l1Rev != null) {
                temp = l1Rev.val + carry;
                l1Rev = l1Rev.next;
            }
            else {
                temp = l2Rev.val + carry;
                l2Rev = l2Rev.next;
            }
            
            if (temp > 9) {
                carry = temp/10;
                temp = temp%10;
            }
            else {
                carry = 0;
            }
            curr.next = new ListNode(temp);
            curr = curr.next;
        }
        
        if (carry != 0) {
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        
        return reverse(ans.next);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
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
