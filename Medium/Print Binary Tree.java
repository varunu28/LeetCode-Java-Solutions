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

    List<List<String>> ans = new ArrayList<>();
        
    public List<List<String>> printTree(TreeNode root) {
        int row = height(root);
        int col = (int)(Math.pow(2, row) - 1);
        
        List<String> oneRow = new ArrayList<>();
        
        for (int i=0;i<col;i++) {
            oneRow.add("");
        }
        
        for (int i=0;i<row;i++) {
            ans.add(new ArrayList<>(oneRow));
        }
        
        helper(0, 0, col, root);
        
        return ans;
    }
    
    public void helper(int rowNum, int start, int end, TreeNode root) {
    
        if (root == null) return;
        
        int mid = (start + end)/2;
        
        List<String> temp = ans.get(rowNum);
        temp.set(mid, String.valueOf(root.val));
        
        ans.set(rowNum, temp);
        
        helper(rowNum+1, start, mid-1, root.left);
        helper(rowNum+1, mid+1, end, root.right);
    }
    
    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
