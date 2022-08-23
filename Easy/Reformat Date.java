class Solution {
  private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
  
  public String reformatDate(String date) {
    String[] split = date.split("\\s+");
    StringBuilder sb = new StringBuilder();
    sb.append(split[2]).append("-");
    int monthIdx = getMonthIdx(split[1]);
    sb.append(monthIdx > 9 ? "" : "0").append(monthIdx).append("-");
    sb.append(Character.isDigit(split[0].charAt(1)) ? split[0].substring(0, 2) : ("0" + split[0].charAt(0)));
    return sb.toString();
  }
  
  private int getMonthIdx(String month) {
    for (int i = 0; i < MONTHS.length; i++) {
      if (month.equals(MONTHS[i])) {
        return i + 1;
      }
    }
    return -1;
  }
}
