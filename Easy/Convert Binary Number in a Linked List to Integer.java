/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public int getDecimalValue(ListNode head) {
    int length = getLength(head);
    int sum = 0;
    while (head != null) {
      sum += ((int) Math.pow(2, length - 1)) * head.val;
      length--;
      head = head.next;
    }
    return sum;
  }
  
  private int getLength(ListNode head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }
}
