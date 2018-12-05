/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node prev;
    public Node treeToDoublyList(Node r) {
        if (r == null) {
            return r;
        }
        
        prev = null;
        Node dummy = new Node(0);
        prev = dummy;
        
        inorderHelper(r);
        
        prev.right = dummy.right;
        dummy.right.left = prev;
        
        return dummy.right;
    }
    
    private void inorderHelper(Node root) {
        if (root == null) {
            return;
        }
        
        inorderHelper(root.left);
        
        prev.right = root;
        root.left = prev;
        prev = root;
        
        inorderHelper(root.right);
    }
}
