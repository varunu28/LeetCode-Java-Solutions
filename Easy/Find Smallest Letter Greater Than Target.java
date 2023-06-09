class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        int idx = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (letters[mid] > target) {
                idx = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx == -1 ? letters[0] : letters[idx];
    }
}
