class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();
        int result = dfs(0, -1, arr1, arr2, dp);
        return result < 2001 ? result : -1;
    }
    
    private int dfs(int idx, int prev, int[] arr1, int[] arr2, Map<Pair<Integer, Integer>, Integer> dp) {
        if (idx == arr1.length) {
            return 0;
        }
        if (dp.containsKey(new Pair<>(idx, prev))) {
            return dp.get(new Pair<>(idx, prev));
        }
        int cost = 2001;
        if (arr1[idx] > prev) {
            cost = dfs(idx + 1, arr1[idx], arr1, arr2, dp);
        }
        int replaceIdx = binarySearch(arr2, prev);
        if (replaceIdx < arr2.length) {
            cost = Math.min(cost, 1 + dfs(idx + 1, arr2[replaceIdx], arr1, arr2, dp));
        }
        dp.put(new Pair<>(idx, prev), cost);
        return cost;
    }
    
    private static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
