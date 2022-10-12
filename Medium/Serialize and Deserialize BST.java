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
      return "";
    }
    StringBuilder sb = new StringBuilder();
    dfs(root, sb);
    return sb.toString().trim();
  }
  
  private void dfs(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append(root.val).append(" ");
    dfs(root.left, sb);
    dfs(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.length() == 0) {
      return null;
    }
    String[] split = data.split("\\s+");
    return buildBST(split, 0, split.length - 1);
  }
  
  private TreeNode buildBST(String[] data, int start, int end) {
    if (start > end) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(data[start]));
    int index;
    for (index = start; index <= end; index++) {
      if (Integer.parseInt(data[index]) > Integer.parseInt(data[start])) {
        break;
      }
    }
    root.left = buildBST(data, start + 1, index - 1);
    root.right = buildBST(data, index, end);
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
