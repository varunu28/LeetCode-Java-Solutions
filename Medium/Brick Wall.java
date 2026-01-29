class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> positionToGapMap = new HashMap<>();
        for (List<Integer> row : wall) {
            int position = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                position += row.get(i);
                positionToGapMap.put(position, positionToGapMap.getOrDefault(position, 0) + 1);
            }
        }
        int result = wall.size();
        for (Integer val : positionToGapMap.values()) {
            result = Math.min(result, wall.size() - val);
        }
        return result;
    }
}
