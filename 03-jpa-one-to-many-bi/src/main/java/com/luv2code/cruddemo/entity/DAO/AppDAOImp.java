package com.luv2code.cruddemo.entity.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImp implements AppDAO{

    EntityManager entityManager;

    @Autowired
    public AppDAOImp (EntityManager theEntityManager){

        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
       
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        
        return entityManager.find(Instructor.class, theId);
        //this is also return the instructorDetail Object 
        //Because of the behaviour of @OneToOne fetch type is "Egar" , means return all of it.
        
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        
        //retriving the id to delete
        Instructor theInstructor = entityManager.find(Instructor.class, theId);

        //delete the retrive Id

        entityManager.remove(theInstructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        
        InstructorDetail tempDetail = entityManager.find(InstructorDetail.class, theId);

        return tempDetail;

    }

    @Override
    @Transactional
    public void deleteIndtuctorDetailById(int theId) {
       
        //get the instructor detail by id

        InstructorDetail tempDetail = entityManager.find(InstructorDetail.class, theId);

        //remove the associate object refference
        //break bi-direction link
        // only instructorDetail data will delete not the Instructor data

        tempDetail.getInstructor().setInstructorDetail(null);


        // remove the detail
        entityManager.remove(tempDetail);

    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
       
        //create the query 

        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);

        query.setParameter("data", theId);

        List<Course> courses= query.getResultList();

        return courses;

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        //create the query
        //***be sure to add white space before double quotes***
        //this code will retreive the instructor and courses
        //The JOIN FETCH is similar to EAGER loding
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "+"JOIN FETCH i.courses "+"JOIN FETCH i.instructorDetail "+ "where i.id = :data",Instructor.class);

        query.setParameter("data",theId);

        Instructor tempInstructor = query.getSingleResult();

        return tempInstructor;

    }

}
