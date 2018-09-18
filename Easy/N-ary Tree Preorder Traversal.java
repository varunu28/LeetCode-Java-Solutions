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
    List<Integer> values = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        updateListIterative(root);
        return values;
    }
    
    private void updateListIterative(Node root) {
        if (root == null) {
            return;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node temp = stack.pop();
            values.add(temp.val);
            
            List<Node> childrens = temp.children;
            
            for (int i=childrens.size()-1; i>=0; i--) {
                stack.push(childrens.get(i));
            }
        }
    }
    
    private void updateListRecursive(Node root) {
        if (root == null) {
            return;
        }
        
        values.add(root.val);
        for (Node node : root.children) {
            updateListRecursive(node);
        }
    }
}
