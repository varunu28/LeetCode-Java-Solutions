class Solution {
    public String reorganizeString(String S) {
        int buffer = S.length()%2 == 0 ? S.length()/2 : S.length()/2 + 1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = S.toCharArray();

        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > buffer) {
                return "";
            }
        }

        return createString(map);
    }

    private String createString(Map<Character, Integer> map) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.add(new int[] {c, map.get(c)});
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            }
            else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }

        return sb.toString();
    }
}
