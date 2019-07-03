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
    int numOfSteps;
    public int distributeCoins(TreeNode root) {
        numOfSteps = 0;
        postorder(root);
        
        return numOfSteps;
    }
    
    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int coin = postorder(root.left) + postorder(root.right);
        
        if (root.val == 0) {
            coin += -1;
        }
        else {
            coin += root.val - 1;
        }
        
        numOfSteps += Math.abs(coin);
        
        return coin;
    }
}
