package com.training.java.springboot.casestudy.repository;

import com.training.java.springboot.casestudy.bean.Student;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import javax.sql.DataSource;

@Repository
public class TestConstructorDAO {

    private Connection conn = null;


    public void setConnection(Connection conn){
        this.conn = conn;
    }

    public void addNewStudent(Student student) throws SQLException {

        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int rowAffected = -1;

        StringBuffer sql = new StringBuffer();
        try {
            sql.append("INSERT INTO student (firstname, lastname, room, created_date) VALUES ")
                    .append("( ?, ?, ?, now() )");
            System.out.println("  Insert sql : "+sql.toString());

            //postgresJdbcTemplate.update(sql.toString(), student.getFirstname(), student.getLastname(), student.getRoom());
            // stmt = conn.createStatement();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, student.getFirstname());
            pstmt.setString(2, student.getLastname());
            pstmt.setString(3, student.getRoom());

            // rowAffected = stmt.executeUpdate(sql.toString());
            rowAffected = pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            // do something
        }
    }
}
