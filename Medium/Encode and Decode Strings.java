public class Codec {

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(lengthEncode(str)).append(str);
    }
    return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    int idx = 0;
    int n = s.length();
    List<String> list = new ArrayList<>();
    while (idx < n) {
      int length = Integer.parseInt(s.substring(idx, idx + 10));
      idx += 10;
      list.add(s.substring(idx, idx + length));
      idx += length;
    }
    return list;
  }
  
  private String lengthEncode(String s) {
    int n = s.length();
    return String.join("", Collections.nCopies(10 - String.valueOf(n).length(), "0")) + String.valueOf(n);
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));

