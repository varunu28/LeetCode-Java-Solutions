class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for (int fruit : fruits) {
            int idx = -1;
            for (int i = 0; i < baskets.length; i++) {
                if (baskets[i] >= fruit) {
                    idx = i;
                    break;
                }
            }
            if (idx == -1) {
                count++;
            } else {
                baskets[idx] = -1;
            }
        }
        return count;
    }
}
