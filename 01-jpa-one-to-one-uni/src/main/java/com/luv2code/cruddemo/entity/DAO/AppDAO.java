package com.luv2code.cruddemo.entity.DAO;

import org.springframework.stereotype.Component;

import com.luv2code.cruddemo.entity.Instructor;


public interface AppDAO {

    void save(Instructor theInstructor);

}
