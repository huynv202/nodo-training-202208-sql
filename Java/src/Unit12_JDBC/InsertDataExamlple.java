package Unit12_JDBC;

import java.io.File;
import java.sql.*;

public class InsertDataExamlple {
    public static void main(String[] args) throws SQLException {
        Connection connection =null;
        Statement statement = null;
        try {

//            File file = new File("./sampledb");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
            statement = connection.createStatement();


        // insert
//            statement.execute("insert into STUDENT_HUY(name,age)values ('Tran Van B',20)");
//            statement.execute("insert into STUDENT_HUY(name,age)values ('Tran Thi B',22)");
//            statement.execute("insert into STUDENT_HUY(name,age)values ('Nguyen Van A',18)");

            //select-------------------
            ResultSet rs = statement.executeQuery("select * from STUDENT_HUY");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id+"\t"+name+"\t"+age);

            }
            rs.close();
            connection.close();
//---------------------------------

//Transaction
//            connection.setAutoCommit(false);
//            for (int i =0;i<10;i++){
//                String name = "Tran Van" + i;
//                int age =10+i;
//                statement.executeUpdate("insert into STUDENT_HUY(id, name, age) values " +
//                        "'('+STUDENT_HUY_SEQ.nextval+','+name+','+age+')'");
//
//            }
//            connection.rollback();
//            connection.setAutoCommit(true);
//            ResultSet rs = statement.executeQuery("select * from STUDENT_HUY");
//           rs = statement.executeQuery("select count(*)from STUDENT_HUY");
//           if(rs.next()){
//               System.out.println("total records ="+rs.getInt(1));
//               connection.close();
//           }
//
//           //batch
//            for(int i =0;i<20;i++){
//                int id = 7+i;
//                String name ="KKa" +i;
//                int age =20+i;
//                String sql ="insert into STUDENT_HUY values" +
//                        "'('+"+id+"+','+"+name+"+','+"+age+"+')'";
//                statement.addBatch(sql);
//            }
//            statement.executeBatch();
//            ResultSet rs;
//            rs = statement.executeQuery("select  count(*) from STUDENT_HUY");
//            if(rs.next()){
//                System.out.println("total records ="+rs.getInt(1));
//                connection.close();
//            }

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
