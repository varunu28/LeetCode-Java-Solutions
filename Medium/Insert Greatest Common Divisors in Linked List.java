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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode gcdNode = new ListNode(findGcd(curr.val, curr.next.val));
            gcdNode.next = curr.next;
            curr.next = gcdNode;
            curr = gcdNode.next;
        }
        return head;
    }
    
    private static int findGcd(int numOne, int numTwo) {
        if (numOne == numTwo) {
            return numOne;
        }
        return numOne > numTwo ? findGcd(numOne - numTwo, numTwo) : findGcd(numOne, numTwo - numOne);
    }
}
