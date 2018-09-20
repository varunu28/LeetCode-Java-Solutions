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
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        while(queue.peek() != null) {
            int size = queue.size();
            
            while (size-- > 1) {
                TreeLinkNode temp = queue.remove();
                temp.next = queue.peek();
                
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            
            queue.remove();
            queue.add(null);
        }
    }
}
