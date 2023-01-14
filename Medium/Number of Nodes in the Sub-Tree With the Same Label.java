class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int[] result = new int[n];
        Set<Integer> visited = new HashSet<>();
        bfs(tree, 0, labels, result, visited);
        return result;
    } 
    
    private int[] bfs(Map<Integer, List<Integer>> tree, int currNode, String labels, int[] result, Set<Integer> visited) {
        int[] labelCount = new int[26];
        if (visited.add(currNode)) {
            labelCount[labels.charAt(currNode) - 'a']++;
            for (Integer child : tree.getOrDefault(currNode, new ArrayList<>())) {
                int[] childLabelCount = bfs(tree, child, labels, result, visited);
                for (int i = 0; i < 26; i++) {
                    labelCount[i] += childLabelCount[i];
                }
            }
            result[currNode] += labelCount[labels.charAt(currNode) - 'a'];
        }
        return labelCount;
    }
}
