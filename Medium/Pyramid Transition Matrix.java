class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : allowed) {
            map.computeIfAbsent(str.substring(0, 2), k -> new ArrayList<>())
                .add("" + str.charAt(2));
        }
        return recurse(bottom, "", map, 1, new HashSet<>());
    }

    private boolean recurse(String bottom, String row, Map<String, List<String>> map, int idx, Set<String> seen) {
        int n = bottom.length();
        if (n == 1) {
            return true;
        }
        if (idx == n) {
            if (seen.contains(row)) {
                return false;
            }
            seen.add(row);
            return recurse(row, "", map, 1, seen);
        }
        String pair = "" + bottom.charAt(idx - 1) + bottom.charAt(idx);
        for (String next : map.getOrDefault(pair, new ArrayList<>())) {
            if (recurse(bottom, row + next, map, idx + 1, seen)) {
                return true;
            }
        }
        return false;
    }
}
