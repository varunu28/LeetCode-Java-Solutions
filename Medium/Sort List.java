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
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode firstHalfTail = head;
    ListNode secondHalfHead = head;
    ListNode secondHalfTail = head;
    while (secondHalfTail != null && secondHalfTail.next != null) {
      firstHalfTail = secondHalfHead;
      secondHalfHead = secondHalfHead.next;
      secondHalfTail = secondHalfTail.next.next;
    }
    firstHalfTail.next = null;
    ListNode leftHalf = sortList(head);
    ListNode rightHalf = sortList(secondHalfHead);
    return merge(leftHalf, rightHalf);
  }
  
  private ListNode merge(ListNode leftHalf, ListNode rightHalf) {
    ListNode dummyNode = new ListNode(-1);
    ListNode currNode = dummyNode;
    while (leftHalf != null || rightHalf != null) {
      if (leftHalf != null && rightHalf != null) {
        if (leftHalf.val < rightHalf.val) {
          currNode.next = new ListNode(leftHalf.val);
          leftHalf = leftHalf.next;
        } else {
          currNode.next = new ListNode(rightHalf.val);
          rightHalf = rightHalf.next;
        }
      } else if (leftHalf != null && rightHalf == null) {
        currNode.next = new ListNode(leftHalf.val);
        leftHalf = leftHalf.next;
      } else {
        currNode.next = new ListNode(rightHalf.val);
        rightHalf = rightHalf.next;
      }
      currNode = currNode.next;
    }
    return dummyNode.next;
  }
}
