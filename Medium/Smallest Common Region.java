class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> regionToParentMap = new HashMap<>();
        for (List<String> region : regions) {
            String parent = region.getFirst();
            for (int i = 1; i < region.size(); i++) {
                regionToParentMap.put(region.get(i), parent);
            }
        }
        List<String> pathOne = trace(region1, regionToParentMap);
        List<String> pathTwo = trace(region2, regionToParentMap);
        int idxOne = 0;
        int idxTwo = 0;
        while (idxOne < pathOne.size() && idxTwo < pathTwo.size() && pathOne.get(idxOne).equals(pathTwo.get(idxTwo))) {
            idxOne++;
            idxTwo++;
        }
        return pathOne.get(idxOne - 1);
    }

    private List<String> trace(String region, Map<String, String> regionToParentMap) {
        List<String> path = new ArrayList<>();
        path.add(region);
        while (regionToParentMap.containsKey(region)) {
            String parent = regionToParentMap.get(region);
            path.add(parent);
            region = parent;
        }
        Collections.reverse(path);
        return path;
    }
}
