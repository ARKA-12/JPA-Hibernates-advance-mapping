package com.luv2code.cruddemo.entity.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.EntityReader;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Instructor;

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

}
