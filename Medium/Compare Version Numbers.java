class Solution {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int v1Start = 0;
        int v2Start = 0;

        while (v1Start < v1.length || v2Start < v2.length) {

            if (v1Start < v1.length && v2Start < v2.length) {
                if (Integer.parseInt(v1[v1Start]) < Integer.parseInt(v2[v2Start])) {
                    return -1;
                } else if (Integer.parseInt(v1[v1Start]) > Integer.parseInt(v2[v2Start])) {
                    return 1;
                }

                v1Start++;
                v2Start++;
            }
            else if (v1Start < v1.length && v2Start == v2.length) {
                if (Integer.parseInt(v1[v1Start]) > 0) {
                    return 1;
                }
                else {
                    v1Start++;
                }
            }
            else {
                if (Integer.parseInt(v2[v2Start]) > 0) {
                    return -1;
                }
                else {
                    v2Start++;
                }
            }
        }

        return 0;
    }
}
