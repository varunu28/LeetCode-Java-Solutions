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
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return list;
        
        Stack<Integer> path = new Stack<>();
        
        pathSumImpl(root, sum, path);
        return list;
    }
    
    private void pathSumImpl(TreeNode root, int sum, Stack<Integer> path) {
        path.push(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                list.add(new ArrayList<Integer>(path));
            }
        }
        
        if (root.left != null) {
            pathSumImpl(root.left, sum-root.val, path);
        }
        
        if (root.right != null) {
            pathSumImpl(root.right, sum-root.val, path);
        }
        
        path.pop();
    }
}
