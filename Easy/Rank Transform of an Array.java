class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        int rank = 1;
        Map<Integer, Integer> numToRank = new HashMap<>();
        for (int num : arr) {
            if (numToRank.containsKey(num)) {
                continue;
            }
            numToRank.put(num, rank++);
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = numToRank.get(copyArr[i]);
        }
        return result;
    }
}
