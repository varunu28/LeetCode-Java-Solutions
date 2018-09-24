class Solution {
    public static int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();

        for (String s : A) {
            int[] even = new int[26];
            int[] odd = new int[26];

            for (int i=0; i<s.length(); i++) {
                if (i%2 == 0) {
                    even[s.charAt(i) - 'a']++;
                }
                else {
                    odd[s.charAt(i) - 'a']++;
                }
            }

            set.add(Arrays.toString(even) + "|" + Arrays.toString(odd));
        }

        return set.size();
    }
}
