package model.service;

import java.util.List;

public interface Service {
    List<model.bean.Service> findAll();

    void create(model.bean.Service service);
}
