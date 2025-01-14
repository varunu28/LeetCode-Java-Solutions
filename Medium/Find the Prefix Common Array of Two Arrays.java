class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int count = 0;
        int n = A.length;
        int[] result = new int[n];
        int[] frequency = new int[n + 1];
        for (int i = 0; i < n; i++) {
            frequency[A[i]]++;
            if (frequency[A[i]] == 2) {
                count++;
            }
            frequency[B[i]]++;
            if (frequency[B[i]] == 2) {
                count++;
            }
            result[i] = count;
        }
        return result;
    }
}
