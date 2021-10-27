package model.repository;

import model.bean.Service;

import java.util.List;

public interface ServiceRepo {
    List<Service> findAll();

    void create(Service service);
}
