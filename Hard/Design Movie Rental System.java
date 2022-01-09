class MovieRentingSystem {

  Comparator<MovieEntry> comparator =
      (o1, o2) -> {
        if (o1.price != o2.price) {
          return o1.price - o2.price;
        }
        if (o1.shopId != o2.shopId) {
          return o1.shopId - o2.shopId;
        }
        return o1.movieId - o2.movieId;
      };
  Map<Integer, Set<MovieEntry>> movieToUnrentedShopMapping;
  Map<ShopMoviePair, Integer> shopMoviePairToPriceMapping;
  TreeSet<MovieEntry> rentedMovies;

  public MovieRentingSystem(int n, int[][] entries) {
    movieToUnrentedShopMapping = new HashMap<>();
    shopMoviePairToPriceMapping = new HashMap<>();
    rentedMovies = new TreeSet<>(comparator);
    for (int[] entry : entries) {
      movieToUnrentedShopMapping
          .computeIfAbsent(entry[1], k -> new TreeSet<>(comparator))
          .add(new MovieEntry(entry[1], entry[2], entry[0]));
      shopMoviePairToPriceMapping.put(new ShopMoviePair(entry[0], entry[1]), entry[2]);
    }
  }

  public List<Integer> search(int movie) {
    return movieToUnrentedShopMapping.getOrDefault(movie, Collections.emptySet()).stream()
        .limit(5)
        .map(e -> e.shopId)
        .collect(Collectors.toList());
  }

  public void rent(int shop, int movie) {
    int price = shopMoviePairToPriceMapping.get(new ShopMoviePair(shop, movie));
    movieToUnrentedShopMapping.get(movie).remove(new MovieEntry(movie, price, shop));
    rentedMovies.add(new MovieEntry(movie, price, shop));
  }

  public void drop(int shop, int movie) {
    int price = shopMoviePairToPriceMapping.get(new ShopMoviePair(shop, movie));
    movieToUnrentedShopMapping.get(movie).add(new MovieEntry(movie, price, shop));
    rentedMovies.remove(new MovieEntry(movie, price, shop));
  }

  public List<List<Integer>> report() {
    return rentedMovies.stream()
        .limit(5)
        .map(e -> List.of(e.shopId, e.movieId))
        .collect(Collectors.toList());
  }

  class ShopMoviePair {
    int shopId;
    int movieId;

    public ShopMoviePair(int shopId, int movieId) {
      this.shopId = shopId;
      this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      ShopMoviePair that = (ShopMoviePair) o;
      return shopId == that.shopId && movieId == that.movieId;
    }

    @Override
    public int hashCode() {
      return Objects.hash(shopId, movieId);
    }
  }

  class MovieEntry {
    int movieId;
    int price;
    int shopId;

    public MovieEntry(int movieId, int price, int shopId) {
      this.movieId = movieId;
      this.price = price;
      this.shopId = shopId;
    }
  }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */
