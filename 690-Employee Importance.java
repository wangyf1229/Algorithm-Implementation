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
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Integer> queue = new LinkedList<>();
        int impor = 0;
        queue.offer(id);
        while (! queue.isEmpty()) {
            int temp = queue.poll();
            Employee cur = map.get(temp);
            impor += cur.importance;
            for (Integer next: cur.subordinates) {
                    queue.offer(next);
            }
        }
        return impor;
    }
}