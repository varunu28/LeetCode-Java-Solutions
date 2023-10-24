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
    public TreeNode correctBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, null));
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<TreeNode> visited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.remove();
                TreeNode node = pair.node();
                TreeNode parent = pair.parent();
                if (visited.contains(node.right)) {
                    if (parent.left == node) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    return root;
                }
                visited.add(node);
                if (node.right != null) {
                    queue.add(new Pair(node.right, node));
                }
                if (node.left != null) {
                    queue.add(new Pair(node.left, node));
                }
            }
        }
        return root;
    }

    private static record Pair(TreeNode node, TreeNode parent) {}
}
