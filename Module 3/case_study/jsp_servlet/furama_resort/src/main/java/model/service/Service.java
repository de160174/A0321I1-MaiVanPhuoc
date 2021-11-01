package model.service;

import java.util.List;
import java.util.Map;

public interface Service {
    List<model.bean.Service> findAll();

    Map<String,String> create(model.bean.Service service);
}
