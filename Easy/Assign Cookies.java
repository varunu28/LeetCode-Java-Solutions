class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i=0;i<g.length;i++) {
            for (int j=0;j<s.length;j++) {
                if (g[i] <= s[j]) {
                    s[j] = 0;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
