package com.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExampleWithEmployee {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Alice", "HR", 30, 50000.0),
				new Employee("Bob", "Finance", 25, 60000.0), new Employee("Charlie", "IT", 30, 55000.0),
				new Employee("David", "Finance", 25, 62000.0), new Employee("Eve", "HR", 28, 52000.0));

		// Example 1: Grouping employees by department
		Map<String, List<Employee>> employeesByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("Grouping by department:");
		System.out.println(employeesByDepartment);

		// Example 2: Grouping employees by age and calculating average salary
		Map<Integer, Double> averageSalaryByAge = employees.stream()
				.collect(Collectors.groupingBy(Employee::getAge, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("\nGrouping by age and calculating average salary:");
		System.out.println(averageSalaryByAge);

		// Example 3: Grouping employees by department and then by age
		Map<String, Map<Integer, List<Employee>>> employeesByDepartmentAndAge = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getAge)));
		System.out.println("\nGrouping by department and then by age:");
		System.out.println(employeesByDepartmentAndAge);

		// Example 4: Grouping employees by department and counting the number of
		// employees in each group
		Map<String, Long> countByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("\nGrouping by department and counting the number of employees:");
		System.out.println(countByDepartment);

		// Example 5: Grouping employees by department and summing their salaries in
		// each group
		Map<String, Double> totalSalaryByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
		System.out.println("\nGrouping by department and summing their salaries:");
		System.out.println(totalSalaryByDepartment);

		// Example 6: Grouping employees by age and finding the oldest employee in each
		// group
		Map<Integer, Employee> oldestEmployeeByAge = employees.stream()
				.collect(Collectors.groupingBy(Employee::getAge,
						Collectors.collectingAndThen(
								Collectors.maxBy((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())),
								employeeOptional -> employeeOptional.orElse(null))));
		System.out.println("\nGrouping by age and finding the oldest employee in each group:");
		System.out.println(oldestEmployeeByAge);

		// Example 7: Grouping employees by department and mapping their names to a list
		// in each group
		Map<String, List<String>> namesByDepartment = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("\nGrouping by department and mapping their names to a list:");
		System.out.println(namesByDepartment);

		// Example 8: Grouping employees by department and finding the average age in
		// each group
		Map<String, Double> averageAgeByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getAge)));
		System.out.println("\nGrouping by department and finding the average age:");
		System.out.println(averageAgeByDepartment);
	}
}
