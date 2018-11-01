/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode ans = new RandomListNode(head.label);
        RandomListNode curr = ans;
        
        while (head != null) {
            curr.next = head.next == null ? null : new RandomListNode(head.next.label);
            curr.random = head.random == null ? null : new RandomListNode(head.random.label);
            
            curr = curr.next;
            head = head.next;
        }
        
        return ans;
    }
}
