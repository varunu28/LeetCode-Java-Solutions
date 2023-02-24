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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{root.left, root.right});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode[] removed = queue.remove();
                TreeNode nodeOne = removed[0];
                TreeNode nodeTwo = removed[1];
                if (nodeOne == null && nodeTwo == null) {
                    continue;
                }
                if (nodeOne == null || nodeTwo == null) {
                    return false;
                }
                if (nodeOne.val != nodeTwo.val) {
                    return false;
                }
                queue.add(new TreeNode[]{nodeOne.left, nodeTwo.right});
                queue.add(new TreeNode[]{nodeOne.right, nodeTwo.left});
            }
        }
        return true;
    }
}
