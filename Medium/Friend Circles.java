class Solution {
    public int findCircleNum(int[][] M) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<M.length; i++) {
            for (int j=0; j<M[i].length; j++) {
                if (M[i][j] == 1) {
                    map.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    map.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (set.contains(entry.getKey())) {
                continue;
            }

            queue.add(entry.getKey());

            while (!queue.isEmpty()) {
                int popped = queue.remove();
                set.add(popped);
                List<Integer> list = map.get(popped);

                for (Integer integer : list) {
                    if (!set.contains(integer)) {
                        queue.add(integer);
                    }
                }
            }

            count++;
        }

        return count;
    }
}
