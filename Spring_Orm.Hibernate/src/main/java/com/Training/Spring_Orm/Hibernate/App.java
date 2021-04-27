package com.Training.Spring_Orm.Hibernate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Training.Spring_Orm.Hibernate.dao.EmployeeDao;
import com.Training.Spring_Orm.Hibernate.entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
          EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);
          
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          
          while(true)
          {
        	  System.out.println("----------------------------");
        	  System.out.println("***********Menu************");
        	  System.out.println("----------------------------");
        	  System.out.println("1. Add Employee");

        	  System.out.println("2. Display all Employee");
        	  System.out.println("3. Display Employee by Id");
        	  System.out.println("4. Delete an Employee");
        	  System.out.println("5. Update an Employee");
        	  System.out.println("6. Exit");
        	  System.out.println("-----------------------------");
        	  
        	  try
        	  {
        		  int choice= Integer.parseInt(br.readLine());
        		  switch(choice)
        		  {
	        		  case 1:
	        		  
	        			  System.out.println("Enter employee id,name and email :");
	        			  int id=Integer.parseInt(br.readLine());
	        			  String name=br.readLine();
	        			  String email=br.readLine();
	        			  Employee newEmployee = new Employee();
	        		         
	        	          newEmployee.setId(id);
	        	          newEmployee.setName(name);
	        	          newEmployee.setEmail(email);
	        	          
	        	          int result =  dao.addEmployee(newEmployee);
	        	          System.out.println("("+result+") rows inserted...");
	        	          		
	        	          break;
	        		  
	        		  case 2:
	        			  List<Employee> employees=dao.getAllEmployee();
	        			  for(Employee employee : employees)
	        			  {
	        				  System.out.println(employee.getId()+"\t"+employee.getName()+"\t"+employee.getEmail());
	        				  
	        				  
	        			  }
	        			  break;
	        			 
	        		  case 3:
	        			  System.out.println("Enter employee id to display the employee :");
	        			  int id1=Integer.parseInt(br.readLine());
	        			  //Employee newEmployee1 = new Employee();
	        			 // Employee getEmployeeById = new Employee();
	        			  //getEmployeeById.setId(id1);
	        			 // dao.getEmployeeById(id1);
	        			  Employee getEmployeeById = new Employee();
	        			  getEmployeeById.setId(id1);
	        			  //dao.getEmployeeById(id1);
	        			  
	        			  
	        			  Employee employee2 = dao.getEmployeeById(id1);
	      				System.out.println(employee2);

        				  System.out.println(employee2.getId()+"\t"+employee2.getName()+"\t"+employee2.getEmail());

	        			  break;
	        		  
	        		  case 4:
	        			  System.out.println("Enter employee id to delete the employee :");
	        			  int id2=Integer.parseInt(br.readLine());
	        			  Employee deleteEmployee = new Employee();
	        			  
	        		        deleteEmployee.setId(id2);
	        			  dao.deleteEmployee(id2);
	        			  break;
	        			  
	        		  case 5:
	        			  System.out.println("Enter updated employee id,name and email :");
	        			  int id3=Integer.parseInt(br.readLine());
	        			  String name3=br.readLine();
	        			  String email3=br.readLine();
	        			  Employee updateEmployee = new Employee();
	        			  updateEmployee.setId(id3);
	        			  updateEmployee.setName(name3);
	        			  updateEmployee.setEmail(email3);
	        			  dao.updateEmployee(updateEmployee);
	        			  System.out.println("Updated successfully");
	        			  break;
	        			  
	        		  case 6:
	        			  System.exit(0);
	        			  break;
	        			  
	        			default :
	        				System.out.println("Wrong Choice!!!");
	        				break;
        		  }
        	  }
        	  catch (Exception e) {
        		  System.out.println(e);
				// TODO: handle exception
			}

          }
          
         
    }
}
