package com.vinidev.portfolio;

import com.vinidev.portfolio.entity.Student;
import com.vinidev.portfolio.entity.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	}
}