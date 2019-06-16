class Solution {
    public int[][] highFive(int[][] items) {
        final int COUNT = 5;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];

            map.computeIfAbsent(id, k -> new PriorityQueue<>(COUNT, Comparator.naturalOrder())).add(score);

            if (map.get(id).size() > COUNT) {
                map.get(id).poll();
            }

            set.add(id);
        }

        int[][] ans = new int[map.size()][2];
        int idx = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int id = iterator.next();
            PriorityQueue<Integer> scores = map.get(id);
            int sum = 0;

            while (!scores.isEmpty()) {
                sum += scores.poll();
            }

            ans[idx++] = new int[]{id, sum / COUNT};
        }

        return ans;
    }
}
