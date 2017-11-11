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
    ArrayList<Integer> values = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        
        int min = Integer.MAX_VALUE;
        for (int i=1;i<values.size();i++) {
            min = Math.min(min, Math.abs(values.get(i)-values.get(i-1)));
        }
        
        return min;
    }
    
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        values.add(root.val);
        inOrder(root.right);
    }
}
