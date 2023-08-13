class Solution {
    public int maxSum(int[] nums) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int num : nums) {
            int maxDigit = getMaxDigit(num);
            if (!map.containsKey(maxDigit)) {
                map.put(maxDigit, new Pair());
            }
            map.get(maxDigit).record(num);
        }
        int result = -1;
        for (Integer key : map.keySet()) {
            result = Math.max(result, map.get(key).getPairSum());
        }
        return result;
    }
    
    private int getMaxDigit(int num) {
        int maxDigit = 0;
        while (num > 0) {
            maxDigit = Math.max(maxDigit, num % 10);
            num /= 10;
        }
        return maxDigit;
    }
    
    private static class Pair {
        int maximum;
        int secondMaximum;
        
        public Pair() {
            maximum = -1;
            secondMaximum = -1;
        }
        
        public void record(int num) {
            if (maximum < num) {
                if (secondMaximum < maximum) {
                    secondMaximum = maximum;
                }
                maximum = num;
            } else if (secondMaximum < num) {
                secondMaximum = num;
            }
        }
        
        public int getPairSum() {
            if (maximum == -1 || secondMaximum == -1) {
                return -1;
            }
            return maximum + secondMaximum;
        }
    }
}
