/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int numOfNodes = (int) Math.pow(2, height) - 1;

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < numOfNodes; j++) {
                temp.add("");
            }

            ans.add(temp);
        }

        updateList(ans, root, 0, 0, numOfNodes);

        return ans;
    }

    private void updateList (List<List<String>> ans, TreeNode root, int idx, int start, int end) {
        if (root == null) {
            return;
        }

        int mid = (start + end) / 2;

        ans.get(idx).set(mid, String.valueOf(root.val));
        updateList(ans, root.left, idx + 1, start, mid - 1);
        updateList(ans, root.right, idx + 1, mid + 1, end);
    }

    private int getHeight (TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
