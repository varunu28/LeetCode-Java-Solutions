class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0;
        int n = colors.length;
        for (int i = 0; i < n - 2; i++) {
            if (colors[i + 1]  != colors[i] && colors[i + 1] != colors[i + 2]) {
                count++;
            }
        }
        if (colors[n - 2] != colors[n - 1] && colors[n - 2] == colors[0]) {
            count++;
        }
        if (colors[n - 1] != colors[0] && colors[n - 1] == colors[1]) {
            count++;
        }
        return count;
    }
}
