package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.DAO.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {

			// createCourseAndReviews(appDAO);
			
			// retriveCouseAndReviews(appDAO);

			deleteCourseAndReviews(appDAO);

		};
	}
		
	

					private void deleteCourseAndReviews(AppDAO appDAO) {
						int theId = 10;

						System.out.println("Deleting Course id: "+ theId);
						appDAO.deleteCourseById(theId);

						System.out.println("done!!!");
	}

					private void retriveCouseAndReviews(AppDAO appDAO) {
	
						//get the course and reviews

						int theId = 10;

						Course tempCourse = appDAO.findCourseAndRerviewsByCourseId(theId);

						//print the course

						System.out.println(tempCourse);

						//print the review
						System.out.println(tempCourse.getReviews());
					
	}

					private void createCourseAndReviews(AppDAO appDAO) {
		
						//creare a course

						Course tempCourse = new Course("PacMan- how to score 1 Million");

						//add reviews

					tempCourse.addReview(new Review("good job my friend!!!"));
					tempCourse.addReview(new Review("yo yo boyy"));
					tempCourse.addReview(new Review("very bad course i don't like it"));

						//save the course
						System.out.println("save the Courses......");
						

						System.out.println("tempCourse: " +tempCourse);
						System.out.println();
						System.out.println("Reviews: "+ tempCourse.getReviews());

					

						appDAO.save(tempCourse);
						System.out.println("done!!");
	}

					private void deleteCouse(AppDAO appDAO) {
						
						int theId=1;

						System.out.println("deleting couseId: "+ theId);

						appDAO.deleteCourseById(theId);

						System.out.println("Done!!");

					}

					private void updateCourse(AppDAO appDAO) {
						
						int theId=3;

						System.out.println("Find the course id: "+ theId);
						Course tempCourse = appDAO.findCouseById(theId);

						//update the course
						System.out.println("Update the course id: "+ theId);

						tempCourse.setTitle("Human Ethics");

						appDAO.update(tempCourse);

						System.out.println("DONE!!");
					}
                


	

private void updateInstructor(AppDAO appDAO) {
		
		int theId = 7;

		//find the Instructor

		System.out.println("Finding the instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		//update the data in istructor
		System.out.println("Update the instructor id: "+theId);
		tempInstructor.setLastName("Maity");

		appDAO.update(tempInstructor);

		System.out.println("DONE!!");

		


	}

private void findInstuctorWithCoursesJoinFetch(AppDAO appDAO) {
	 	int theId=7;

		//find the instructor
		System.out.println("finding instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);// this will fetch both courses and instruction because of JOIN FETCH

		System.out.println("tempInstructor: "+ tempInstructor);

		System.out.println();
		System.out.println("Associate Instructor: " + tempInstructor.getCourses());
		System.out.println();
		System.out.println("DONE!!");



	}

private void findCoursesForInstructor(AppDAO appDAO) {
	int theId = 7;

		System.out.println("Finding Instructor id: " +theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);//only load the instructor not couses because couses are LAZY loading
		System.out.println();

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println();

		//find trhe couses for Instructor

		System.out.println("Finding vouses for Instructor ID:  "+ theId);

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		//associate the objects

		tempInstructor.setCourses(courses);
		System.err.println();
	
		System.out.println("THE associated courses: "+ tempInstructor.getCourses());
		System.out.println();
		System.out.println("DONE!!!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		
		int theId=7;

		System.out.println("Finding Instructor id: " +theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);//only load the instructor not couses because couses are LAZY loading
		System.out.println();

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println();

		System.out.println("The associated couses : "+ tempInstructor.getCourses());
		System.out.println();
		System.out.println("Done!!");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		//create the instructor
		Instructor tempInstructor = new Instructor("Sandipatel322@gmail.com","Sandip","Patel");
		//create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("codexhub","palying football");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//Create couses
		Course tempCourses1 = new Course("Matehmatics");
		Course tempCourses2 = new Course("Science");
		Course tempCourses3 = new Course("Chemistry");

		//add the couses to instructor

		tempInstructor.add(tempCourses1);
		tempInstructor.add(tempCourses2);
		tempInstructor.add(tempCourses3);

		//saving instructor
		//this will also save the courses 
		//because of CascadeType.PERSIST
		//

		System.out.println();
		System.out.println();
		System.out.println("saving instructor:  "+ tempInstructor);
		System.out.println();
		System.out.println();
		System.out.println("The Courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!!!");
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
		
		int theId=7;

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
