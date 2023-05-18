package com.accenture.students.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }
    @GetMapping("{Id}")
    public Student getStudent( @PathVariable ("Id") Integer id){
        return studentService.getStudent(id);
    }
    @DeleteMapping("{Id}")
    public void deleteStudentById(@PathVariable("Id") Integer id){
        studentService.deleteStudentById(id);
    }

    @PutMapping("{Id}")
    public void updateStudent(@PathVariable ("Id") Integer id, @RequestBody StudentUpdateRequest studentUpdateRequest){
        studentService.updateStudentById(id,studentUpdateRequest);
    }
}
