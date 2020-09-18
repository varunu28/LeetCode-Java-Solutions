class Solution {
  public String destCity(List<List<String>> paths) {
    Set<String> outgoingPathCities = new HashSet<>();
    Set<String> cities = new HashSet<>();
    for (List<String> path : paths) {
      outgoingPathCities.add(path.get(0));
      cities.add(path.get(0));
      cities.add(path.get(1));
    }
    for (String city : cities) {
      if (!outgoingPathCities.contains(city)) {
        return city;
      }
    }
    return "";
  }
}
