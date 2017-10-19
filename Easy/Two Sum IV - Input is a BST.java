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
        if (root == null) return false;
        List<Integer> list = new ArrayList<>();
        
        inOrder(root,list);

        for (int i=0;i<list.size();i++) {
            if(list.indexOf(k-list.get(i)) != -1 && list.indexOf(k-list.get(i)) != i) {
                return true;
            }
        }
        return false;
    }
    
    public void inOrder(TreeNode root,List<Integer> list) {
        if (root == null)return;
        
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
