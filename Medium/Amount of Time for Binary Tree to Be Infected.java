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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        buildNodeToParentRelationship(root, null, nodeToParent);
        TreeNode startNode = nodeToParent.keySet()
            .stream()
            .filter(node -> node.val == start)
            .findFirst()
            .orElse(null);
        return calculateInfectionTime(nodeToParent, startNode);
    }

    private void buildNodeToParentRelationship(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> nodeToParent) {
        if (root == null) {
            return;
        }
        nodeToParent.put(root, parent);
        buildNodeToParentRelationship(root.left, root, nodeToParent);
        buildNodeToParentRelationship(root.right, root, nodeToParent);
    }

    private int calculateInfectionTime(Map<TreeNode, TreeNode> nodeToParent, TreeNode startNode) {
        int time = 0;
        Set<Integer> isInfected = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        isInfected.add(startNode.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode removed = queue.remove();
                TreeNode parent = nodeToParent.get(removed);
                if (nodeToParent.get(removed) != null && isInfected.add(nodeToParent.get(removed).val)) {
                    queue.add(nodeToParent.get(removed));
                }
                if (removed.left != null && isInfected.add(removed.left.val)) {
                    queue.add(removed.left);
                }
                if (removed.right != null && isInfected.add(removed.right.val)) {
                    queue.add(removed.right);
                }
            }
            if (queue.isEmpty()) {
                break;
            }
            time++;
        }
        return time;
    }
}
