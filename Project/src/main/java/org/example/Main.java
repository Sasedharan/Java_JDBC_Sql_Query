package org.example;

import org.example.execute.MysqlExecute;
import org.example.execute.PostgreSqlExecute;


import java.sql.*;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws SQLException {

        logger.info("Connected to MySql Database");

        MysqlExecute m = new MysqlExecute();
        ResultSet resultset1 = m.ExecuteMysqlQuery();

        logger.info("Postgres - Connected");

        PostgreSqlExecute p = new PostgreSqlExecute();
        ResultSet resultset2 = p.ExecutePostgresQuery();

       /* System.out.println("The Round off Value is : " + resultset1.getDouble(1));
        System.out.println("The Round off Value is : " + resultset2.getDouble(1));*/

       CompareResultset(resultset1, resultset2);

    }

    public static void CompareResultset(ResultSet resultSet1, ResultSet resultSet2) throws SQLException {
             ResultSetMetaData rsmd = null;
        try {
            while (resultSet1.next()) {
                String result1 = resultSet1.getMetaData().toString();
                System.out.println(result1);
                while (resultSet2.next()) {
                    String result2 = resultSet2.getMetaData().toString();
                    System.out.println(result2);
                    if (result1.equals(result2)) {
                        System.out.println("Data Match");
                        System.out.println(result1.equals(result2));
                    }else{
                        throw new SQLException();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Data Mismatch : "+" "+ " with " + " " );
        }

    }
}
