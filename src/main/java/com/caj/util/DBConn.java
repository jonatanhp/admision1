/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Ibañez1
 */
public class DBConn {
   
    public Connection conn=null;
    public Connection conn1=null;
    public Connection getDBConnOSQL() throws Exception{
        if(conn==null){
            try{
                //DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
				/*
				 * DriverManager.registerDriver (new postgre);
				 * conn=DriverManager.getConnection("jdbc:oracle:thin:@10.75.23.120:1521:cajdb",
				 * "sicam","produccion2015");
				 */
                
                
                String url = "jdbc:postgresql://localhost:5433/rail2";
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password", "Cuaster1023.");
                //props.setProperty("ssl", "true");
                Connection conn = DriverManager.getConnection(url, props);
                this.conn = conn;
               
                
                
                return conn;
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
	    return conn;
    }
    
    
}