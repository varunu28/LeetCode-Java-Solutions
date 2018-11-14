class Solution {
    public String intToRoman(int num) {
        List<Integer> keys = Arrays.asList(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000);
        List<String> values = Arrays.asList("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M");
        Map<Integer, String> map = new HashMap<>();
        for (int i=0; i<keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        
        StringBuilder sb = new StringBuilder();

        for (int i=keys.size()-1; i>=0; i--) {
            if (num / keys.get(i) > 0) {
                int n = num / keys.get(i);
                num %= keys.get(i);

                sb.append(String.join("", Collections.nCopies(n, map.get(keys.get(i)))));
            }

            if (num == 0) {
                break;
            }
        }

        return sb.toString();
    }
}
