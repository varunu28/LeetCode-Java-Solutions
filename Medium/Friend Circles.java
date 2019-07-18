class Solution {
    public int findCircleNum(int[][] M) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    map.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                }
            }
        }
        
        return dfs(map, M.length);
    }
    
    private int dfs(Map<Integer, Set<Integer>> map, int n) {
        int count = 0;
        Set<Integer> seen = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if (!seen.contains(i)) {
                dfsHelper(i, seen, map);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfsHelper(int idx, Set<Integer> seen, Map<Integer, Set<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            seen.add(removed);
            
            for (int friend : map.getOrDefault(removed, new HashSet<>())) {
                if (!seen.contains(friend)) {
                    queue.add(friend);
                }
            }
        }
    }
}
