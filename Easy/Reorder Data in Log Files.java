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
    letterLogs.sort((o1, o2) -> {
      String contentOne = o1.substring(o1.indexOf(" ") + 1);
      String contentTwo = o2.substring(o2.indexOf(" ") + 1);
      int c = contentOne.compareTo(contentTwo);
      if (c != 0) {
        return c;
      }
      return o1.substring(0, o1.indexOf(" ")).compareTo(o2.substring(0, o2.indexOf(" ")));
    });
    letterLogs.addAll(digitLogs);
    return letterLogs.toArray(new String[0]);
  }
}
