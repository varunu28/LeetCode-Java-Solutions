class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            map.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            map.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int firstElement = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
        queue.add(firstElement);
        Set<Integer> set = new HashSet<>();
        int[] result = new int[n];
        int idx = 0;
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            if (set.contains(removed)) {
                continue;
            }
            result[idx++] = removed;
            set.add(removed);
            queue.addAll(map.get(removed));
        }
        return result;
    }
}
