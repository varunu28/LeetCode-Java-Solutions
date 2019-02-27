/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);
        
        for (Node n : node.neighbors) {
            newNode.neighbors.add(cloneGraph(n));
        }
        
        return newNode;
    }
}
