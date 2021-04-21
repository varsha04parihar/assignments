package com.training_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao
{
	 private static Statement statement = null;
	    private Connection conn;

	    public EmployeeDaoImpl() throws SQLException 
	    {
	        conn = ConnectFactory.getConnection();
	        statement = conn.createStatement();
	    }

	    @Override
	    public void addEmployee(Employee employee) throws SQLException 
	    {
	    	 // write code to add employee into mysql database
	        String sql = "insert into Employee_data values (" + employee.getEmpId() + ", '" + employee.getName() + "', '" + employee.getEmail() + "')";
	        int count = 0;
	        count = statement.executeUpdate(sql);

	        if (count > 0) {
	            System.out.println("Employee saved");
	        } else {
	            System.out.println("Try Again");
	        }
	    	
	    	
	    	
			
	    	/*
				 * BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				 * System.out.println("Enter id ,name and email of employee"); int i=br.read();
				 * String n=br.readLine(); String e=br.readLine();
				 * 
				 * PreparedStatement ps=conn.prepareStatement("insert into Employee_data" +
				 * " values(?,?,?)");
				 * 
				 * ps.setInt(1, i); ps.setString(2, n); ps.setString(3, e);
				 * 
				 * 
				 * //execute ps int result=ps.executeUpdate();
				 * 
				 * if(result==1) System.out.println("Record Updated using Prepared Statement");
				 * else { System.out.println("Please try again");
				 * 
				 * }
				 */
	    	
	    }

	    @Override
	    public void updateEmployee(Employee employee) throws SQLException 
	    {
	    	/*
	    	try {
	    		
	    		String query1=
	    				"update Employee_data set email='"+employee.getEmail()+"'"
	    						+ " where name='"+employee.getName()+"'";
	    				//+ "and id='"+employee.getEmpId()+"'";
	

				 int res = statement.executeUpdate(query1);
			
			if(res>0)
				System.out.println("Record Updated");
			else
			
				System.out.println("Please try again");

			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/
	    	 String sql = "update Employee_data set name='"+employee.getName()+"', email='"+employee.getEmail()+"' where id="+ employee.getEmpId();
	         int count = 0;
	         count = statement.executeUpdate(sql);

	         if (count > 0) {
	             System.out.println("Employee saved");
	         } else {
	             System.out.println("Not completed");
	         }
	    }

	    public void deleteEmployee(int id) throws SQLException 
	    {
	    	String sql = "delete from Employee_data where id= "+ id;
	        int count = 0;
	        count = statement.executeUpdate(sql);

	        if (count > 0) {
	            System.out.println("Employee saved");
	        } else {
	            System.out.println("Not completed");
	        }
	    	/*
	    	try {
	    		
	    		String query2=
	    				"delete from Employee_data where id=5";
	    		 //'"+employee.getEmpId()+"'";
	    		
	    				
	

				 int res1 = statement.executeUpdate(query2);
			
			if(res1>0)
				System.out.println("Record deleted");
			else
			
				System.out.println("Please try again");

			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	    }

	    @Override
	    public Employee getEmployeeById(int id) throws SQLException 
	    {
	    	
	    	 Employee employee = null;
	         String sql = "select * from Employee_data where id = "+ id;
	         ResultSet rs = statement.executeQuery(sql);
	         if(rs.next()){
	             int empId = rs.getInt("id");
	             String name = rs.getString("name");
	             String email = rs.getString("email");
	             employee = new Employee(empId, name, email);
	         }
	         System.out.println(employee.getEmpId()+"\t"+employee.getName()+"\t"+employee.getEmail());
	         return employee;
	     
/*
	   
	    		Employee employee=null;
	    		String query2=
	    				"select * from Employee_data where id="+empId;
	    		 //'"+employee.getEmpId()+"'";
	    		
	    				
	

				
					ResultSet rs = statement.executeQuery(query2);
					 while(rs.next())
				        {
				        	int id=rs.getInt("id");
				        	String name=rs.getString("name");
				        	String email=rs.getString("email");
				        	Employee employee1= new Employee(id,name,email);
				        	
				        }
			return employee;
				*/
	    	
				
	

	    }

	    @Override
	    public List<Employee> getEmployees() throws SQLException
	    {
	    	
	        List<Employee> list=new ArrayList<Employee>();
	        String sql="select * from Employee_data";
	        ResultSet rs=statement.executeQuery(sql);
	        while(rs.next())
	        {
	        	int id=rs.getInt("id");
	        	String name=rs.getString("name");
	        	String email=rs.getString("email");
	        	Employee employee= new Employee(id,name,email);
	        	list.add(employee);
	        }
			return list;
	       
	  

	     }
}
