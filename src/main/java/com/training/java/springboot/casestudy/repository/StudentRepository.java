package com.training.java.springboot.casestudy.repository;

import com.training.java.springboot.casestudy.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate postgresJdbcTemplate;

    public void addNewStudent(Student student){
        StringBuffer sql = new StringBuffer();
        try {
            sql.append("INSERT INTO student (firstname, lastname, room, created_date) VALUES ")
               .append("( ?, ?, ?, now() )");
            System.out.println("  Insert sql : "+sql.toString());

            postgresJdbcTemplate.update(sql.toString(), student.getFirstname(), student.getLastname(), student.getRoom());

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            // do something
        }
    }

    public List<Student> listAllStudent() throws Exception {
        List<Student> resultlist = new ArrayList<Student>();

        StringBuffer sqlBuff = new StringBuffer();
        sqlBuff.append("SELECT id, firstname, lastname, room, created_date, updated_date FROM student ");
        // sqlBuff.append("WHERE TASK_GROUP = ? ");

        resultlist = postgresJdbcTemplate.query(
                sqlBuff.toString(),
                new ResultSetExtractor<List<Student>>(){
                    public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException, SQLException {
                        List<Student> list = new ArrayList<Student>();
                        while(rs.next()){
                            Student student = new Student();
                            student.setId(rs.getInt("id"));
                            student.setFirstname(rs.getString("firstname"));
                            student.setLastname(rs.getString("lastname"));
                            student.setRoom(rs.getString("room"));
                            student.setCreatedDate(rs.getTimestamp("created_date"));
                            student.setUpdatedDate(rs.getTimestamp("updated_date"));

                            list.add(student);
                        }
                        return list;
                    }
                }
        );

        return resultlist;
    }
}
