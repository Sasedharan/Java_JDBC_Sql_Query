package org.example.execute;

import org.example.connection.SqlConnection;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class MysqlExecute {

    public ResultSet ExecuteMysqlQuery() throws SQLException {
        SqlConnection mysql = new SqlConnection();
        Connection mysqlConnection = mysql.connectMysql();
        Scanner scanner = new Scanner(System.in);
        ResultSetMetaData rsmd = null;
        PreparedStatement pstmt = null;
        ResultSet res = mysqlConnection.prepareStatement("select * from EMPLOYEE where rollnumber = 1")
                .executeQuery();
        return res;
         /*pstmt = mysqlConnection.prepareStatement("select round(num1,?) from functions;");
         System.out.println("Enter the digit");
         try {
             pstmt.setDouble(1, scanner.nextInt());
         }catch (RuntimeException e){
             System.out.println("Required Type - Integer");

         }
        ResultSet res1 = pstmt.executeQuery();
         res1.next();
        return res1;*/
    }
}
