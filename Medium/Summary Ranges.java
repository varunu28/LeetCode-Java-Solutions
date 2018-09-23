class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        if (nums.length == 0) {
            return ranges;
        }

        int count = 1;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        int n = nums.length-1;

        while (i < n) {
            if (nums[i+1] - nums[i] == 1) {
                count++;
            }
            else {
                if (count > 1) {
                    sb.append("->").append(nums[i]);
                    ranges.add(sb.toString());
                    count = 1;
                }
                else {
                    ranges.add(sb.toString());
                }
                sb = new StringBuilder();
                sb.append(nums[i+1]);
            }

            i++;
        }

        if (count > 1) {
            sb.append("->").append(nums[i]);
            ranges.add(sb.toString());
        }
        else {
            ranges.add(sb.toString());
        }

        return ranges;
    }
}
