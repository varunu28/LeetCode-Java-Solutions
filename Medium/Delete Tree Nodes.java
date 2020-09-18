class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        for (int i = nodes - 1; i > 0; i--) {
            value[parent[i]] += value[i];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nodes; i++) {
            if (set.contains(parent[i])) {
                value[i] = 0;
            }
            if (value[i] == 0) {
                set.add(i);
            }
        }
        return nodes - set.size();
    }
}
