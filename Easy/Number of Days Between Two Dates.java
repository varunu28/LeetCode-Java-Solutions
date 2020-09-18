class Solution {
  private int[] daysOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  
  public int daysBetweenDates(String date1, String date2) {
    return Math.abs(daysFrom1971(date1) - daysFrom1971(date2));
  }
  
  private int daysFrom1971(String date) {
    String[] dateArr = date.split("-");
    int year = Integer.parseInt(dateArr[0]);
    int month = Integer.parseInt(dateArr[1]);
    int day = Integer.parseInt(dateArr[2]);
    int numOfDays = day;
    for (int y = 1971; y < year; y++) {
      numOfDays += isLeapYear(y) ? 366 : 365;
    }
    for (int m = 0; m < month - 1; m++) {
      numOfDays += daysOfMonth[m];
    }
    if (month > 2 && isLeapYear(year)) {
      numOfDays++;
    }
    return numOfDays;
  }
  
  private boolean isLeapYear(int year) {
    return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
  }
}
