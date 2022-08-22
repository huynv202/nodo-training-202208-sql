package Unit12_JDBC;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class DataAccessLogic {
    private final static Logger logger = Logger.getLogger(DataAccessLogic.class.getName());
    Connection connection =null;
    CachedRowSet rowSet;

    public DataAccessLogic() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
        rowSet = RowSetProvider.newFactory().createCachedRowSet();
        rowSet.setCommand("Select * from STUDENT_HUY");
        rowSet.execute(connection);
    }
    public void disconnect(){
        try {
            if(connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            logger.log(Level.WARNING,e.toString());
        }
    }
    int pageSize =10;
    List<String> loadNames (int page) throws SQLException {
        List names =new ArrayList() ;
        rowSet.setPageSize(pageSize);
        int start = (page - 1) * pageSize + 1;
        if (!rowSet.absolute(start)) {
            return names;

        }
        rowSet.previous();
        while (rowSet.next()) {
            names.add(rowSet.getString("name"));
            if (names.size() >= pageSize) {
                break;
            }
        }
        return names;
    }

    int numberOfPage() throws SQLException {
        Statement statement=null;
        try {
            statement= connection.createStatement();
            ResultSet rs =  statement.executeQuery("SELECT COUNT(*) from STUDENT_HUY");
            if(!rs.next()){
                return 0;
            }
            int total = rs.getInt(1);
            int totalPage = total/pageSize;
            if(total% pageSize!=0){
                totalPage++;
            }
            return totalPage;
        }finally {
            statement.close();
        }

    }

    public static void main(String[] args) throws SQLException {
        DataAccessLogic data = new DataAccessLogic();
        AtomicReference<List<String>> names = new AtomicReference<>(data.loadNames(1));
        names.get().forEach(System.out::println);
        System.out.println("total page ="+data.numberOfPage());
        IntStream.range(1,data.numberOfPage()+1).forEach(page->{
            System.out.println("+++++++++++++++++"+page);
            try {
                names.set(data.loadNames(page));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println(names);
        });
    }
}
