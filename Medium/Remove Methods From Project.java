class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] invocation : invocations) {
            graph.computeIfAbsent(invocation[0], _ -> new ArrayList<>())
                .add(invocation[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(k);
        set.add(k);
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (Integer neighbor : graph.getOrDefault(removed, new ArrayList<>())) {
                if (set.add(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        for (int[] invocation : invocations) {
            if (!set.contains(invocation[0]) && set.contains(invocation[1])) {
                return IntStream.range(0, n)
                            .boxed()
                            .toList();
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
