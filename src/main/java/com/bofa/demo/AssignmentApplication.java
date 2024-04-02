package com.bofa.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bofa.bean.Employee;
import com.bofa.config.AppConfig;
import com.bofa.service.CustomerService;
import com.bofa.service.EmployeeServiceDAOImpl;

@SpringBootApplication
@EnableAutoConfiguration
public class AssignmentApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AssignmentApplication.class, args);
		ApplicationContext context=SpringApplication.run(AppConfig.class);
		CustomerService lookup=(CustomerService) context.getBean("CustomerService");
		System.out.println(lookup.addCustomer("My Name"));
		System.out.println(lookup.updateCustomer("Update"));
		lookup.listCustomer();
		System.out.println(lookup.deleteCustomer("pradeep"));
		
		EmployeeServiceDAOImpl employeeJDBCTemplate = 
				context.getBean(EmployeeServiceDAOImpl.class);
					
		// method call here 
		runEmployeeCRUD(employeeJDBCTemplate);
	}

	 public static void runEmployeeCRUD(EmployeeServiceDAOImpl 
	    		employeeJDBCTemplate) {
				
			// create the employee data 
			
	          employeeJDBCTemplate.setupDB();
			
			System.out.println("------Records Creation--------");
			employeeJDBCTemplate.create("siddu", 11);
			employeeJDBCTemplate.create("bano", 2);
			employeeJDBCTemplate.create("gridhar", 15);

			System.out.println("------Listing Multiple Records--------");
			List<Employee> employees = employeeJDBCTemplate.listEmployees();
			for (Employee record : employees) {
				System.out.print("ID : " + record.getId());
				System.out.print(", Name : " + record.getName());
				System.out.println(", Age : " + record.getAge());
			}
			
			/*
			System.out.println("----Updating Record with ID = 2 -----");
			employeeJDBCTemplate.update(2, 20);

			System.out.println("----Listing Record with ID = 2 -----");
			Employee employee = employeeJDBCTemplate.getEmployee(2);
			System.out.print("ID : " + employee.getId());
			System.out.print(", Name : " + employee.getName());
			System.out.println(", Age : " + employee.getAge());
			 */

	        
			
			
		}
}
