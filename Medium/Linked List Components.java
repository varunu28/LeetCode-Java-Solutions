/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }
        
        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) {
                    head = head.next;
                }
                
                count++;
            }
            else {
                head = head.next;
            }
        }
        
        return count;
    }
}
