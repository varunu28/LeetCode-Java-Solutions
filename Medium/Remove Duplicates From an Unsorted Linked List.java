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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }
        curr = head;
        ListNode prev = null;
        ListNode newHead = null;
        while (curr != null) {
            if (map.get(curr.val) > 1) {
                if (prev != null) {
                    prev.next = curr.next;
                }
            } else {
                prev = curr;
                if (newHead == null) {
                    newHead = curr;
                }
            }
            curr = curr.next;
        }
        return newHead;
    }
}
