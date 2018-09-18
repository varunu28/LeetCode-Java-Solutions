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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) {
            return values;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.empty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);

            if (temp.left != null) {
                stack1.push(temp.left);
            }

            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }

        while (!stack2.empty()) {
            values.add(stack2.pop().val);
        }
        
        return values;
    }
}
