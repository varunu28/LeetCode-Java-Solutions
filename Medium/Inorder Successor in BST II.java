/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        
        // If right node exists => Find lowest value in right node. 
        if (x.right != null) {
            Node node = x.right;
            
            while (node.left != null) {
                node = node.left;
            }
            
            return node;
        }
        
        // Find the first left which a node took to reach the node x
        Node parent = x.parent;
        Node lastNode = x;
        Node lastLeft = null;
        
        while (parent != null) {
            if (parent.left == lastNode && lastLeft == null) {
                lastLeft = parent;
            }
            
            lastNode = parent;
            parent = parent.parent;
        }
        
        return lastLeft;
    }
}
