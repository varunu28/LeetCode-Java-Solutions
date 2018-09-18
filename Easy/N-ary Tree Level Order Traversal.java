/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> values = new ArrayList<>();
        
        if (root == null) {
            return values;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            
            while(n-- > 0) {
                Node node = queue.remove();
                temp.add(node.val);
                List<Node> childrens = node.children;
                queue.addAll(childrens);
            }
            
            values.add(temp);
        }
        
        return values;
    }
}
