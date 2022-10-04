package com.dev.student.dao;

import com.dev.student.entity.Student;
import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {

    public void setDataSource(DataSource ds);

    public void create(String name, Integer age);

    public List<Student> listStudents();

    public void updateByName(Integer id, String name);

    public void updateByAge(Integer id, Integer age);

    public Student getStudent(Integer id);

}
