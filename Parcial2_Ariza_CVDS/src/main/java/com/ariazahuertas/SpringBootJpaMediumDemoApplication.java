package com.ariazahuertas;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ariazahuertas.model.Employee;

@SpringBootApplication
public class SpringBootJpaMediumDemoApplication {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaMediumDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {
			for (Employee i : employeeService.getAllEmployees()){
				employeeService.deleteEmployee(i.getEmployeeId());
			}
			employeeService.addEmployee(new Employee("Nicolas", "Ariza", "Security", 50000.00, "2002-04-24"));
			employeeService.addEmployee(new Employee("Steven", "Huertas", "Security", 60000.00, "2001-03-25"));
			employeeService.addEmployee(new Employee("Jorge", "Useche", "Teacher", 92000.00, "2001-12-25"));
			//System.out.println("Adding employees....\n");
			//employeeService.addEmployee(new Employee("Hank", "Hill", "Salesman", 63000.00));
			//employeeService.addEmployee(new Employee("Peggy", "Hill", "Substitute", 43000.00));
			//employeeService.addEmployee(new Employee("Homer", "Simpson", "Plant Operator", 163000.00));
			//employeeService.addEmployee(new Employee("Rick", "Sanchez", "Scientis", 633000.00));
			//employeeService.addEmployee(new Employee("Bob", "Belcher", "Fry Cook", 10.00));

			//System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));

			for (Employee i : employeeService.getAllEmployees()){
				System.out.println(i.getFirstName() + ", " + i.calculateAge());
			}
			//System.out.println(employeeService.getEmployee(1L));

			//System.out.println("\nUpdating employee with id = 1....");
			//System.out.println("Before----->" + employeeService.getEmployee(1L));
			//Employee employee = employeeService.getEmployee(1L);
			//employee.setFirstName("Marge");
			//System.out.println("After------>" + employeeService.updateEmployee(employee));

			//System.out.println("\nDeleting employee....");
			//employeeService.deleteEmployee(1L);
		};
	}

}
