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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prevToLeft = null;
        for (int i = 1; i < left; i++) {
            prevToLeft = curr;
            curr = curr.next;
        }
        ListNode nextToLeft = prevToLeft == null ? head : prevToLeft.next;
        for (int i = left; i < right; i++) {
            curr = curr.next;
        }
        ListNode nextToRight = curr.next;
        curr.next = null;
        if (prevToLeft != null) {
            prevToLeft.next = null;
        }
        ListNode reversedStart = reverse(nextToLeft);
        if (prevToLeft != null) {
            prevToLeft.next = reversedStart;
        }
        curr = reversedStart;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = nextToRight;
        return prevToLeft == null ? reversedStart : head;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
