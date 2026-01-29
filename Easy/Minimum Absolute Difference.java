class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int num : arr) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }
        // This is done so that smallest element in the array points to index 0
        int shift = -minValue;
        int[] line = new int[maxValue - minValue + 1];
        for (int num : arr) {
            line[num + shift] = 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        int minPairDiff = maxValue - minValue;
        int prev = 0;
        for (int curr = 1; curr <= maxValue + shift; curr++) {
            if (line[curr] == 0) {
                continue;
            }
            if (curr - prev == minPairDiff) {
                result.add(List.of(prev - shift, curr - shift));
            } else if (curr - prev < minPairDiff) {
                minPairDiff = curr - prev;
                result.clear();
                result.add(List.of(prev - shift, curr - shift));
            }
            prev = curr;
        }
        return result;
    }
}
