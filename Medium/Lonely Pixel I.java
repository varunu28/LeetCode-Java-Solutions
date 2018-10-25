class Solution {
    public int findLonelyPixel(char[][] picture) {
        int count = 0;
        Map<Integer, Integer> rowMap = new HashMap<>();

        for (int i=0; i<picture.length; i++) {
            rowMap.put(i, 0);
            for (int j=0; j<picture[i].length; j++) {
                if (picture[i][j] == 'B') {
                    rowMap.put(i, rowMap.get(i) + 1);
                }
            }
        }

        Map<Integer, Integer> colMap = new HashMap<>();
        for (int i=0; i<picture[0].length; i++) {
            colMap.put(i, 0);
            for (int j=0; j<picture.length; j++) {
                if (picture[j][i] == 'B') {
                    colMap.put(i, colMap.get(i) + 1);
                }
            }
        }

        for (int i=0; i<picture.length; i++) {
            for (int j=0; j<picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    if (rowMap.get(i) == 1 && colMap.get(j) == 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
