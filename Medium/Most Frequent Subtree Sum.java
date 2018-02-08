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
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        populateSum(root);
        
        int count = 0;
        
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if (entry.getValue() == max) {
                count++;
            }
        }
        
        int[] ans = new int[count];
        int i = 0;
        
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if (entry.getValue() == max) {
                ans[i] = entry.getKey();
                i++;
            }
        }
        
        return ans;
    }
    
    public void populateSum(TreeNode root) {
        
        if (root == null) return; 
        int sum = getSum(root);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        max = Math.max(max, map.get(sum));
        
        populateSum(root.left);
        populateSum(root.right);
        
    }
    
    public int getSum(TreeNode root) {
        if (root == null) return 0;
        
        int sum = root.val;
        return sum + getSum(root.left) + getSum(root.right);
    }
}
