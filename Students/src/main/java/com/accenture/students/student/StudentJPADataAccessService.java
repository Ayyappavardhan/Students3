package com.accenture.students.student;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentJPADataAccessService implements StudentDao{
    private final StudentsRepository studentsRepository;

    public StudentJPADataAccessService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Student> selectAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public void insertStudent(Student student) {
        studentsRepository.save(student);
    }

    @Override
    public Optional<Student> getStudent(Integer id) {
        return studentsRepository.findById(id);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentsRepository.deleteById(id);
    }

    @Override
    public boolean existStudentById(Integer id) {
        return studentsRepository.existsStudentById(id);
    }

    @Override
    public void updateStudentById(Student update) {
        studentsRepository.save(update);
    }

}
