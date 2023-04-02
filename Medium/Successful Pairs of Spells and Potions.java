class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            result[i] = findCountOfSuccessfulPotion(potions, success, (long) spells[i]);
        }
        return result;
    }
    
    private int findCountOfSuccessfulPotion(int[] potions, long success, long spell) {
        int left = 0;
        int right = potions.length - 1;
        int minIdx = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (potions[mid] * spell >= success) {
                minIdx = Math.min(minIdx, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minIdx == Integer.MAX_VALUE ? 0 : (potions.length - minIdx);
    }
}
