class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int startIdx = result.size();
            while (num > 0) {
                result.add(num % 10);
                num /= 10;
            }
            int endIdx = result.size() - 1;
            while (startIdx < endIdx) {
                int temp = result.get(startIdx);
                result.set(startIdx++, result.get(endIdx));
                result.set(endIdx--, temp);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
