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
        ListNode ans = new ListNode(-1);
        ListNode curr = ans;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int temp = carry;
            if (l1 != null && l2 != null) {
                temp += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;  
            }    
            else if (l1 != null && l2 == null) {
                temp += l1.val;
                l1 = l1.next;
            }
            else {
                temp += l2.val;
                l2 = l2.next;   
            }
            
            carry = temp > 9 ? temp / 10 : 0;
            temp = temp > 9 ? temp % 10 : temp;
            
            curr.next = new ListNode(temp);
            curr = curr.next;
        }
        
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        
        return ans.next;
    }
}
