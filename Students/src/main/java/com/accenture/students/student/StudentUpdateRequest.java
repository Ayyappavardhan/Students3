package com.accenture.students.student;

public record StudentUpdateRequest(
        String name,
        String email,
        String phoneNumber) {

}
