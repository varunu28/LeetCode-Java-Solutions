class Solution {
  public String[] reorderLogFiles(String[] logs) {
    List<String> letterLogs = new ArrayList<>();
    List<String> digitLogs = new ArrayList<>();
    for (String log : logs) {
      if (Character.isDigit(log.split("\\s+")[1].charAt(0))) {
        digitLogs.add(log);
      } else {
        letterLogs.add(log);
      }
    }
    letterLogs.sort(Comparator.comparing((String o) -> o.substring(o.indexOf(' ') + 1))
        .thenComparing(o -> o.split("\\s+")[0]));
    letterLogs.addAll(digitLogs);
    return letterLogs.toArray(new String[0]);
  }
}
