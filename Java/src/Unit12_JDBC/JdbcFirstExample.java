package Unit12_JDBC;

import java.io.File;
import java.sql.*;

public class JdbcFirstExample {
    public static void main(String[] args) throws SQLException {
        Connection connection =null;
        Statement statement = null;
        try {
            File file = new File("./sampledb");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
            statement = connection.createStatement();
//            String sql ="create table student_huy"
//                    +"("
//                    +"id int primary key ,"
//                    +"name varchar(100),"
//                    +"age int default (20)"
//                    +")";
//
//            String seq= "create sequence student_huy_seq\n" +
//                    "start with 1\n" +
//                    "increment by 1 ";
//            statement.execute("insert into STUDENT_HUY(id,name,age)values (student_huy_seq.nextval,'Tran Van B',20)");
//            statement.execute("insert into STUDENT_HUY(id,name,age)values (student_huy_seq.nextval,'Tran Thi B',22)");
//            statement.execute("insert into STUDENT_HUY(id,name,age)values (student_huy_seq.nextval,'Nguyen Van A',18)");

//            System.out.println(statement.execute(sql));
//            System.out.println(statement.execute(seq));
//            System.out.println("db path"+file.getAbsolutePath());
//            System.out.println("Create database successful!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            statement.close();
            connection.close();

        }
    }
}
