package com.training.java.springboot.casestudy.service;

import com.training.java.springboot.casestudy.bean.Student;
import com.training.java.springboot.casestudy.repository.StudentNoSpringDAO;
import com.training.java.springboot.casestudy.repository.StudentRepository;
import com.training.java.springboot.casestudy.repository.TestConstructorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestConstructorDAO testConstructorDAO;

    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate postgresJdbcTemplate;

    public List<Student> listStudent() throws Exception {
        return studentRepository.listAllStudent();
    }
    public void addNewStudent(Student student) throws Exception {
        // fake exception
        String firstname = student.getFirstname();
        if(firstname == null || "god".equalsIgnoreCase(firstname)){
            throw new Exception("Invalid Firstname, please input another.");
        }
        studentRepository.addNewStudent(student);
    }

    public void addNewStudentNoSpring(Student student) throws Exception {
        // fake exception
        String firstname = student.getFirstname();
        if(firstname == null || "god".equalsIgnoreCase(firstname)){
            throw new Exception("Invalid Firstname, please input another.");
        }

        // # start method 1
        // Connection conn = postgresJdbcTemplate.getDataSource().getConnection();
        // StudentNoSpringDAO studentDao = new StudentNoSpringDAO();
        // studentDao.addNewStudent(conn, student);
        // # end method 1

        // # start method 2
        System.out.println("  testConstructorDAO hash = "+testConstructorDAO);
        DataSource ds = postgresJdbcTemplate.getDataSource();
        testConstructorDAO.setConnection(ds.getConnection());
        testConstructorDAO.addNewStudent(student);
        // # end method 2
    }

    public void addNewStudentNoSpringNotPassConnection(Student student) throws Exception {
        // fake exception
        String firstname = student.getFirstname();
        if(firstname == null || "god".equalsIgnoreCase(firstname)){
            throw new Exception("Invalid Firstname, please input another.");
        }


        // # start method 2
        System.out.println("  testConstructorDAO hash = "+testConstructorDAO);
        DataSource ds = postgresJdbcTemplate.getDataSource();
        // testConstructorDAO.setConnection(ds.getConnection());
        testConstructorDAO.addNewStudent(student);
        // # end method 2
    }


}
