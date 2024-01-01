class Solution {
    public int findContentChildren(int[] greed, int[] cookieSize) {
        Arrays.sort(greed);
        Arrays.sort(cookieSize);
        int idx = 0;
        for (int i = 0; i < cookieSize.length && idx < greed.length; i++) {
            if (cookieSize[i] >= greed[idx]) {
                idx++;
            }
        }
        return idx;
    }
}
