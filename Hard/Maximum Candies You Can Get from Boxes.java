class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int result = 0;
        int n = candies.length;
        boolean[] hasBox = new boolean[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) {
                queue.add(box);
                visited[box] = true;
            }
        }
        while (!queue.isEmpty()) {
            int removed = queue.poll();
            result += candies[removed];
            for (int key : keys[removed]) {
                if (status[key] == 0 && hasBox[key] && !visited[key]) {
                    visited[key] = true;
                    queue.add(key);
                }
                status[key] = 1;
            }
            for (int nextBox : containedBoxes[removed]) {
                hasBox[nextBox] = true;
                if (!visited[nextBox] && status[nextBox] == 1) {
                    visited[nextBox] = true;
                    queue.add(nextBox);
                }
            }
        }
        return result;
    }
}
