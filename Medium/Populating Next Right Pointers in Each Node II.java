/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode tempHead = new TreeLinkNode(0);
            TreeLinkNode curr = tempHead;   
            
            while (root != null) {
                if (root.left != null) {
                    curr.next = root.left;
                    curr = curr.next;
                }
                
                if (root.right != null) {
                    curr.next = root.right;
                    curr = curr.next;
                }
                
                root = root.next;
            }
            
            root = tempHead.next;
        }
    }
}
