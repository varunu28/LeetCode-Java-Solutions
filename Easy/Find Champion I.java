import java.util.Map.Entry;

class Solution {
    public int findChampion(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
        }
        return map.entrySet()
            .stream()
            .filter(entry -> entry.getValue() == grid.length - 1)
            .findFirst()
            .map(Entry::getKey)
            .orElse(-1);
    }
}
