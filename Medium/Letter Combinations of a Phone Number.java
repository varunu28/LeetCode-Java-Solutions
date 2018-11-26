class Solution {
    public List<String> combinations;
    public Map<Character, String> map;

    public List<String> letterCombinations(String number) {
        if (number.length() == 0) {
            return new ArrayList<>();
        }
        
        combinations = new ArrayList<>();
        map = new HashMap<>();
        char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String[] values = {"*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i=0; i<chars.length; i++) {
            map.put(chars[i], values[i]);
        }

        StringBuilder sb = new StringBuilder();
        helper(number, sb, 0);

        return combinations;
    }

    private void helper(String num, StringBuilder sb, int start) {
        if (sb.length() == num.length()) {
            combinations.add(new StringBuilder(sb.toString()).toString());
            return;
        }

        for (int i=start; i<num.length(); i++) {
            String val = map.get(num.charAt(i));

            for (char c : val.toCharArray()) {
                // Choose
                sb.append(c);

                // Explore
                helper(num, sb, i+1);

                // Un-choose
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
