class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        List<String> line = new ArrayList<>();
        int currLineLength = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < words.length) {
            if (line.size() + currLineLength + words[idx].length() > maxWidth) {
                int spaces = maxWidth - currLineLength;
                if (line.size() == 1) {
                    result.add(line.get(0) + " ".repeat(spaces));
                    line.clear();
                    currLineLength = 0;
                    continue;
                }
                int spacesPerWord = spaces / (line.size() - 1);
                int extraSpaces = spaces % (line.size() - 1);
                for (int i = 0; i < line.size() - 1; i++) {
                    sb.append(line.get(i));
                    sb.append(" ".repeat(spacesPerWord));
                    if (extraSpaces-- > 0) {
                        sb.append(" ");
                    }
                }
                sb.append(line.getLast());
                result.add(sb.toString());
                sb.setLength(0);
                line.clear();
                currLineLength = 0;
                continue;
            }
            line.add(words[idx]);
            currLineLength += words[idx].length();
            idx++;
        }
        for (int i = 0; i < line.size(); i++) {
            sb.append(line.get(i));
            if (i != line.size() - 1) {
                sb.append(" ");
            }
        }
        int trailSpaceLength = maxWidth - sb.length();
        sb.append(" ".repeat(trailSpaceLength));
        result.add(sb.toString());
        return result;
    }
}
