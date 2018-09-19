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
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        
        return 1 + Math.max(max, 0);
    }
}
