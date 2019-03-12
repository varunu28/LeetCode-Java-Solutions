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
    PriorityQueue<TreeNode> pq;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        pq = new PriorityQueue<TreeNode>(k, new Comparator<TreeNode>() {
           public int compare(TreeNode o1, TreeNode o2) {
               return Double.valueOf(Math.abs(target - o2.val)).compareTo(Double.valueOf(Math.abs(target - o1.val)));
           } 
        });
        
        helper(root, k);
        
        List<Integer> list = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            list.add(pq.poll().val);
        }
        
        Collections.reverse(list);
        
        return list;
    }
    
    private void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        
        pq.add(root);
        if (pq.size() > k) {
            pq.poll();
        }
        
        helper(root.left, k);
        helper(root.right, k);
    }
}
