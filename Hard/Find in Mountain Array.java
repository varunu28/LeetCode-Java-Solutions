/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int start = 1;
        int end = n - 2;
        while (start != end) {
            int mid = (start + end) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int peakIndex = start;
        start = 0;
        end = peakIndex;
        while (start != end) {
            int mid = (start + end) / 2;
            if (mountainArr.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (mountainArr.get(start) == target) {
            return start;
        }
        start = peakIndex + 1;
        end = n - 1;
        while (start != end) {
            int mid = (start + end) / 2;
            if (mountainArr.get(mid) > target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return mountainArr.get(start) == target ? start : -1;
    }
}
