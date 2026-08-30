class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, NumData> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], _ -> new NumData());
            map.get(nums[i]).record(i);
        }
        int result = 0;
        return (int) map.values()
            .stream()
            .filter(NumData::isSpecial)
            .count();
    }

    private class NumData {
        private int left;
        private int right;
        private int frequency;

        public NumData() {
            this.left = -1;
            this.right = -1;
            this.frequency = 0;
        }

        public void record(int index) {
            this.frequency++;
            if (this.left == -1) {
                this.left = index;
            }
            this.right = index;
        }

        public boolean isSpecial() {
            return this.right - this.left + 1 == this.frequency;
        }
    }
}
