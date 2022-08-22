package Unit12_JDBC;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMetadataExample {
    public static void main(String[] args) throws SQLException {
        Connection connection =null;
        try {
//            File file = new File("./sampledb");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("db version "+metaData.getDatabaseMajorVersion());
            System.out.println("Driver name: "+metaData.getDriverName());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
    }
}
