class FoodRatings {

    private final Map<String, Integer> foodToRating;

    private final Map<String, String> foodToCuisine;

    private final Map<String, PriorityQueue<Food>> cuisineToFood;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foodToRating = new HashMap<>();
        this.foodToCuisine = new HashMap<>();
        this.cuisineToFood = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            foodToRating.put(food, rating);
            foodToCuisine.put(food, cuisine);
            cuisineToFood.computeIfAbsent(cuisine, k -> new PriorityQueue<>()).add(new Food(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        this.foodToRating.put(food, newRating);
        String cuisine = foodToCuisine.get(food);
        cuisineToFood.get(cuisine).add(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        Food highestRatedFood = cuisineToFood.get(cuisine).peek();
        while (foodToRating.get(highestRatedFood.name) != highestRatedFood.rating) {
            cuisineToFood.get(cuisine).poll();
            highestRatedFood = cuisineToFood.get(cuisine).peek();
        }
        return highestRatedFood.name;
    }

    private record Food(String name, int rating) implements Comparable<Food> {
        @Override
        public int compareTo(Food o) {
            int c = o.rating - rating;
            return c == 0 ? name.compareTo(o.name) : c;
        }
    }
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
