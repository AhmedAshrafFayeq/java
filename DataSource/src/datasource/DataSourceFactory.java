/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.IOException;
import javax.sql.DataSource;

/**
 *
 * @author ahmed
 */
public class DataSourceFactory {

    public static DataSource getMySQLDataSource() {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        MysqlDataSource dataSource = null;
        try {
            fileInputStream = new FileInputStream("db.properties");
            properties.load(fileInputStream);
            dataSource = new MysqlDataSource();
            dataSource.setURL(properties.getProperty("MYSQL_DB_URL"));
            dataSource.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
            dataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataSourceFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataSourceFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dataSource;

    }

}
