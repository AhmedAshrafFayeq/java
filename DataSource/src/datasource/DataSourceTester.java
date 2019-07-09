/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
//import javax.sql.DataSource;

/**
 *
 * @author ahmed
 */
public class DataSourceTester {

    public static void main(String[] args) {
        testDataSource();
    }

    private static void testDataSource() {
        DataSource dataSource;
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            dataSource = DataSourceFactory.getMySQLDataSource();
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from employeedb.employee");
            while (resultSet.next()) {
                System.out.println("EmpID= " + resultSet.getInt("ID") + "  Name= " + resultSet.getString("Name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataSourceTester.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataSourceTester.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
