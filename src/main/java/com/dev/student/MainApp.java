package com.dev.student;

import com.dev.student.entity.Student;
import com.dev.student.template.StudentJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)
                context.getBean("studentJDBCTemplate");

        System.out.println("\n====== Records Creation ======");
        studentJDBCTemplate.create("Rivaldo", 16);

        System.out.println("\n====== Updating record by ID ======");
        studentJDBCTemplate.updateByName(1, "Felipe");
        studentJDBCTemplate.updateByAge(1, 16);

        System.out.println("\n====== Update listing record ======");


        System.out.println("\n====== Listing Multiple Records ======");
        List<Student> students = studentJDBCTemplate.listStudents();

        for (Student record : students) {
            System.out.print("Id: " + record.getId());
            System.out.print(", Name: " + record.getName());
            System.out.println(", Age: " + record.getAge());
        }
    }
}
