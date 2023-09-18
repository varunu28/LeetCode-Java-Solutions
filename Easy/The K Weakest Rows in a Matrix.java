class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o -> o[0]));
        for (int i = 0; i < mat.length; i++) {
            pq.add(new int[]{i, findNumberOfSoldiers(mat[i])});
        }
        int[] result = new int[k];
        for (int i = 0; i < k && !pq.isEmpty(); i++){
            result[i] = pq.poll()[0];
        }
        return result;
    }

    private int findNumberOfSoldiers(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right < 0 ? 0 : left;
    }
}
