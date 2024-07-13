package com.luv2code.cruddemo.entity.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
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

}
