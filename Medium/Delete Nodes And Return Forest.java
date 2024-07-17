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
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        Set<Integer> set = new HashSet<>();
        for (int val : toDelete) {
            set.add(val);
        }
        List<TreeNode> result = new ArrayList<>();
        recurse(root, result, set, null);
        return result;
    }

    private void recurse(TreeNode root, List<TreeNode> result, Set<Integer> set, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (set.contains(root.val)) {
            if (parent != null && parent.left == root) {
                parent.left = null;
            } else if (parent != null && parent.right == root) {
                parent.right = null;
            }
            recurse(root.left, result, set, null);
            recurse(root.right, result, set, null);
            return;
        }
        if (parent == null) {
            result.add(root);
        }
        recurse(root.left, result, set, root);
        recurse(root.right, result, set, root);
    }
}
