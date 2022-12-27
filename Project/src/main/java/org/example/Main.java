package org.example;

import org.apache.log4j.Logger;
import org.example.connection.SqlConnection;
import org.example.execute.MysqlExecute;
import org.example.execute.PostgreSqlExecute;

import java.sql.*;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        logger.info("Connected to MySql Database");

        MysqlExecute m = new MysqlExecute();
        ResultSet resultset1 = m.ExecuteMysqlQuery();

      /*  resultset1.next();{
            System.out.println("RollNo :" + resultset1.getString(1));
            System.out.println("Empcode :" + resultset1.getString(2));
            System.out.println("Ename :" + resultset1.getString(3));
            System.out.println("Skill :" + resultset1.getString(4));
        }*/


        logger.info("Postgres - Connected");

        PostgreSqlExecute p = new PostgreSqlExecute();
        ResultSet resultset2 = p.ExecutePostgresQuery();

        /* resultset2.next();
        {
            System.out.println("RollNo :" + resultset2.getString(1));
            System.out.println("Empcode :" + resultset2.getString(2));
            System.out.println("Ename :" + resultset2.getString(3));
            System.out.println("Skill :" + resultset2.getString(4));
        }*/

        CompareResultset(resultset1, resultset2);


    }

    public static void CompareResultset(ResultSet resultSet1, ResultSet resultSet2) throws SQLException {
      /*  try{
        while((resultSet1.next() && resultSet2.next())) {
            String result1 = resultSet1.getString(1);
            String result2 = resultSet2.getString(1);
            if (result1.startsWith(result2)) {
                System.out.println("Data Match");
                System.out.println(result1.startsWith(result2));
            } else {
                throw new SQLException();

            }
        }
            } catch (SQLException e) {
                System.out.println("Data Mismatch");

            }
        }*/
        try {
            while (resultSet1.next()) {
                String result1 = resultSet1.getString(1);
                while (resultSet2.next()) {
                    String result2 = resultSet2.getString(1);
                    if (result1.startsWith(result2)) {
                        System.out.println("Data Match");
                        System.out.println(result1.startsWith(result2));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("MisMatch Data");
        }
    }
  public void functions(){

  }
}