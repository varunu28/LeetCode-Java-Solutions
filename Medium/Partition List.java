/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        Queue<Integer> small = new LinkedList<>();
        Queue<Integer> bigOrEqual = new LinkedList<>();
        ListNode curr = head;
        while (curr != null){
            if (curr.val < x) {
                small.add(curr.val);
            }
            else {
                bigOrEqual.add(curr.val);
            }
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            if (!small.isEmpty()) {
                curr.val = small.remove();
            }
            else {
                curr.val = bigOrEqual.remove();
            }
            curr = curr.next;
        }
        
        return head;
    }
}
