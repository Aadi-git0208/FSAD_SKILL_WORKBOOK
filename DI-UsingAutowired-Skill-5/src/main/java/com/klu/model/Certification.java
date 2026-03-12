package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Certification {
     private int id;
     private String name;
     private String dateOfCompletion;
     
     public Certification(@Value("4112")int id,@Value("AWS")String name,@Value("23-01-26")String dateOfCompletion) {
    	 this.id = id ;
    	 this.name = name;
    	 this.dateOfCompletion = dateOfCompletion;
     }
	
     public void display() {
    	 System.out.println("ID: "+id);
    	 System.out.println("Name: "+name);
    	 System.out.println("Date Of Completion: "+dateOfCompletion);
     }
	 
}
