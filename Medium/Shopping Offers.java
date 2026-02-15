class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return shoppingOffers(price, special, needs, memo);
    }

    private int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int minPrice = 0;
        for (int i = 0; i < price.size(); i++) {
            minPrice += price.get(i) * needs.get(i);
        }
        for (List<Integer> offer : special) {
            if (isValidOffer(offer, needs)) {
                List<Integer> newNeeds = calculateUpdatedNeed(offer, needs);
                minPrice = Math.min(minPrice, offer.getLast() + shoppingOffers(price, special, newNeeds, memo)); 
            }
        }
        memo.put(needs, minPrice);
        return minPrice;
    }

    private boolean isValidOffer(List<Integer> offer, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (offer.get(i) > needs.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> calculateUpdatedNeed(List<Integer> offer, List<Integer> needs) {
        List<Integer> newNeeds = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            newNeeds.add(needs.get(i) - offer.get(i));
        }
        return newNeeds;
    }
}
