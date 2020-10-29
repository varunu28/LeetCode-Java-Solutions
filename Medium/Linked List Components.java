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
  public int numComponents(ListNode head, int[] G) {
    int numOfComponents = 0;
    Set<Integer> set = Arrays.stream(G).boxed().collect(Collectors.toSet());
    while (head != null && !set.isEmpty()) {
      if (set.contains(head.val)) {
        while (head != null && !set.isEmpty() && set.contains(head.val)) {
          set.remove(head.val);
          head = head.next;
        }
        numOfComponents++;
      } else {
        head = head.next;
      }
    }
    return numOfComponents;
  }
}
