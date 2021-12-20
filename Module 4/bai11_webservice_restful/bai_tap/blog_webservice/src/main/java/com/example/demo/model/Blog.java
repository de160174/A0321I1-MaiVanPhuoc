package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "blog_web_service")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int blogId;

    private String blogName;
    private String content;
    private String author;


    @ManyToOne
    @JoinColumn(name = "categoy_id")
    private Category category;

    public Blog() {
    }

    public Blog(int blogId, String blogName, String content, String author, Category category) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.content = content;
        this.author = author;
        this.category = category;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
