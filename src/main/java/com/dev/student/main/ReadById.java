package com.dev.student.main;

import com.dev.student.entity.Student;
import com.dev.student.template.StudentJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadById {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        var studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

        System.out.println("\n========== LISTAGEM DE REGISTRO POR ID ==========");
        var studentById = new Student();

        studentById = studentJDBCTemplate.getStudent(1);
        registrationListingById(studentById);
    }

    public static void registrationListingById(Student studentById) {
        System.out.println("Id: " + studentById.getId());
        System.out.println("Name: " + studentById.getName());
        System.out.println("Age: " + studentById.getAge());
    }

}
