class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int day = 0;

        for (int flower : flowers) {
            day++;
            set.add(flower);
            Integer lower = set.lower(flower);
            Integer higher = set.higher(flower);

            if ((lower != null && flower - lower - 1 == k) || (higher != null && higher - flower - 1 == k)) {
                return day;
            }
        }

        return -1;
    }
}
