public class Codec {

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      sb.append(lengthEncoding(s)).append(s);
    }
    return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    int idx = 0;
    List<String> result = new ArrayList<>();
    int n = s.length();
    while (idx < n) {
      int currStringLength = lengthDecoding(s.substring(idx, idx + 4));
      idx += 4;
      result.add(s.substring(idx, idx + currStringLength));
      idx += currStringLength;
    }
    return result;
  }
  
  private String lengthEncoding(String s) {
    int n = s.length();
    char[] bytes = new char[4];
    for(int i = 3; i >= 0; i--) {
      bytes[3 - i] = (char) (n >> (i * 8) & 0xff);
    }
    return new String(bytes);
  }
  
  private int lengthDecoding(String bytesStr) {
    int result = 0;
    for(char b : bytesStr.toCharArray())
      result = (result << 8) + (int)b;
    return result;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
