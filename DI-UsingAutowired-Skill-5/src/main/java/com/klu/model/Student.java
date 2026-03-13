package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
   private int id;
   private String name;
   private String gender;
   
   @Autowired
   private Certification certification;

   @Autowired
   public Student(@Value("101")int id,@Value("Amar")String name) {
	   this.id = id;
	   this.name = name;
   }
   
   @Value("Male")
   public void setGender(String gender) {
	   this.gender = gender;
   }
   
   public void display() {
	   System.out.println("ID: "+id);
	   System.out.println("Name: "+name);
	   System.out.println("Gender: "+gender);
	   certification.display();
   }
   
}
