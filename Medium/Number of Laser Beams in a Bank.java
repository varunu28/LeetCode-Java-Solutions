class Solution {
  public int numberOfBeams(String[] bank) {
    int prevLaserCount = 0;
    int totalNumberOfBeams = 0;
    for (String beam : bank) {
      if (beam.indexOf('1') != -1) {
        int currentBeamCount = (int) beam.chars().mapToObj(c -> (char) c).filter(c -> c == '1')
            .count();
        totalNumberOfBeams += prevLaserCount * currentBeamCount;
        prevLaserCount = currentBeamCount;
      }
    }
    return totalNumberOfBeams;
  }
}
