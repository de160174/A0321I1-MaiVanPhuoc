package service;

import entity.Student;

import java.util.List;

public interface StudentService {
    Student findById(Integer id);

    List<Student> findAll();

    void updateStudent(Integer id, String name, String dateOfBirth);
}
