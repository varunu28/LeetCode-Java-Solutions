class Solution {
    public String customSortString(String s, String t) {

        // Separate out the characters from t which are not part of s
        StringBuilder nonS = new StringBuilder();
        for (int i=0; i<t.length(); i++) {
            if (s.indexOf(t.charAt(i)) == -1) {
                nonS.append(t.charAt(i));
            }
        }

        // Create a character array of t with words present in s
        Character[] arr = new Character[t.length() - nonS.length()];
        for (int i=0,j=0; i<t.length(); i++) {
            if (s.indexOf(t.charAt(i)) != -1) {
                arr[j++] = t.charAt(i);
            }
        }

        // Create a value map for characters in s with increasing counter
        int counter = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, counter);
            counter++;
        }

        // Sort the character array based on value map
        Arrays.sort(arr, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        // Prepare the final string answer
        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            sb.append(c);
        }

        // Append characters not present in s to the end of solution
        sb.append(nonS.toString());

        return sb.toString();
    }
}
