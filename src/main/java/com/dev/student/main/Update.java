package com.dev.student.main;

import com.dev.student.entity.Student;
import com.dev.student.template.StudentJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class Update {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        var studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

        System.out.println("\n========== ATUALIZANDO REGISTRO POR ID ==========");
        studentJDBCTemplate.updateByName(8, "Rivaldo");
        studentJDBCTemplate.updateByAge(8, 17);

        System.out.println("\n========== LISTAGEM DE TODOS OS REGISTROS ==========");
        List<Student> students = studentJDBCTemplate.listStudents();

        for (Student record : students) {
            System.out.print("Id: " + record.getId());
            System.out.print(", Name: " + record.getName());
            System.out.println(", Age: " + record.getAge());
        }

    }
}
