package com.vinidev.studentcontrol.DAO;

import com.vinidev.studentcontrol.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByFName(String firstName);
    void update(Student theStudent);
    void deleteSingle(Integer id);
}
