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
    public ListNode sortLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null){
           if (curr.next.val < 0) {
               // Make a new head with negative value and assign its next pointer to current head
               head = new ListNode(curr.next.val,head);
               curr.next = curr.next.next;
           } else {
                curr = curr.next;
           }  
        } 
        return head; 
    }
}
