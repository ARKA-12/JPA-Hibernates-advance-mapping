package com.luv2code.cruddemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="review")
public class Review {

//define the fields

//define the constructor

//define getter/setter

//define toString

//annotate the fields

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "id")
private int id;

@Column(name="comment")
private String comment;



public Review(){}

    public Review(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Review{");
        sb.append("id=").append(id);
        sb.append(", comment=").append(comment);
        sb.append('}');
        return sb.toString();
    }



}
