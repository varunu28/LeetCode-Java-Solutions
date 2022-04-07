class Solution {
  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    Map<String, List<String>> map = new HashMap<>();
    Map<String, Integer> ingredientCounter = new HashMap<>();
    for (int i = 0; i < recipes.length; i++) {
      List<String> currentIngredientList = ingredients.get(i);
      for (String ingredient : currentIngredientList) {
        map.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipes[i]);
        ingredientCounter.put(recipes[i], ingredientCounter.getOrDefault(recipes[i], 0) + 1);
      }
    }
    Queue<String> queue = new LinkedList<>();
    Set<String> prepared = new HashSet<>();
    for (String supply : supplies) {
      queue.add(supply);
    }
    while (!queue.isEmpty()) {
      String removed = queue.remove();
      for (String dependentRecipe : map.getOrDefault(removed, new ArrayList<>())) {
        ingredientCounter.put(dependentRecipe, ingredientCounter.getOrDefault(dependentRecipe, 0) - 1);
        if (ingredientCounter.get(dependentRecipe) == 0) {
          queue.add(dependentRecipe);
          prepared.add(dependentRecipe);
        }
      }
    }
    return new ArrayList<>(prepared);
  }
}
