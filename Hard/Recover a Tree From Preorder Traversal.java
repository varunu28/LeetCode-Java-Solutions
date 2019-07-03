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
    public TreeNode recoverFromPreorder(String S) {
        Map<Integer, TreeNode> map = new HashMap<>();
        int idx = 0;
        int n = S.length();

        while (idx < n) {
            int level = 0;
            StringBuilder sb = new StringBuilder();

            while (idx < n && S.charAt(idx) == '-') {
                level++;
                idx++;
            }

            while (idx < n && Character.isDigit(S.charAt(idx))) {
                sb.append(S.charAt(idx++));
            }

            TreeNode currNode = new TreeNode(Integer.parseInt(sb.toString()));
            map.put(level, currNode);
            if (level > 0) {
                TreeNode parent = map.get(level - 1);
                if (parent.left == null) {
                    parent.left = currNode;
                }
                else {
                    parent.right = currNode;
                }
            }
        }

        return map.get(0);
    }
}
