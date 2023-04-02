class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(frequencyMap.keySet());
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            while (size-- > 0) {
                int removed = queue.remove();
                row.add(removed);
                if (frequencyMap.get(removed) > 1) {
                    frequencyMap.put(removed, frequencyMap.get(removed) - 1);
                    queue.add(removed);
                }
            }
            result.add(row);
        }
        return result;
    }
}
