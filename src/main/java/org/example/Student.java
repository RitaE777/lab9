package org.example;

public class Student extends Human{
    private String university;
    private String faculty;
    private String speciality;

    public Student(String name, String surname, String lastname, int age, Gender gender, String university, String faculty, String speciality) {
        super(name, surname, lastname, age, gender);
        this.university = university;
        this.faculty = faculty;
        this.speciality = speciality;
    }
}
