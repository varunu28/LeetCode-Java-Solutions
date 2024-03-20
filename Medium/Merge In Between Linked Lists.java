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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        for (int i = 1; i < a; i++) {
            curr = curr.next;
        }
        ListNode start = curr;
        for (int i = a - 1; i <= b; i++) {
            curr = curr.next;
        }
        ListNode end = curr;
        start.next = list2;
        curr = list2;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = end;
        return list1;
    }
}
