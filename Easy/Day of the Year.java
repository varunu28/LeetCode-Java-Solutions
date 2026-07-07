class Solution {

    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        String[] splits = date.split("-");
        int year = Integer.parseInt(splits[0]);
        int month = Integer.parseInt(splits[1]);
        int day = Integer.parseInt(splits[2]);
        int days = 0;
        for (int i = 1; i < month; i++) {
            days += DAYS_IN_MONTH[i - 1];
            if (i == 2 && isLeapYear(year)) {
                days++;
            }
        }
        days += day;
        return days;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
