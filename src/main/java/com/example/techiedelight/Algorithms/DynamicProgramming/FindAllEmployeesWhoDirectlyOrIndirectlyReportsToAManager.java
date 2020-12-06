package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
class FindAllEmployeesWhoDirectlyOrIndirectlyReportsToAManager
{
    // Recursive DP function to find all employees who directly or indirectly
    // reports to a given manager and store the result in the result map
    private static List<Character> findAllReportingEmployees(Character manager,
                            Map<Character, List<Character>> managerToEmployeeMappings,
                            Map<Character, List<Character>> result)
    {
        // if the sub-problem is already seen before
        if (result.containsKey(manager)) {
            // return the already computed mapping
            return result.get(manager);
        }
 
        // find all employees reporting directly to the current manager
        List<Character> managerEmployees = managerToEmployeeMappings.get(manager);
 
        if (managerEmployees != null)
        {
            // find all employees reporting in-directly to the current manager
            for (char reportee : new ArrayList<>(managerEmployees)) {
                // find all employees reporting to the current employee
                List<Character> employees = findAllReportingEmployees(reportee,
                        managerToEmployeeMappings, result);
 
                // move those employees to the current manager
                if (employees != null) {
                    managerEmployees.addAll(employees);
                }
            }
        }
 
        // save the result to avoid re-computation and return it
        result.put(manager, managerEmployees);
        return managerEmployees;
    }
 
    // Find all employees who directly or indirectly reports to a manager
    public static void findEmployees(Map<Character, Character> employeeToManagerMappings)
    {
        // store manager to employee mappings in a new map
        // List<Character> is used since a manager can have several employees mapped
        Map<Character, List<Character>> managerToEmployeeMappings = new HashMap<>();
 
        // fill above map with the manager to employee mappings
        for (Map.Entry<Character, Character> entry: employeeToManagerMappings.entrySet())
        {
            char employee = entry.getKey();
            char manager = entry.getValue();
 
            // don't map an employee with itself
            if (employee != manager) {
                managerToEmployeeMappings.putIfAbsent(manager, new ArrayList<>());
                managerToEmployeeMappings.get(manager).add(employee);
            }
        }
 
        // construct an ordered map to store the result
        Map<Character,List<Character>> result = new HashMap<>();
 
        // find all reporting employees (direct and indirect) for every manager
        // and store the result in a map
        for (Map.Entry<Character, Character> entry: employeeToManagerMappings.entrySet()) {
            findAllReportingEmployees(entry.getKey(), managerToEmployeeMappings, result);
        }
 
        // print contents of the result map
        for (Map.Entry<Character, List<Character>>  entry: result.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
 
    public static void main(String[] args)
    {
        // construct a map of employee to manager mappings
        Map<Character, Character> employeeToManagerMappings = new HashMap<>();
 
        employeeToManagerMappings.put('A', 'A');
        employeeToManagerMappings.put('B', 'A');
        employeeToManagerMappings.put('C', 'B');
        employeeToManagerMappings.put('D', 'B');
        employeeToManagerMappings.put('E', 'D');
        employeeToManagerMappings.put('F', 'E');
 
        findEmployees(employeeToManagerMappings);
    }
}