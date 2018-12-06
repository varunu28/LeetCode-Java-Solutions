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
    Map<String, TreeNode> map;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        
        helper(root);
        
        for (TreeNode node : map.values()) {
            if (node != null) {
                ans.add(node);
            }
        }
        
        return ans;
    }

    private String helper(TreeNode root) {
        if (root == null) {
            return "#";
        }
        
        String path = root.val + "|" + helper(root.left) + "|" + helper(root.right);
        map.put(path, map.containsKey(path) ? root : null);
        
        return path;
    }
}
