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
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        Set<Integer> set = new HashSet<>();
        int min = popStack(stack);
        set.add(min);
        
        while (!stack.isEmpty()) {
            int num = popStack(stack);
            if (set.contains(k-num)) {
                return true;
            }
            
            if (min + num > k) {
                return false;
            }
            
            set.add(num);
        }
        
        return false;
    }
    
    private int popStack(Stack<TreeNode> stack) {
        TreeNode n = stack.pop();
        TreeNode right = n.right;
        
        while (right != null) {
            stack.push(right);
            right = right.left;
        }
        
        return n.val;
    }
}
