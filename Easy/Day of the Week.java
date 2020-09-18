class Solution {
    int[] m = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    String[] res = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
    public String dayOfTheWeek(int day, int month, int year) {
      int days = years(year);
      if(isLeap(year))
        m[2] = 29;
      for(int i=0; i < month; i++){
        days += m[i];
      }
      days += day-1;
      return res[days%7];
    }
    private int years(int y){
      int count = 0;
      for(int i=1971; i < y; i++){
        if(isLeap(i))
         count += 366;    
        else
         count += 365;    
      }
      return count;
    }
    private boolean isLeap(int y){
      if(y % 4 != 0) return false;
      else if(y%100 != 0) return true;
      else if(y % 400 != 0) return false;
      else return true;
    }
}
