class Solution {
    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int card: deck) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int X = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 2) {
                return false;
            }

            if (X == -1) {
                X = entry.getValue();
            }
            else {
                X = findGCD(X, entry.getValue());
            }
        }

        if (X == 1) {
            return false;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % X != 0) {
                return false;
            }
        }

        return true;
    }

    private static int findGCD(int n1, int n2) {
        while(n1 != n2) {
            if(n1 > n2)
                n1 -= n2;
            else
                n2 -= n1;
        }

        return n1;
    }
}
