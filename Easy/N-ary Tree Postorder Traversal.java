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
    public List<Integer> postorder(Node root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) {
            return values;
        }
        
        
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.empty()) {
            Node temp = stack1.pop();
            stack2.push(temp);
            List<Node> childrens = temp.children;
            for(Node children : childrens) {
                stack1.push(children);
            }
        }

        while (!stack2.empty()) {
            values.add(stack2.pop().val);
        }
        
        return values;
    }
}
