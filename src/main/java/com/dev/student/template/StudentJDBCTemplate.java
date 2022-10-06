package com.dev.student.template;

import com.dev.student.template.mapper.StudentMapper;
import com.dev.student.dao.StudentDAO;
import com.dev.student.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, Integer age) {
        String insertQuery = "insert into student (name, age) values (?, ?)";
        jdbcTemplateObject.update(insertQuery, name, age);

        System.out.println("Nome do registro criado: " + name + ", Age = " + age);

        return;
    }

    @Override
    public Student getStudent(Integer id) {
        String getStudentQuery = "select * from student where id = ?";
        Student student = jdbcTemplateObject.queryForObject(getStudentQuery, new Object[]{id}, new StudentMapper());

        return student;
    }

    @Override
    public List<Student> listStudents() {
        String selectQuery = "select * from student";
        List<Student> students = jdbcTemplateObject.query(selectQuery, new StudentMapper());

        return students;
    }

    @Override
    public void updateByName(Integer id, String name) {
        String updateQueryByName = "update student set name = ? where id = ?";
        jdbcTemplateObject.update(updateQueryByName, name, id);

        return;
    }

    @Override
    public void updateByAge(Integer id, Integer age) {
        String updateQueryByAge = "update student set age = ? where id = ?";
        jdbcTemplateObject.update(updateQueryByAge, age, id);

        System.out.println("Atualizar registro com ID: " + id);

        return;
    }

    @Override
    public void delete(Integer id) {
        String deleteQuery = "delete from student where id = ?";
        jdbcTemplateObject.update(deleteQuery, id);

        System.out.println("Deleted Record with ID = " + id);

        return;
    }

}
