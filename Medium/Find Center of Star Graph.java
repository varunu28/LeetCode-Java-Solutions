class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = edges.length;
        for (int[] edge : edges) {
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == n) {
                return key;
            }
        }
        return -1;
    }
}
