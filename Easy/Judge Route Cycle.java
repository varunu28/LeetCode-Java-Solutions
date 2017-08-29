class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        
        String move = "UDRL";
        int[] val = {1,-1,1,-1};
        
        for (int i=0;i<moves.length();i++) {
            if (move.indexOf(moves.charAt(i)) <= 1) {
                y = y + val[move.indexOf(moves.charAt(i))];
            }
            else {
                x = x + val[move.indexOf(moves.charAt(i))];
            }
        }
        return (x == 0 && y == 0);
    }
}