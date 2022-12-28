package org.example;

import org.example.execute.MysqlExecute;
import org.example.execute.PostgreSqlExecute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        logger.info("\n****  CONNECTED TO MYSQL DATABASE  **** ");
        MysqlExecute m = new MysqlExecute();
        ResultSet resultset1 = m.ExecuteMysqlQuery();

        logger.info("\n****  CONNECTED TO POSTGRESQL DATABASE  **** ");
        PostgreSqlExecute p = new PostgreSqlExecute();
        ResultSet resultset2 = p.ExecutePostgresQuery();

        System.out.println("\n___Comparing Tables from Two DataBases___");
        System.out.println("------------------------------------------");
        CompareResultset(resultset1, resultset2);
    }

    public static void CompareResultset(ResultSet resultSet1, ResultSet resultSet2) throws SQLException {
        try {
            while (resultSet1.next()) {
                String empid = resultSet1.getString("empid");
                String name = resultSet1.getString("name");
                String skill = resultSet1.getString("skill");
                while (resultSet2.next()) {
                    String empid1 = resultSet2.getString("empid");
                    String name1 = resultSet2.getString("name");
                    String skill1 = resultSet2.getString("skill");
                    if (empid.equals(empid1)) {
                        if (name.equals(name1)) {
                            if (skill.equals(skill1)) {
                                System.out.println(" Similar Data in the Table ");
                            } else {
                                logger.info("Skill Data Mismatch");
                            }
                        } else {
                            logger.info("Name Data Mismatch");
                        }
                    } else {
                        logger.info("Employee_ID Data Mismatch");
                    }
                }
            }
        } catch (SQLException e) {
            logger.info(" Data's MisMatch Found ");
        }
    }
}

