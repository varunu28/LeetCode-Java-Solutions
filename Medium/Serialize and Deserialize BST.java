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
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString().trim();
    }
    
    private void dfsSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(" ");
            return;
        }
        sb.append(root.val).append(" ");
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split("\\s+")));
        return dfsDeserialize(queue);
    }
    
    private TreeNode dfsDeserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String removed = queue.remove();
        if (removed.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(removed));
        root.left = dfsDeserialize(queue);
        root.right = dfsDeserialize(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
