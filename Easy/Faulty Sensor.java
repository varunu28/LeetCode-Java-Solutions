class Solution {
    public int badSensor(int[] sensor1, int[] sensor2) {
        int idx = 0;
        int n = sensor1.length;
        while (idx < n && sensor1[idx] == sensor2[idx]) {
            idx++;
        }
        while (idx + 1 < n && sensor1[idx] == sensor2[idx + 1] && sensor1[idx + 1] == sensor2[idx]) {
            idx++;
        }
        return idx >= n - 1 ? -1 : sensor1[idx] == sensor2[idx + 1] ? 1 : 2;
    }
}
