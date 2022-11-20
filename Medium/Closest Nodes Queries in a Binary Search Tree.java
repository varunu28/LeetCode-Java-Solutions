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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        traverse(root, set);
        List<List<Integer>> result = new ArrayList<>();
        for (Integer query : queries) {
            Integer lower = set.floor(query);
            Integer upper = set.ceiling(query);
            result.add(Arrays.asList((lower == null ? -1 : lower), (upper == null ? -1 : upper)));
        }
        return result;
    }
    
    private void traverse(TreeNode root, TreeSet<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        traverse(root.left, set);
        traverse(root.right, set);
    }
}
