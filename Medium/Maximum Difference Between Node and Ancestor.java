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
    int res=Integer.MIN_VALUE;
    int max(TreeNode root)
    {
        if(root==null) return Integer.MIN_VALUE;
        if(root.left==null && root.right==null) return root.val;
        int l=max(root.left);
        int r=max(root.right);
        int m=Math.max(l,r);
        res=Math.max(res,Math.abs(root.val-m));
        return Math.max(root.val,m);
    }
    int min(TreeNode root)
    {
        if(root==null) return Integer.MAX_VALUE;
        if(root.left==null && root.right==null) return root.val;
        int l=min(root.left);
        int r=min(root.right);
        int m=Math.min(l,r);
        res=Math.max(res,Math.abs(root.val-m));
        return Math.min(root.val,m);
    }
    public int maxAncestorDiff(TreeNode root) {
        max(root);
        min(root);
        return res;
    }
}