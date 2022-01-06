package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @NotEmpty(message = "tên không được để trống")
    private String employeeName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthDay;
    @Pattern(regexp = "^[0-9]{9}$", message = "Số CMND phải đúng định dạng XXXXXXXXX ")
    private String employeeIdCard;
    @Min(value = 0,message = "phải là giá trị dương")
    private double employeeSalary;
    @Pattern(regexp = "^090[0-9]{7}|091[0-9]{7}$",message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx")
    private String employeePhone;
    @Email(message = "email chưa hợp lệ")
    private String employeeEmail;
    @NotEmpty(message = "địa chỉ không được để trống")
    private String employeeAddress;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne()
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne()
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_name")
    private User user;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthDay() {
        return employeeBirthDay;
    }

    public void setEmployeeBirthDay(Date employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
