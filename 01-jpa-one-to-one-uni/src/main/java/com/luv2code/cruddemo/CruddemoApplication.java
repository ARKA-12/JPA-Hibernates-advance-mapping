package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.entity.DAO.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		
		return runner ->{
			createInstructor(appDAO);
		};

	}

	private void createInstructor(AppDAO appDAO) {
		//create the instructor
		Instructor tempInstructor = new Instructor("Sandipp12@gmail.com","Sandip","Pramanik");
		//create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("codexhub","palying football");

		// assosiate the object with one to one relation

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//saving the instructor

		//NOTE: this will also save the details object
		//because of CascadeType.ALL
		System.out.println("Saving the Instructor:- "+ tempInstructor);

		appDAO.save(tempInstructor);

		System.out.println("Done....");

	}

}
