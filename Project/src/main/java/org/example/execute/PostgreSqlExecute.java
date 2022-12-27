package org.example.execute;

import org.example.connection.PostgreSqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PostgreSqlExecute {

    public ResultSet ExecutePostgresQuery() throws SQLException {
        PostgreSqlConnection postgres = new PostgreSqlConnection();
        Connection postgresConnection = postgres.connectPostgres();
        Scanner scanner = new Scanner(System.in);
        PreparedStatement pstmt = null;

           /* ResultSet rs = postgresConnection.prepareStatement("select * from EMPLOYEE where rollnumber = 1")
                    .executeQuery();
            return rs;
     */
        pstmt = postgresConnection.prepareStatement("select trunc(num1,?) from functions");
        System.out.println("Enter the value to be truncated");
        try {
            pstmt.setDouble(1, scanner.nextInt());
        }catch (RuntimeException e){
            System.out.println("Enter Valid Datatype");
        }
             ResultSet res1 =pstmt.executeQuery();
             return res1;
    }
}
