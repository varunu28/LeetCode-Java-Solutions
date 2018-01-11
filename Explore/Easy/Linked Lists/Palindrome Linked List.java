/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int l = 0;
        ListNode curr = head;
        
        while (curr != null) {
            l++;
            curr = curr.next;
        }
        
        int i = 1;
        curr = head;
        
        while (i < l/2) {
            curr = curr.next;
            i++;
        }
        
        ListNode mid = reverse(curr.next);
        
        curr = head;
        
        while(mid != null) {
            if (curr.val != mid.val) return false;
            curr = curr.next;
            mid = mid.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
