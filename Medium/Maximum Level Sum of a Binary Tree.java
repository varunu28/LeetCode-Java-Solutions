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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = 0;
        int maxLevel = 1;
        int currLevel = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int tempSum = 0;
            while (size-- > 0) {
                TreeNode removed = queue.remove();
                tempSum += removed.val;
                if (removed.left != null) {
                    queue.add(removed.left);
                }
                if (removed.right != null) {
                    queue.add(removed.right);
                }
            }
            if (maxSum < tempSum) {
                maxSum = tempSum;
                maxLevel = currLevel;
            }
            currLevel++;
        }
        
        return maxLevel;
    }
}
