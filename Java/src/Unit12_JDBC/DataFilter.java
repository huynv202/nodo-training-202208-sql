package Unit12_JDBC;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;
import java.util.function.Predicate;

public class DataFilter implements Predicate {
    @Override
    public boolean test(Object o) {
        return false;
    }
    boolean evaluate(RowSet rowSet) throws SQLException {
        CachedRowSet cachedRowSet = (CachedRowSet) rowSet;
        return cachedRowSet.getString("name").indexOf("Nguyen")>-1;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet();
        frs.setUrl("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
        frs.setCommand("Select * from STUDENT_HUY");
        DataFilter fil = new DataFilter();
        frs.setFilter(frs.getFilter());
        frs.execute();
        System.out.println("ID\tName\t\tAge");
        while (frs.next()){
            System.out.println("id"+"\t"+ frs.getString(2)+"\t"+frs.getInt(3));
        }
    }
}
