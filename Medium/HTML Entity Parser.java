class Solution {
  public String entityParser(String text) {
    if (text == null || text.length() == 0) {
      return "";
    }
    Map<String, String> map = Map.of(
      "&quot;", "\"", 
      "&apos;", "'", 
      "&gt;", ">", 
      "&lt;", "<", 
      "&frasl;", "/"
    );
    for (String key : map.keySet()) {
      text = text.replaceAll(key, map.get(key));
    }
    return text.replaceAll("&amp;", "&");
  }
}
