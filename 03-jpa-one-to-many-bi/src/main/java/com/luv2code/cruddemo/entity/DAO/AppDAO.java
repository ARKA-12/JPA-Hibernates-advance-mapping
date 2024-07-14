package com.luv2code.cruddemo.entity.DAO;

import java.util.List;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;


public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteIndtuctorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    Instructor update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCouseById(int theId);

    void deleteCourseById(int theId);

    


}
