package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class BlogRepoImpl implements BlogRepo{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query=entityManager.createQuery("select b from Blog b",Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(int id) {
        TypedQuery<Blog> query=entityManager.createQuery("select b from Blog b where b.blogId=:id",Blog.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void add(Blog model) {
        entityManager.persist(model);
    }

    @Override
    public void update(Blog model) {
        entityManager.merge(model);
    }


    @Override
    public void remove(int id) {
        Blog blog=findById(id);
        entityManager.remove(blog);
    }
}
