package com.training_java;

import java.sql.SQLException;

public class EmployeeDaoFactory {

    private static EmployeeDao dao;

    public static EmployeeDao getEmployeeDao() throws SQLException {
        if(dao==null){
            dao = new EmployeeDaoImpl();
        }
        return dao;
    }

}
