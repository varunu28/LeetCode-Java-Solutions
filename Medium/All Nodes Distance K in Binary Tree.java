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
    
    public Map<TreeNode, TreeNode> parentMap;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parentMap = new HashMap<>();
        addParentHelper(root, null);
        
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int currLevel = 0;
        
        queue.add(target);
        
        while (!queue.isEmpty() && currLevel != K) {
            int size = queue.size();
            
            while (size-- > 0) {
                TreeNode removed = queue.remove();
                visited.add(removed);
                TreeNode parent = parentMap.get(removed);
                
                if (removed.left != null && !visited.contains(removed.left)) {
                    queue.add(removed.left);
                }
                
                if (removed.right != null && !visited.contains(removed.right)) {
                    queue.add(removed.right);
                }
                
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                }
            }
            
            currLevel++;
        }
        
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.remove().val);
        }
        
        return list;
    }
    
    private void addParentHelper(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        
        parentMap.put(node, parent);
        
        addParentHelper(node.left, node);
        addParentHelper(node.right, node);
    }
}
