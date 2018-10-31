class Solution {
    public int firstMissingPositive(int[] arr) {
        if (arr.length == 0) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        int temp = 1;

        while (temp <= max) {
            if (set.contains(temp) == false && temp > 0) {
                return temp;
            }

            temp++;
        }

        return max + 1 == 0 ? 1 : max+1;
    }
}
