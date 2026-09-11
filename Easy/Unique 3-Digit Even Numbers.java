class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }
        int result = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 9; k += 2) {
                    count[i]--;
                    count[j]--;
                    count[k]--;
                    if (count[i] >= 0 && count[j] >= 0 && count[k] >= 0) {
                        result++;
                    }
                    count[i]++;
                    count[j]++;
                    count[k]++;
                }
            }
        }
        return result;
    }
}
