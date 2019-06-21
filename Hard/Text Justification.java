class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int idx = 0;
        int n = words.length;

        while (idx < n) {
            int count = 0;
            int currLength = 0;
            int oldIdx = idx;
            int totalWordLength = 0;

            while (idx < n && currLength + words[idx].length() <= maxWidth) {
                count++;
                currLength += words[idx].length() + 1;
                totalWordLength += words[idx].length();
                idx++;
            }

            StringBuilder sb = new StringBuilder();
            // Left Justify
            if (count == 1 || idx == n) {
                while (oldIdx < idx) {
                    sb.append(words[oldIdx++]);
                    if (!words[oldIdx-1].endsWith(".") && oldIdx != idx) {
                        sb.append(" ");
                    }
                }

                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            }
            // Left & Right Justify
            else {
                int spacing = (maxWidth - totalWordLength) / (count - 1);
                int extraSpacing = maxWidth - totalWordLength - spacing * (count - 1);
                int tempIdx = oldIdx;
                while (tempIdx < idx) {
                    sb.append(words[tempIdx++]);
                    if (tempIdx != idx) {
                        int totalSpace = spacing + (extraSpacing > 0 ? 1 : 0);
                        extraSpacing--;
                        for (int j = 0; j < totalSpace; j++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            list.add(sb.toString());
        }

        return list;
    }
}
