package com.training.java.springboot.casestudy.service;

import com.training.java.springboot.casestudy.bean.Student;
import com.training.java.springboot.casestudy.repository.StudentNoSpringDAO;
import com.training.java.springboot.casestudy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

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
        Connection conn = postgresJdbcTemplate.getDataSource().getConnection();
        StudentNoSpringDAO studentDao = new StudentNoSpringDAO();
        studentDao.addNewStudent(conn, student);
    }


}
