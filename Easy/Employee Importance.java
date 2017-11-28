/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        
        for (int i=0;i<employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        
        return solver(map, id);
    }
    
    public int solver(Map<Integer, Employee> map, int id) {
        Employee main = map.get(id);
        int total = main.importance;
        
        for(int s : main.subordinates) {
            total += solver(map, s);
        }
        
        return total;
    }
}
