class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> moves = new ArrayList<>();
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.substring(i, i + 2).equals("++")) {
                moves.add(currentState.substring(0, i) + "--" + currentState.substring(i + 2));
            }
        }
        return moves;
    }
}
