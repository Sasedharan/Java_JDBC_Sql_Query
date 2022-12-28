package org.example.execute;

import org.example.connection.SqlConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class MysqlExecute {
    Logger log = LoggerFactory.getLogger(MysqlExecute.class);

    public ResultSet ExecuteMysqlQuery() throws SQLException {
        SqlConnection mysql = new SqlConnection();
        Connection mysqlConnection = mysql.connectMysql();
        Scanner scanner = new Scanner(System.in);
        PreparedStatement pstmt = null;

        ResultSet rs = mysqlConnection.prepareStatement("select * from EMPLOYEE1 where empid = 3")
                .executeQuery();
        log.info("\n\n___ROUND_OFF Function___");
        try {
            pstmt = mysqlConnection.prepareStatement("select round(num1,?) from functions;");
            System.out.println("Enter the no.of digit to be round_off");
            pstmt.setDouble(1, scanner.nextInt());
            ResultSet res1 = pstmt.executeQuery();
            res1.next();
            System.out.println("The Round-Off Value is : " + res1.getDouble(1) + "\n");
        } catch (RuntimeException e) {
            System.out.println("Wrong Input - Require Integer Datatype\n");
        }
        return rs;
    }
}
