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
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> leaves = new HashSet<>();
        traverse(root, null, graph, leaves);
        int result = 0;
        for (TreeNode leaf : leaves) {
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            queue.add(leaf);
            visited.add(leaf);
            for (int i = 0; i <= distance; i++) {
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode curr = queue.remove();
                    if (leaves.contains(curr) && curr != leaf) {
                        result++;
                    }
                    for (TreeNode neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                        if (visited.add(neighbor)) {
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
        return result / 2;
    }

    private void traverse(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph, Set<TreeNode> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node);
        }
        if (parent != null) {
            graph.computeIfAbsent(parent, k -> new ArrayList<>()).add(node);
            graph.computeIfAbsent(node, k -> new ArrayList<>()).add(parent);
        }
        traverse(node.left, node, graph, leaves);
        traverse(node.right, node, graph, leaves);
    }
}
