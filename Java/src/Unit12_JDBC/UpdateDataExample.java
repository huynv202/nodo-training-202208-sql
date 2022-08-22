package Unit12_JDBC;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection=null;
        File file = new File("./sampledb");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");

        PreparedStatement statement = connection.prepareStatement("UPDATE STUDENT_HUY SET Name =? WHERE ID=?");
        statement.setString(1,"ok");
        statement.setInt(2,5);
        statement.executeUpdate();
        connection.close();
    }
}
