class Solution {
  public String[] reorderLogFiles(String[] logs) {
    List<String> letterLogs = new ArrayList<>();
    List<String> digitLogs = new ArrayList<>();
    for (String log : logs) {
      String[] strs = log.split("\\s+");
      if (Character.isDigit(strs[1].charAt(0))) {
        digitLogs.add(log);
      }
      else {
        letterLogs.add(log);
      }
    }
    Collections.sort(letterLogs, new Comparator<String>(){
      public int compare(String s1, String s2) {
        String key1 = s1.substring(s1.indexOf(' ') + 1);
        String key2 = s2.substring(s2.indexOf(' ') + 1);
        int c = key1.compareTo(key2);
        if (c != 0) {
          return c;
        }
        return s1.substring(0, s1.indexOf(' ')).compareTo(s2.substring(0, s2.indexOf(' ')));
      }
    });
    String[] ans = new String[logs.length];
    int idx = 0;
    for (String log : letterLogs) {
      ans[idx++] = log;
    }
    for (String log : digitLogs) {
      ans[idx++] = log;
    }
    return ans;
  }
}
