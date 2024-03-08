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
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (Integer key : map.keySet()) {
            curr.next = new ListNode(map.get(key));
            curr = curr.next;
        }
        return dummy.next;
    }
}
