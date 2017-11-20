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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        TreeNode curr = root;
    
        while(curr != null) {
            s.push(curr);
            curr = curr.left;
        }
        
        while(s.size() > 0) {
            curr = s.pop();
            arr.add(curr.val);
            
            if (curr.right != null) {
                curr = curr.right;
                
                while(curr != null) {
                    s.push(curr);
                    curr = curr.left;
                }
            }
        }
        
        return arr;
    }
}
