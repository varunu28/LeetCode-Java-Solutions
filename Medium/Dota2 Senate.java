class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rValid = new LinkedList<>();
        Queue<Integer> dValid = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rValid.add(i);
            } else {
                dValid.add(i);
            }
        }
        while (!rValid.isEmpty() && !dValid.isEmpty()) {
            int rTurn = rValid.remove();
            int dTurn = dValid.remove();
            if (dTurn < rTurn) {
                dValid.add(dTurn + n);
            } else {
                rValid.add(rTurn + n);
            }
        }
        return rValid.isEmpty() ? "Dire" : "Radiant";
    }
}
