package com.accenture.students.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student,Integer> {
    boolean existsStudentById(Integer id);


}
