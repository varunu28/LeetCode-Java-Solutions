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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int res = 1;
        
        while (list.size() != 0) {
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode node : list) {
                if(node == null) {
                    temp.add(null);
                    temp.add(null);
                }
                else {
                    temp.add(node.left);
                    temp.add(node.right);
                }
            }
            
            temp = removeExtraNull(temp);
            res = Math.max(res, temp.size());
            list = temp;
        }
        
        return res;
    }
    
    private List<TreeNode> removeExtraNull(List<TreeNode> list) {
        List<TreeNode> ans = new ArrayList<>();
        if (list.size() == 0) {
            return ans;
        }
        
        int start = 0;
        int end = list.size() - 1;
        
        while (start <= end && list.get(start) == null) {
            start++;
        }
        
        while (end >= 0 && list.get(end) == null) {
            end--;
        }
        
        while (start <= end) {
            ans.add(list.get(start++));
        }
        
        return ans;
    }
}
