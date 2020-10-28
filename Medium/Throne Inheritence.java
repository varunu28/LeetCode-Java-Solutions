class ThroneInheritance {
  Map<String, ArrayList<String>> family;
  Set<String> deadPeople;
  String king;
  public ThroneInheritance(String kingName) {
    this.king = kingName;
    family = new HashMap<>();
    family.put(kingName, new ArrayList<>());
    deadPeople = new HashSet<>();
  }

  public void birth(String parentName, String childName) {
    family.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
  }

  public void death(String name) {
    deadPeople.add(name);
  }

  public List<String> getInheritanceOrder() {
    List<String> inheritenceOrder = new ArrayList<>();
    findInheritenceRecursively(king, inheritenceOrder);
    return inheritenceOrder;
  }
  
  private void findInheritenceRecursively(String currPerson, List<String> inheritenceOrder) {
    if (!deadPeople.contains(currPerson)) {
      inheritenceOrder.add(currPerson);
    }
    for (String children : family.getOrDefault(currPerson, new ArrayList<>())) {
      findInheritenceRecursively(children, inheritenceOrder);
    }
  }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
