class Solution {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, Map<String, Double>> graphOne = buildGraph(pairs1, rates1);
        Map<String, Map<String, Double>> graphTwo = buildGraph(pairs2, rates2);
        Map<String, Double> dayOneTraversal = getMaxAmounts(initialCurrency, graphOne, null);
        Map<String, Double> dayTwoTraversal = getMaxAmounts(initialCurrency, graphTwo, dayOneTraversal);
        return dayTwoTraversal.getOrDefault(initialCurrency, 0.0);
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            String origin = pairs.get(i).get(0);
            String target = pairs.get(i).get(1);
            double rate = rates[i];
            graph.computeIfAbsent(origin, _ -> new HashMap<>()).put(target, rate);
            graph.computeIfAbsent(target, _ -> new HashMap<>()).put(origin, 1 / rate);
        }
        return graph;   
    }

    private Map<String, Double> getMaxAmounts(String currency, Map<String, Map<String, Double>> graph, Map<String, Double> initialAmounts) {
        Map<String, Double> maxAmounts = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        if (initialAmounts == null) {
            maxAmounts.put(currency, 1.0);
            queue.add(currency);
        } else {
            maxAmounts.putAll(initialAmounts);
            queue.addAll(initialAmounts.keySet());
        }
        while (!queue.isEmpty()) {
            String current = queue.poll();
            double amount = maxAmounts.get(current);
            for (Map.Entry<String, Double> entry : graph.getOrDefault(current, new HashMap<>()).entrySet()) {
                String neighbor = entry.getKey();
                double rate = entry.getValue();
                double newAmount = amount * rate;
                if (newAmount > maxAmounts.getOrDefault(neighbor, 0.0)) {
                    maxAmounts.put(neighbor, newAmount);
                    queue.add(neighbor);
                }
            }
        }
        return maxAmounts;
    }
}
