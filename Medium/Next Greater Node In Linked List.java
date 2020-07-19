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
  public int[] nextLargerNodes(ListNode head) {
    // Reverse the list
    ListNode curr = head;
    ListNode prev = null;
    ListNode next = null;
    int count = 0;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      count++;
    }
    curr = prev;
    Stack<Integer> stack = new Stack<>();
    int[] ans = new int[count];
    int idx = count - 1;
    while (curr != null) {
      // Keep track of next greatest value node
      while (!stack.isEmpty() && stack.peek() <= curr.val) {
        stack.pop();
      }
      ans[idx--] = stack.isEmpty() ? 0 : stack.peek(); 
      stack.push(curr.val);
      curr = curr.next;
    }
    return ans;
  }
}
