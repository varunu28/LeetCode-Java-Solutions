class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (o1, o2) -> {
            int c = Integer.compare(o1[0], o2[0]);
            if (c != 0) {
                return c;
            }
            return Integer.compare(o2[1], o1[1]);
        });
        int meetingDays = 0;
        int idx = 0;
        while (idx < meetings.length) {
            int start = meetings[idx][0];
            int end = meetings[idx][1];
            idx++;
            while (idx < meetings.length && meetings[idx][0] <= end) {
                end = Math.max(end, meetings[idx][1]);
                idx++;
            }
            meetingDays += (end - start + 1);
        }
        return days - meetingDays;
    }
}
