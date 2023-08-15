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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = null;
        ListNode lessCurr = null;
        ListNode greaterHead = null;
        ListNode greaterCurr = null;
        while (head != null) {
            if (head.val < x) {
                if (lessCurr == null) {
                    lessCurr = new ListNode(head.val);
                    lessHead = lessCurr;
                } else {
                    lessCurr.next = new ListNode(head.val);
                    lessCurr = lessCurr.next;
                }
            } else {
                if (greaterCurr == null) {
                    greaterCurr = new ListNode(head.val);
                    greaterHead = greaterCurr;
                } else {
                    greaterCurr.next = new ListNode(head.val);
                    greaterCurr = greaterCurr.next;
                }
            }
            head = head.next;
        }
        if (lessHead == null) {
            return greaterHead;
        }
        lessCurr.next = greaterHead;
        return lessHead;
    }
}
