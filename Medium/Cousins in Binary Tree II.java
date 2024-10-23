/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int prevLevelSum = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                node.val = prevLevelSum - node.val;
                int siblingSum = (node.left != null ? node.left.val : 0) + 
                    (node.right != null ? node.right.val : 0); 
                if (node.left != null) {
                    levelSum += node.left.val;
                    node.left.val = siblingSum;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    levelSum += node.right.val;
                    node.right.val = siblingSum;
                    queue.add(node.right);
                }
            }
            prevLevelSum = levelSum;
        }
        return root;
    }
}
