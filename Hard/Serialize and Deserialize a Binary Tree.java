/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    StringBuilder sb;
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        serializeHelper(root);
        
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root) {
        if (root == null) {
            sb.append("null").append(",");
        }
        else {
            sb.append(root.val).append(",");
            serializeHelper(root.left);
            serializeHelper(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        
        return deserializeHelper(queue);
    }
    
    private TreeNode deserializeHelper(Queue<String> queue) {
        String value = queue.remove();
        if (value.equals("null")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
