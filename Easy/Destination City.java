class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> cities = new HashSet<>();
        Set<String> outgoingCities = new HashSet<>();
        for (List<String> path : paths) {
            cities.addAll(path);
            outgoingCities.add(path.get(0));
        }
        cities.removeAll(outgoingCities);
        return cities.iterator().next();
    }
}
