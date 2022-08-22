package Unit12_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStoredProducedureExample {
    public static void main(String[] args) throws SQLException {
        Connection connection =null;
        Statement statement =null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
            statement = connection.createStatement();
            statement.executeUpdate("create procedure getage2312312(stream_name VARCHAR(255),out age int)"+
                    " parameter style java reads "+
                    " sql data language java external name "+
                    " 'jdbc.DbFunction.getAge'");
            System.out.println("Done");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
    }
}
