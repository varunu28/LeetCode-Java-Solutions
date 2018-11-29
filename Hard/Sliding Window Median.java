class Solution {
    List<Long> list;
    double[] ans;
    boolean isEven;

    public double[] medianSlidingWindow(int[] nums, int k) {
        list = new ArrayList<>();
        ans = new double[nums.length - k + 1];
        isEven = k % 2 == 0;

        for (int i=0; i<k; i++) {
            list.add((long) nums[i]);
        }

        Collections.sort(list);
        int idx = 0;
        ans[idx++] = getMedian();

        for (int i=k; i<nums.length; i++) {
            removeElement(nums[idx - 1]);
            int tempIdx = getBinarySearchIdx(nums[i]);
            list.add(tempIdx, (long) nums[i]);

            ans[idx++] = getMedian();
        }

        return ans;
    }

    private int getBinarySearchIdx(int num) {
        if (list.size() == 0 || num < list.get(0)) {
            return 0;
        }
        if (num > list.get(list.size() - 1)) {
            return list.size();
        }

        int start = 0;
        int end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (list.get(mid) < num) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }

        return end;
    }

    private void removeElement(int num) {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) == num) {
                list.remove(i);
                break;
            }
        }
    }

    private double getMedian() {
        if (isEven) {
            return (double) (list.get(list.size()/2) + list.get(list.size()/2 - 1)) / 2;
        }
        else {
            return (double) list.get(list.size()/2);
        }
    }
}
