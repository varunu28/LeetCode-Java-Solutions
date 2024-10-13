class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0]));
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (pq.size() == nums.size()) {
            int[] removed = pq.poll();
            int min = removed[0];
            int row = removed[1];
            int col = removed[2];
            if (max - min < end - start) {
                start = min;
                end = max;
            }
            if (col + 1 < nums.get(row).size()) {
                int next = nums.get(row).get(col + 1);
                pq.add(new int[]{next, row, col + 1});
                max = Math.max(max, next);
            }
        }
        return new int[]{start, end};
    }
}
