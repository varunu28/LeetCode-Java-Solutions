class Solution {
  public String reformatDate(String date) {
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    Map<String, String> monthMap = new HashMap<>();
    for (int i = 1; i <= 12; i++) {
      monthMap.put(months[i - 1], (i > 9 ? "" : "0") + i);
    }
    String[] strs = date.split("\\s+");
    int dayEndIdx = 0;
    while (dayEndIdx < strs[0].length() && Character.isDigit(strs[0].charAt(dayEndIdx))) {
      dayEndIdx++;
    }
    String dayStr = strs[0].substring(0, dayEndIdx);
    return strs[2] + "-" + monthMap.get(strs[1]) + "-" + (dayStr.length() == 2 ? dayStr : "0" + dayStr);
  }
}
