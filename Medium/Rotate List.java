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
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) {
      return head;
    }
    ListNode curr = head;
    // Get length of list & update the number of rotations
    int count = 0;
    while (curr != null) {
      curr = curr.next;
      count++;
    }
    k %= count;
    if (k == 0) {
      return head;
    }
    // Move the pointer just before the rotation index
    int stop = count - k;
    int currCount = 1;
    curr = head;
    while (currCount < stop) {
      currCount++;
      curr = curr.next;
    }
    ListNode nextNode = curr.next;
    // Detach rotation part of list and append it in the beginning of list
    curr.next = null;
    ListNode newHead = nextNode;
    while (nextNode.next != null) {
      nextNode = nextNode.next;
    }
    nextNode.next = head;
    return newHead;
  }
}
