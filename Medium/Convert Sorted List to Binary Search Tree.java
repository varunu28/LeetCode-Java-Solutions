/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode curr;
    
    public TreeNode sortedListToBST(ListNode head) {        
        curr = head;
        return generate(count(head));
    }
    
    public int count(ListNode node) {
        int n = 0;
        while (node != null) {
            node = node.next;
            ++n;
        }
        return n;
    }
    
    public TreeNode generate(int n) {
        if (n==0) return null;
        
        TreeNode node = new TreeNode(0);
        node.left = generate(n/2);
        node.val = curr.val;
        curr = curr.next;
        node.right = generate(n-(n/2)-1);
        
        return node;
    }
}
