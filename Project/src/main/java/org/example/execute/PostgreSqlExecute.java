package org.example.execute;

import org.example.connection.PostgreSqlConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Scanner;

public class PostgreSqlExecute {

    Logger log = LoggerFactory.getLogger(PostgreSqlExecute.class);

    public ResultSet ExecutePostgresQuery() throws SQLException {
        PostgreSqlConnection postgres = new PostgreSqlConnection();
        Connection postgresConnection = postgres.connectPostgres();
        Scanner scanner = new Scanner(System.in);
        PreparedStatement pstmt = null;

        ResultSet rs = postgresConnection.prepareStatement("select * from EMPLOYEE1 where empid =2")
                .executeQuery();
        log.info("\n\n___TRUNCATE FUNCTION___");
        try {
            pstmt = postgresConnection.prepareStatement("select trunc(num1,? :: integer) from functions");
            System.out.println("Enter no.of digit to be truncate");
            pstmt.setDouble(1, scanner.nextInt());
            ResultSet res1 = pstmt.executeQuery();
            res1.next();
            System.out.println("The Truncated Value is : " + res1.getDouble(1) + "\n");

        } catch (RuntimeException e) {
            System.out.println("Wrong Input - Require Integer Datatype");
        }
        return rs;
    }
}
