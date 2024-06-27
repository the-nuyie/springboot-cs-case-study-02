package com.training.java.springboot.casestudy.controller;

import com.training.java.springboot.casestudy.bean.Student;
import com.training.java.springboot.casestudy.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// @RestController
@Controller
@RequestMapping("/controller/jsp")
public class JspController {

    Logger logger = LogManager.getLogger(JspController.class);

    @Autowired
    private StudentService studentService;


    @GetMapping("/home")
    public String home(Model model) {
        String destinationJsp = "home";
        return destinationJsp;
    }

    // @PostMapping("/viewStudents")
    @GetMapping("/view-students")
    public String viewStudents(Model model) {

        String destinationJsp = null;
        String errorMessage = null;

        logger.debug("ViewStudent START");

        List<Student> list = null;

        try{
            list = studentService.listStudent();
            logger.debug("ListStudent = "+list);
            model.addAttribute("students", list);
            destinationJsp = "view-students";

        }catch(Exception ex){
            ex.printStackTrace();
            errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            destinationJsp = "error";
        }

        logger.debug("ViewStudent END");

        return destinationJsp;
    }

    @GetMapping("/input-student")
    public String inputStudent(Model model) {
        String destinationJsp = "input-student";
        return destinationJsp;
    }

    @PostMapping("/add-student")
    public ModelAndView addStudent(@RequestParam("firstname") String firstname,
                                   @RequestParam("lastname") String lastname,
                                   @RequestParam("room") String room,
                                   ModelMap model) {

        String destinationJsp = "";
        logger.debug("addStudent() START");
        logger.debug("  parameters : firstname={}, lastname={}, room={}",firstname,lastname,room);

        Student student = new Student();
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setRoom(room);

        logger.debug("addStudent() END");

        try{
            studentService.addNewStudent(student);
            return new ModelAndView("redirect:./view-students", model);
        }catch(Exception ex){
            ex.printStackTrace();
            model.addAttribute("errorMessage", ex.getMessage());
            return new ModelAndView("error", model);
        }

    }

}
