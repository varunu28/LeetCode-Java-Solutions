class Solution {
    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();

        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        ArrayList<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
            return result;
        }

        ArrayList<Character> temp = new ArrayList<Character>();
        updateResult(digits, temp, result, map);

        return result;
    }

    private static void updateResult(String digits, ArrayList<Character> temp, ArrayList<String> result, Map<Integer, String> map) {
        if (digits.length() == 0) {
            char[] charArray = new char[temp.size()];

            for (int i=0; i<temp.size(); i++) {
                charArray[i] = temp.get(i);
            }

            result.add(String.valueOf(charArray));
            return;
        }

        Integer curr = Integer.valueOf(digits.substring(0, 1));
        String letters = map.get(curr);

        for (int i=0; i<letters.length(); i++) {
            temp.add(letters.charAt(i));
            updateResult(digits.substring(1), temp, result, map);
            temp.remove(temp.size()-1);
        }
    }
}
