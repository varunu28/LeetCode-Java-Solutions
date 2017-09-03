/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode copyHead = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                if(head.next.next == null) {
                    head.next = null;
                    break;
                }
                else {
                    head.next = head.next.next;
                }
            }
            else {
                head = head.next;
            }
        }
        return copyHead;
    }
}
