class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] combined = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            combined[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(combined, (o1, o2) -> o2[1] - o1[1]);
        long result = 0;
        long total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] unit : combined) {
            pq.add(unit[0]);
            total += unit[0];
            if (pq.size() > k) {
                total -= pq.poll();
            }
            if (pq.size() == k) {
                result = Math.max(result, total * unit[1]);
            }
        }
        return result;
    }
}
