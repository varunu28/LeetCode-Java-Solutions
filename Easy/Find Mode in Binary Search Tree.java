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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        inorderTraversal(root, map);
        
        int maxVal = 0;
        int count = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                count = 1;
            }    
            else if (entry.getValue() == maxVal) {
                count++;
            }    
        }
        
        int[] ans = new int[count];
        int i = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxVal) {
                ans[i++] = entry.getKey();
            }
        }
        
        return ans;
        
    }
    
    public void inorderTraversal(TreeNode root, Map<Integer, Integer> map) {
        
        if (root == null) return;
        
        inorderTraversal(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inorderTraversal(root.right, map);
    }
}
