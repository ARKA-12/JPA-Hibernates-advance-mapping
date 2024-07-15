package com.luv2code.cruddemo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;
    
    //set up the mapping to instructorDetail entity
    @OneToOne(cascade=CascadeType.ALL) // all type of cascading can perfome here
    @JoinColumn(name="instructor_detail_id") // joining the column to the Instructor table as we already write a scipt to the mySQL
    private InstructorDetail instructorDetail;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "instructor",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}) 
    // in couse class we have the instructor Object
    // this mapped by reffers to "instructor" property in "Course" class
    private List<Course> courses;

    
    
    public  Instructor (){}

    public Instructor(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instructor{");
        sb.append("id=").append(id);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append(", instructorDetail=").append(instructorDetail);
        sb.append('}');
        return sb.toString();
    }

  
    
    // add a convinience method for bi-directional relationship

    public void add(Course tempCourses){

        if(courses ==null){
            courses= new ArrayList<>();
        }

        courses.add(tempCourses);

        tempCourses.setInstructor(this);

    }


}
