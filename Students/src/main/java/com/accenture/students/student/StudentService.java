package com.accenture.students.student;

import com.accenture.students.exception.RequestValidationException;
import com.accenture.students.exception.ResourceNotFound;
import com.accenture.students.validations.EmailValidation;
import com.accenture.students.validations.PhoneNumberValidation;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {
    private final StudentDao studentDao;
    private final PhoneNumberValidation phoneNumberValidation;
    private final EmailValidation emailValidation;
    /**
     * @param studentDao
     * @param phoneNumberValidation
     * @param emailValidation
     */
    public StudentService(StudentDao studentDao, PhoneNumberValidation phoneNumberValidation, EmailValidation emailValidation) {
        this.studentDao = studentDao;
        this.phoneNumberValidation = phoneNumberValidation;

        this.emailValidation = emailValidation;
    }
    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public void addStudent(Student student) {
        if (!emailValidation.isValid(student.getEmail())) {
            throw new RequestValidationException("Enter a proper formatted mail address");
        }
        if (!phoneNumberValidation.isValid(student.getPhoneNumber())) {
            throw new RequestValidationException("Enter a proper formatted PhoneNumber");
        }
        String str = phoneNumberValidation.trimTwoNumbersFromThePhoneNumber(student.getPhoneNumber());
        student.setPhoneNumber(str);
        studentDao.insertStudent(student);
    }
    public Student getStudent(Integer id) {
        return studentDao.getStudent(id).orElseThrow(
                () -> new ResourceNotFound
                        ("Student with [%s] not found".formatted(id)));
    }
    /**
     * @param id
     */
    public void deleteStudentById(Integer id) {
        if (!studentDao.existStudentById(id)) {
            throw new ResourceNotFound("Student id [%d] not exists".formatted(id));
        }
        studentDao.deleteStudentById(id);
    }
    /**
     * @param id
     * @param studentUpdateRequest
     */
    public void updateStudentById(Integer id, StudentUpdateRequest studentUpdateRequest) {
        Student student = getStudent(id);
        boolean changes = false;
        if (studentUpdateRequest.name() != null &&
                !studentUpdateRequest.name().equals(student.getName())) {
            student.setName(studentUpdateRequest.name());
            changes = true;
        }
        if (studentUpdateRequest.email() != null &&
                !studentUpdateRequest.email().equals(student.getEmail())) {
            if (!emailValidation.isValid(studentUpdateRequest.email())) {
                throw new RequestValidationException("Email not in the proper format ");
            }
            student.setEmail(studentUpdateRequest.email());
            changes = true;
        }
        if (studentUpdateRequest.phoneNumber() != null &&
                !studentUpdateRequest.phoneNumber().equals(student.getPhoneNumber())) {
            if (!phoneNumberValidation.isValid(student.getPhoneNumber())) {
                throw new RequestValidationException("Enter a proper formatted PhoneNumber");
            }
            student.setPhoneNumber(phoneNumberValidation.trimTwoNumbersFromThePhoneNumber
                    (studentUpdateRequest.phoneNumber()));
            changes = true;
        }
        if (!changes) {
            throw new RequestValidationException("No Changes for given Id [%d]".formatted(id));
        }
        studentDao.updateStudentById(student);
    }
}