class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int count : apple) {
            totalApples  += count;
        }
        Arrays.sort(capacity);
        int idx = capacity.length - 1;
        int currCapacity = capacity[idx--];
        while (totalApples > 0) {
            int applesDeleted = Math.min(currCapacity, totalApples);
            totalApples -= applesDeleted;
            currCapacity -= applesDeleted;
            if (currCapacity == 0 && totalApples > 0) {
                currCapacity = capacity[idx--];
            }
        }
        return capacity.length - idx - 1;
    }
}
