package com.training_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws SQLException, IOException
	{
		 Scanner scanner = new Scanner(System.in);
		 int option;
		while(true)
		{
		 
	        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
	        System.out.println("*************Menu************");
	        
	        System.out.println("Please select any one options");
	        System.out.println("------------------------------");
	        System.out.println("Press 1: Insert record");
	        System.out.println("Press 2: Update record");
	        System.out.println("Press 3: Delete record");
	        System.out.println("Press 4: Get a record");
	        System.out.println("Press 5: Get all the records");
	        System.out.println("Press 6: Exit");
	        System.out.println("-------------------------------");

	        option = scanner.nextInt();
	        switch (option)
	        {
	            case 1: {
	                insert();
	                break;
	            }
	            case 2: {
	                update();
	                break;
	            }
	            case 3: {
	                delete();
	                break;
	            }
	            case 4: {
	                get();
	                break;
	            }
	            case 5:{
	            	all();
	            	break;
	            }
	            case 6:
	            {
	            	return;
	            }
	            default: {
	                System.out.println("Incorrect options");
	            }
	        }


		}

	        //EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
	        //Employee employee = new Employee(1, "mark", "m@gmail.com");
	        //dao.addEmployee(employee);

	//
//	        Scanner scanner = new Scanner(System.in);
//	        System.out.print("Enter EmpId: ");
//	        int id = scanner.nextInt();
	//
//	        System.out.print("Enter Employee Name: ");
//	        String name = scanner.next();
	//
//	        System.out.print("Enter Employee Email: ");
//	        String email = scanner.next();
	//
//	        Employee employee = new Employee(id, name, email);
//	        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
//	        dao.addEmployee(employee);


	       
	        
	    }
	

	
	    private static void insert() throws SQLException
	    {
	    	EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();

	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print("Enter EmpId: ");
	        int id = scanner.nextInt();

	        System.out.print("Enter Employee Name: ");
	        String name = scanner.next();

	        System.out.print("Enter Employee Email: ");
	        String email = scanner.next();

	        Employee employee = new Employee(id, name, email);
	        EmployeeDao dao1 = EmployeeDaoFactory.getEmployeeDao();
	        dao1.addEmployee(employee);
	    }

	    private static void update() throws SQLException
	    {
	    	EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();

	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print("Enter EmpId: ");
	        int id = scanner.nextInt();

	        System.out.print("Enter Employee Name: ");
	        String name = scanner.next();

	        System.out.print("Enter Employee Email: ");
	        String email = scanner.next();

	        Employee employee = new Employee(id, name, email);
	        EmployeeDao dao1 = EmployeeDaoFactory.getEmployeeDao();
	        dao1.updateEmployee(employee);
	    }

	    private static void delete() throws SQLException
	    {
	    	EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();

	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print("Enter EmpId: ");
	        int id = scanner.nextInt();

	        

	        Employee employee = new Employee(id);
	        EmployeeDao dao1 = EmployeeDaoFactory.getEmployeeDao();
	        dao1.deleteEmployee(id);

	    }
	    private static void get() throws SQLException
	    {
	    	EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();

	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print("Enter EmpId: ");
	        int id = scanner.nextInt();

	        

	        Employee employee = new Employee(id);
	        EmployeeDao dao1 = EmployeeDaoFactory.getEmployeeDao();
	        dao1.getEmployeeById(id);

	    }


	    private static void all() throws SQLException {

	        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
	        List<Employee> list =  dao.getEmployees();
	        for (Employee emp:list) {
	            System.out.println(emp.toString());
	        }
	    }
	    
}

