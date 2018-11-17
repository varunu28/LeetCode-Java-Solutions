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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 1;
        }
        
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 0);
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int len = queue.size();
            int leftPos = map.get(queue.peek());
            
            for (int i=0; i<len; i++) {
                TreeNode popped = queue.remove();
                int currPos = map.get(popped);
                size = Math.max(size, currPos - leftPos + 1);
                
                if (popped.left != null) {
                    queue.add(popped.left);
                    map.put(popped.left, 2 * currPos);
                }
                
                if (popped.right != null) {
                    queue.add(popped.right);
                    map.put(popped.right, 2 * currPos + 1);
                }
            }
        }
        
        return size;
    }
}
