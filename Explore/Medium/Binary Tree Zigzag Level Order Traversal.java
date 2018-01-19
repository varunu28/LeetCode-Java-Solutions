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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if (root == null) return ans; 
        
        s1.push(root);
        
        while (!s1.empty() || !s2.empty()) {
            
            List<Integer> list = new ArrayList<>();
            
            while (!s1.empty()) {
                TreeNode temp = s1.pop();

                list.add(temp.val);

                if (temp.left != null) {
                    s2.add(temp.left);
                }
                
                if (temp.right != null) {
                    s2.add(temp.right);
                }
            }
            
            if (list.size() > 0) {
                ans.add(list);
                continue;
            }
            
            while (!s2.empty()) {
                TreeNode temp = s2.pop();
                list.add(temp.val);

                if (temp.right != null) {
                    s1.add(temp.right);
                }
                
                if (temp.left != null) {
                    s1.add(temp.left);
                }

            }
            
            ans.add(list);
        }
        
        return ans;
    }
}
