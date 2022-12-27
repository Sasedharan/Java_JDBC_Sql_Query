package org.example.execute;

import org.example.connection.SqlConnection;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MysqlExecute {

    public ResultSet ExecuteMysqlQuery() throws SQLException {
        SqlConnection mysql = new SqlConnection();
        Connection mysqlConnection = mysql.connectMysql();
        Scanner scanner = new Scanner(System.in);
        PreparedStatement pstmt = null;
/*
        ResultSet res = mysqlConnection.prepareStatement("select * from EMPLOYEE where rollnumber = 1")
                .executeQuery();
        return res;*/

         pstmt = mysqlConnection.prepareStatement("select truncate(num1,?) from functions ");
         System.out.println("Enter the value to be truncated");
         try {
             pstmt.setDouble(1, scanner.nextInt());
         }catch (RuntimeException e){
             System.out.println("Enter Correct Datatype");
         }
        ResultSet res = pstmt.executeQuery();
        return res;
    }
}
