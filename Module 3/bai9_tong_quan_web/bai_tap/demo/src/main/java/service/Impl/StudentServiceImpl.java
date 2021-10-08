package service.Impl;

import entity.Student;
import repository.Impl.StudentRepositoryImpl;
import repository.StudentRepository;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository repository=new StudentRepositoryImpl();
    @Override
    public Student findById(Integer id) {
        Student student=this.repository.findById(id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students=repository.findAll();
        return students;
    }

    @Override
    public void updateStudent(Integer id, String name, String dateOfBirth) {
        if(name.equals("")) {
            System.out.println("Tên không được để trống");
            return;
        }
        if(dateOfBirth.equals("")){
            System.out.println("Ngày sinh không được để trống.");
            return;
        }
        if(this.repository.findById(id) == null) {
            System.out.println("id không tồn tạo trong database");
            return;
        }
        this.repository.updateStudent(id,name,dateOfBirth);
    }
}
