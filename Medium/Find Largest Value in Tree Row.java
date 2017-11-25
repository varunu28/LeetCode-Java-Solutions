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
    
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
        if (root == null) return ans;
        
        ArrayList<TreeNode> arr = new ArrayList<>();
        arr.add(root);
        
        while (arr.size() != 0) {
            ArrayList<TreeNode> roots = new ArrayList<>();
            ArrayList<Integer> a = new ArrayList<>();
            
            int i = 0;
            
            while (i < arr.size()) {
                TreeNode p = arr.get(i);
                if (p.left != null) {
                    roots.add(p.left);
                }
                if (p.right != null) {
                    roots.add(p.right);
                }
                
                a.add(p.val);
                
                i++;
            }

            Collections.sort(a);
            
            ans.add(a.get(a.size()-1));
            arr.clear();
            
            i = 0;
            while(i < roots.size()) {
                arr.add(roots.get(i));
                i++;
            }
        }
        
        return ans;
    }
}
