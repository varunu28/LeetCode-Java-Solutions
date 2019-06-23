class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Integer> end = new PriorityQueue<>(Comparator.comparingInt(o -> trips[o][2]));
        Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
        end.add(0);
        int currCapacity = trips[0][0];
        for (int i = 1; i < trips.length; i++) {
            while (!end.isEmpty() && trips[i][1] >= trips[end.peek()][2]) {
                currCapacity -= trips[end.poll()][0];
            }

            if (currCapacity + trips[i][0] > capacity) {
                return false;
            }

            currCapacity += trips[i][0];
            end.add(i);
        }

        return true;
    }
}
