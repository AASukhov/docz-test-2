package com.example.project2.repository;

import com.example.project2.dto.MessageResponseDto;
import com.example.project2.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource({"classpath:properties/query.properties",
        "classpath:properties/application.properties"})
public class StudentRepository {

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUser;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    @Value("${get_all_students}")
    private String getAllStudentsQuery;

    @Value("${create_new_student}")
    private String createNewStudentQuery;

    @Value("${delete_student}")
    private String deleteNewStudentQuery;

    public List<Student> getStudentList() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = DriverManager.getConnection(databaseUrl,databaseUser,databasePassword);
        PreparedStatement statement = connection.prepareStatement(getAllStudentsQuery);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Student student = new Student(resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getString(5));
            students.add(student);
        }
        return students;
    }

    public MessageResponseDto createNewStudent (Student student) throws SQLException {
        Connection connection = DriverManager.getConnection(databaseUrl,databaseUser,databasePassword);
        PreparedStatement statement = connection.prepareStatement(createNewStudentQuery);
        statement.setLong(1, student.getId());
        statement.setString(2, student.getName());
        statement.setString(3, student.getSurname());
        statement.setDate(4, new Date(student.getDate().getTime()));
        statement.setString(5, student.getGroup());
        statement.executeUpdate();
        return new MessageResponseDto("Новый студент добавлен");
    }

    public MessageResponseDto deleteNewStudent (Long id) throws SQLException {
        Connection connection = DriverManager.getConnection(databaseUrl,databaseUser,databasePassword);
        PreparedStatement statement = connection.prepareStatement(deleteNewStudentQuery);
        statement.setLong(1, id);
        statement.execute();
        return new MessageResponseDto("Студент был удален");
    }
}
