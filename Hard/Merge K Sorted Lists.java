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
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode listNode : lists) {
      if (listNode != null) {
        pq.add(listNode);
      }
    }
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (!pq.isEmpty()) {
      ListNode removed = pq.remove();
      curr.next = new ListNode(removed.val);
      curr = curr.next;
      if (removed.next != null) {
        pq.add(removed.next);
      }
    }
    return dummy.next;
  }
}
