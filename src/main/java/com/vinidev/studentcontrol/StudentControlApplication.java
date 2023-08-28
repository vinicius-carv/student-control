package com.vinidev.studentcontrol;

import com.vinidev.studentcontrol.entity.Student;
import com.vinidev.studentcontrol.DAO.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentControlApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			System.out.println("Application is running");
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO){
		//Creating tempStudent
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Maluco","do pedaco","malucopedaco@gmail.com");
		//saving
		System.out.println("Saving...");
		studentDAO.save(tempStudent);
		//display saved student
		System.out.println("Saved student. Generated Id:"+ tempStudent.getId());
		System.out.println("Finding student with id: "+ tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("Found student: "+myStudent.toString());
		updateStudent(studentDAO);
		queryForStudentsDAO(studentDAO);
		//queryForStudentsByFirstName(studentDAO);
		deleteStudent(studentDAO, 8);
		queryForStudentsDAO(studentDAO);

	}

	private void updateStudent(StudentDAO studentDAO) {
		// Set do Id
		int studentId = 2;
		System.out.println("Getting student with id: "+ studentId);
		// Recebendo o retorno da funcao findById que returna um Student
		// Student foi recuperado e armazenado no objeto myStudent
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating student...");
		// Setando o parametro
		myStudent.setFirstName("Maconheiro");
		// fazendo commit/push da alteracao
		studentDAO.update(myStudent);
		// Success message
		System.out.println("Success! updated object: "+myStudent.toString());

	}

	private void queryForStudentsByFirstName(StudentDAO studentDAO) {
		List<Student> theStudentSearched = studentDAO.findByFName("Maluco");
		for(Student tempStudent : theStudentSearched){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudentsDAO(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
			System.out.println("---------------------------------------------------");
		}
	}

	private void deleteStudent(StudentDAO studentDAO, int studentId){
		Student theStudent = studentDAO.findById(studentId);
		System.out.println("Deleting: "+ theStudent.toString());
		studentDAO.deleteSingle(studentId);
	}
}