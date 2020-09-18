class Solution {
  public List<String> removeSubfolders(String[] folder) {
    Set<String> set = new HashSet<>();
    Arrays.sort(folder, new Comparator<String>(){
      public int compare(String s1, String s2) {
        return s1.length() - s2.length();
      }
    });
    for (String fl : folder) {
      String[] files = fl.split("/");
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < files.length; i++) {
        sb.append("/").append(files[i]);
        if (set.contains(sb.toString())) {
          break;
        }
      }
      if (sb.length() > 0) {
        set.add(sb.toString());
      }
    }
    return new ArrayList<>(set);
  }
}
