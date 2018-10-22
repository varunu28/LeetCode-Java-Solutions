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
    public StringBuilder  sb;
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        sb = new StringBuilder();
        serializeHelper(root);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root) {
        if (root == null) {
            sb.append('#').append(',');
            return;
        }

        sb.append(root.val).append(',');
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(q);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String s = queue.remove();
        if (s.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
