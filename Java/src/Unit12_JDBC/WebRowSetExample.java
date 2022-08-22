package Unit12_JDBC;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;

public class WebRowSetExample {
    public static void main(String[] args) {
        Connection connection =null;
        Statement statement = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select  * from STUDENT_HUY");
            File file =new File("output.xml");
            Writer writer= new FileWriter(file);
            WebRowSet webRowSet = RowSetProvider.newFactory().createWebRowSet();
            webRowSet.writeXml(rs,writer);
            Desktop.getDesktop().open(file);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {

        }
    }
}
