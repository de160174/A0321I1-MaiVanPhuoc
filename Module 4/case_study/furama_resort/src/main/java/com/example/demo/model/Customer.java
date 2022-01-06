package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @NotEmpty(message = "tên không được để trống")
    private String customerName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date customerBirthDay;

    private int customerGender;

    @Pattern(regexp = "^[0-9]{9}$", message = "Số CMND phải đúng định dạng XXXXXXXXX ")
    private String customerIdCard;

    @Pattern(regexp = "^090[0-9]{7}|091[0-9]{7}$",message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx")
    private String customerPhone;

    @Email(message = "email chưa hợp lệ")
    private String customerEmail;

    @NotEmpty(message = "địa chỉ không được để trống")
    private String customerAddress;
    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(Date customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
