class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        List<List<Integer>> result = new ArrayList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        pq.add(new int[]{0, 0, nums1[0] + nums2[0]});
        visited.add(new Pair<Integer, Integer>(0, 0));
        while (k-- > 0 && !pq.isEmpty()) {
            int[] removed = pq.poll();
            int i = removed[0];
            int j = removed[1];
            result.add(List.of(nums1[i], nums2[j]));
            Pair<Integer, Integer> nums1Pair = new Pair<Integer, Integer>(i + 1, j);
            Pair<Integer, Integer> nums2Pair = new Pair<Integer, Integer>(i, j + 1);
            if (i + 1 < nums1.length && !visited.contains(nums1Pair)) {
                pq.add(new int[]{i + 1, j, nums1[i + 1] + nums2[j]});
                visited.add(nums1Pair);
            }
            if (j + 1 < nums2.length && !visited.contains(nums2Pair)) {
                pq.add(new int[]{i, j + 1, nums1[i] + nums2[j + 1]});
                visited.add(nums2Pair);
            }
        }
        return result;
    }
}
