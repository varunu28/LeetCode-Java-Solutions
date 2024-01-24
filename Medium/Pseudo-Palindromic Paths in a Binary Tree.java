/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] result = {0};
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map, result);
        return result[0];
    }

    private void helper(TreeNode root, Map<Integer, Integer> map, int[] result) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (root.left == null && root.right == null) {
            if (isPseudoPalindromic(map)) {
                result[0]++;
            }
        }
        helper(root.left, map, result);
        helper(root.right, map, result);
        map.put(root.val, map.getOrDefault(root.val, 0) - 1);
    }

    private static boolean isPseudoPalindromic(Map<Integer, Integer> map) {
        boolean oddFound = false;
        for (Integer key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                if (oddFound) {
                    return false;
                }
                oddFound = true;
            }
        }
        return true;
    }
}
