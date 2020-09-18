class Solution {
    List<Integer> daysInMonth = Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int day = Integer.parseInt(date.split("-")[2]);
        
        int numOfDays = getNumOfDays(month, isLeapYear(year));
        
        return numOfDays + day;
    }
    
    private boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            else {
                return true;
            }
        }
        return false;
    }
    
    private int getNumOfDays(int month, boolean isLeapYear) {
        int numOfDays = 0;
        for (int i = 1; i < month; i++) {
            if (i == 2) {
                numOfDays += isLeapYear ? daysInMonth.get(i - 1) + 1 : daysInMonth.get(i - 1);            
            } 
            else {
                numOfDays += daysInMonth.get(i - 1);
            }
        }
        return numOfDays;
    }
}
