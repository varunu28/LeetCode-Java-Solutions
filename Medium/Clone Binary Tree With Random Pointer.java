/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        Map<Node, NodeCopy> map = new HashMap<>();
        copyOnlyNode(root, map);
        copyNodePointers(root, map);
        return map.get(root);
    }
    
    private void copyNodePointers(Node root, Map<Node, NodeCopy> map) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node removed = queue.remove();
            NodeCopy copied = map.get(removed);
            if (removed.left != null) {
                queue.add(removed.left);
                copied.left = map.get(removed.left);
            }
            if (removed.right != null) {
                queue.add(removed.right);
                copied.right = map.get(removed.right);
            }
            if (removed.random != null) {
                copied.random = map.get(removed.random);
            }
        }
    }
    
    private void copyOnlyNode(Node root, Map<Node, NodeCopy> map) {
        if (root == null) {
            return;
        }
        NodeCopy copiedNode = new NodeCopy(root.val);
        map.put(root, copiedNode);
        copyOnlyNode(root.left, map);
        copyOnlyNode(root.right, map);
    }
}
