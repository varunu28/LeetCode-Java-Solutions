/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            ListNode curr =temp;
            int v = curr.val;
            ListNode t = temp;
            while (curr != null) {
                if (curr.val < v) {
                    v = curr.val;
                    t = curr;
                }
                curr = curr.next;
            }
            t.val = temp.val;
            temp.val = v;
            temp = temp.next;
        }
        return head;
    }
}
