package leecode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leecode.common.Employee;

public class EmployeeImportance {

    int total = 0;

    public int getImportance(List<Employee> employees, int id) {
        total = 0;

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        dfs(map.get(id), map);

        return total;
    }

    private void dfs(Employee employee, Map<Integer, Employee> map) {
        if (employee == null) return;

        total += employee.importance;

        for (Integer id : employee.subordinates) {
            dfs(map.get(id), map);
        }
    }
}
