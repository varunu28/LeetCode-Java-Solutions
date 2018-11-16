/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    int length;
    public Solution(ListNode head) {
        this.head = head;
        length = findLength(head);
    }
    
    private int findLength(ListNode head) {
        int count = 0;
        
        while (head != null) {
            count++;
            head = head.next;
        }
        
        return count;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int idx = new Random().nextInt(((length - 1) - 0) + 1);
        return getKthNode(head, idx);
    }
    
    private int getKthNode(ListNode head, int k) {
        int count = 0;
        
        while (count < k) {
            count++;
            head = head.next;
        }
        
        return head.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
