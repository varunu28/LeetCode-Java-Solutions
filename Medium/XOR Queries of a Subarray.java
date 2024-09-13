class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXors = new int[n];
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];
            prefixXors[i] = xor;
        }
        n = queries.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            int xorResult = prefixXors[right];
            if (left != 0) {
                xorResult = xorResult ^ prefixXors[left - 1];
            }
            result[i] = xorResult;
        }
        return result;
    }
}
