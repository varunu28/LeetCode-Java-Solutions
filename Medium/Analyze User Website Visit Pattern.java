class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> visitMap = new HashMap<>();
        int n = username.length;
        for (int i = 0; i < n; i++) {
            visitMap.computeIfAbsent(username[i], k -> new ArrayList<>()).add(new Visit(timestamp[i], website[i]));
        }
        
        Map<String, Integer> tripletMap = new HashMap<>();
        for (String user : visitMap.keySet()) {
            List<Visit> visits = visitMap.get(user);
            Collections.sort(visits);
            Set<String> visited = new HashSet<>();
            for (int i = 0; i < visits.size(); i++) {
                for (int j = i + 1; j < visits.size(); j++) {
                    for (int k = j + 1; k < visits.size(); k++) {
                        String tempTriplet = visits.get(i).website + "," +  visits.get(j).website + "," + visits.get(k).website;
                        if (visited.add(tempTriplet)) {
                            tripletMap.put(tempTriplet, tripletMap.getOrDefault(tempTriplet, 0) + 1);
                        }
                    }
                }
            }
        }
        
        int maxValue = 0;
        String res = "";
        for (String triplet : tripletMap.keySet()) {
            if (tripletMap.get(triplet) > maxValue) {
                maxValue = tripletMap.get(triplet);
                res = triplet;
            }
            else if (tripletMap.get(triplet) == maxValue) {
                if (triplet.compareTo(res) < 0) {
                    res = triplet;
                }
            }
        }
        
        return Arrays.asList(res.split(","));
    }
}

class Visit implements Comparable<Visit> {
    int timestamp;
    String website;
    
    public Visit(int timestamp, String website) {
        this.timestamp = timestamp;
        this.website = website;
    }
    
    public String toString() {
        return timestamp + "->" + website;
    }
    
    public int compareTo(Visit visit) {
        return this.timestamp - visit.timestamp;
    }
}
