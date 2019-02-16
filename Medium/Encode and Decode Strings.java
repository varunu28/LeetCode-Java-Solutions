public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        
        for (String str : strs) {
            sb.append(str.length()).append("|").append(str);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        
        int idx = 0;
        int n = s.length();
        
        while (idx < n) {
            int slashIdx = s.indexOf('|', idx);
            int size = Integer.parseInt(s.substring(idx, slashIdx));
            idx = slashIdx + size + 1;
            list.add(s.substring(slashIdx + 1, idx));
        }
        
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
