package com.example.project2.controller;

import com.example.project2.dto.MessageResponseDto;
import com.example.project2.entity.Student;
import com.example.project2.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class AppController {

    private final StudentRepository repository;

    public AppController (StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String getStudentsList(Model model) throws SQLException {
        List<Student> students = repository.getStudentList();
        model.addAttribute("students", students);
        return "index";
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponseDto> addNewStudent(@RequestBody Student request) throws SQLException {
        return new ResponseEntity<>(repository.createNewStudent(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> deleteStudent(@PathVariable("id") long id) throws SQLException {
        return new ResponseEntity<>(repository.deleteNewStudent(id), HttpStatus.OK);
    }

}
