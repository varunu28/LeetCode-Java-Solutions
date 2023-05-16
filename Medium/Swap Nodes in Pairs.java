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
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null && curr.next != null) {
            ListNode nextNode = curr.next;
            ListNode nextToNext = curr.next.next;
            if (prev == null) {
                head = nextNode;
            } 
            if (prev != null) {
                prev.next = nextNode;
            }
            nextNode.next = curr;
            curr.next = nextToNext;
            prev = curr;
            curr = nextToNext;
        } 
        return head;
    }
}
