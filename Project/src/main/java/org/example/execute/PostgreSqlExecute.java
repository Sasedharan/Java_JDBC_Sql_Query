package org.example.execute;

import org.example.connection.PostgreSqlConnection;

import java.sql.*;
import java.util.Scanner;

public class PostgreSqlExecute {

    public ResultSet ExecutePostgresQuery() throws SQLException {
        PostgreSqlConnection postgres = new PostgreSqlConnection();
        Connection postgresConnection = postgres.connectPostgres();
        Scanner scanner = new Scanner(System.in);
        ResultSetMetaData rsmd = null;
        PreparedStatement pstmt = null;

            ResultSet rs = postgresConnection.prepareStatement("select * from EMPLOYEE where rollnumber =2")
                    .executeQuery();
            return rs;


       /* pstmt = postgresConnection.prepareStatement("select round(num1,? :: integer) from functions");
        System.out.println("Enter the round_off digit");
        try {
            pstmt.setDouble(1, scanner.nextInt());
        }catch (RuntimeException e){
            System.out.println("Required Type - Integer");

        }
             ResultSet res1 =pstmt.executeQuery();
             res1.next();
             return res1;*/
    }
}
