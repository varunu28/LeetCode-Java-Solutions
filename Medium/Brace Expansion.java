class Solution {
    public String[] expand(String s) {
        List<String> list = new ArrayList<>();
        int idx = 0;
        int n = s.length();
        while (idx < n) {
            if (s.charAt(idx) == '{') {
                idx++;
                StringBuilder sb = new StringBuilder();
                while (idx < n && s.charAt(idx) != '}') {
                    if (s.charAt(idx) == ',') {
                        idx++;
                        continue;
                    }
                    sb.append(s.charAt(idx++));
                }
                list.add(sb.toString());
                idx++;
            } else {
                list.add(s.charAt(idx++) + "");
            }
        }
        List<String> result = new ArrayList<>();
        recurse(result, list, new StringBuilder(), 0);
        Collections.sort(result);
        return result.toArray(new String[]{});
    }

    private void recurse(List<String> result, List<String> list, StringBuilder sb, int idx) {
        if (sb.length() == list.size()) {
            result.add(new String(sb.toString()));
            return;
        }
        for (char c : list.get(idx).toCharArray()) {
            sb.append(c);
            recurse(result, list, sb, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
