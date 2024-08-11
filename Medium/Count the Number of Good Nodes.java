class Solution {
    public int countGoodNodes(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }        
        int[] result = {0};
        recurse(map, result, 0, -1);
        return result[0];
    }

    private int recurse(Map<Integer, Set<Integer>> map, int[] result, int node, int prevNode) {
        int count = -1;
        int total = 1;
        boolean flag = true;
        for (Integer conn : map.getOrDefault(node, new HashSet<>())) {
            if (conn == prevNode) {
                continue;
            }
            int temp = recurse(map, result, conn, node);
            total += temp;
            if (count == -1) {
                count = temp;
            } else if (count != temp) {
                flag = false;
            }
        }
        if (flag) {
            result[0]++;
        }
        return total;
    }
}
