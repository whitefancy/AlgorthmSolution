package OJSolution.application.DFSBFS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class EmployeeImportance {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "[{\"id\" : 1,\"importance\" :5,\"subordinates\" : [2, 3]}, {\"id\" : 2, \"importance\" :3, \"subordinates\" :[]}, {\"id\" : 3,\"importance\" : 3,\"subordinates\" : []}]";
        ObjectMapper objectMapper = new ObjectMapper();
        Employee[] employees1 = objectMapper.readValue(json, Employee[].class);
        List<Employee> employees = objectMapper.readValue(json, new TypeReference<List<Employee>>() {
        });
        System.out.println(new EmployeeImportance().getImportance(employees, 1));
    }

    private int getImportance(List<Employee> employees, int id) {
        int count = 0;
        return getCount(employees, id);
    }

    private int getCount(List<Employee> employees, int id) {
        Employee employee = employees.get(id - 1);
        int count = 0;
        count += employee.importance;
        for (int i = 0; i < employee.subordinates.size(); i++) {
            Integer sub = employee.subordinates.get(i);
            count += getCount(employees, sub);
        }
        return count;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    int importance;
    // the id of direct subordinates
    List<Integer> subordinates;
}