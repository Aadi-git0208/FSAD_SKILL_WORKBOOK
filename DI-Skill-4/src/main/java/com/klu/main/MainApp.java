package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.config.AppConfig;
import com.klu.model.Student;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext cn1 = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student st1 = (Student)cn1.getBean("student");
		st1.display();
		
		ApplicationContext cn2 = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Student st2 = (Student)cn2.getBean(Student.class);		
        st2.display();
	}

}
