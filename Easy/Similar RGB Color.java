class Solution {
  public String similarRGB(String color) {
    StringBuilder simlarColor = new StringBuilder();
    simlarColor.append("#");
    for (int i = 1; i < 6; i += 2) {
      simlarColor.append(findClosestColor(color.substring(i, i + 2)));
    }
    return simlarColor.toString();
  }
  
  private String findClosestColor(String section) {
    int num = Integer.parseInt(section, 16);
    int roundedValue = Math.round((float) num / 17);
    return Integer.toHexString(roundedValue).repeat(2);
  }
}
