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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = getInorderNodes(root);
        return createBST(inorder, 0, inorder.size() - 1);
    }

    private List<Integer> getInorderNodes(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            TreeNode rightNode = node.right;
            while (rightNode != null) {
                stack.push(rightNode);
                rightNode = rightNode.left;
            }
        }
        return list;
    }

    private TreeNode createBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode leftTree = createBST(list, start, mid - 1);
        TreeNode rightTree = createBST(list, mid + 1, end);
        return new TreeNode(list.get(mid), leftTree, rightTree);
    }
}
