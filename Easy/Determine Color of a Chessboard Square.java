class Solution {
  public boolean squareIsWhite(String coordinates) {
    return (
        ("aceg".indexOf(coordinates.charAt(0)) != -1
            && Character.getNumericValue(coordinates.charAt(1)) % 2 == 0) ||
            ("aceg".indexOf(coordinates.charAt(0)) == -1
                && Character.getNumericValue(coordinates.charAt(1)) % 2 != 0)
    );
  }
}
