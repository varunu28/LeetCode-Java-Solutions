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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        // Used for inserting in the right position in sorted list
        ListNode prev = dummy;
        ListNode next = null;
        while (curr != null) {
            // Traversal #1
            next = curr.next;
            // This iteration finds the correct insertion order in new sorted list
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            // Update the pointers to set the right position
            curr.next = prev.next;
            prev.next = curr;
            // Reset back to dummy so it can be used in next iteration
            prev = dummy;
            // Traversal #2
            curr = next;
        }
        // Return the node for sorted list
        return dummy.next;
    }
}
