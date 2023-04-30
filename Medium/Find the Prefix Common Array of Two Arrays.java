class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
            count += map.get(A[i]) == 2 ? 1 : 0;
            if (A[i] != B[i]) {
                count += map.get(B[i]) == 2 ? 1 : 0;
            }
            result[i] = count;
        }
        return result;
    }
}
