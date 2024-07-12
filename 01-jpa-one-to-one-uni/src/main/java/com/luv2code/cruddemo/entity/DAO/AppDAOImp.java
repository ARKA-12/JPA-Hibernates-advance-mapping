package com.luv2code.cruddemo.entity.DAO;

import org.springframework.beans.factory.annotation.Autowired;
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

}
