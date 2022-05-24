class Solution {
  public String[] reorderLogFiles(String[] logs) {
    List<String> letterLogs = new ArrayList<>();
    List<String> digitLogs = new ArrayList<>();
    for (String log : logs) {
      String[] split = log.split("\\s+");
      if (Character.isDigit(split[1].charAt(0))) {
        digitLogs.add(log);
      } else {
        letterLogs.add(log);
      }
    }
    letterLogs.sort(Comparator.comparing((String o) -> o.substring(o.indexOf(' ') + 1))
        .thenComparing(o -> o.substring(0, o.indexOf(' '))));
    letterLogs.addAll(digitLogs);
    return letterLogs.toArray(new String[]{});
  } 
}
