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
  public int[] nodesBetweenCriticalPoints(ListNode head) {
    int firstIdx = Integer.MAX_VALUE;
    int lastIdx = 0;
    int minDistance = Integer.MAX_VALUE;
    int prevVal = head.val;
    for (int i = 0; head.next != null; i++) {
      if ((prevVal < head.val && head.next.val < head.val) ||
          (prevVal > head.val && head.next.val > head.val)) {
        if (lastIdx != 0) {
          minDistance = Math.min(minDistance, i - lastIdx);
        }
        firstIdx = Math.min(firstIdx, i);
        lastIdx = i;
      }
      prevVal = head.val;
      head = head.next;
    }
    return minDistance == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[]{minDistance, lastIdx - firstIdx};
  }
}
