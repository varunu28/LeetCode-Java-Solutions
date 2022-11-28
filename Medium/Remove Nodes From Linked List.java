/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode revNode = reverse(head);
        ListNode curr = revNode;
        ListNode prev = null;
        int maxValue = Integer.MIN_VALUE;
        while (curr != null) {
            if (curr.val < maxValue) {
                prev.next = curr.next;
            } else {
                prev = curr;
                maxValue = Math.max(curr.val, maxValue);
            }
            curr = curr.next;
        }
        return reverse(revNode);
    }
    
    private ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
