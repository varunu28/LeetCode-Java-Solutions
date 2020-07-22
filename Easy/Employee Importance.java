/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
  public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> map = new HashMap<>();
    for (Employee employee : employees) {
      map.put(employee.id, employee);
    }
    int importance = 0;
    Queue<Employee> queue = new LinkedList<>();
    queue.add(map.get(id));
    while (!queue.isEmpty()) {
      Employee removed = queue.remove();
      importance += removed.importance;
      for (Integer subordinate : removed.subordinates) {
        queue.add(map.get(subordinate));
      }
    }
    return importance;
  }
}
