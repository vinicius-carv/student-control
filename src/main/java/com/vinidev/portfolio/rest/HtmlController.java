package com.vinidev.portfolio.rest;

import com.vinidev.portfolio.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.lang.model.type.ErrorType;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String getIndex(Model model){
        return "index";
    }
    @GetMapping("/signup")
    public String getHtmlSignUp(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "signup";
    }
    @GetMapping("/login-student")
    public String getHtmlLoginStudent(Model model){
        return "login-student";
    }
    @PostMapping(path="/signUpSuccess")
    // no post student
    public String postStudent(@ModelAttribute("student") Student student){
        System.out.println(student.toString());
        return "success";
    }
    @PostMapping(path = "/edit")
    public String editProfile(@ModelAttribute("student") Student student) {
        System.out.println("Editing profile for student id: " + student.getId());
        return "edit";
    }
}
