class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        for (int[] indice : indices) {
            rowMap.put(indice[0], rowMap.getOrDefault(indice[0], 0) + 1);
            colMap.put(indice[1], colMap.getOrDefault(indice[1], 0) + 1);   
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = 0;
                temp += rowMap.getOrDefault(i, 0);
                temp += colMap.getOrDefault(j, 0);
                count += temp % 2;
            }
        }
        return count;
    }
}
