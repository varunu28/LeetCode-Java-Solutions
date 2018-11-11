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
    public int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        rangeSumBSTHelper(root, L, R);
        
        return sum;
    }
    
    private void rangeSumBSTHelper(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            rangeSumBSTHelper(root.right, low, high);
            rangeSumBSTHelper(root.left, low, high);
        }
        else {
            if (root.val < low) {
                rangeSumBSTHelper(root.right, low, high);
            }

            if (root.val > high) {
                rangeSumBSTHelper(root.left, low, high);
            }
        }
    }
}
