class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int n = s.length();
        int[][] prefixSum = new int[26][n];
        for (int i = 0; i < n; i++) {
            prefixSum[s.charAt(i) - 'a'][i]++;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j < n; j++) {
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int count = 0;
            for (int c = 0; c < 26; c++) {
                int leftFreq = left == 0 ? 0 : prefixSum[c][left - 1];
                int rightFreq = prefixSum[c][right];
                int freqInRange = rightFreq - leftFreq;
                count += (freqInRange * (freqInRange + 1)) / 2;
            }
            result[i] = count;
        }
        return result;
    }
}
