/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    TreeNode root;
    Set<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        buildTree(root, 0);
    }
    
    private void buildTree(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        root.val = val;
        set.add(val);
        buildTree(root.left, 2 * val + 1);
        buildTree(root.right, 2 * val + 2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
