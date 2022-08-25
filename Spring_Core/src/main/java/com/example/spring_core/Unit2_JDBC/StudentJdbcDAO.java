package com.example.spring_core.Unit2_JDBC;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcDAO {
    @Autowired
    private PlatformTransactionManager transactionManager;

    public void save(Object name , Object age){
        TransactionDefinition def =new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        String countQuery ="Select count(*) from student";
        try {
            int count = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("before count = " + count);
            String sql ="insert into student(name, age) values(?,?)";
            jdbcTemplate.update(sql, name, age);
            int save = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("after save = " + save);
            String coutQuery="Select count(*) from student";
            int count1 = jdbcTemplate.queryForObject(coutQuery, Integer.class);
            transactionManager.commit(status);
        } catch (DataAccessException e) {
            transactionManager.rollback(status);
            LOGGER.error("Error in save", e);
            int total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("after count = " + total);
        }
    }
   private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class.getName());


    private String insertQuery;

    @Autowired
    DataSource dataSource;


     JdbcTemplate jdbcTemplate;

    public void setDataSource( DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    private void createTableIFNotExists() throws SQLException {
      try {


        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "STUDENT_HUY1", null);

//        if (rs.next()) {
//            jdbcTemplate.execute("create table STUDENT_HUY1 (id int primary key,name varchar(255), age int)");
//        }
          String sql="create table STUDENT_HUY1 (ID int primary key " +
                  ",name varchar(255)," +
                  "age int)";
//          jdbcTemplate.execute(sql);
      }catch (SQLException e) {
          e.printStackTrace();

      }
    }


    public void insert(String name, int age) {

        jdbcTemplate.update(insertQuery,name, age);
        LOGGER.info("Created Record Name = " + name + " Age = " + age);
    }


    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery;
    }

    public int totalRecord(){
            return jdbcTemplate.execute(new StatementCallback<Integer>() {
                @Override
                public Integer doInStatement(Statement stmt) throws SQLException, DataAccessException {
                    ResultSet rs = stmt.executeQuery("select count(*) from STUDENT_HUY1");
                    return rs.next()?rs.getInt(1):0;
                }
            });
    }
    private final static class StudentRowMapper implements org.springframework.jdbc.core.RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            try {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            return student;
        }catch (Exception e){
                LOGGER.error(e,e);
                return null;
            }
        }
    }
    public List loadStudent(String name){
        return jdbcTemplate.query("select * from STUDENT_HUY1 where name=?", new Object[]{name}, new StudentRowMapper());

    }
    private String updateAgeByNameQuery= "update STUDENT_HUY1 set age = ? where name = ?";
    public void updateAgeByName(String name, int age) {
        jdbcTemplate.update(updateAgeByNameQuery, age, name);
        LOGGER.info("Updated Record Name = " + name + " Age = " + age);
    }
    public int[]add(List<Student> students){
        List<Object[]> batch = new ArrayList<>();
        for (Student student:students){
            batch.add(new Object[]{student.getName(),student.getAge()});
        }
//      List<Object[]> batch =  students.stream().map(student -> new Object[]{student.getName(),student.getAge()}).collect(java.util.stream.Collectors.toList());
        return jdbcTemplate.batchUpdate("insert into STUDENT_HUY1 (name,age) values (?,?)",batch);
    }
}
