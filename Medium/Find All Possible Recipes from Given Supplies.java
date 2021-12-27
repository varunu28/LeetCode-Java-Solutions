class Solution {
  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients,
      String[] supplies) {
    Map<String, Set<String>> ingredientToRecipeMap = new HashMap<>();
    Map<String, Integer> recipeToIngredientCount = new HashMap<>();
    for (int i = 0; i < recipes.length; i++) {
      String recipe = recipes[i];
      List<String> ingredientsForRecipe = ingredients.get(i);
      recipeToIngredientCount.put(recipe, ingredientsForRecipe.size());
      for (String ingredient : ingredientsForRecipe) {
        ingredientToRecipeMap.computeIfAbsent(ingredient, k -> new HashSet<>()).add(recipe);
      }
    }
    Queue<String> queue = new LinkedList<>(List.of(supplies));
    Set<String> result = new HashSet<>();
    while (!queue.isEmpty()) {
      String ingredient = queue.remove();
      for (String dependentRecipe : ingredientToRecipeMap.getOrDefault(ingredient,
          new HashSet<>())) {
        recipeToIngredientCount.put(dependentRecipe,
            recipeToIngredientCount.get(dependentRecipe) - 1);
        if (recipeToIngredientCount.get(dependentRecipe) == 0) {
          result.add(dependentRecipe);
          queue.add(dependentRecipe);
        }
      }
    }
    return new ArrayList<>(result);
  }
}
