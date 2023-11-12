class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, Set<Integer>> stopToBusMapping = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBusMapping.computeIfAbsent(stop, k -> new HashSet<>()).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int route : stopToBusMapping.get(source)) {
            queue.add(route);
            visited.add(route);
        }
        int buses = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int removed = queue.remove();
                for (int stop : routes[removed]) {
                    if (stop == target) {
                        return buses;
                    }
                    for (int nextBus : stopToBusMapping.getOrDefault(stop, new HashSet<>())) {
                        if (!visited.contains(nextBus)) {
                            visited.add(nextBus);
                            queue.add(nextBus);
                        }
                    }
                }
            }
            buses++;
        }
        return -1;
    }
}
