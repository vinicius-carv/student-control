package com.vinidev.studentcontrol.common;

import com.vinidev.studentcontrol.entity.Student;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class CrudStudent {
    // Para a funcao createStudent, retorna um erro com uma mensagem
    public static class InvalidEmailException extends RuntimeException {
        public InvalidEmailException(String message) {
            super(message);
        }
    }
    public static class EmptyInput extends RuntimeException {
        public EmptyInput(String message) {
            super(message);
        }
    }
    // Validador de email com regex
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

        // Compilando o padrao regex acima
        Pattern pattern = Pattern.compile(emailRegex);

        // Usando o padrao regex com a entrada
        Matcher matcher = pattern.matcher(email);

        // Retorna True/False
        return matcher.matches();
    }

    private Map<Long, Student> studentDatabase = new HashMap<>();
    private long nextStudentId = 1;
    public Student createStudent(String fname, String lname, String email) {
        if (isValidEmail(email)) {
            return new Student(fname, lname, email);
        }else{
            throw new InvalidEmailException("Invalid email address: " + email);
        }
    }
    public Student getStudent(long id) {
        return studentDatabase.get(id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDatabase.values());
    }

    public void updateStudent(int id, String fname, String lname, String email){
        Student student = studentDatabase.get(id);
        if(student != null){
            if(isValidEmail(email)){
                student.setFirstName(fname);
                student.setLastName(lname);
                student.setEmail(email);
            }else{
                throw new InvalidEmailException("Ivalid email address: "+email);
            }
        }else{
            throw new EmptyInput("The object entered was empty");
        }
    }

    public void deleteStudent(int id){
        studentDatabase.remove(id);
    }
}
