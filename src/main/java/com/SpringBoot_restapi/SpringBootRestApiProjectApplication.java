package com.SpringBoot_restapi;

import com.SpringBoot_restapi.model.Student;
import com.SpringBoot_restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApiProjectApplication {

	public static void main(String[] args) { SpringApplication.run(SpringBootRestApiProjectApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;



//	@Override
//	public void run(String... args) throws Exception{
//		Student student = new Student();
//		student.setFirstName("Ganesh");
//		student.setLastName("kakada");
//		student.setEmaiId("ganeshkakada62078@gmail.com");
//		studentRepository.save(student);
//
//		Student student1 = new Student();
//		student1.setFirstName("Krishna");
//		student1.setLastName("DJ");
//		student1.setEmaiId("DJsheranambajebaje@gmail.com");
//		studentRepository.save(student1);
//	}
}
