package com.accenture.students.student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    List<Student> selectAllStudents();
    void insertStudent(Student student);
    Optional<Student> getStudent(Integer id);
    void deleteStudentById(Integer id);
    boolean existStudentById(Integer id);
    void updateStudentById(Student update);
}
