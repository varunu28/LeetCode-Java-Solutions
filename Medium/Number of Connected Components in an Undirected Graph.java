class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        
        Set<Integer> set = new HashSet<>();
        int count = 0;
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (set.contains(entry.getKey())) {
                continue;
            }
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(entry.getKey());
            set.add(entry.getKey());
            
            while (!queue.isEmpty()) {
                int popped = queue.remove();
                List<Integer> connections = map.getOrDefault(popped, new ArrayList<Integer>());
                
                for (int connection : connections) {
                    if (set.contains(connection)) {
                        continue;
                    }
                    
                    set.add(connection);
                    queue.add(connection);
                }
            }
            
            count++;
        }
        
        return count + (n - set.size());
    }
}
