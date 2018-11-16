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
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new LinkedList<>();
        if (N % 2 == 0) {
            return ans;
        }
        
        return helper(N);
    }
    
    private List<TreeNode> helper(int N) {
        List<TreeNode> ans = new LinkedList<>();
        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        
        for (int i = 1; i <= N - 2; i += 2) {
            List<TreeNode> left = helper(i);
            List<TreeNode> right = helper(N - i - 1);
            
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode node = new TreeNode(0);
                    node.left = leftNode;
                    node.right = rightNode;
                    ans.add(node);
                }
            }
        }
        
        return ans;
    }
}
