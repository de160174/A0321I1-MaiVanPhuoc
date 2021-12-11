package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Bill {
    @Id
    private int idBill;

    private boolean status;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;

    public Bill() {
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
