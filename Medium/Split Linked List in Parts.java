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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        ListNode[] splits = new ListNode[k];
        int elementsPerPart = length / k;
        int partsWithExtra = length % k;
        ListNode prev = null;
        for (int i = 0; i < k && head != null; i++, partsWithExtra--) {
            splits[i] = head;
            for (int j = 0; j < elementsPerPart + (partsWithExtra > 0 ? 1 : 0); j++) {
                prev = head;
                head = head.next;
            }
            prev.next = null;
        }
        return splits;
    }
}
