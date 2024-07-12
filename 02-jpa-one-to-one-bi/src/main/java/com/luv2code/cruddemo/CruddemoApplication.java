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

			//findInstructor(appDAO);

			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			 deleteInstructorDetail(appDAO);

		};


	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		
		int theId = 3;

		System.out.println("deleting the detail id: "+ theId);

		appDAO.deleteIndtuctorDetailById(theId);

		System.out.println("Done!!");

	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=2;
		//get the instructor detail object
		System.out.println("Find the instructor id: " +theId);
		InstructorDetail tempDetail = appDAO.findInstructorDetailById(theId);


		//print the instructor detail
		System.out.println("TempDetails: " +tempDetail);
		//print thr associated instructor
		System.out.println("Associated intructor : " + tempDetail.getInstructor());

		System.out.println("Done!!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		
		int theId=1;

		System.out.println("Delete Instructor Id: " + theId);
		 appDAO.deleteInstructorById(theId); // we use cascadeType.ALL in instructor entity so it will delete both table data 

		System.out.println("Done!");



	}

	private void findInstructor(AppDAO appDAO) {

		int theId=1;
		System.out.println("Finding Instructor ID: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("The associated instructor details only: " + tempInstructor.getInstructorDetail());


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
